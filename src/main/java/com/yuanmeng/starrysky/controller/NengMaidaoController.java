package com.yuanmeng.starrysky.controller;

import com.alibaba.fastjson.JSONObject;
import com.yuanmeng.starrysky.common.RedisOperator;
import com.yuanmeng.starrysky.common.WxUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/api")
public class NengMaidaoController {

    private WxUtils wx = new WxUtils();

    @Autowired
    private RedisOperator redis;

    @RequestMapping(path="/check")
    public String check(){
        return "OK!";
    }

    @RequestMapping(path="/login")
    public String login(@RequestBody JSONObject jsonParam){
        System.out.println(jsonParam.toJSONString());
        System.out.println("xxxxx");
        wx.setOriginalData(jsonParam);
        return "";
    }

    @RequestMapping(path = "/checkredis")
    public String checkredis(){
        redis.set("1234", "4321", 1000*30);
        String res = redis.get("1234");
        return res;
    }


}
