<%@ page contentType="text/html;charset=UTF-8" %>

<html>

<head>

    <title>管理员主页</title>

    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">

</head>

<body>

<div class="nav">
    在线考试系统 - 管理员后台
</div>

<div class="container">

    <div class="card">

        <div class="title">
            管理员控制台
        </div>

        <p style="text-align:center;color:gray;">
            欢迎进入题库管理系统
        </p>

        <br>

        <a href="<%=request.getContextPath()%>/questionList">
            <button>
                查看试题
            </button>
        </a>

        <br><br>

        <a href="<%=request.getContextPath()%>/addQuestion.jsp">
            <button>
                添加试题
            </button>
        </a>

        <br><br>

        <a href="<%=request.getContextPath()%>/index.jsp">
            <button style="background:#dc3545;">
                退出系统
            </button>
        </a>

    </div>

</div>

</body>

</html>