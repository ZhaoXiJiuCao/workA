package com.ems.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {
    @GetMapping(value = "/")
    public String index(){
        System.out.println("/index");
        return "index";
    }

    @GetMapping(value = "/abc")
    @ResponseBody
    public String test(){
        return "1234567";
    }
}
