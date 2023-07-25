package com.jl.demo.spring.repository.mapper.db3306;

import com.jl.demo.spring.repository.model.db3306.User;
import com.jl.demo.spring.repository.model.db3306.UserExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper3306 {
    long countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);
}