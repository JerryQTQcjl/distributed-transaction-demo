package com.jl.demo.spring.service.impl;

import com.jl.demo.spring.repository.mapper.db3306.UserMapper3306;
import com.jl.demo.spring.repository.mapper.db3308.UserMapper3308;
import com.jl.demo.spring.repository.model.db3306.User;
import com.jl.demo.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author jerry chan
 * @date 2023/7/23 23:00
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper3306 userMapper3306;

    @Autowired
    private UserMapper3308 userMapper3308;

    @Override
    @Transactional(transactionManager = "jtaTransactionManager", rollbackFor = Exception.class)
    public void insert() {
        User user3306 = new User();
        user3306.setName("111");
        userMapper3306.insert(user3306);

        com.jl.demo.spring.repository.model.db3308.User user3308 = new com.jl.demo.spring.repository.model.db3308.User();
        user3308.setName("222");
        userMapper3308.insert(user3308);

        throw new RuntimeException("test");
    }
}
