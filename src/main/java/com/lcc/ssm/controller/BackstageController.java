package com.lcc.ssm.controller;

import com.lcc.ssm.utils.CookieUtil;
import com.lcc.ssm.utils.JavaWebToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by liangchengcheng on 2017/6/29.
 */
@Controller
@RequestMapping("/backend")
public class BackstageController {

    @RequestMapping(value = "/loginPage", method = {RequestMethod.GET})
    public String loginPage(HttpServletRequest request, String account, String password) {
        return "login";
    }


    @RequestMapping(value = "/login", method = {RequestMethod.POST})
    public String login(HttpServletRequest request, HttpServletResponse response, RedirectAttributes model,
                        String account, String password) {
        if ("fuzu".equals(account) && "fuzhucheng".equals(password)){
            Map<String, Object> loginInfo = new HashMap<>();
            loginInfo.put("isLogin", "yes!");
            loginInfo.put("timestamp", new Date());
            String sessionId = JavaWebToken.createJavaWebToken(loginInfo);

            CookieUtil.addCookie(response,"isLogin",sessionId);
            return "redirect:loginSuccess";
        }else {
            model.addFlashAttribute("error","密码错误");
            return "redirect:loginPage";
        }
    }

    @RequestMapping(value = "/loginSuccess", method = {RequestMethod.GET})
    public String accusationPage(HttpServletRequest request) {
        return "success";
    }
    @RequestMapping(value = "/logOut", method = {RequestMethod.GET})
    public String loginOut(HttpServletRequest request, HttpServletResponse response) {
        CookieUtil.deleteCookie(response,"isLogin");
        return "redirect:loginPage";
    }
}
