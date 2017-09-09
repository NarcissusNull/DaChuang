<%--
  Created by IntelliJ IDEA.
  User: 11697
  Date: 2017/7/1
  Time: 22:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  $END$
  <p><% out.print(session.getAttribute("user"));%></p>
  <form action="login.jsp">
    <input type="submit" value="登录">
  </form>
  </body>
</html>
