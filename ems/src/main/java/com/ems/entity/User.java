package com.ems.entity;

import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder(toBuilder = true)
@ToString
public class User {
    /**
     * 编号
     */
    private String id;
    /**
     * 姓名
     */
    private String userName;
    /**
     * 档案
     */
    private String realName;
    /**
     * 性别
     */
    private String sex;
    /**
     * 年龄
     */
    private String password;
    /**
     * 状态
     */
    private String status;
    /**
     * 薪资
     */
    private LocalDateTime registertTime;
}
