package com.haaphoop.eshop.inventory.controller;

import com.haaphoop.eshop.inventory.model.User;
import com.haaphoop.eshop.inventory.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
    @Autowired
    private UserService service;

    @RequestMapping("/test")
    @ResponseBody
    public User test(){
        User user = service.findUserInfo();
        return user;
    }

    @RequestMapping("/getCacheUserInfo")
    @ResponseBody
    public User getCacheUserInfo(){
        User user = service.getCacheUser();
        return user;
    }
}
