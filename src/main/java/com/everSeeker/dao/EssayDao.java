package com.everSeeker.dao;

import com.everSeeker.entity.Essay;
import org.springframework.stereotype.Repository;

/**
 * Created by pingping on 16/1/19.
 */
@Repository
public interface EssayDao {

    void addEssay(Essay essay);

    Essay getEssayByTitle(String title);

    Essay getEssayById(int id);

    void updateEssay(Essay essay);
}
