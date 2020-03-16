package com.yuanmeng.starrysky.common;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import com.yuanmeng.starrysky.common.JsonUtils;
import org.springframework.stereotype.Component;

@Component
public class WxUtils {

    //@Autowired
    //private RedisOperator redis;

    @Value("${wx.appid}")
    private String appid;

    @Value("${wx.secret}")
    private String secret_key;

    private Map<String, String> UserData = new HashMap<>();

    public Map<String, String> getUserData() {
        return UserData;
    }

    public String wxSessionKey(String code){
        String url = "https://api.weixin.qq.com/sns/jscode2session";
        Map<String, String> param = new HashMap<>();
        param.put("appid", this.appid);
        param.put("secret", this.secret_key);
        param.put("js_code", code);
        param.put("grant_type", "authorization_code");
        String wxResult = HttpClientUtil.doGet(url, param);
        return wxResult;
    }

    //信息解密
    public String decrypt(String session_key, String encrypted_data, String iv){
        System.out.println("session key   " + session_key);
        System.out.println("encrypted_data   " + encrypted_data);
        System.out.println("iv   " + iv);

        String wx_json = AES.wxDecrypt(encrypted_data, session_key, iv);
        return wx_json;
    }

}
