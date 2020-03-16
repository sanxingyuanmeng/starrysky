package com.yuanmeng.starrysky.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yuanmeng.starrysky.annotation.LoginUser;
import com.yuanmeng.starrysky.common.ResponseUtils;
import com.yuanmeng.starrysky.entity.BuyHistory;
import com.yuanmeng.starrysky.entity.Goods;
import com.yuanmeng.starrysky.entity.Platform;
import com.yuanmeng.starrysky.service.impl.BuyHistoryServiceImpl;
import com.yuanmeng.starrysky.service.impl.GoodsLabelsServiceImpl;
import com.yuanmeng.starrysky.service.impl.GoodsServiceImpl;
import com.yuanmeng.starrysky.service.impl.PlatformServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 用户邀请表 前端控制器
 * </p>
 *
 * @author zsh
 * @since 2020-03-13
 */
@RestController
@RequestMapping("/buyHistory")
public class BuyHistoryController {

    @Autowired
    private BuyHistoryServiceImpl buyHistoryService;

    @Autowired
    private GoodsServiceImpl goodsService;

    @Autowired
    private PlatformServiceImpl platformService;


    @RequestMapping(path="/list")
    public Object list(@LoginUser Integer userId){
        if(userId == null){
            return ResponseUtils.unlogin();
        }

        List<BuyHistory> buyHistoryList = buyHistoryService.findBuyHistoryByUserId(userId);
        //List<Object> footprintVoList = new ArrayList<>(footprintList.size());
        List<Object> buyGoodsVoList = new ArrayList<>(buyHistoryList.size());

        for(BuyHistory buyHistory:buyHistoryList){
            Map<String, Object> c = new HashMap<String, Object>();
            c.put("id", buyHistory.getId());
            c.put("goodsId", buyHistory.getGoodsId());

            Goods goods = goodsService.getById(buyHistory.getGoodsId());
            c.put("name", goods.getTitle());
            c.put("brief", goods.getContentTitle());
            c.put("pics", goods.getPics());
            c.put("price", goods.getPrice());
            //c.put("platform", goods.getPlatformId());

            Platform platform = platformService.getById(goods.getPlatformId());
            c.put("platform", platform.getName());
            c.put("address", goods.getAddress());
            c.put("addressType", goods.getAddressType());

            buyGoodsVoList.add(c);
        }

        return ResponseUtils.ok(buyGoodsVoList);
    }

}
