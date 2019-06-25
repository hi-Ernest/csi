package edu.team.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.team.dao.UserDao;
import edu.team.entity.User;
import edu.team.service.UserService;

/**
 * 用户ServiceImpl
 * @author tianguo
 * @date 2019/06/24
 */
@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;

	@Override
	public boolean exits(String username) {
		List<User> userList = userDao.findByUsername(username);
        if(userList.size()>0)
            return true;
        else
            return false;
	}

	@Override
	public void addUser(User user) {
		userDao.add(user);
		
	}

	@Override
	public void editUser(User user) {
		userDao.edit(user);
		
	}

	@Override
	public void deleteUser(Integer id) {
		userDao.delete(id);
		
	}

	@Override
	public User getUser(Integer id) {
		return userDao.getUser(id);
	}

	@Override
	public List<User> queryUsers(String username) {
		if(username == null || "".equals(username))
            return userDao.findAllUsers();
        else return userDao.queryByUsername(username);
	}		
}
