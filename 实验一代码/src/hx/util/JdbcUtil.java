package hx.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcUtil {

    private static String driver = "com.mysql.cj.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3306/examdb?useSSL=false&serverTimezone=UTC";
    private static String username = "root";
    private static String password = "20120104";   // 改成你的mysql密码

    public static Connection getConnection() {
        try {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url, username, password);
            return conn;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}