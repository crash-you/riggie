package com.liujava.services.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liujava.Enity.User;
import com.liujava.mapper.UserMapper;
import com.liujava.services.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
