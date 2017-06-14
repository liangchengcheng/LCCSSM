package com.lcc.ssm.serviceimpl;

import com.lcc.ssm.dao.ScoreDao;
import com.lcc.ssm.dao.UserDao;
import com.lcc.ssm.entity.Score;
import com.lcc.ssm.entity.User;
import com.lcc.ssm.service.JedisClient;
import com.lcc.ssm.service.ScoreService;
import com.lcc.ssm.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Created by liangchengcheng on 2017/6/14.
 */
@Service
public class ScoreServiceImpl implements ScoreService {

    @Autowired
    private ScoreDao scoreDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private JedisClient jedisClient;

    @Override
    public int insertScore(Score score) {
        int t  = scoreDao.insertScore(score);
        return t;
    }

    @Override
    public List<Score> queryAll() {
        List<Score> scores = scoreDao.queryAll();
        return scores;
    }

    @Override
    public void updateScore(User user, int scoreCount) {
        User userFind = new User();
        Score score = new Score();
        score.setChangeType("做任务");
        score.setScore(scoreCount);
        score.setUser(user);
        scoreDao.insertScore(score);
        userDao.updateScore(user.getId(), scoreCount);

        Set<String> userSet = jedisClient.getTopLast("Toptest", (long) 0, (long) 5);
        Iterator<String> iter = userSet.iterator();
        List<User> userList = new ArrayList<>();
        while (iter.hasNext()) {
            User userTemp = JsonUtils.jsonObjectToUser(iter.next());
            System.out.println("user   " + user.toString());
            userList.add(userTemp);
            if (userTemp.getAccount().equals(user.getAccount())) {
                userFind = userTemp;
            }
        }
        //如果原本有的就修改原有的。
        if (userFind != null) {
            jedisClient.zadd("Toptest", (double) user.getScore(), userFind);
            System.out.println("修改原有的！！！");
            return;
        }
        //如果没有就加进去嘛，根据排行榜来区分
        if (userList.size() >= 20) {
            if (user.getScore() + scoreCount > userList.get(19).getScore()) {
                System.out.println("大于排名20名中的最后一名就丢进缓存    :");
                System.out.println("userList    :" + userList.toString());
            }
        } else {
            System.out.println("排行榜小于20人就直接丢进缓存    :");
            if (userFind != null) {
                jedisClient.zadd("Toptest", (double) user.getScore(), user);
            }
            System.out.println("user   " + userFind);
        }
    }

    @Override
    public List<Score> queryLimit(int offset, int limit) {
        List<Score> scoreList = scoreDao.queryLimit(offset, limit);
        return scoreList;
    }
}
