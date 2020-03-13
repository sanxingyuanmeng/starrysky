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
        String url = "https://api.weixin.qq.com/sns/jscode2session";
        Map<String, String> param = new HashMap<>();
        param.put("appid", this.appid);
        param.put("secret", this.secret_key);
        param.put("js_code", this.originalData.get("code"));
        param.put("grant_type", "authorization_code");

        System.out.println("paraxxxx");
        System.out.println(param);

        String wxResult = HttpClientUtil.doGet(url, param);

        JSONObject jsObject = JSONObject.parseObject(wxResult);

        this.UserIdInfo =JSONObject.parseObject(jsObject.toJSONString(),
                new TypeReference<Map<String, String>>(){});

        System.out.println(this.UserIdInfo);
        return this.UserIdInfo;
    }


    //信息解密
    public void decrypt(String session_key, String encrypted_data, String iv){
        System.out.println("session key   " + session_key);
        System.out.println("encrypted_data   " + encrypted_data);
        System.out.println("iv   " + iv);

        String wx_json = AES.wxDecrypt(encrypted_data, session_key, iv);
        this.UserData = JSONObject.parseObject(wx_json,
                new TypeReference<Map<String, String>>(){});
    }

    //封装getUserOpenId和decrypt，用户在登录的时候直接使用
    public void decryptUserInfo(){
        this.getUserOpenId();
        this.decrypt(this.UserIdInfo.get("session_key"), this.originalData.get("encryptedData"), this.originalData.get("iv"));

    }
}
