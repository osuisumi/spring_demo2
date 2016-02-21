package com.everSeeker.service;

import com.everSeeker.entity.User;

import javax.ws.rs.PathParam;

/**
 * Created by pingping on 16/1/19.
 */
public interface UserService {
    /**
     * 注册用户
     */
    void addUser(User user);

    /**
     * 根据用户名查询用户信息
     */
    User getUserByUsername(String username);

    /**
     * 根据输入的用户名密码核实用户身份.
     * 返回1，通过；10，用户名不存在；100，密码错误。
     */
    int checkUser(String username, String password);
}
