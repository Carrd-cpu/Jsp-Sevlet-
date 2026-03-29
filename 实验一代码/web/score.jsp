<%--<%@ page contentType="text/html;charset=UTF-8"%>--%>

<%--<html>--%>
<%--<head>--%>
<%--    <title>考试成绩</title>--%>
<%--</head>--%>

<%--<body>--%>

<%--<h2>考试结束</h2>--%>

<%--你的成绩是：--%>

<%--<h1>--%>
<%--    ${score}--%>
<%--</h1>--%>

<%--<a href="userHome.jsp">返回首页</a>--%>

<%--</body>--%>
<%--</html>--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>

<head>

    <title>考试成绩</title>

    <link rel="stylesheet" href="css/style.css">

</head>

<body>

<div class="nav">
    考试结果
</div>

<div class="container">

    <div class="card">

        <div class="title">

            你的成绩是：

            ${score}

        </div>

        <a href="startExam">

            <button>
                重新考试
            </button>

        </a>

    </div>

</div>

</body>

</html>