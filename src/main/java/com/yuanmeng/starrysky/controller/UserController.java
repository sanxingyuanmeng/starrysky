package com.yuanmeng.starrysky.controller;


import com.alibaba.fastjson.JSONObject;
import com.yuanmeng.starrysky.common.RedisOperator;
import com.yuanmeng.starrysky.common.ResponseUtils;
import com.yuanmeng.starrysky.common.WxUtils;
import com.yuanmeng.starrysky.common.wxLoginInfo;
import com.yuanmeng.starrysky.entity.User;
import com.yuanmeng.starrysky.service.UserService;
import com.yuanmeng.starrysky.service.UserTokenManager;
import com.yuanmeng.starrysky.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
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

    @Autowired
    private UserServiceImpl userService;

    @RequestMapping(path="/check")
    public String check(){
        return "OK!";
    }

    @RequestMapping(path="/login")
    public Object login(@RequestBody wxLoginInfo wxLogInfo, HttpServletRequest request){
        String code = wxLogInfo.getCode();
        String iv = wxLogInfo.getIv();
        String   encryptedData = wxLogInfo.getEncryptedData();
        if (code == null){
            return ResponseUtils.badArgument();
        }

        //wx.setwx(jsonParam);
        String sessionInfo = wx.wxSessionKey(code);
        JSONObject wxSessionJson = JSONObject.parseObject(sessionInfo);

        String sessionKey = wxSessionJson.getString("session_key");
        if(sessionKey == null){
            return ResponseUtils.fail(402, "get session key error");
        }



        //与微信服务端交互并解密用户信息
        String UserInfo = wx.decrypt(sessionKey, encryptedData, iv);

        //存储用户信息
        JSONObject wxUserInfoJson = JSONObject.parseObject(UserInfo);
        String openId = wxUserInfoJson.getString("openId");
        if(null == openId){
            return ResponseUtils.fail(402, "get openId fail");
        }


        //将session信息放入到redis中
        redis.set(openId, sessionKey, 1000*60);

        User user = userService.findOneByOpenId(openId);
        if (null == user){
            //插入数据库
            user = new User();
            user.setOpenId(openId);
            user.setArea(wxUserInfoJson.getString("area"));
            user.setCity(wxUserInfoJson.getString("city"));
            user.setCountry(wxUserInfoJson.getString("country"));
            user.setGender(wxUserInfoJson.getInteger("gender"));
            user.setNickname(wxUserInfoJson.getString("nickName"));
            user.setHeadIcon(wxUserInfoJson.getString("avatarUrl"));
            user.setProvince(wxUserInfoJson.getString("province"));
            LocalDateTime now = LocalDateTime.now();
            user.setJoinDate(now);
            user.setCreateTime(now);
            user.setUpdateTime(now);
            user.setLastLogin(now);
            user.setType(0);
            userService.save(user);


        }else{
            //更新数据库
            LocalDateTime now = LocalDateTime.now();
            user.setUpdateTime(now);
            user.setLastLogin(now);
            userService.updateById(user);
        }

        //获取token
        String token = UserTokenManager.generateToken(user.getId());
        Map<Object, Object> result = new HashMap<Object, Object>();
        result.put("token", token);
        result.put("userInfo", wxUserInfoJson);
        result.put("id", user.getId());
        System.out.println(result);
        return ResponseUtils.ok(result);
    }


}
