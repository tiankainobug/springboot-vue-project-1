package com.hello.helloworld.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hello.helloworld.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {

}
