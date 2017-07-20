<%--
  Created by IntelliJ IDEA.
  User: Narcissus
  Date: 2017/7/19
  Time: 16:01
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <%
            boolean legal = false;
            String name     = request.getParameter("name_login");
            String password = request.getParameter("password_login");
            //TODO[在数据库里查name和password，修改legal的值]
        %>
        <% if(legal){ %>
        <title>登录成功</title>
        <% }else{ %>
        <title>登录失败</title>
        <% } %>
    </head>
    <body>
    </body>
</html>
