package com.everSeeker.service;

import com.everSeeker.task.QuartzTask;
import com.everSeeker.task.SpringTask;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by pingping on 16/2/4.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/spring.xml"})
public class TestTask extends AbstractJUnit4SpringContextTests {

    @Resource
    private QuartzTask quartzTask;

    @Resource
    private SpringTask springTask;

    @Test
    public void TestRankingByScore() {
        quartzTask.rankingByScore();
    }

    @Test
    @Scheduled(cron = "0/10 * * * * ?")
    public void TestRankingByScoreJob() {
        springTask.rankingByScoreJob();
    }
}
