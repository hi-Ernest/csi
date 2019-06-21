package edu.team.dao;

import org.apache.ibatis.annotations.Mapper;

import edu.team.entity.User;

/**
 * 初始项目Dao层示例
 * @author dailiwen
 * @date 2019/06/21
 */
@Mapper
public interface UserDao {
    User select();
}
