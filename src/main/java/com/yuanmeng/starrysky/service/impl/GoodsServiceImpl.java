package com.yuanmeng.starrysky.service.impl;

import com.yuanmeng.starrysky.entity.Goods;
import com.yuanmeng.starrysky.mapper.GoodsMapper;
import com.yuanmeng.starrysky.service.GoodsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 商品表 服务实现类
 * </p>
 *
 * @author zsh
 * @since 2020-03-13
 */
@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements GoodsService {

}
