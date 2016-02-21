package com.everSeeker.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by pingping on 16/1/19.
 */
public class Comment implements Serializable {
    private int id;
    private String content;
    private int userId;
    private int essayId;
    private Date commentDate;

    public Comment() {}

    public Comment(String content, int userId, int essayId) {
        this.content = content;
        this.userId = userId;
        this.essayId = essayId;
        this.commentDate = new Date();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getEssayId() {
        return essayId;
    }

    public void setEssayId(int essayId) {
        this.essayId = essayId;
    }

    public Date getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(Date commentDate) {
        this.commentDate = commentDate;
    }

    @Override
    public String toString() {
        return "Comment [id=" + id + ", content=" + content + ", userId=" + userId + ", essayId=" + essayId +
                ", commentDate=" + commentDate + "]";
    }
}
