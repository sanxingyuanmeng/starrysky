package com.yuanmeng.starrysky.common;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.util.Base64;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import com.yuanmeng.starrysky.common.JsonUtils;

public class WxUtils {

    //@Autowired
    //private RedisOperator redis;

    @Value("${wx.appid}")
    private String appid;

    @Value("${wx.secret}")
    private String secret_key;


    public Map<String, String> getOriginalData() {
        return originalData;
    }

    private Map<String, String> originalData = new HashMap<>();
    private Map<String, String> UserData = new HashMap<>();

    public Map<String, String> getUserData() {
        return UserData;
    }

    public Map<String, String> getUserIdInfo() {
        return UserIdInfo;
    }

    private Map<String, String> UserIdInfo = new HashMap<>();


    //获取用户原始信息
    public void setOriginalData(JSONObject jsonObject){


        this.originalData= JSONObject.parseObject(jsonObject.toJSONString(),
                new TypeReference<Map<String, String>>(){});


        System.out.println(this.originalData);
        for(String key:this.originalData.keySet()){
            System.out.println(key + "  :  " + this.originalData.get(key));
        }
    }

    //获取openid/unionid/session_key字段
    public Map<String, String> getUserOpenId(){


         /*
        redis.set("user-redis-session:" + model.getOpenid(),
                model.getSession_key(),
                1000 * 60 * 30);
        */

        String url = "https://api.weixin.qq.com/sns/jscode2session";
        Map<String, String> param = new HashMap<>();
        param.put("appid", this.appid);
        param.put("secret", this.secret_key);
        param.put("js_code", this.originalData.get("code"));
        param.put("grant_type", "authorization_code");
        String wxResult = HttpClientUtil.doGet(url, param);

        JSONObject jsObject = JSONObject.parseObject(wxResult);

        this.UserIdInfo =JSONObject.parseObject(jsObject.toJSONString(),
                new TypeReference<Map<String, String>>(){});

        return this.UserIdInfo;
    }


    //信息解密
    public String decrypt(String session_key, String encrypted_data, String iv){
        final Base64.Decoder decoder = Base64.getDecoder();
        String dec_session_key = new String(decoder.decode(session_key));
        String dec_iv = new String(decoder.decode(iv));
        String dec_encrypted_data = new String(decoder.decode(encrypted_data));
        String wx_json = AES.wxDecrypt(dec_encrypted_data, dec_session_key, dec_iv);
        return wx_json;


    }

}
