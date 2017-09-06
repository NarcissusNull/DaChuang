package com.dao;

import com.connect.DBAconnect;
import com.vo.Friend;
import com.vo.History;
import com.vo.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 13190 on 2017/8/3.
 * 将user打造为范本，将后来的重构一下
 */
public class UserDao {
    public static List<User> selectall() throws SQLException {//搜索所有的用户内容，并返回一个User线性表
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<User> list = new ArrayList<>();
        try{//主体部分
            conn = DBAconnect.getConnection();
            if (conn != null) {
                String sql = "select * from User";//sql语句进行
                pstmt = conn.prepareStatement(sql);//编译预处理
                rs = pstmt.executeQuery();//sql执行

                while (rs.next()) {
                    User user=new User();
                    user.setUserID(rs.getInt(1));
                    user.setIdentyid(rs.getString(2));
                    user.setNickname(rs.getString(3));
                    user.setRealname(rs.getString(4));
                    user.setPoint(rs.getInt(5));
                    user.setQq(rs.getString(6));
                    user.setPhone(rs.getString(7));
                    user.setPassword(rs.getString(8));
                    list.add(user);
                }
            }
        }
        catch (SQLException e){//sql抛出
            e.printStackTrace();
        }
        finally {
            rs.close();
            pstmt.close();
            conn.close();
        }
        return list;
    }
     public static List<User> select(String option) throws SQLException {//单项搜索
            Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<User> list = new ArrayList<>();
        try {
            conn = DBAconnect.getConnection();
            if (conn != null) {
                String sql = "select " + option + " from User";//sql语句进行
                pstmt = conn.prepareStatement(sql);//编译预处理
                rs = pstmt.executeQuery();
               User user = new User();
                if(option=="userID")
                    user.setUserID(rs.getInt(1));
                else if(option=="IdentyId")
                    user.setIdentyid(rs.getString(1));
                else if(option=="Nickname")
                    user.setNickname(rs.getString(1));
                else if(option=="Realname")
                    user.setRealname(rs.getString(1));
                else if(option=="Point")
                    user.setPoint(rs.getInt(1));
                else if(option=="Qq")
                    user.setQq(rs.getString(1));
                else if(option=="Phone")
                    user.setPhone(rs.getString(1));
                else if(option=="Password")
                    user.setPassword(rs.getString(1));
                else{
                    System.out.print("User输入格式错误，请检查，该表的正确输入格式为:/n userID IdentyId Nickname Realname Point Qq Password");
                    return null;
                }
                list.add(user);
            }
        } catch (SQLException e) {//sql抛出
            e.printStackTrace();
        } finally {
            rs.close();
            pstmt.close();
            conn.close();
        }
        return list;
    }

    public static List<User> select(String option,String conditon) throws SQLException {//单项搜索
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<User> list = new ArrayList<>();
        try {
            conn = DBAconnect.getConnection();
            if (conn != null) {
                String sql = "select " + option + " from User where "+conditon;//sql语句进行
                pstmt = conn.prepareStatement(sql);//编译预处理
                rs = pstmt.executeQuery();
                User user = new User();
                if(option=="userID")
                    user.setUserID(rs.getInt(1));
                else if(option=="IdentyId")
                    user.setIdentyid(rs.getString(1));
                else if(option=="Nickname")
                    user.setNickname(rs.getString(1));
                else if(option=="Realname")
                    user.setRealname(rs.getString(1));
                else if(option=="Point")
                    user.setPoint(rs.getInt(1));
                else if(option=="Qq")
                    user.setQq(rs.getString(1));
                else if(option=="Phone")
                    user.setPhone(rs.getString(1));
                else if(option=="Password")
                    user.setPassword(rs.getString(1));
                else{
                    System.out.print("User输入格式错误，请检查，该表的正确输入格式为:/n userID IdentyId Nickname Realname Point Qq Password");
                    return null;
                }
                list.add(user);
            }
        } catch (SQLException e) {//sql抛出
            e.printStackTrace();
        } finally {
            rs.close();
            pstmt.close();
            conn.close();
        }
        return list;
    }

    public static void  delete(String condition)throws SQLException{
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn=DBAconnect.getConnection();
            if(conn!=null){
                String sql="delete  from User where "+condition;
                pstmt=conn.prepareStatement(sql);
                pstmt = conn.prepareStatement(sql);//编译预处理
                rs= pstmt.executeQuery();
                pstmt.executeUpdate();
            }
        }
        catch (Exception e){//sql抛出
            e.printStackTrace();
        }
        finally {
            rs.close();
            pstmt.close();
            conn.close();
        }
    }
    public static void update(String option,String values1,String condition,String values2) throws  SQLException{
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try{
            conn=DBAconnect.getConnection();
            if(conn!=null){
                String sql="update User set "+option+"="+values1+" where "+condition+"="+values2;
                conn.prepareStatement(sql);
            }
        }
        catch (Exception e){//sql抛出
            e.printStackTrace();
        }
        finally {
            rs.close();
            pstmt.close();
            conn.close();
        }
    }
    public static void update(String option,int values1,String condition,String values2) throws  SQLException{
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try{
            conn=DBAconnect.getConnection();
            if(conn!=null){
                String sql="update User set "+option+"="+values1+" where "+condition+"="+values2;
                conn.prepareStatement(sql);
            }
        }
        catch (Exception e){//sql抛出
            e.printStackTrace();
        }
        finally {
            rs.close();
            pstmt.close();
            conn.close();
        }
    }
    public static void update(String option,int values1,String condition,int values2) throws  SQLException{
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try{
            conn=DBAconnect.getConnection();
            if(conn!=null){
                String sql="update User set"+option+"="+values1+" where"+condition+"="+values2;
                conn.prepareStatement(sql);
            }
        }
        catch (Exception e){//sql抛出
            e.printStackTrace();
        }
        finally {
            rs.close();
            pstmt.close();
            conn.close();
        }
    }
    public static void update(String option,String values1,String condition,int values2) throws  SQLException{
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try{
            conn=DBAconnect.getConnection();
            if(conn!=null){
                String sql="update User set"+option+"="+values1+" where"+condition+"="+values2;
                conn.prepareStatement(sql);
            }
        }
        catch (Exception e){//sql抛出
            e.printStackTrace();
        }
        finally {
            rs.close();
            pstmt.close();
            conn.close();
        }
    }
}
