package com.dao;

import com.connect.DBAconnect;
import com.vo.Line;
import com.vo.Scene;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 13190 on 2017/8/9.
 */
public class LineDao {
    public static List<Line> selectall() throws SQLException {//搜索所有的用户内容，并返回一个User线性表
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Line> list = new ArrayList<>();
        try{//主体部分
            conn = DBAconnect.getConnection();
            if (conn != null) {
                String sql = "select * from Line";//sql语句进行
                pstmt = conn.prepareStatement(sql);//编译预处理
                rs = pstmt.executeQuery();//sql执行

                while (rs.next()) {
                    Line line=new Line();
                    line.setSpotid1(rs.getString(1));
                    line.setSpotid2(rs.getString(2));
                    line.setWhere(rs.getString(3));
                    list.add(line);
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

    public static List<Line> select(String option) throws SQLException {//单项搜索
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Line> list = new ArrayList<>();
        try {
            conn = DBAconnect.getConnection();
            if (conn != null) {
                String sql = "select " + option + " from Line";//sql语句进行
                pstmt = conn.prepareStatement(sql);//编译预处理
                rs = pstmt.executeQuery();
                Line line = new Line();
                if(option=="Spotid1")
                    line.setSpotid1(rs.getString(1));
                else if(option=="Spotid2")
                    line.setSpotid1(rs.getString(1));
                else if(option=="Name")
                    line.setSpotid1(rs.getString(1));
                else{
                    System.out.print("输入格式错误，请检查，该表的正确输入格式为:/n Spotid1 Spotid2  Name");
                    return null;
                }
                list.add(line);
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

    public static List<Line> select(String option,String conditon) throws SQLException {//单项搜索
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Line> list = new ArrayList<>();
        try {
            conn = DBAconnect.getConnection();
            if (conn != null) {
                String sql = "select " + option + " from Line Where "+conditon;//sql语句进行
                pstmt = conn.prepareStatement(sql);//编译预处理
                rs = pstmt.executeQuery();
                Line line = new Line();
                if(option=="Spotid1")
                    line.setSpotid1(rs.getString(1));
                else if(option=="Spotid2")
                    line.setSpotid1(rs.getString(1));
                else if(option=="Name")
                    line.setSpotid1(rs.getString(1));
                else{
                    System.out.print("输入格式错误，请检查，该表的正确输入格式为:/n Spotid1 Spotid2  Name");
                    return null;
                }
                list.add(line);
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
    public static void update(String option,String values1,String condition,String values2) throws  SQLException{
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try{
            conn=DBAconnect.getConnection();
            if(conn!=null){
                String sql="update Line set"+option+"="+values1+" where"+condition+"="+values2;
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
                String sql="update Line set"+option+"="+values1+" where"+condition+"="+values2;
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
                String sql="update Line set"+option+"="+values1+" where"+condition+"="+values2;
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
                String sql="update Line set"+option+"="+values1+" where"+condition+"="+values2;
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
