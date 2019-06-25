package edu.team.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.team.entity.User;
import edu.team.service.UserService;
import org.springframework.web.servlet.ModelAndView;

/**
 * 项目初始control层示例
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/test")
    public User test() {
        return userService.getUser(1);
    }

    @RequestMapping("/m")
    public ModelAndView testMode() {

        ModelAndView modelAndView = new ModelAndView();

        //调用service方法得到用户列表
//        List<User> users = userService.findUser();
        //将得到的用户列表内容添加到ModelAndView中
        modelAndView.addObject("id",12);
        //设置响应的jsp视图
        modelAndView.setViewName("index");
        return modelAndView;

//        return new ModelAndView("index", "id", 31);
    }

    @RequestMapping("/index")
    public String index() {
        return "abc";
    }

    @RequestMapping("/index2")
    public String index2() {
        return "main";
    }

    @RequestMapping("/index3")
    public String index3() {
        return "loginForm";
    }
}
