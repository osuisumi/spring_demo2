package com.everSeeker.service;

import com.everSeeker.entity.Comment;

/**
 * Created by pingping on 16/1/19.
 */
public interface CommentService {

    /**
     * 发表评论
     */
    void publishNewComment(Comment comment);
}
