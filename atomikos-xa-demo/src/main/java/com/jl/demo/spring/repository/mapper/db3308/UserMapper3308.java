package com.jl.demo.spring.repository.mapper.db3308;

import com.jl.demo.spring.repository.model.db3308.User;
import com.jl.demo.spring.repository.model.db3308.UserExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper3308 {
    long countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);
}