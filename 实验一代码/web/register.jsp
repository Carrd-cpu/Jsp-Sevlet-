<%--<%@ page contentType="text/html;charset=UTF-8"%>--%>

<%--<html>--%>
<%--<head>--%>
<%--    <title>用户注册</title>--%>
<%--</head>--%>

<%--<body>--%>

<%--<h2>用户注册</h2>--%>

<%--<form action="register" method="post">--%>

<%--    用户名：--%>
<%--    <input type="text" name="userName"><br><br>--%>

<%--    密码：--%>
<%--    <input type="password" name="password"><br><br>--%>

<%--    性别：--%>
<%--    <input type="text" name="sex"><br><br>--%>

<%--    邮箱：--%>
<%--    <input type="text" name="email"><br><br>--%>

<%--    <input type="submit" value="注册">--%>

<%--</form>--%>

<%--</body>--%>
<%--</html>--%>
<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>

    <title>用户注册</title>

    <link rel="stylesheet" href="css/style.css">

</head>

<body>

<div class="nav">
    在线考试系统
</div>

<div class="container">

    <div class="card">

        <div class="title">
            用户注册
        </div>

        <form action="register" method="post">

            用户名
            <input type="text" name="userName">

            密码
            <input type="password" name="password">

            邮箱
            <input type="email" name="email">

            性别
            <input type="text" name="sex">

            <button type="submit">
                注册
            </button>

        </form>

    </div>

</div>

</body>
</html>