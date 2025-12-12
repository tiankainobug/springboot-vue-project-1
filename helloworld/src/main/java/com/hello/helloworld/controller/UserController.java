package com.hello.helloworld.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hello.helloworld.entity.User;
import com.hello.helloworld.mapper.UserMapper;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 功能：
 * 作者：田凯
 * 日期：2025/12/11 20:44
 **/
@Api(value = "用户接口")
@RestController()
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/getAllUser")
    public List<User> queryUserList() {
        List<User> users = userMapper.selectList(null);
        return users;
    }

    @PostMapping("/add")
    public String addUser(@RequestBody User user) {
        int insert = userMapper.insert(user);
        if (insert > 0) {
            return "添加成功";
        }
        return "添加失败";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        int delete = userMapper.deleteById(id);
        if (delete > 0) {
            return "删除成功";
        }
        return "删除失败";
    }

    @PutMapping("/update")
    public String updateUser(@RequestBody User user) {
        int update = userMapper.updateById(user);
        if (update > 0) {
            return "更新成功";
        }
        return "更新失败";
    }

}
