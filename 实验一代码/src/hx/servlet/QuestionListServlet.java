package hx.servlet;

import hx.dao.QuestionDao;
import hx.entity.Question;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.List;

@WebServlet("/questionList")
public class QuestionListServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        QuestionDao dao = new QuestionDao();

        List<Question> list = dao.getAllQuestion();

        request.setAttribute("list",list);

        request.getRequestDispatcher("questionList.jsp").forward(request,response);
    }
}