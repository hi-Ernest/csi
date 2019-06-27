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
	 * 修改用户
	 */
	public void editUser(Integer id);

	/**
	 * 删除用户
	 */
	public void deleteById(Integer id);

	/**
	 * 获取指定id用户
	 * @return 
	 */
	public String findByUsername(Integer id);

	/**
	 * 获取指定登录用户
	 */
	public String findByLoginname(String loginname);
	/**
	 * 获取全部用户
	 */
	public List<User> findAllUsers();

}
