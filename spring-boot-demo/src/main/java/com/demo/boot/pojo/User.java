package com.demo.boot.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

/**
 * @ClassName : User.java
 * @Description : lombok 使用  用户信息
 * @Author : lizhiwen
 * @Date: 2020-08-20 14:40
 */
@ApiModel(value = "user 对象",description = "用户信息")
@Data
@Builder
public class User {
    /**
     * 用户ID
     */
    @ApiModelProperty(value = "用户id",name = "userId",example = "1")
    private String userId;
    /**
     *姓名
     */
    @ApiModelProperty(value = "姓名",name = "userName",example = "李志文")
    private String userName;
    /**
     * 年龄
     */
    @ApiModelProperty(value = "年龄",name = "age",example = "28")
    private int age;
    /**
     * 性别
     */
    @ApiModelProperty(value = "性别",name = "sex",example = "false")
    private boolean sex;
    /**
     * 地址
     */
    @ApiModelProperty(value = "地址",name = "address",example = "武汉")
    private String address;

}
