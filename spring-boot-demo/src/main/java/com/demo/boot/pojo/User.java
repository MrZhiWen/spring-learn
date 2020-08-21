package com.demo.boot.pojo;

import lombok.Builder;
import lombok.Data;

/**
 * @ClassName : User.java
 * @Description : lombok 使用  用户信息
 * @Author : lizhiwen
 * @Date: 2020-08-20 14:40
 */
@Data
@Builder
public class User {
    /**
     *姓名
     */
    private String userName;
    /**
     * 年龄
     */
    private int age;
    /**
     * 性别
     */
    private boolean sex;
    /**
     * 地址
     */
    private String address;

}
