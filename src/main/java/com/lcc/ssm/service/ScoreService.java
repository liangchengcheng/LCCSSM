package com.lcc.ssm.service;

import com.lcc.ssm.entity.Score;
import com.lcc.ssm.entity.User;

import java.util.List;

/**
 * Created by liangchengcheng on 2017/6/12.
 */
public interface ScoreService {

    //插入积分记录
    public int insertScore(Score score);

    //查询全部积分记录.
    List<Score> queryAll();

    //修改用户积分
    void updateScore(User user, int scoreCount);

    /**
     * 限定查询用户积分记录，比如查询前10条
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     */
    List<Score> queryLimit(int offset, int limit);
}
