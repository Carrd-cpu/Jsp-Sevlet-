package hx.dao;

import hx.entity.User;
import hx.util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDao {

    // 用户登录
    public User login(String username, String password) {

        User user = null;

        try {
            Connection conn = JdbcUtil.getConnection();

            String sql = "select * from Users where userName=? and password=?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if(rs.next()){

                user = new User();
                user.setUserId(rs.getInt("userId"));
                user.setUserName(rs.getString("userName"));
                user.setPassword(rs.getString("password"));
                user.setSex(rs.getString("sex"));
                user.setEmail(rs.getString("email"));
                user.setRole(rs.getString("role"));

            }

            rs.close();
            ps.close();
            conn.close();

        }catch (Exception e){
            e.printStackTrace();
        }

        return user;
    }


    // 用户注册
    public boolean register(User user){

        try {

            Connection conn = JdbcUtil.getConnection();

            String sql = "insert into Users(userName,password,sex,email,role) values(?,?,?,?,?)";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1,user.getUserName());
            ps.setString(2,user.getPassword());
            ps.setString(3,user.getSex());
            ps.setString(4,user.getEmail());
            ps.setString(5,"user");

            int result = ps.executeUpdate();

            ps.close();
            conn.close();

            if(result>0){
                return true;
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return false;
    }

}