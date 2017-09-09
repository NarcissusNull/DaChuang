<%@ page import="com.connect.DBAconnect" %>
<%@ page import="com.dao.UserDao" %>
<%@ page import="java.sql.SQLException" %><%--
  Created by IntelliJ IDEA.
  User: Narcissus
  Date: 2017/9/8
  Time: 10:02
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html >
<head>
    <meta charset="UTF-8">
    <title>登录界面</title>
    <link rel="stylesheet" href="login.new.css" type="text/css"/>
</head>
<body>
<%
    request.setCharacterEncoding("UTF-8");
    String user = request.getParameter("user");
    String password = request.getParameter("password");
    DBAconnect.Change("root","narcissus");
    //TODO[不同数据库需要更改不同账号密码]
%>
<% if(user==null){ %>
<section class="login-form-wrap">
    <h1>无名游记</h1>
    <!--form为表单标签，action规定提交表单时向何处发送数据-->
    <form class="login-form" method="post" action="login.new.jsp">
        <label>
            <input type="text" name="user" required placeholder="手机/邮箱">
        </label>
        <label>
            <input type="password" name="password" required placeholder="密码">
        </label>
        <input type="submit" value="Login">
    </form>
    <!--href为链接地址-->
    <h5><a href="#">忘记密码？</a></h5>
    <h6><a href="#">注册账号</a></h6>
</section>
<% }else{ %>
<%
    boolean loginLegal = false;
    try {
        loginLegal = UserDao.userExit(user,password);
    } catch (SQLException e) {
        e.printStackTrace();
    }
%>
<% if(loginLegal){ %>
    <%--TODO[登陆成功页面]--%>
<% }else{ %>
    <%--TODO[登录失败页面]--%>
<% } %>
<% } %>
</body>
</html>