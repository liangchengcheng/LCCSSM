package com.lcc.ssm.controller;

import com.alibaba.fastjson.JSON;
import com.lcc.ssm.entity.Score;
import com.lcc.ssm.entity.User;
import com.lcc.ssm.service.ScoreService;
import com.lcc.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by liangchengcheng on 2017/6/27.
 */
@RestController
@RequestMapping("/score")
public class ScoreController {
    @Autowired
    private ScoreService scoreService;
    @Autowired
    private UserService userService;

    //更新成绩
    @RequestMapping(value = "/updateScore", produces = "text/html;charset=UTF-8", method = {RequestMethod.GET, RequestMethod.GET})
    public String updateScore(Long id,Integer scoreCount) {
        User user = userService.queryById(id);
        scoreService.updateScore(user,scoreCount);
        return JSON.toJSONString(user);
    }

    //分页查询
    @RequestMapping(value = "/queryLimit", produces = "text/html;charset=UTF-8", method = {RequestMethod.GET, RequestMethod.GET})
    public String queryLimit(int offset,  int limit) {
        List<Score> scoreList = scoreService.queryLimit(offset,limit);
        return JSON.toJSONString(scoreList);
    }
}