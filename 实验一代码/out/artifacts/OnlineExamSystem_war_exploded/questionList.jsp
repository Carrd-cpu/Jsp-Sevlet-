<%--<%@ page contentType="text/html;charset=UTF-8" %>--%>
<%--<%@ page import="java.util.*,hx.entity.Question" %>--%>

<%--<html>--%>
<%--<head>--%>
<%--    <title>题目列表</title>--%>
<%--</head>--%>

<%--<body>--%>

<%--<h2>题库列表</h2>--%>

<%--<table border="1">--%>

<%--    <tr>--%>
<%--        <th>ID</th>--%>
<%--        <th>题目</th>--%>
<%--        <th>A</th>--%>
<%--        <th>B</th>--%>
<%--        <th>C</th>--%>
<%--        <th>D</th>--%>
<%--        <th>答案</th>--%>
<%--    </tr>--%>

<%--    <%--%>
<%--        List<Question> list = (List<Question>)request.getAttribute("list");--%>

<%--        for(Question q:list){--%>
<%--    %>--%>

<%--    <tr>--%>
<%--        <td><%=q.getQuestionId()%></td>--%>
<%--        <td><%=q.getTitle()%></td>--%>
<%--        <td><%=q.getOptionA()%></td>--%>
<%--        <td><%=q.getOptionB()%></td>--%>
<%--        <td><%=q.getOptionC()%></td>--%>
<%--        <td><%=q.getOptionD()%></td>--%>
<%--        <td><%=q.getAnswer()%></td>--%>
<%--    </tr>--%>

<%--    <%--%>
<%--        }--%>
<%--    %>--%>

<%--</table>--%>

<%--</body>--%>
<%--</html>--%>
<%--<%@ page import="java.util.*" %>--%>
<%--<%@ page import="hx.entity.Question" %>--%>
<%--<%@ page contentType="text/html;charset=UTF-8"%>--%>

<%--<html>--%>

<%--<head>--%>

<%--    <title>题库管理</title>--%>

<%--    <link rel="stylesheet" href="css/style.css">--%>

<%--</head>--%>

<%--<body>--%>

<%--<div class="nav">--%>
<%--    管理员 - 题库管理--%>
<%--</div>--%>

<%--<div class="container">--%>

<%--    <div class="card">--%>

<%--        <table border="1" width="100%" cellspacing="0">--%>

<%--            <tr>--%>

<%--                <th>ID</th>--%>
<%--                <th>题目</th>--%>
<%--                <th>答案</th>--%>

<%--            </tr>--%>

<%--            <%--%>

<%--                List<Question> list=(List<Question>)request.getAttribute("list");--%>

<%--                for(Question q:list){--%>

<%--            %>--%>

<%--            <tr>--%>

<%--                <td><%=q.getQuestionId()%></td>--%>

<%--                <td><%=q.getTitle()%></td>--%>

<%--                <td><%=q.getAnswer()%></td>--%>

<%--            </tr>--%>

<%--            <%--%>
<%--                }--%>
<%--            %>--%>

<%--        </table>--%>

<%--    </div>--%>

<%--</div>--%>

<%--</body>--%>

<%--</html>--%>
<%@ page import="java.util.*" %>
<%@ page import="hx.entity.Question" %>
<%@ page contentType="text/html;charset=UTF-8"%>

<html>

<head>

    <title>题库管理</title>

    <link rel="stylesheet" href="css/style.css">

</head>

<body>

<div class="nav">
    管理员 - 题库管理
</div>

<div class="container">

    <div class="card">

        <h2 style="text-align:center;">题库列表</h2>

        <br>

        <table border="1" width="100%" cellspacing="0" style="text-align:center">

            <tr>

                <th>ID</th>
                <th>题目</th>
                <th>正确答案</th>
                <th>操作</th>

            </tr>

            <%

                List<Question> list=(List<Question>)request.getAttribute("list");

                for(Question q:list){

            %>

            <tr>

                <td><%=q.getQuestionId()%></td>

                <td><%=q.getTitle()%></td>

                <td><%=q.getAnswer()%></td>

                <td>

                    <a href="deleteQuestion?id=<%=q.getQuestionId()%>">

                        <button style="background:red;color:white;border:none;padding:5px 10px;border-radius:4px;">
                            删除
                        </button>

                    </a>

                    &nbsp;

                    <a href="editQuestion?id=<%=q.getQuestionId()%>">

                        <button style="background:orange;color:white;border:none;padding:5px 10px;border-radius:4px;">
                            修改
                        </button>

                    </a>

                </td>

            </tr>

            <%
                }
            %>

        </table>

        <br>

        <a href="addQuestion.jsp">

            <button>
                添加新试题
            </button>

        </a>

    </div>

</div>

</body>

</html>
