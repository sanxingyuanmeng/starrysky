package com.yuanmeng.starrysky.controller;

import com.yuanmeng.starrysky.model.Ugc;
import com.yuanmeng.starrysky.repository.UgcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/ugc")
public class UgcController {
    @Autowired
    private UgcRepository ugcRepository;

    @RequestMapping(path = "/add")
    public Optional<Ugc> addUgc(Ugc ugc){
        Ugc tmp = ugcRepository.save(ugc);
        System.out.print(tmp);
        return ugcRepository.findById(ugc.getId());
    }

    @RequestMapping(path = "/all")
    public ResponseEntity findAll(){
        return ResponseEntity.ok(ugcRepository.findAll());
    }

    @RequestMapping(path = "/edit")
    public @ResponseBody
    String editUgc(Ugc ugc){
        Ugc tmp = ugcRepository.findById(ugc.getId()).get();
        Long tmp_id = tmp.getId();
        tmp = ugc;
        tmp.setId(tmp_id);
        //tmp.setId(ugc.getId());

        ugcRepository.save(tmp);
        System.out.print(tmp);
        return "{'msg': 'OK'}";
    }

    @RequestMapping(path = "/remove")
    public void removeUgc(Long id){
        ugcRepository.deleteById(id);
    }
}

