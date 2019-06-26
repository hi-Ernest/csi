package edu.team.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

import edu.team.service.LoginService;

/**
 * 登录界面Controller层
 * @author dailiwen
 * @date 2019/06/24
 */
@RestController
public class LoginController {
    @Autowired
    LoginService loginService;

    @RequestMapping(value = "loginIn", method = RequestMethod.GET)
    public String login(String loginName, String password, HttpSession session) {
        String result = loginService.login(loginName, password);
        if (result.equals("1")) {
            session.setAttribute("loginName", loginName);
            session.setAttribute("status", 1);
            return "SUCCESS";
        } else if (result.equals("2")) {
            session.setAttribute("loginName", loginName);
            session.setAttribute("status", 2);
            return "SUCCESS";
        } else {
            return "FAIL";
        }
    }
}
