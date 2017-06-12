package com.lcc.ssm.serviceimpl;

import com.lcc.ssm.dao.UserDao;
import com.lcc.ssm.entity.User;
import com.lcc.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by liangchengcheng on 2017/6/12.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public User queryById(long id) {
        User user = userDao.queryById(id);
        return user;
    }

    @Override
    public List<User> queryAll() {
        List<User> userList = userDao.queryAll();
        return userList;
    }

    @Override
    public int deleteUser(long id) {
        int t = userDao.deleteUser(id);
        return t;
    }

    @Override
    public int insertUser(User user) {
        int t = userDao.insertUser(user);
        return t;
    }

    @Override
    public List<User> queryTopN() {
        List<User> userList = userDao.queryTopN();
        return userList;
    }

    @Override
    public List<User> findUserByProvince(String province) {
        List<User> userList = userDao.findUserByProvince(province);
        System.out.println(userList.toString());
        return userList;
    }
}