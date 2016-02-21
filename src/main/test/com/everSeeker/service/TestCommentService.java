package com.everSeeker.service;

import com.everSeeker.entity.Comment;
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
public class TestCommentService extends AbstractTransactionalJUnit4SpringContextTests {
    @Resource
    private CommentService commentService;

    @Test
    @Rollback(false)
    public void TestPublishNewComment() {
        Comment comment = new Comment("写的不错.", 3, 2);
        commentService.publishNewComment(comment);
    }
}
