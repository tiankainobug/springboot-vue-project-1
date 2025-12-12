package com.hello.helloworld.controller;

import com.hello.helloworld.entity.User;
import com.hello.helloworld.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 功能：
 * 作者：田凯
 * 日期：2025/12/11 20:44
 **/
@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/getAllUser")
    public List<User> queryUserList() {
        return userMapper.queryUserList();
    }
}
