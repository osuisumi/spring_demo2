package com.everSeeker.service;

import com.everSeeker.dao.EssayDao;
import com.everSeeker.entity.Essay;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by pingping on 16/1/20.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/spring.xml"})
public class TestEssayService extends AbstractTransactionalJUnit4SpringContextTests {

    @Resource
    private EssayService essayService;

    @Resource
    private EssayDao essayDao;

    @Test
    @Rollback(false)
    public void TestPublishNewEssay() {
        Essay essay1 = new Essay("mysql常用命令小结", 1, "mysql");
        Essay essay2 = new Essay("pymongo学习第1篇——增删改查", 1, "mongo");
        Essay essay3 = new Essay("python爬虫1——获取网站源代码(豆瓣图书top250信息)", 1, "python,爬虫,正则表达式");
        essayService.publishNewEssay(essay1);
        essayService.publishNewEssay(essay2);
        essayService.publishNewEssay(essay3);
    }

    @Test
    @Rollback(false)
    public void TestReadEssay() {
        Essay essay = essayDao.getEssayByTitle("mysql常用命令小结");
        System.out.println(essay);
        essayService.readEssay(essay);
    }
}
