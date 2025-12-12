package com.hello.helloworld.controller;

import com.hello.helloworld.entity.Order;
import com.hello.helloworld.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 功能：
 * 作者：田凯
 * 日期：2025/12/12 23:16
 **/
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderMapper orderMapper;

    @PostMapping("/addOrder")
    public String addOrder(@RequestBody Order order) {
        orderMapper.insert(order);
        return "添加成功";
    }
}
