package edu.team.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.team.dao.LoginDao;
import edu.team.entity.User;
import edu.team.service.LoginService;
import edu.team.util.MD5Util;

/**
 * @author dailiwen
 * @date 2019/06/24
 */

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    LoginDao loginDao;

    /**
     * @param loginName
     * @param password
     * @return e10adc3949ba59abbe56e057f20f883e
     */
    @Override
    public String login(String loginName, String password) {
        User user = loginDao.login(loginName);
        if (user == null) {
            return "3";
        }
        if (user.getPassword().equals(MD5Util.getMD5_32(password))) {
            if (user.getStatus() == 1) {
                //管理员登录
                return "1";
            } else if (user.getStatus() == 2) {
                //普通用户登录
                return "2";
            }
        }
        return "3";
    }
}
