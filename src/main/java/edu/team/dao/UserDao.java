package edu.team.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import edu.team.entity.User;
/**
 * 用户Dao层
 * @author tianguo
 * @date 2019/06/24
 */
@Mapper
public interface UserDao {
	
	public void add(@Param("username")String username, @Param("status")Integer status, @Param("loginname")String loginname, @Param("password")String password);
    
    public void edit(@Param("userName") String userName, @Param("loginName") String loginName, @Param("status") Integer status, @Param("id") Integer id);
    
    public void deleteUserById(Integer id);
    
    public User getUserFromId(Integer id);
    
    public List<User> getUserFromInfo(@Param("user_name") String user_name, @Param("status") Integer status);
    
    public List<User> findByLoginname(String loginname);
    
    public List<User> findAllUsers();
    
    public List<User> getUserFromUserName(@Param("user_name") String user_name);
}
