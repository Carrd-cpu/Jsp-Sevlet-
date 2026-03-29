package hx.dao;

import hx.entity.User;

public class TestUserDao {

    public static void main(String[] args) {

        UserDao dao = new UserDao();

        User user = dao.login("Carrd","123456");

        if(user!=null){
            System.out.println("登录成功");
            System.out.println("用户名："+user.getUserName());
            System.out.println("角色："+user.getRole());
        }else{
            System.out.println("登录失败");
        }

    }
}