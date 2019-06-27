package edu.team.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import edu.team.entity.User;
import edu.team.service.LoginService;
import edu.team.util.JacksonUtil;

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
            User user = loginService.getUserInfo(loginName);
            session.setAttribute("loginId", user.getId());
            session.setAttribute("loginName", loginName);
            session.setAttribute("status", 1);
            return "SUCCESS";
        } else if (result.equals("2")) {
            User user = loginService.getUserInfo(loginName);
            session.setAttribute("loginId", user.getId());
            session.setAttribute("loginName", loginName);
            session.setAttribute("status", 2);
            return "SUCCESS";
        } else {
            return "FAIL";
        }
    }

    @RequestMapping(value = "loginOut", method = RequestMethod.POST)
    public String loginOut(HttpServletRequest request) {
        try {
            Enumeration em = request.getSession().getAttributeNames();
            while(em.hasMoreElements()){
                request.getSession().removeAttribute(em.nextElement().toString());
            }
            return JacksonUtil.objectToJson("SUCCESS");
        } catch (Exception e) {
            return JacksonUtil.objectToJson("FAIL");
        }
    }

    @RequestMapping(value = "getPermission", method = RequestMethod.POST)
    public String getPermission(HttpSession session) {
        return JacksonUtil.objectToJson(session.getAttribute("status"));
    }
}
