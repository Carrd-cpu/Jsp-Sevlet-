package hx.servlet;

import hx.dao.QuestionDao;
import hx.entity.Question;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.List;

@WebServlet("/submitExam")
public class SubmitExamServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,HttpServletResponse response)
            throws ServletException,IOException {

        QuestionDao dao=new QuestionDao();

        List<Question> list=dao.getAllQuestion();

        int score=0;

        for(Question q:list){

            String answer=request.getParameter("q"+q.getQuestionId());

            if(answer!=null && answer.equals(q.getAnswer())){
                score+=10;
            }
        }

        request.setAttribute("score",score);

        request.getRequestDispatcher("score.jsp").forward(request,response);
    }
}