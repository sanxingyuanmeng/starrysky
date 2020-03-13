package com.yuanmeng.starrysky.controller;

import com.yuanmeng.starrysky.model.User;
import com.yuanmeng.starrysky.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(path = "/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @RequestMapping(path = "/add")
    public Optional<User> addUgc(User user){
        User tmp = userRepository.save(user);
        System.out.print(tmp);
        return userRepository.findById(user.getId());
    }

    @RequestMapping(path = "/all")
    public ResponseEntity findAll(){
        return ResponseEntity.ok(userRepository.findAll());
    }

    @RequestMapping(path = "/edit")
    public @ResponseBody
    String editUgc(User user){
        User tmp = userRepository.findById(user.getId()).get();
        Long tmp_id = tmp.getId();
        tmp = user;
        tmp.setId(tmp_id);
        //tmp.setId(ugc.getId());

        userRepository.save(tmp);
        System.out.print(tmp);
        return "{'msg': 'OK'}";
    }

    @RequestMapping(path = "/remove")
    public void removeUgc(Long id){
        userRepository.deleteById(id);
    }
}

