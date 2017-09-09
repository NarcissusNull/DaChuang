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
<%
    request.setCharacterEncoding("UTF-8");
    String user = request.getParameter("user");
    String password = request.getParameter("password");
    DBAconnect.Change("root","narcissus");
    //TODO[不同数据库需要更改不同账号密码]
%>
<% if(user==null){ %>
<%--如果没有表单输入，进入登录界面--%>
<% session.setAttribute("lastUrl",request.getHeader("Referer")); %>
<head>
    <meta charset="UTF-8">
    <title>登录界面</title>
    <link rel="stylesheet" href="css/login.css" type="text/css"/>
</head>
<body>
<section class="login-form-wrap">
    <h1>无名游记</h1>
    <!--form为表单标签，action规定提交表单时向何处发送数据-->
    <form class="login-form" method="post" action="login.jsp">
        <label>
            <input type="text" name="user" required placeholder="用户名">
        </label>
        <label>
            <input type="password" name="password" required placeholder="密码">
        </label>
        <input type="submit" value="Login">
    </form>
    <!--href为链接地址-->
    <h5><a href="#">忘记密码？</a></h5>
    <h6><a href="#">注册账号</a></h6>
    <%--TODO[添加注册和忘记密码界面]--%>
</section>
</body>
<% }else{ %>
<%--判断是否登录成功--%>
<%
    boolean loginLegal = false;
    try {
        loginLegal = UserDao.userExit(user,password);
    } catch (SQLException e) {
        e.printStackTrace();
    }
%>
<% if(loginLegal&&session.getAttribute("user")==null){ %>
<%--登录成功界面--%>
<% session.setAttribute("user",user); %>
<head>
    <meta charset="UTF-8">
    <title>登录成功</title>
    <link rel="stylesheet" type="text/css" href="css/login.successful.css">
</head>
<body>
<section class="login-form-wrap">
    <h1>恭喜你！登陆成功！</h1>
    <form action="<%= session.getAttribute("lastUrl") %>">
        <input type="submit" name="" value="返回">
    </form>
    <form action="index.jsp">
        <input type="submit" name="" value="确定">
    </form>
</section>
</body>
<% }else{ %>
<%--登录失败界面--%>
<head>
    <meta charset="UTF-8">
    <title>登录失败</title>
    <link rel="stylesheet" type="text/css" href="css/login.failure.css">
</head>
<body>
<section class="login-form-wrap">
    <h1>不好意思,您登陆失败</h1>
    <form action="javascript:history.go(-1)">
        <%--返回上一个页面并保留表单参数，back（-1）不保留参数--%>
        <input type="submit" name="" value="重试">
        <!--返回登陆界面重新登陆-->
    </form>
    <form action="index.jsp">
        <input type="submit" name="" value="确定">
        <!--返回未登录的网站首页，放弃重新登陆-->
    </form>
</section>
</body>
<% } %>
<% } %>
</html>