package com.everSeeker.dao;

import com.everSeeker.entity.Comment;
import org.springframework.stereotype.Repository;

/**
 * Created by pingping on 16/1/19.
 */
@Repository
public interface CommentDao {
    void addComment(Comment comment);
}
