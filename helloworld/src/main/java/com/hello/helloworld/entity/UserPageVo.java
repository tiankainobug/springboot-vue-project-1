package com.hello.helloworld.entity;

import lombok.Data;

/**
 * 功能：
 * 作者：田凯
 * 日期：2025/12/12 22:50
 **/
@Data
public class UserPageVo {
    private Integer currentPage;
    private Integer pageSize;
    private String username;
}
