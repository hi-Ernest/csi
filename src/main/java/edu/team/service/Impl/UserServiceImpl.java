package edu.team.service.Impl;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.team.dao.UserDao;
import edu.team.entity.Notice;
import edu.team.entity.User;
import edu.team.service.UserService;

/**
 * 用户ServiceImpl
 * 
 * @author tianguo
 * @date 2019/06/24
 */
@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;

	@Override
	public String add(String username, Integer status, String loginname, String password) {
		try {
			userDao.add(username, status, loginname, password);
			return "SUCCESS";
		} catch (Exception e) {
			System.out.print("dailiwen!!!!!!!!!!!!------------" + e);
			return "FAIL";
		}
	}

	@Override
	public String deleteUserById(Integer id) {
        try {
        	userDao.deleteUserById(id);
            return "SUCCESS";
        } catch (Exception e) {
            System.out.println(e);
            return "FAIL";
        }
	}
	
	@Override
	public String updataUserById(String userName, String loginName, Integer status, Integer id) {
        try {
        	userDao.edit(userName, loginName, status, id);
            return "SUCCESS";
        } catch (Exception e) {
            System.out.println(e);
            return "FAIL";
        }
	}

	@Override
	public String findByLoginname(String loginname) {
		List<User> list = userDao.findByLoginname(loginname);
		if (list.size() == 0) {
			return "SUCCESS";
		} else {
			return "FAIL";
		}
	}

	@Override
	public List<User> findAllUsers() {
		try {
        List<User> users = userDao.findAllUsers();
		System.out.print(users.get(0).getId() + "-----------dailiwen!!!!!!!!!!");
		} catch (Exception e) {
			
		}
		return userDao.findAllUsers();
	}

	@Override
	public List<User> getUserFromInfo(String userName, Integer status) {
        List<User> users = userDao.getUserFromInfo(userName, status);
        System.out.print(users.size() + "-----------dailiwen!!!!!!!!!!");
        return users;
	}

	@Override
	public List<User> getUserFromUserName(String userName) {
		// TODO Auto-generated method stub
        List<User> users = userDao.getUserFromUserName(userName);
        System.out.print(users.size() + "-----------dailiwen!!!!!!!!!!");
        return users;
	}

	@Override
	public User getUserFromId(Integer id) {
		// TODO Auto-generated method stub
		return userDao.getUserFromId(id);
	}
}
