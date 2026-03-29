package hx.servlet;

import hx.util.JdbcUtil;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

@WebServlet("/addQuestion")
public class AddQuestionServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,HttpServletResponse response)
            throws ServletException,IOException {

        request.setCharacterEncoding("utf-8");

        String title=request.getParameter("title");
        String optionA=request.getParameter("optionA");
        String optionB=request.getParameter("optionB");
        String optionC=request.getParameter("optionC");
        String optionD=request.getParameter("optionD");
        String answer=request.getParameter("answer");

        try{

            Connection conn= JdbcUtil.getConnection();

            String sql="insert into question(title,optionA,optionB,optionC,optionD,answer) values(?,?,?,?,?,?)";

            PreparedStatement ps=conn.prepareStatement(sql);

            ps.setString(1,title);
            ps.setString(2,optionA);
            ps.setString(3,optionB);
            ps.setString(4,optionC);
            ps.setString(5,optionD);
            ps.setString(6,answer);

            ps.executeUpdate();

            conn.close();

        }catch(Exception e){
            e.printStackTrace();
        }

        response.sendRedirect("questionList");

    }
}