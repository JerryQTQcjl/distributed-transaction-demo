package com.jl.demo.srping.service.impl;

import com.jl.demo.spring.AtomikosTestApplication;
import com.jl.demo.spring.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = AtomikosTestApplication.class)
class UserServiceImplTest {

    @Autowired
    private UserService userService;

    @Test
    void insert() {
        userService.insert();
    }
}