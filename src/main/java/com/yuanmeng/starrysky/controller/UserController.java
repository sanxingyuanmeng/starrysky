package com.yuanmeng.starrysky.controller;


import com.alibaba.fastjson.JSONObject;
import com.yuanmeng.starrysky.common.RedisOperator;
import com.yuanmeng.starrysky.common.WxUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * <p>
 * 用户账号表 前端控制器
 * </p>
 *
 * @author zsh
 * @since 2020-03-13
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private WxUtils wx;

    @Autowired
    private RedisOperator redis;

    @RequestMapping(path="/check")
    public String check(){
        return "OK!";
    }

    @RequestMapping(path="/login")
    public String login(@RequestBody JSONObject jsonParam){
        System.out.println(jsonParam.toJSONString());
        wx.setOriginalData(jsonParam);

        //与微信服务端交互并解密用户信息
        wx.decryptUserInfo();

        Map<String, String> User = wx.getUserData();
        for(String key:User.keySet()){
            System.out.println(key + User.get(key));
        }
        return "";
    }

    /*
    @RequestMapping(path = "/checkredis")
    public String checkredis(){
        redis.set("1234", "4321", 1000*30);
        String res = redis.get("1234");
        return res;
    }

     */

}
