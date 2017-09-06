<%--
  注册结果界面
  Created by IntelliJ IDEA.
  User: Narcissus
  Date: 2017/7/20
  Time: 12:34
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <meta charset="UTF-8">
        <%
            boolean legal = false;
            String name     = request.getParameter("name_signup");
            String password = request.getParameter("password_signup");
            //TODO[判断name是否存在数据库中，如果不在，修改lagel值，并将数据存入数据库]
        %>
        <title>注册成功</title>
        <title>注册失败</title>
    </head>
    <body>

    </body>
</html>
