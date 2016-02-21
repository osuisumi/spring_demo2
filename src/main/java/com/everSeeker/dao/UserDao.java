package com.everSeeker.dao;

import com.everSeeker.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {

    void addUser(@Param("user") User user);

    User getUserById(int id);

    User getUserByUsername(@Param("username") String username);

    void updateUser(User user);

    void rankingByScore();
}
