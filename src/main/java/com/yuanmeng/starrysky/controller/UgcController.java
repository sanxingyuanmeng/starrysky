package com.yuanmeng.starrysky.controller;


import com.yuanmeng.starrysky.service.UgcService;
import com.yuanmeng.starrysky.entity.Ugc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 用户评论表 前端控制器
 * </p>
 *
 * @author zsh
 * @since 2020-03-13
 */
@RestController
@RequestMapping("/ugc")
public class UgcController {

    @Autowired
    private UgcService ugcService;

    @RequestMapping(path = "/add")
    public Ugc addUgc(Ugc ugc){
        ugcService.save(ugc);
        return ugcService.getById(ugc.getId());
    }

    @RequestMapping(path = "/all")
    public ResponseEntity findAll(){
        return ResponseEntity.ok(ugcService.list());
    }

    @RequestMapping(path = "/edit")
    public @ResponseBody
    String editUgc(Ugc ugc){
        Ugc tmp = new Ugc();
        ugc.setType(0);
        ugc.setSourceUserid(999);
        ugcService.updateById(ugc);
        System.out.print(tmp);
        return "{'msg': 'OK'}";
    }

    @RequestMapping(path = "/remove")
    public void removeUgc(Long id){
        ugcService.removeById(id);
    }
}

