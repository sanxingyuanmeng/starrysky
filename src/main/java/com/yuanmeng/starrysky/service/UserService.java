package com.yuanmeng.starrysky.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yuanmeng.starrysky.model.User;
import com.yuanmeng.starrysky.repository.UserRepository;

@Service
@Transactional
public class UserService {
    UserRepository userRepositoy;
}
