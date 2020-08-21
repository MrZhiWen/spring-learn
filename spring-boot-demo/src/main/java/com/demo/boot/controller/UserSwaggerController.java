package com.demo.boot.controller;

import com.demo.boot.pojo.ResultVO;
import com.demo.boot.pojo.User;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName : UserSwaggerController.java
 * @Description : Swagger 案例使用
 * @Author : lizhiwen
 * @Date: 2020-08-21 10:32
 */
@Api(value = "用户相关接口", tags = {"用户操作接口"})
@RestController
@RequestMapping("/user")
@Slf4j
public class UserSwaggerController {


    @ApiOperation(value = "根据用户ID 或者 姓名 获取用户信息", notes = "提示内容")
    @PostMapping("/findUser")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户ID", dataType = "String", required = true)
            , @ApiImplicitParam(name = "userName", value = "用户名称", dataType = "String", required = false)
    })
    public ResultVO findUser(String userId, String userName) {
        User user = User.builder().userId(userId)
                .age(28)
                .sex(false)
                .address("武汉")
                .userName( userName==null?"":userName)
                .build();
        log.info("获取user 信息{}", user);
        return ResultVO.builder().date(user)
                .code(0000)
                .msg("成功").build();
    }


    @ApiOperation(value = "根据用户ID获取用户信息", notes = "提示内容")
    @PostMapping("/findUserById")
    @ApiImplicitParam(name = "userId", value = "用户ID", dataType = "String", required = true)
    public ResultVO findUserById(String userId) {
        User user = User.builder().userId(userId)
                .age(28)
                .sex(false)
                .address("武汉")
                .build();
        log.info("获取user 信息{}", user);
        return ResultVO.builder().date(user)
                .code(0000)
                .msg("成功").build();
    }


    @ApiOperation(value = "根据用户ID获取用户信息", notes = "提示内容")
    @GetMapping("/getUserId/{userId}")
    @ApiImplicitParam(name = "userId", value = "用户ID", dataType = "String", required = true)
    public ResultVO getUserId(@PathVariable String userId) {
        User user = User.builder().userId(userId)
                .age(28)
                .sex(false)
                .address("武汉")
                .build();
        log.info("获取user 信息{}", user);
        return ResultVO.builder().date(user)
                .code(0000)
                .msg("成功").build();
    }



}
