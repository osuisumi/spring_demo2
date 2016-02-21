package com.everSeeker.service.impl;

import com.everSeeker.dao.CommentDao;
import com.everSeeker.dao.EssayDao;
import com.everSeeker.dao.UserDao;
import com.everSeeker.entity.Comment;
import com.everSeeker.entity.Essay;
import com.everSeeker.entity.User;
import com.everSeeker.service.CommentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service("commentService")
@Transactional
public class CommentServiceImpl implements CommentService {
    @Resource
    private CommentDao commentDao;
    @Resource
    private EssayDao essayDao;
    @Resource
    private UserDao userDao;

    public void publishNewComment(Comment comment) {
        //comment表中新增一条记录
        commentDao.addComment(comment);
        //essay表comment_count+1
        Essay essay = essayDao.getEssayById(comment.getEssayId());
        if(essay != null) {
            essay.setCommentCount(essay.getCommentCount() + 1);
            essayDao.updateEssay(essay);
            //user表随笔作者对应的记录score+10
            User user = userDao.getUserById(essay.getUserId());
            if(user != null) {
                user.setScore(user.getScore() + 10);
                userDao.updateUser(user);
            }
        }
    }
}
