package edu.team.service;

import java.util.List;

import edu.team.entity.User;

/**
 * 用户Service接口
 * @author tianguo
 * @date 2019/06/24
 */
public interface UserService {

	/**
	 * 增加用户
	 * @return 
	 */
	public String add(String username, Integer status, String loginname, String password);


	/**
	 * 删除用户
	 */
	public String deleteUserById(Integer id);

	/**
	 * 获取指定信息用户
	 * @return 
	 */
	public List<User> getUserFromInfo(String userName, Integer status);
	
	/**
	 * 获取指定用户名用户
	 * @return 
	 */
	public List<User> getUserFromUserName(String userName);

	/**
	 * 获取指定登录用户
	 */
	public String findByLoginname(String loginname);
	/**
	 * 获取全部用户
	 */
	public List<User> findAllUsers();
	
	public User getUserFromId(Integer id);
	
	public String updataUserById(String userName, String loginName, Integer status, Integer id);

}
