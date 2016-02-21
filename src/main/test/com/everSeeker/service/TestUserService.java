package com.everSeeker.service;

import com.everSeeker.dao.UserDao;
import com.everSeeker.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/spring.xml"})
public class TestUserService extends AbstractTransactionalJUnit4SpringContextTests {

    @Resource
    private UserService userService;

    @Resource
    private UserDao userDao;

    /**
     * AbstractTransactionalJUnit4SpringContextTests默认回滚。如果需要修改为不回滚设置为false即可。
     * 默认回滚的主要目的是避免产生脏数据。但是如果数据库主键采取自增模式的话，实质上对数据库还是有一点影响。如果主键采取UUID就没这个问题。
     */
    @Test
    @Rollback(false)
    public void TestAddUser() {
        User user = new User("ponpon7", "888888");
        userService.addUser(user);
    }

    @Test
    public void TestGetUserByUsername() {
        System.out.println(userService.getUserByUsername("ppp"));
    }

    @Test
    @Rollback(false)
    public void TestCheckUser() {
        System.out.println(userService.checkUser("ppp", "1234"));
        System.out.println(userService.checkUser("ppt", "1212"));
        System.out.println(userService.checkUser("ppp", "1000"));
    }

    @Test
    @Rollback(false)
    public void TestRankingByScore() {
        userDao.rankingByScore();
    }
}
