package com.everSeeker.service.impl;

import com.everSeeker.SpringContextUtils;
import com.everSeeker.dao.UserDao;
import com.everSeeker.entity.User;
import com.everSeeker.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao = SpringContextUtils.getApplicationContext().getBean(UserDao.class);

    private static Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    public void addUser(User user) {
        userDao.addUser(user);
    }

    public User getUserByUsername(String username) {
        User user = userDao.getUserByUsername(username);
        log.info("All info about {}: \n{}", username, user);
        return user;
    }

    public int checkUser(String username, String password) {
        log.info("start check username: {}", username);
        User user = userDao.getUserByUsername(username);
        if (user == null) {
            log.warn("username is incorrect!");
            return 10;
        }
        if (!user.getPassword().equals(password)) {
            log.warn("passowrd is incorrect!");
            return 100;
        }
        log.info("{} has successed checked!", username);
        return 1;
    }

}
