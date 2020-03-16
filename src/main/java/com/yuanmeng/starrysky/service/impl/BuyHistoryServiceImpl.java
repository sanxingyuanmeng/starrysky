package com.yuanmeng.starrysky.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yuanmeng.starrysky.entity.BuyHistory;
import com.yuanmeng.starrysky.mapper.BuyHistoryMapper;
import com.yuanmeng.starrysky.service.BuyHistoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 用户邀请表 服务实现类
 * </p>
 *
 * @author zsh
 * @since 2020-03-13
 */
@Service
public class BuyHistoryServiceImpl extends ServiceImpl<BuyHistoryMapper, BuyHistory> implements BuyHistoryService {
    @Resource
    private BuyHistoryMapper buyHistoryMapper;

    public List<BuyHistory> findBuyHistoryByUserId(Integer userId){
        List<BuyHistory> buyHistoryList = buyHistoryMapper.selectList(
                new QueryWrapper<BuyHistory>().lambda().eq(BuyHistory::getUserId, userId)
        );

        return buyHistoryList;
    }
}
