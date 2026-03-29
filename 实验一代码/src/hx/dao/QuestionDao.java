//package hx.dao;
//
//import hx.entity.Question;
//import hx.util.JdbcUtil;
//
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.List;
//
//public class QuestionDao {
//
//    // 查询所有题目
//    public List<Question> getAllQuestion() {
//
//        List<Question> list = new ArrayList<>();
//
//        try {
//            Connection conn = JdbcUtil.getConnection();
//
//            String sql = "select * from question";
//            PreparedStatement ps = conn.prepareStatement(sql);
//
//            ResultSet rs = ps.executeQuery();
//
//            while(rs.next()){
//
//                Question q = new Question();
//
//                q.setQuestionId(rs.getInt("questionId"));
//                q.setTitle(rs.getString("title"));
//                q.setOptionA(rs.getString("optionA"));
//                q.setOptionB(rs.getString("optionB"));
//                q.setOptionC(rs.getString("optionC"));
//                q.setOptionD(rs.getString("optionD"));
//                q.setAnswer(rs.getString("answer"));
//
//                list.add(q);
//            }
//
//            conn.close();
//
//        }catch(Exception e){
//            e.printStackTrace();
//        }
//
//        return list;
//    }
//
//}
package hx.dao;

import hx.entity.Question;
import hx.util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class QuestionDao {

    // 查询所有题目
    public List<Question> getAllQuestion(){

        List<Question> list = new ArrayList<>();

        try{

            Connection conn = JdbcUtil.getConnection();

            String sql = "select * from question";

            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){

                Question q = new Question();

                q.setQuestionId(rs.getInt("questionId"));
                q.setTitle(rs.getString("title"));
                q.setOptionA(rs.getString("optionA"));
                q.setOptionB(rs.getString("optionB"));
                q.setOptionC(rs.getString("optionC"));
                q.setOptionD(rs.getString("optionD"));
                q.setAnswer(rs.getString("answer"));

                list.add(q);
            }

            conn.close();

        }catch(Exception e){
            e.printStackTrace();
        }

        return list;
    }


    // 随机抽取4道题
    public List<Question> getRandomQuestion(){

        List<Question> list = new ArrayList<>();

        try{

            Connection conn = JdbcUtil.getConnection();

            String sql = "SELECT * FROM question ORDER BY RAND() LIMIT 4";

            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){

                Question q = new Question();

                q.setQuestionId(rs.getInt("questionId"));
                q.setTitle(rs.getString("title"));
                q.setOptionA(rs.getString("optionA"));
                q.setOptionB(rs.getString("optionB"));
                q.setOptionC(rs.getString("optionC"));
                q.setOptionD(rs.getString("optionD"));
                q.setAnswer(rs.getString("answer"));

                list.add(q);
            }

            conn.close();

        }catch(Exception e){
            e.printStackTrace();
        }

        return list;
    }


    // 添加题目
    public void addQuestion(Question q){

        try{

            Connection conn = JdbcUtil.getConnection();

            String sql = "insert into question(title,optionA,optionB,optionC,optionD,answer) values(?,?,?,?,?,?)";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1,q.getTitle());
            ps.setString(2,q.getOptionA());
            ps.setString(3,q.getOptionB());
            ps.setString(4,q.getOptionC());
            ps.setString(5,q.getOptionD());
            ps.setString(6,q.getAnswer());

            ps.executeUpdate();

            conn.close();

        }catch(Exception e){
            e.printStackTrace();
        }
    }


    // 删除题目
    public void deleteQuestion(int id){

        try{

            Connection conn = JdbcUtil.getConnection();

            String sql = "delete from question where questionId=?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1,id);

            ps.executeUpdate();

            conn.close();

        }catch(Exception e){
            e.printStackTrace();
        }
    }


    // 根据ID查询题目
    public Question getQuestionById(int id){

        Question q = null;

        try{

            Connection conn = JdbcUtil.getConnection();

            String sql = "select * from question where questionId=?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1,id);

            ResultSet rs = ps.executeQuery();

            if(rs.next()){

                q = new Question();

                q.setQuestionId(rs.getInt("questionId"));
                q.setTitle(rs.getString("title"));
                q.setOptionA(rs.getString("optionA"));
                q.setOptionB(rs.getString("optionB"));
                q.setOptionC(rs.getString("optionC"));
                q.setOptionD(rs.getString("optionD"));
                q.setAnswer(rs.getString("answer"));
            }

            conn.close();

        }catch(Exception e){
            e.printStackTrace();
        }

        return q;
    }


    // 修改题目
    public void updateQuestion(Question q){

        try{

            Connection conn = JdbcUtil.getConnection();

            String sql = "update question set title=?,optionA=?,optionB=?,optionC=?,optionD=?,answer=? where questionId=?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1,q.getTitle());
            ps.setString(2,q.getOptionA());
            ps.setString(3,q.getOptionB());
            ps.setString(4,q.getOptionC());
            ps.setString(5,q.getOptionD());
            ps.setString(6,q.getAnswer());
            ps.setInt(7,q.getQuestionId());

            ps.executeUpdate();

            conn.close();

        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
