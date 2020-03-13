package com.yuanmeng.starrysky.service.impl;

import com.yuanmeng.starrysky.entity.User;
import com.yuanmeng.starrysky.mapper.UserMapper;
import com.yuanmeng.starrysky.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户账号表 服务实现类
 * </p>
 *
 * @author zsh
 * @since 2020-03-13
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
