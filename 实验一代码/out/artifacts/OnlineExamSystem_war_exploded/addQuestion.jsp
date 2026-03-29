<%--<%@ page contentType="text/html;charset=UTF-8" %>--%>

<%--<html>--%>
<%--<head>--%>
<%--    <title>添加题目</title>--%>
<%--</head>--%>

<%--<body>--%>

<%--<h2>添加试题</h2>--%>

<%--<form action="addQuestion" method="post">--%>

<%--    题目：<input type="text" name="title"><br><br>--%>

<%--    A：<input type="text" name="optionA"><br><br>--%>

<%--    B：<input type="text" name="optionB"><br><br>--%>

<%--    C：<input type="text" name="optionC"><br><br>--%>

<%--    D：<input type="text" name="optionD"><br><br>--%>

<%--    答案：--%>
<%--    <select name="answer">--%>
<%--        <option>A</option>--%>
<%--        <option>B</option>--%>
<%--        <option>C</option>--%>
<%--        <option>D</option>--%>
<%--    </select>--%>

<%--    <br><br>--%>

<%--    <input type="submit" value="添加">--%>

<%--</form>--%>

<%--</body>--%>
<%--</html>--%>
<%@ page contentType="text/html;charset=UTF-8" %>

<html>

<head>

    <title>添加试题</title>

    <link rel="stylesheet" href="css/style.css">

</head>

<body>

<div class="nav">
    添加试题
</div>

<div class="container">

    <div class="card">

        <div class="title">
            新增试题
        </div>

        <form action="addQuestion" method="post">

            题目

            <input type="text" name="title">

            选项A

            <input type="text" name="optionA">

            选项B

            <input type="text" name="optionB">

            选项C

            <input type="text" name="optionC">

            选项D

            <input type="text" name="optionD">

            正确答案

            <input type="text" name="answer">

            <button type="submit">
                添加试题
            </button>

        </form>

    </div>

</div>

</body>

</html>
