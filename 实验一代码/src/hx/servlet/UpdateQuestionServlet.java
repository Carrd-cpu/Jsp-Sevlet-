package hx.servlet;

import hx.dao.QuestionDao;
import hx.entity.Question;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/updateQuestion")
public class UpdateQuestionServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        String idStr = request.getParameter("id");
        String title = request.getParameter("title");
        String optionA = request.getParameter("optionA");
        String optionB = request.getParameter("optionB");
        String optionC = request.getParameter("optionC");
        String optionD = request.getParameter("optionD");
        String answer = request.getParameter("answer");

        if (idStr == null || idStr.isEmpty()) {
            response.sendRedirect("questionList?msg=missingId");
            return;
        }

        try {
            int id = Integer.parseInt(idStr);

            // 简单服务器端校验
            if (title == null) title = "";
            if (optionA == null) optionA = "";
            if (optionB == null) optionB = "";
            if (optionC == null) optionC = "";
            if (optionD == null) optionD = "";
            if (answer == null) answer = "";

            Question q = new Question();
            q.setQuestionId(id);
            q.setTitle(title.trim());
            q.setOptionA(optionA.trim());
            q.setOptionB(optionB.trim());
            q.setOptionC(optionC.trim());
            q.setOptionD(optionD.trim());
            q.setAnswer(answer.trim());

            QuestionDao dao = new QuestionDao();
            dao.updateQuestion(q);

            response.sendRedirect("questionList?msg=updated");
        } catch (NumberFormatException e) {
            response.sendRedirect("questionList?msg=invalidId");
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    // 支持 GET 请求重定向到列表
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("questionList");
    }
}

