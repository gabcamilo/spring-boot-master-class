package com.gabrielacamilo.springbootmasterclass.dao;

import com.gabrielacamilo.springbootmasterclass.model.User;

import java.util.*;

public class FakeDataDao implements UserDao {

    private static Map<UUID, User> database;

    static {
        database = new HashMap<>();
        UUID joeUserUid = UUID.randomUUID();
        database.put(joeUserUid, new User(
                joeUserUid,
                "Joe",
                "Jones",
                User.Gender.MALE,
                22,
                "joe.jones@gmail.com"
                ));
    }

    @Override
    public List<User> selectAllUsers() {
        return new ArrayList<>(database.values());
    }

    @Override
    public User selectUserByUid(UUID userUid) {
        return database.get(userUid);
    }

    @Override
    public int updateUser(UUID userUid, User user) {
        database.put(user.getUserUid(), user);
        return 1;
    }

    @Override
    public int deleteUser(UUID userUid) {
        database.remove(userUid);
        return 1;
    }

    @Override
    public int insertUser(UUID userUid, User user) {
        database.put(userUid, user);
        return 1;
    }
}
