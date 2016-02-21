package com.everSeeker.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by pingping on 16/1/19.
 */
public class Essay implements Serializable {
    private int id;
    private String title;
    private Date createDate;
    private int userId;
    private int readingCount;
    private int commentCount;
    private String tag;

    /**
     * 必须定义默认的构造函数。否则在调用essayDao.getEssayByTitle(String title)等方法时会报以下错误。
     * org.mybatis.spring.MyBatisSystemException: nested exception is org.apache.ibatis.executor.ExecutorException:
     *      No constructor found in com.everSeeker.entity.Essay matching [java.lang.Integer, java.lang.String, java.sql.Timestamp, java.lang.Integer, java.lang.Integer, java.lang.Integer, java.lang.String]
     */
    public Essay() {}

    public Essay(String title, int userId, String tag) {
        this.title = title;
        this.createDate = new Date();
        this.userId = userId;
        this.readingCount = 0;
        this.commentCount = 0;
        this.tag = tag;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getReadingCount() {
        return readingCount;
    }

    public void setReadingCount(int readingCount) {
        this.readingCount = readingCount;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    @Override
    public String toString() {
        return "Essay [id=" + id + ", title=" + title + ", createDate" + createDate + ", userId=" + userId +
                ", readingCount=" + readingCount + ", commentCount=" + commentCount + ", tag=" + tag + "]";
    }
}
