package com.lcc.ssm.utils;

import org.apache.commons.collections.map.HashedMap;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by liangchengcheng on 2017/6/9.
 * session 认证
 */
public class AuthUtil {
    private static Map<String,Object> getClientLoginInfo(HttpServletRequest request) throws Exception{
        Map<String,Object> r = new HashMap<>();
        String sessionId = request.getHeader("sessionId");
        if (sessionId != null){
            r = decodeSession(sessionId);
            return r;
        }
        throw new Exception("session解析错误");
    }

    /**
     * session解密
     */
    public static Map<String,Object> decodeSession(String sessionId){
        try{
            return verifyJavaWebToken(sessionId);
        }catch (Exception e){
            return null;
        }
    }

    private static Map<String,Object> verifyJavaWebToken(String sessionId) {
        Map<String,Object> r = new HashMap<>();
        if (sessionId !=null && !sessionId.equals("")){
            r.put("session",sessionId);
            return r;
        }
        return r;
    }
}
