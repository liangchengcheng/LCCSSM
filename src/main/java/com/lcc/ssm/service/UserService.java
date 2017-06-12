package com.lcc.ssm.service;

import com.lcc.ssm.entity.User;

import java.util.List;

/**
 * Created by liangchengcheng on 2017/6/12.
 */
public interface UserService {

    //根据id查人
    User queryById(long id);

    //查询所有用户
    List<User> queryAll();

    //删除用户
    int deleteUser(long id);

    //增加用户
    int insertUser(User user);

    //排行榜的查找topN
    List<User> queryTopN();

    //根据省份查用户
    List<User> findUserByProvince(String province);

}
