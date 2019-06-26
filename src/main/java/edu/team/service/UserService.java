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
	 * 判断用户是否存在
	 */
	public boolean exits(String username);

	/**
	 * 增加用户
	 * @return 
	 */
	public void add(String username, Integer status, String loginname, String password);

	/**
	 * 修改用户
	 */
	public void editUser(Integer id);

	/**
	 * 删除用户
	 */
	public void deleteUser(Integer id);

	/**
	 * 获取指定id用户
	 * @return 
	 */
	public User getUser(Integer id);

	/**
	 * 获取用户列表
	 */
	public List<User> queryUsers(String username);
	/**
	 * 获取全部用户
	 */
	public List<User> findAllUsers();

}
