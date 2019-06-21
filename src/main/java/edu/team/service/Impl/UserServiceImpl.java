package edu.team.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.team.dao.UserDao;
import edu.team.entity.User;
import edu.team.service.UserService;

/**
 * 初始项目ServiceImpl示例
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;


    @Override
    public User select() {
        return userDao.select();
    }
}
