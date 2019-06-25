package edu.team.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import edu.team.entity.User;
/**
 * 用户Dao层
 * @author tianguo
 * @date 2019/06/24
 */
@Mapper
public interface UserDao {
	
    public void add(User user);
    
    public void edit(User user);
    
    public void delete(Integer id);
    
    public User getUser(Integer id);
    
    public List<User> findByUsername(String username);
    
    public List<User> queryByUsername(String username);
    
    public List<User> findAllUsers();
}
