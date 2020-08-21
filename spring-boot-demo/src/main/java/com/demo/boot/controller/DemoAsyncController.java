package com.demo.boot.controller;

import com.demo.boot.pojo.User;
import com.demo.boot.service.DemoAsyncService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName : DemoAsyncController.java
 * @Description : spring boot 异步处理案例 控制类
 * @Author : lizhiwen
 * @Date: 2020-08-20 16:03
 */
@RestController
@Slf4j
public class DemoAsyncController {

    @Autowired
    private DemoAsyncService demoAsyncService;

    /**
     * 使用默认线程池
     * @return
     */
    @GetMapping("/addUser")
    public User registerUser(){
        User user = User.builder().userName("李志文").age(28).sex(false).address("湖北省洪湖市").build();
        log.info("获取用户信息{}",user);
        demoAsyncService.addScore();
        log.info("-----用户注册成功------");
        return user;
    }
    /**
     * 使用指定线程池
     * @return
     */
    @GetMapping("/addUser1")
    public User registerUser1(){
        User user = User.builder().userName("李志文").age(28).sex(false).address("湖北省洪湖市").build();
        log.info("获取用户信息{}",user);
        demoAsyncService.addScore1();
        demoAsyncService.addScore2();
        log.info("-----用户注册成功------");
        return user;
    }


}
