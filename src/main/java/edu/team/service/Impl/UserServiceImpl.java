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
	public String add( String username, Integer status, String loginname, String password) {		
		try {
			userDao.add(username, status, loginname, password);
			return "SUCCESS";
		}
		catch(Exception e){
			return "FAIL";
		}
	}

	@Override
	public void editUser( Integer id) {
		userDao.edit(id);
		
	}

	@Override
	public void deleteById(Integer id) {
		userDao.delete(id);
		
	}


	@Override
	public String findByLoginname(String loginname) {
		List<User> list=userDao.findByLoginname(loginname);
		if(list.size()==0) {
			return "SUCCESS";
		}else
			return "FAIL";
	}
	
	@Override
	public List<User> findAllUsers(){
		return userDao.findAll();
	}

	@Override
	public String findByUsername(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
}
