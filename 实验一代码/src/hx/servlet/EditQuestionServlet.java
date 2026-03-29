package hx.servlet;

import hx.dao.QuestionDao;
import hx.entity.Question;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/editQuestion")
public class EditQuestionServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idStr = request.getParameter("id");
        if (idStr == null || idStr.isEmpty()) {
            response.sendRedirect("questionList");
            return;
        }
        try {
            int id = Integer.parseInt(idStr);
            QuestionDao dao = new QuestionDao();
            Question q = dao.getQuestionById(id);
            if (q == null) {
                // 未找到，重定向回列表并带提示
                response.sendRedirect("questionList?msg=notfound");
                return;
            }
            request.setAttribute("question", q);
            request.getRequestDispatcher("editQuestion.jsp").forward(request, response);
        } catch (NumberFormatException e) {
            response.sendRedirect("questionList?msg=invalidId");
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    // 允许以 POST 方式访问编辑页面（若有人用表单 POST 跳转到本 URL）
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
