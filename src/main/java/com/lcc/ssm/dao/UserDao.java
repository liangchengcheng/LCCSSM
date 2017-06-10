package com.lcc.ssm.dao;

import com.lcc.ssm.entity.User;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * Created by liangchengcheng on 2017/6/10.
 */
public interface UserDao {

    //根据id查人
    User queryById(long id);

    //查询所有用户
    List<User> queryAll();

    //删除用户
    int deleteUser(long id);

    //增加用户
    int insertUser(User user);

    //修改用户积分
    void updateScore(@Param("id") long id, @Param("scoreCount") int scoreCount);

    //排行榜的查找topN
    List<User> queryTopN();

    //根据省份查用户
    List<User> findUserByProvince(@Param("province") String province);

}
