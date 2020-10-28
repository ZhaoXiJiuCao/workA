package com.ems.controller;

import com.ems.entity.User;
import com.ems.service.UserInfoService;
import com.ems.utils.CommonException;
import com.ems.utils.ValidCodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.ByteArrayInputStream;
import java.util.List;

@Controller
public class IndexController {
    @Autowired
    UserInfoService userInfoService;
    @GetMapping(value = "/")
    public String index(){
        System.out.println("/index");
        return "index";
    }

    @GetMapping(value = "/abc")
    @ResponseBody
    public ByteArrayInputStream test() throws CommonException {
        return ValidCodeUtil.getInstance().getVerfyImage("abcc");

    }
    @GetMapping(value = "/abcd")
    @ResponseBody
    public List<User> test1()  {
       return userInfoService.getAllUserInfo();
//        return "test接口";

    }
}
