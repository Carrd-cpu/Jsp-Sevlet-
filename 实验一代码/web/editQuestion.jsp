<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="hx.entity.Question" %>
<%@ page import="java.util.*" %>

<%
    // 从 request 中读取 question（如果存在则为编辑模式）
    Question q = (Question) request.getAttribute("question");
    boolean isEdit = (q != null);
    String pageTitle = isEdit ? "编辑题目" : "新增题目";
    String actionUrl = isEdit ? "updateQuestion" : "addQuestion"; // 注意：updateQuestion servlet 需自己实现
    String msg = request.getParameter("msg");
%>

<html>
<head>
    <title><%= pageTitle %></title>
    <link rel="stylesheet" href="css/style.css">
    <style>
        /* 页面局部样式，和项目 style.css 保持一致的简单补充 */
        .form-row { margin: 12px 0; }
        .form-row label { display:block; font-weight: bold; margin-bottom:6px; }
        .form-row input[type="text"], .form-row select { width: 100%; padding:8px; box-sizing: border-box; }
        .actions { margin-top: 18px; }
        .actions button { padding:10px 16px; margin-right:8px; }
        .hint { color: #d9534f; margin-bottom:10px; }
        .small { font-size: 0.9em; color: #666; }
    </style>
    <script>
        function validateForm() {
            var title = document.getElementById('title').value.trim();
            var a = document.getElementById('optionA').value.trim();
            var b = document.getElementById('optionB').value.trim();
            var c = document.getElementById('optionC').value.trim();
            var d = document.getElementById('optionD').value.trim();
            var answer = document.getElementById('answer').value;

            if (!title) { alert('请输入题目内容'); return false; }
            if (!a || !b || !c || !d) { alert('请完整填写所有选项'); return false; }
            if (!answer) { alert('请选择正确答案'); return false; }
            return true;
        }

        function confirmDelete(id) {
            if (!id) return;
            if (confirm('确定要删除该题目吗？此操作不可撤销。')) {
                window.location.href = 'deleteQuestion?id=' + encodeURIComponent(id);
            }
        }
    </script>
</head>
<body>

<div class="nav">
    管理员 - <%= pageTitle %>
</div>

<div class="container">
    <div class="card">

        <div class="title">
            <%= pageTitle %>
        </div>

        <% if (msg != null) { %>
        <div class="hint"><%= msg %></div>
        <% } %>

        <form action="<%= actionUrl %>" method="post" onsubmit="return validateForm();">

            <% if (isEdit) { %>
            <!-- 编辑时需要提交 id -->
            <input type="hidden" name="id" value="<%= q.getQuestionId() %>">
            <% } %>

            <div class="form-row">
                <label for="title">题目</label>
                <input type="text" id="title" name="title" value="<%= isEdit ? q.getTitle() : "" %>">
            </div>

            <div class="form-row">
                <label for="optionA">选项 A</label>
                <input type="text" id="optionA" name="optionA" value="<%= isEdit ? q.getOptionA() : "" %>">
            </div>

            <div class="form-row">
                <label for="optionB">选项 B</label>
                <input type="text" id="optionB" name="optionB" value="<%= isEdit ? q.getOptionB() : "" %>">
            </div>

            <div class="form-row">
                <label for="optionC">选项 C</label>
                <input type="text" id="optionC" name="optionC" value="<%= isEdit ? q.getOptionC() : "" %>">
            </div>

            <div class="form-row">
                <label for="optionD">选项 D</label>
                <input type="text" id="optionD" name="optionD" value="<%= isEdit ? q.getOptionD() : "" %>">
            </div>

            <div class="form-row">
                <label for="answer">正确答案</label>
                <select id="answer" name="answer">
                    <option value="">-- 请选择 --</option>
                    <option value="A" <%= isEdit && "A".equals(q.getAnswer()) ? "selected" : "" %>>A</option>
                    <option value="B" <%= isEdit && "B".equals(q.getAnswer()) ? "selected" : "" %>>B</option>
                    <option value="C" <%= isEdit && "C".equals(q.getAnswer()) ? "selected" : "" %>>C</option>
                    <option value="D" <%= isEdit && "D".equals(q.getAnswer()) ? "selected" : "" %>>D</option>
                </select>
            </div>

            <div class="actions">
                <button type="submit"><%= isEdit ? "保存修改" : "添加试题" %></button>

                <a href="questionList">
                    <button type="button">返回题库列表</button>
                </a>

                <% if (isEdit) { %>
                <button type="button" style="background:#d9534f;color:white;" onclick="confirmDelete('<%= q.getQuestionId() %>')">
                    删除该题
                </button>
                <% } %>
            </div>

            <div class="small" style="margin-top:12px;">
                提示：正确答案请选择字母（A/B/C/D）。若要支持更多类型题目（填空/主观等），可在后续扩展字段和后端处理逻辑。
            </div>

        </form>

    </div>
</div>

</body>
</html>
