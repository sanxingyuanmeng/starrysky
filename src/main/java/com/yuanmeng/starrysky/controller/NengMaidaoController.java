package com.yuanmeng.starrysky;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping(path="/api")
public class NengMaidaoController {

    @RequestMapping(path="/check")
    public String check(){
        return "OK!";
    }


}
