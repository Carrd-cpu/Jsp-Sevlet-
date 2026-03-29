<%--<%@ page contentType="text/html;charset=UTF-8"%>--%>
<%--<%@ page import="java.util.*,hx.entity.Question"%>--%>

<%--<html>--%>
<%--<head>--%>
<%--    <title>在线考试</title>--%>
<%--</head>--%>

<%--<body>--%>

<%--<h2>在线考试</h2>--%>

<%--<form action="submitExam" method="post">--%>

<%--    <%--%>
<%--        List<Question> list=(List<Question>)request.getAttribute("list");--%>

<%--        for(Question q:list){--%>
<%--    %>--%>

<%--    <p><%=q.getTitle()%></p>--%>

<%--    <input type="radio" name="q<%=q.getQuestionId()%>" value="A">--%>
<%--    A <%=q.getOptionA()%><br>--%>

<%--    <input type="radio" name="q<%=q.getQuestionId()%>" value="B">--%>
<%--    B <%=q.getOptionB()%><br>--%>

<%--    <input type="radio" name="q<%=q.getQuestionId()%>" value="C">--%>
<%--    C <%=q.getOptionC()%><br>--%>

<%--    <input type="radio" name="q<%=q.getQuestionId()%>" value="D">--%>
<%--    D <%=q.getOptionD()%><br><br>--%>
<%--    <%--%>
<%--        }--%>
<%--    %>--%>

<%--    <input type="submit" value="提交试卷">--%>

<%--</form>--%>

<%--</body>--%>
<%--</html>--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="hx.entity.Question" %>

<html>
<head>

    <title>在线考试</title>

    <link rel="stylesheet" href="css/style.css">

</head>

<body>

<div class="nav">
    在线考试系统 - 开始考试
</div>

<div class="container">

    <div class="card">

        <form action="submitExam" method="post">

            <%

                List<Question> list=(List<Question>)request.getAttribute("list");

                int i=1;

                for(Question q:list){

            %>

            <div class="question">

                <b><%=i++%>. <%=q.getTitle()%></b>

                <br><br>

                <input type="radio" name="q<%=q.getQuestionId()%>" value="A">
                A <%=q.getOptionA()%>

                <br>

                <input type="radio" name="q<%=q.getQuestionId()%>" value="B">
                B <%=q.getOptionB()%>

                <br>

                <input type="radio" name="q<%=q.getQuestionId()%>" value="C">
                C <%=q.getOptionC()%>

                <br>

                <input type="radio" name="q<%=q.getQuestionId()%>" value="D">
                D <%=q.getOptionD()%>

            </div>

            <%
                }
            %>

            <button type="submit">
                提交试卷
            </button>

        </form>

    </div>

</div>

</body>
</html>