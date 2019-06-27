package edu.team.service;

import edu.team.entity.User;

/**
 * @author dailiwen
 * @date 2019/06/24
 */

public interface LoginService {

    public String login(String loginId, String password);

    public User getUserInfo(String loginName);
}
