package com.everSeeker.task;

import com.everSeeker.dao.UserDao;
import com.everSeeker.service.UserService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Component
public class QuartzTask {
    @Resource
    private UserDao userDao;

    @Resource
    private UserService userService;

    public void rankingByScore() {
        System.out.println("通过quartz, 每隔10s执行一次任务。。。");
//        userDao.rankingByScore();
    }
}
