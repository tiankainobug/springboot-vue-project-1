package com.hello.helloworld.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hello.helloworld.entity.User;
import com.hello.helloworld.entity.UserPageVo;
import com.hello.helloworld.mapper.UserMapper;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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

    @PostMapping("/getUserByPage")
public List<User> getUserByPage(@RequestBody UserPageVo pageVo) {
    try {
        Page<User> userPage = new Page<>(pageVo.getCurrentPage(), pageVo.getPageSize());
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();

        // 对用户输入进行安全处理，防止SQL注入
        if (pageVo.getUsername() != null && !pageVo.getUsername().trim().isEmpty()) {
            String safeUsername = pageVo.getUsername().trim()
                .replace("\\", "\\\\")
                .replace("%", "\\%")
                .replace("_", "\\_");
            queryWrapper.like("username", safeUsername);
        }

        Page<User> userPage1 = userMapper.selectPage(userPage, queryWrapper);
        return userPage1.getRecords();
    } catch (Exception e) {
        // 记录异常日志
        throw new RuntimeException("查询用户分页数据失败", e);
    }
}

}
