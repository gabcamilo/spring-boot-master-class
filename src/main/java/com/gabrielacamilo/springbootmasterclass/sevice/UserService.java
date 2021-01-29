package com.gabrielacamilo.springbootmasterclass.sevice;

import com.gabrielacamilo.springbootmasterclass.dao.UserDao;
import com.gabrielacamilo.springbootmasterclass.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    private final UserDao userDao;

    @Autowired
    public UserService(UserDao userDao) {
        this.userDao=userDao;
    }

    public List<User> getAllUsers() {
        return userDao.selectAllUsers();
    }

    public Optional<User> getUser(UUID userUid) {
        return userDao.selectUserByUid(userUid);
    }

    public int updateUser(UUID userUid, User user) {
        Optional<User> optionalUser = getUser(userUid);
        if (optionalUser.isPresent()){
            userDao.updateUser(user);
            return 1;
        }
        return -1;
    }

    public int removeUser(UUID userUid) {
        Optional<User> optionalUser = getUser(userUid);
        if (optionalUser.isPresent()){
            userDao.deleteUserByUserUid(userUid);
            return 1;
        }
        return -1;
    }

    public int insertUser(User user) {
        return userDao.insertUser(UUID.randomUUID(), user);
    }
}
