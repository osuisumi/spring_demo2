package com.everSeeker.task;

import com.everSeeker.dao.UserDao;
import com.everSeeker.service.UserService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component("springTask")
public class SpringTask {

    @Resource
    private UserDao userDao;

    @Resource
    private UserService userService;

    @Scheduled(cron = "0/20 * * * * ?")
    public void rankingByScoreJob() {
        System.out.println("通过spring-task，每隔20秒执行一次任务。。。");
        System.out.println("----------------------------------------");
        userService.getUserByUsername("ponpon7");
//        userDao.rankingByScore();
    }
}
