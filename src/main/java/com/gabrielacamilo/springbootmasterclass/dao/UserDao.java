package com.gabrielacamilo.springbootmasterclass.dao;

import com.gabrielacamilo.springbootmasterclass.model.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserDao {
    List<User> selectAllUsers();

    Optional<User> selectUserByUid(UUID userUid);

    int updateUser(User user);

    int deleteUserByUserUid(UUID userUid);

    int insertUser(UUID userUid, User user);
}
