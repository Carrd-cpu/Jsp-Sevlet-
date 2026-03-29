package hx.util;

import java.sql.Connection;

public class TestDB {

    public static void main(String[] args) {

        Connection conn = JdbcUtil.getConnection();

        if(conn != null){
            System.out.println("数据库连接成功！");
        }else{
            System.out.println("数据库连接失败！");
        }

    }
}