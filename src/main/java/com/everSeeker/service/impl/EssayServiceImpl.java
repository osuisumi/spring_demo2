package com.everSeeker.service.impl;

import com.everSeeker.dao.EssayDao;
import com.everSeeker.dao.UserDao;
import com.everSeeker.entity.Essay;
import com.everSeeker.entity.User;
import com.everSeeker.service.EssayService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by pingping on 16/1/20.
 */
@Service("essayService")
@Transactional
public class EssayServiceImpl implements EssayService {
    @Resource
    private EssayDao essayDao;
    @Resource
    private UserDao userDao;

    public void publishNewEssay(Essay essay) {
        //essay表新增一条记录
        essayDao.addEssay(essay);
        //user表对应的记录essay_count + 1
        User user = userDao.getUserById(essay.getUserId());
        if(user != null) {
            user.setEssayCount(user.getEssayCount() + 1);
            userDao.updateUser(user);
        }
    }

    public void readEssay(Essay essay) {
        //essay表reading_count+1
        essay.setReadingCount(essay.getReadingCount()+1);
        essayDao.updateEssay(essay);
        //user表score+1
        User user = userDao.getUserById(essay.getUserId());
        if(user != null) {
            user.setScore(user.getScore() + 1);
            userDao.updateUser(user);
        }
    }

}
