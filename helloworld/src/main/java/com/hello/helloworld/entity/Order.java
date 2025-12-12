package com.hello.helloworld.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 功能：
 * 作者：田凯
 * 日期：2025/12/12 23:02
 **/
@Data
@TableName("t_order")
public class Order {
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;
    private Integer amount;

    @TableField(value = "create_time", fill = FieldFill.INSERT)
    // 核心注解：指定序列化格式 + 时区（避免时区偏移）
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime createTime;
    private Long uid;
}