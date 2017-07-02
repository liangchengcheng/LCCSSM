<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: liangchengcheng
  Date: 2017/7/2
  Time: 上午10:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户登录界面</title>
</head>
<body>
<c:if test="${error!=null}">
    <div class="alert alert-error">
        <a class="close" data-dismiss="alert">
            x
        </a>
        密码错误
    </div>
</c:if>


<form action="/backend/login" method="post" align="center">
    用户名:<input type="text" name="account"><br>
    密码:<input type="password" name="password"><br>
    <input type="submit" value="登录">
</form>
</body>
</html>
