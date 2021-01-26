package com.gabrielacamilo.springbootmasterclass.dao;

import com.gabrielacamilo.springbootmasterclass.model.User;

import java.util.List;
import java.util.UUID;

public interface UserDao {
    List<User> selectAllUsers();

    User selectUserByUid(UUID userUid);

    int updateUser(UUID userUid, User user);

    int deleteUser(UUID userUid);

    int insertUser(UUID userUid, User user);
}
