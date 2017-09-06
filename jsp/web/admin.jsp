<%--
  Created by IntelliJ IDEA.
  User: Narcissus
  Date: 2017/7/24
  Time: 21:28
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>实验管理员界面</title>
    <link rel="stylesheet" type="text/css" href="main.css">
    <style type="text/css">
        input.nav_shoushuo{height: 51px;width: 449px;border: 1px solid red;font-size:25px;position: absolute;top:10px;left: 300px;}
        input.main_name{height: 45px;width: 150px;position: absolute;left: 100px;top:65px;font-size: 30px;}
        input.main_dlname{height: 45px;width: 150px;position: absolute;left: 400px;top:65px;font-size: 30px;}
        input.main_sex{height: 45px;width: 150px;position: absolute;left: 680px;top:65px;font-size: 30px;}
        input.main_phone{height: 45px;width: 180px;position: absolute;left: 1000px;top:65px;font-size: 30px;}
        input.main_zctime{height: 45px;width: 170px;position: absolute;left: 1320px;top:65px;font-size: 30px;}
        input.main_jifen{height: 45px;width: 150px;position: absolute;left: 100px;top:160px;font-size: 30px;}
        input.main_idnumber{height: 45px;width: 450px;position: absolute;left: 450px;top:160px;font-size: 30px;}
        input.main_shimiyouji{height: 45px;width: 150px;position: absolute;left: 1100px;top:160px;font-size: 30px;}
        p.welcome{font-size: 25px;float:left;}
        p.htgl_system{font-size: 25px;color: blue;text-align: right;float: right;}
        p.m_p_name{font-size: 25px;font-weight: bold;position: absolute;top: 55px;left: 20px; }
        p.m_dl_name{font-size: 25px;font-weight: bold;position: absolute;top: 55px;left: 300px;}
        p.m_sex{font-size: 25px;font-weight: bold;position: absolute;top: 55px;left: 600px;}
        p.m_phone{font-size: 25px;font-weight: bold;position: absolute;top: 55px;left: 880px;}
        p.m_zctime{font-size: 25px;font-weight: bold;position: absolute;top: 55px;left: 1200px;}
        p.m_jifen{font-size: 25px;font-weight: bold;position: absolute;top: 150px;left: 20px;}
        p.m_idnumber{font-size: 25px;font-weight: bold;position: absolute;top: 150px;left: 300px;}
        p.m_shimiyouji{font-size: 25px;font-weight: bold;position: absolute;top: 150px;left: 980px;}
        .btn{width: 80px;height: 50px;border:1px solid red;border-radius: 20px;background-color: green;position: absolute;top: 12px;left: 800px;cursor: pointer;}
        .nav{width: 1800px;margin: 0px;height: 60px;}
        .main{width: 1600px;height: 250px;background-color: yellow;position: absolute;left: 280px;top: 140px;}
        .siderbar{width: 260px;height: 735px;background-color: green; }
        .gaibian_part{background-color: red;position: absolute;left: 280px;top: 500px;width:1600px;height: 250px;}
        .m_zc_user{font-size: 25px;background-color: blue; color: white;
            position: absolute;left: 20px;width: 1500px;}
        .g_button{width:220px;height: 100px;font-size: 20px;margin: 10px;cursor: pointer;}
        button.main_shangyiye{width:50px;height: 35px;position: absolute;left: 700px;bottom: 0px;}
        button.main_xiayiye{width:50px;height: 35px;position: absolute;right: 700px;bottom: 0px;}
        .gai_buttona{width:160px;height: 160px;font-size: 20px;margin: 10px;cursor: pointer;}
        .gai_add{cursor: pointer;}
        .gai_delete{cursor: pointer;}
        .gai_bianji{cursor: pointer;}
        .gai_save{cursor: pointer;}
        .gai_quxiao{cursor: pointer;}
    </style>
</head>
<body>
<div class="nav">
    <input id="sr_username" class="nav_shoushuo" placeholder="站内搜索">
    <button id="search1" class="btn">搜索</button>
    <p class="htgl_system">后台管理系统</p>
    <p class="welcome">欢迎您,(管理员称号)   </p><br>
</div>
<form class="main">
    <p class="m_zc_user">注册用户信息</p><br>
    <p class="m_p_name">姓名:</p>
    <input id="user_name" class="main_name">
    <p class="m_dl_name">登录名:</p>
    <input id="dl_name" class="main_dlname">
    <p class="m_sex">性别:</p>
    <input id="sex" class="main_sex">
    <p class="m_phone">联系电话:</p>
    <input id="phonenumber" class="main_phone">
    <p class="m_zctime">注册时间:</p>
    <input id="zctime" class="main_zctime">
    <p class="m_jifen">积分:</p>
    <input id="jifen" class="main_jifen">
    <p class="m_idnumber">身份证号码:</p>
    <input id="idnumber" class="main_idnumber">
    <p class="m_shimiyouji">私密游记:</p>
    <input id="shimiyouji" class="main_shimiyouji">
    <button id="shangyiye" class="main_shangyiye">上一页</button>
    <button id="xiayiye" class="main_xiayiye">下一页</button>
</form>
<div class="gaibian_part">
    <button id="but6" class="gai_buttona">确认修改信息</button>
    <button id="but7" class="gai_add">添加</button>
    <button id="but8" class="gai_delete">删除</button>
    <button id="but9" class="gai_bianji">编辑</button>
    <button id="but10" class="gai_save">保存</button>
    <button id="but11" class="gai_quxiao">取消</button>
</div>
<div class="siderbar">
    <button id="but0" class="g_button">查看全部用户信息</button>
    <button id="but1" class="g_button">查看用户信息</button>
    <button id="but2" class="g_button">用户的浏览记录</button>
    <button id="but3" class="g_button">用户发布的评论</button>
    <button id="but4" class="g_button">用户上传的游记</button>
    <button id="but5" class="g_button">用户的私密游记</button>
</div>
</body>
</html>
