<%--
  登录注册界面
  Created by IntelliJ IDEA.
  User: Narcissus
  Date: 2017/7/19
  Time: 16:01
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
    <head>
    	<meta charset="UTF-8">
    	<title>注册界面</title>
    </head>
    <body>
        <div class="text" style="text-align:center;">
            <p style="font-size: 30px;color:red;">亲，你还没有注册哦，快来注册吧！</p>
            <form action="signup.jsp" method="post">
                <input name="name_sugnup" type="text" style="height: 51px;width: 449px" placeholder="输入昵称"><br>
                <%--TODO[js判定用户名是否合法，是否存在，如果不合法或者已存在，注册按钮不可点击，并给出简单提示]--%>
                <input name="password_signup" type="text" style="height: 51px;width: 449px" placeholder="输入密码(6~12位)" ><br>
                <input name="password_signup_sure" type="text" style="height: 51px;width: 449px" placeholder="确认密码"><br>
                <%--TODO[js判定密码是否合法，两次输入密码是否一致，不合法或不一致，注册按钮不可点击，并给出简单提示]--%>
                <input type="submit" value="注册">
            </form>
	    </div>
	    <div class="text" style="text-align:center;" style=" width:100%; text-align:left; margin-left:15px; margin-right:15px;">
            <hr class="hrLine" style="width:50px;"/>
	        第三方登录
            <hr class="hrLine" style="width:50px;"/>
        </div>
        <div class="text" style="text-align:center;">
            <form action="login.jsp" method="POST">
                账号:<input name="name_login" type="text" style="height: 51px;width: 449px"><br>
                密码:<input name="password_login" type="password" style="height: 51px;width: 449px"><br>
                <input type="submit" value="登录">
            </form>
        </div>
    </body>
</html>