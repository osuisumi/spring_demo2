package com.everSeeker.service;

import com.everSeeker.entity.Essay;

/**
 * Created by pingping on 16/1/19.
 */
public interface EssayService {
    /**
     * 发表新随笔
     */
    void publishNewEssay(Essay essay);

    /**
     * 阅读随笔
     */
    void readEssay(Essay essay);
}