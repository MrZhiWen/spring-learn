package com.demo.boot.controller;

import com.demo.boot.pojo.User;
import com.demo.boot.service.DemoAsyncService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName : DemoAsyncController.java
 * @Description : spring boot 异步处理案例 控制类
 * @Author : lizhiwen
 * @Date: 2020-08-20 16:03
 */
@RestController
@RequestMapping("/async")
@Slf4j
@Api(value = "异步任务demo相关接口", tags = {"异步任务demo"})
public class DemoAsyncController {

    @Autowired
    private DemoAsyncService demoAsyncService;

    /**
     * 使用默认线程池
     * @return
     */
    @ApiOperation(value = "用户注册 添加积分", notes = "提示内容")
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
    @ApiOperation(value = "用户注册,添加积分,并且更新缓存", notes = "提示内容")
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
