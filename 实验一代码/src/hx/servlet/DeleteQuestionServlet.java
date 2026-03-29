package hx.servlet;

import hx.dao.QuestionDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/deleteQuestion")
public class DeleteQuestionServlet extends HttpServlet {

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
            dao.deleteQuestion(id);
        } catch (NumberFormatException e) {
            // invalid id, ignore and redirect
            e.printStackTrace();
        } catch (Exception e) {
            throw new ServletException(e);
        }
        response.sendRedirect("questionList");
    }
}
