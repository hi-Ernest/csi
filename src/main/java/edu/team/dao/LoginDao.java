package edu.team.dao;

import org.apache.ibatis.annotations.Mapper;

import edu.team.entity.User;

/**
 * 登录界面Dao层
 * @author dailiwen
 * @date 2019/06/24
 */
@Mapper
public interface LoginDao {

    User login(String loginName);
}
