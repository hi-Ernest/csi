package edu.team.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.team.entity.User;
import edu.team.service.UserService;

/**
 * 项目初始control层示例
 */
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/test")
    public User test() {
        return userService.select();
    }
}
