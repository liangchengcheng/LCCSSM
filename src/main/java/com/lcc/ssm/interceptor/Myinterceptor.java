package com.lcc.ssm.interceptor;

import com.lcc.ssm.utils.AuthUtil;
import com.lcc.ssm.utils.CookieUtil;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.Map;

/**
 * Created by 符柱成 on 2017/4/28.
 */
public class Myinterceptor implements HandlerInterceptor {

    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        //拿到cookie
        //也就是获取session里的登录状态值
        String cookie = CookieUtil.getByName(httpServletRequest, "isLogin");
        if (cookie != null) {
            //session解密，我们工程session对于自身的工程来说有相对的安全机制，也就是一些加密什么的，所以获取需解密
            Map<String, Object> map = AuthUtil.decodeSession(cookie);
            String loginStatus = (String) map.get("isLogin");
            Long timestamp = (Long) map.get("timestamp");
            if (loginStatus != null && timestamp != null && new Date().getTime() - timestamp < 1000 * 60 * 60 * 24 * 10) {
                return true;
            }
        }
        //没有找到登录状态则重定向到登录页，返回false，不执行原来controller的方法
        httpServletResponse.sendRedirect("/backend/loginPage");
        return false;
    }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

        System.out.println("postHandle run!");
    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

        System.out.println("afterCompletion run!");
    }
}
