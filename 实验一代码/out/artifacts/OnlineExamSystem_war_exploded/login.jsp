<%--<%@ page contentType="text/html;charset=UTF-8" %>--%>

<%--<html>--%>
<%--<head>--%>
<%--    <title>在线考试系统-登录</title>--%>
<%--</head>--%>

<%--<body>--%>

<%--<h2>用户登录</h2>--%>

<%--<form action="login" method="post">--%>

<%--    用户名：<input type="text" name="username"><br><br>--%>

<%--    密码：<input type="password" name="password"><br><br>--%>

<%--    <input type="submit" value="登录">--%>

<%--</form>--%>

<%--<%--%>
<%--    String msg=request.getParameter("msg");--%>
<%--    if("error".equals(msg)){--%>
<%--%>--%>

<%--<p style="color:red">用户名或密码错误</p>--%>

<%--<%--%>
<%--    }--%>
<%--%>--%>

<%--<a href="register.jsp">注册新用户</a>--%>

<%--</body>--%>
<%--</html>--%>
<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>

    <title>在线考试系统</title>

    <link rel="stylesheet" href="css/style.css">

</head>

<body>

<div class="nav">
    在线考试系统
</div>

<div class="container">

    <div class="card">

        <div class="title">
            用户登录
        </div>

        <form action="login" method="post">

            用户名
            <input type="text" name="username">

            密码
            <input type="password" name="password">

            <button type="submit">
                登录
            </button>

        </form>

        <br>

        <a href="register.jsp">没有账号？点击注册</a>

    </div>

</div>

</body>
</html>