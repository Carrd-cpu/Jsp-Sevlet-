package hx.servlet;

import hx.dao.UserDao;
import hx.entity.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        UserDao dao = new UserDao();

        User user = dao.login(username,password);

        if(user!=null){

            HttpSession session = request.getSession();
            session.setAttribute("user",user);

            if("admin".equals(user.getRole())){
                response.sendRedirect("adminHome.jsp");
            }else{
                response.sendRedirect("userHome.jsp");
            }

        }else{
            response.sendRedirect("login.jsp?msg=error");
        }

    }
}