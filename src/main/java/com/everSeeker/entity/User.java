package com.everSeeker.entity;

import java.io.Serializable;

/**
 * 对象的序列化 class implements Serializable
 * 参考文档：http://www.cnblogs.com/xudong-bupt/archive/2013/05/19/3086493.html
 */
public class User implements Serializable {
    private int id;
    private String username;
    private String password;
    private int score;
    private int ranking;
    private int essayCount;

    public User() {}

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        score = 0;
        ranking = 0;
        essayCount = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public int getEssayCount() {
        return essayCount;
    }

    public void setEssayCount(int essayCount) {
        this.essayCount = essayCount;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", username=" + username + ", password=" + password + ", score=" + score +
                ", rankding=" + ranking + ", essayCount=" + essayCount + "]";
    }
}
