package edu.team.dao;

import org.apache.ibatis.annotations.Mapper;

import edu.team.entity.User;

/**
 * @author dailiwen
 * @date 2019/06/24
 */
@Mapper
public interface LoginDao {

    public User login(String loginName);
}
