package com.yuanmeng.starrysky.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/api")
public class NengMaidaoController {

    @RequestMapping(path="/check")
    public String check(){
        return "OK!";
    }

    @RequestMapping(path="/login")
    public String login(@RequestBody JSONObject jsonParam){
        System.out.println(jsonParam.toJSONString());
        return "";
    }


}
