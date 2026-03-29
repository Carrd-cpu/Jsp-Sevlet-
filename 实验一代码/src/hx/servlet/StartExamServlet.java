package hx.servlet;

import hx.dao.QuestionDao;
import hx.entity.Question;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.List;

@WebServlet("/startExam")
public class StartExamServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,HttpServletResponse response)
            throws IOException {

        QuestionDao dao = new QuestionDao();

        List<Question> list = dao.getRandomQuestion();

        request.setAttribute("list", list);

        try{
            request.getRequestDispatcher("exam.jsp").forward(request,response);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}