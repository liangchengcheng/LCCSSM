package com.lcc.ssm.controller;

import com.alibaba.fastjson.JSON;
import com.lcc.ssm.entity.User;
import com.lcc.ssm.service.JedisClient;
import com.lcc.ssm.service.UserService;
import com.lcc.ssm.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Created by liangchengcheng on 2017/6/14.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;;

    @Autowired
    private JedisClient jedisClient;

    @RequestMapping(value = "/insertUser", produces = "text/html;charset=UTF-8",
            method = {RequestMethod.GET, RequestMethod.GET})
    public String insertUser(String account, String country){
        User user = new User();
        user.setAccount(account);
        user.setCountry(country);
        userService.insertUser(user);
        return JSON.toJSONString(user);
    }

    @RequestMapping(value = "/queryAll", produces = "text/html;charset=UTF-8",
            method = {RequestMethod.GET, RequestMethod.GET})
    public String queryAll() {
        List<User> userList = userService.queryAll();
        return JSON.toJSONString(userList);
    }

    @RequestMapping(value = "/deleteUser", produces = "text/html;charset=UTF-8",
            method = {RequestMethod.GET, RequestMethod.GET})
    public String deleteUser(Long id) {
        int t = userService.deleteUser(id);
        return JSON.toJSONString(t);
    }

    @RequestMapping(value = "/queryById", produces = "text/html;charset=UTF-8",
            method = {RequestMethod.GET, RequestMethod.GET})
    public String queryById(Long id) {
        User user = userService.queryById(id);
        return JSON.toJSONString(user);
    }

    @RequestMapping(value = "/queryTopN", produces = "text/html;charset=UTF-8",
            method = {RequestMethod.GET, RequestMethod.GET})
    public String queryTopN() {
        List<User> userList = null;
        try {
            Set<String> resultSet = jedisClient.zgetAll("Toptest", (long) 0, (long) 20);
            System.out.println("resultSet    " + resultSet.toString());
            Iterator<String> iter = resultSet.iterator();
            if (resultSet.size() > 0) {
                //字符串转为list
                System.out.println("有缓存啦啦啦！！！");
                userList = new ArrayList<>();
                while (iter.hasNext()) {
                    //JSONArray array = JSONArray.parseArray(iter.next());
                    User user = JsonUtils.jsonObjectToUser(iter.next());
                    System.out.println("user   " + user.toString());
                    userList.add(user);
                }
                return JSON.toJSONString(userList);
            } else {
                System.out.println("Toptest没查过");
                userList = userService.queryTopN();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            jedisClient.zaddList("Toptest", userList);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return JSON.toJSONString(userList);
    }
}
