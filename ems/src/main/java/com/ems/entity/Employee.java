package com.ems.entity;

import lombok.*;

/**
 * @author xiaozhihe
 * @Description: ${todo}
 * @date 2020/7/1320:30
 */
@Data
@Builder(toBuilder = true)
@ToString
public class Employee {
    /**
     * 编号
     */
    private String id;
    /**
     * 姓名
     */
    private String name;
    /**
     * 档案
     */
    private String profilePath;
    /**
     * 性别
     */
    private String sex;
    /**
     * 年龄
     */
    private int age;
    /**
     * 薪资
     */
    private double salary;
}
