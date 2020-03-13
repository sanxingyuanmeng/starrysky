package com.yuanmeng.starrysky.controller;

import com.yuanmeng.starrysky.model.Goods;
import com.yuanmeng.starrysky.repository.GoodsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/goods")
public class GoodsController {
    @Autowired
    private GoodsRepository goodsRepository;

    @RequestMapping(path = "/add")
    public void addGoods(Goods good){
        goodsRepository.save(good);
    }

    @RequestMapping(path = "/edit")
    public void editGoods(Goods good){

        goodsRepository.save(good);
    }

    @RequestMapping(path = "/remove")
    public void removeGoods(Long id){
        goodsRepository.deleteById(id);
    }
}

