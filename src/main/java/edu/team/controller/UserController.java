package edu.team.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.team.entity.Notice;
import edu.team.entity.User;
import edu.team.service.UserService;
import edu.team.util.JacksonUtil;
import edu.team.util.MD5Util;

import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

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
		if ("SUCCESS".equals(res)) {
			res = JacksonUtil.objectToJson(userService.add(username, status, loginname, MD5Util.getMD5_32(password)));
			return res;
		} else {
			return JacksonUtil.objectToJson("FAIL");
		}
	}
	
    @RequestMapping(value = "findAllUsers", method = RequestMethod.POST)
    public PageInfo<User> findAllUsers(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        PageHelper.startPage(pageNum, 10);
        PageInfo<User> pageInfo = new PageInfo<User>(userService.findAllUsers());
        return pageInfo;
    }
    
    @RequestMapping(value = "getUserFromInfo", method = RequestMethod.POST)
    public PageInfo<User> getUserFromInfo(String userName, String status, @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        PageHelper.startPage(pageNum, 10);
        if (("".equals(userName) && "".equals(status)) || (null == userName && null == status)) {
            return new PageInfo<User>(userService.findAllUsers());
        } else {
        	if("".equals(status)) {
        		return new PageInfo<User>(userService.getUserFromUserName(userName));
        	} else {
                return new PageInfo<User>(userService.getUserFromInfo(userName, Integer.valueOf(status)));
        	}
        }
    }
    
	@RequestMapping(value = "deleteUserById", method = RequestMethod.POST)
	public String deleteUserById(String ids) {
        String result;
        String[] id = ids.split(",");
        for (int i = 0; i < id.length; i++) {
            result = userService.deleteUserById(Integer.valueOf(id[i]));
            if ("FAIL".equals(result)) {
                return JacksonUtil.objectToJson("FAIL");
            }
        }
        return JacksonUtil.objectToJson("SUCCESS");
	}
	
    @RequestMapping(value = "getUserFromId", method = RequestMethod.POST)
    public User getUserFromId(String id) {
        return userService.getUserFromId(Integer.valueOf(id));
    }

    @RequestMapping(value = "updateUserFromId", method = RequestMethod.POST)
    public String updateNoticeFromId(String id, String userName, String loginName, Integer status) {
    	User user = userService.getUserFromId(Integer.valueOf(id));
    	String res = "SUCCESS";
    	if(!user.getLoginName().equals(loginName)) {
    		res = userService.findByLoginname(loginName);
    	}
		if ("SUCCESS".equals(res)) {
			return JacksonUtil.objectToJson(userService.updataUserById(userName, loginName, status, Integer.valueOf(id)));
		} else {
			return JacksonUtil.objectToJson("FAIL");
		}
    }
}
