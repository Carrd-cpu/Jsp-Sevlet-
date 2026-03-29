package hx.servlet;

import hx.util.JdbcUtil;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,HttpServletResponse response)
            throws IOException {

        request.setCharacterEncoding("utf-8");

        String userName=request.getParameter("userName");
        String password=request.getParameter("password");
        String sex=request.getParameter("sex");
        String email=request.getParameter("email");

        try{

            Connection conn= JdbcUtil.getConnection();

            String sql="insert into Users(userName,password,sex,email,role) values(?,?,?,?,?)";

            PreparedStatement ps=conn.prepareStatement(sql);

            ps.setString(1,userName);
            ps.setString(2,password);
            ps.setString(3,sex);
            ps.setString(4,email);
            ps.setString(5,"user");

            ps.executeUpdate();

            conn.close();

        }catch(Exception e){
            e.printStackTrace();
        }

        response.sendRedirect("login.jsp");
    }
}