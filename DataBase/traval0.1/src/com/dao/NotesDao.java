package com.dao;

import com.connect.DBAconnect;
import com.vo.Notes;
import com.vo.User;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 13190 on 2017/8/9.
 */
public class NotesDao {//具体文件的存取处理类
    public static List<Notes> selectall() throws SQLException {//搜索所有的用户内容，并返回一个User线性表
        Connection conn = null;//连接
        PreparedStatement pstmt = null;//处理于
        ResultSet rs = null;//游标
        List<Notes> list = new ArrayList<>();//线性表建立
        try{//主体部分
            conn = DBAconnect.getConnection();
            if (conn != null) {
                String sql = "select * from Notes";//sql语句进行
                pstmt = conn.prepareStatement(sql);//编译预处理
                rs = pstmt.executeQuery();//sql执行

                while (rs.next()) {
                    Notes notes=new Notes();
                    notes.setTextid(rs.getInt(1));
                    notes.setContent(rs.getString(2));
                    notes.setComment(rs.getString(3));
                    notes.setUploadtiem(rs.getString(4));
                    notes.setChangetime(rs.getString(5));
                    notes.setName(rs.getString(6));
                    notes.setAutor(rs.getString(7));
                    notes.setWhere(rs.getString(8));
                    notes.setChanger(rs.getString(9));
                    list.add(notes);
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
    public static List<Notes> select(String option) throws SQLException {//单项搜索
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Notes> list = new ArrayList<>();
        try {
            conn = DBAconnect.getConnection();
            if (conn != null) {
                String sql = "select " + option + " from Notes";//sql语句进行
                pstmt = conn.prepareStatement(sql);//编译预处理
                rs = pstmt.executeQuery();
                Notes notes = new Notes();
                if(option=="Textid")
                    notes.setTextid(rs.getInt(1));
                else if(option=="Content")
                    notes.setContent(rs.getString(1));
                else if(option=="Comment")
                    notes.setComment(rs.getString(1));
                else if(option=="Uploadtiem")
                    notes.setUploadtiem(rs.getString(1));
                else if(option=="Changetime")
                    notes.setChangetime(rs.getString(1));
                else if(option=="Name")
                    notes.setName(rs.getString(1));
                else if(option=="Autor")
                    notes.setAutor(rs.getString(1));
                else if(option=="Where")
                    notes.setWhere(rs.getString(1));
                else if(option=="Password")
                    notes.setChanger(rs.getString(1));
                else{
                    System.out.print("User输入格式错误，请检查，该表的正确输入格式为:/n Textid Content Comment Uploadtiem Changetime Name Autor Changer");
                    return null;
                }
                list.add(notes);
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
    public static List<Notes> select(String option,String conditon) throws SQLException {//单项搜索
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Notes> list = new ArrayList<>();
        try {
            conn = DBAconnect.getConnection();
            if (conn != null) {
                String sql = "select " + option + " from User where " + conditon;//sql语句进行
                pstmt = conn.prepareStatement(sql);//编译预处理
                rs = pstmt.executeQuery();
                Notes notes = new Notes();
                if (option == "Textid")
                    notes.setTextid(rs.getInt(1));
                else if (option == "Content")
                    notes.setContent(rs.getString(1));
                else if (option == "Comment")
                    notes.setComment(rs.getString(1));
                else if (option == "Uploadtiem")
                    notes.setUploadtiem(rs.getString(1));
                else if (option == "Changetime")
                    notes.setChangetime(rs.getString(1));
                else if (option == "Name")
                    notes.setName(rs.getString(1));
                else if (option == "Autor")
                    notes.setAutor(rs.getString(1));
                else if (option == "Where")
                    notes.setWhere(rs.getString(1));
                else if (option == "Changer")
                    notes.setChanger(rs.getString(1));
                else {
                    System.out.print("User输入格式错误，请检查，该表的正确输入格式为:/n Textid Content Comment Uploadtiem Changetime Name Autor Changer");
                    return null;
                }
                list.add(notes);
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
                String sql="delete  from Notes where "+condition;
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
    public static void update(String option,String values1,String condition,String values2) throws  SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = DBAconnect.getConnection();
            if (conn != null) {
                String sql = "update Notes set " + option + "=" + values1 + " where " + condition + "=" + values2;
                conn.prepareStatement(sql);
            }
        } catch (Exception e) {//sql抛出
            e.printStackTrace();
        } finally {
            rs.close();
            pstmt.close();
            conn.close();
        }
    }


    public static void update(String option, int values1, String condition, String values2) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn=DBAconnect.getConnection();
            if(conn!=null){
                String sql="update Notes set "+option+"="+values1+" where "+condition+"="+values2;
                conn.prepareStatement(sql);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
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
                String sql="update Notes set "+option+"="+values1+" where "+condition+"="+values2;
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
                String sql="update Notes set "+option+"="+values1+" where "+condition+"="+values2;
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

    public static void updateNotes(String notes) throws SQLException{//文件读取函数
        FileInputStream fis = null;
        File file = new File(notes);
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            fis = new FileInputStream(file);
            conn =DBAconnect.getConnection();
            try {
                pstmt= conn.prepareStatement("insert tesimg values(?)");
                pstmt.setBinaryStream(1, fis, (int) file.length());
                pstmt.executeUpdate();
            } catch (SQLException ex) {
                ex.printStackTrace();
            } finally {
                rs.close();
                pstmt.close();
                conn.close();
            }
        } catch (IOException ex1) {
            ex1.printStackTrace();
        } finally {
            try {
                fis.close();
            } catch (IOException ex2) {
                ex2.printStackTrace();
            }
        }

    }


}





