package com.demo.boot.controller;

import com.demo.boot.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName : HollerController.java
 * @Description : 测试接口类
 * @Author : lizhiwen
 * @Date: 2020-08-19 16:00
 */

@RestController
@Slf4j
public class HollerController {

    /**
     * 日志 @Slf4j logback 配置 的使用
     */
    @GetMapping("/holler")
    public void holler() {
        log.trace("进入 holler 接口中.....");
        log.debug("进入 holler 接口中.....");
        log.info("进入 holler 接口中.....");
        log.warn("进入 holler 接口中.....");
        log.error("进入 holler 接口中.....");
    }

    /**
     * 日志 @Slf4j logback 配置 的使用
     * @return
     */
    @GetMapping("name")
    public String name() {
        log.info("获取用户姓名接口.....");
        return "lizhiwen";
    }

    /**
     * lombok 使用
     * @return
     */
    @GetMapping("user")
    public User getUser() {
        User user = User.builder().userName("李志文").age(28).sex(false).address("湖北省洪湖市").build();
        log.info("获取用户信息{}",user);
        return user;
    }

}
