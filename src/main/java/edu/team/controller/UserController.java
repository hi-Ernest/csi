package edu.team.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.team.entity.User;
import edu.team.service.UserService;
import edu.team.util.JacksonUtil;

import org.springframework.web.servlet.ModelAndView;

/**
 * 项目初始control层示例
 */

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String add(String username, Integer status, String loginname, String password) {
		String res = userService.findByLoginname(loginname);
		System.out.print(res);
		if ("SUCCESS".equals(res)) {
			System.out.print("userService.add(username, status, loginname, password)");
			return userService.add(username, status, loginname, password);
		} else {
			System.out.print(userService.add(username, status, loginname, password) + "fail");
			return JacksonUtil.objectToJson("FAIL");
		}

	}

	@RequestMapping("/m")
	public ModelAndView testMode() {

		ModelAndView modelAndView = new ModelAndView();

		// 调用service方法得到用户列表
//        List<User> users = userService.findUser();
		// 将得到的用户列表内容添加到ModelAndView中
		modelAndView.addObject("id", 12);
		// 设置响应的jsp视图
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
