package com.dao;

import com.connect.DBAconnect;
import com.vo.Friend;
import com.vo.Spot;
import com.vo.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 13190 on 2017/8/9.
 */
public class SpotDao {
    public static List<Spot> selectall() throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Spot> list = new ArrayList<>();
        try{//主体部分
            conn = DBAconnect.getConnection();
            if (conn != null) {
                String sql = "select * from Spot";//sql语句进行
                pstmt = conn.prepareStatement(sql);//编译预处理
                rs = pstmt.executeQuery();//sql执行

                while (rs.next()) {
                    Spot spot = new Spot();
                    spot.setPoint(rs.getInt(1));
                    spot.setSceneid(rs.getString(2));
                    spot.setScenename(rs.getString(3));
                    spot.setCity(rs.getString(4));
                    list.add(spot);
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

    public static List<Spot> select(String option) throws SQLException {//单项搜索
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Spot> list = new ArrayList<>();
        try {
            conn = DBAconnect.getConnection();
            if (conn != null) {
                String sql = "select " + option + " from Spot";//sql语句进行
                pstmt = conn.prepareStatement(sql);//编译预处理
                rs = pstmt.executeQuery();
                Spot spot = new Spot();
                if(option=="Point")
                    spot.setPoint(rs.getInt(1));
                else if(option=="Sceneid")
                    spot.setSceneid(rs.getString(1));
                else if(option=="Spotname")
                    spot.setSpotname(rs.getString(1));
                else if(option=="Scenename")
                    spot.setScenename(rs.getString(1));
                else if(option=="City")
                    spot.setCity(rs.getString(1));

                else{
                    System.out.print("User输入格式错误，请检查，该表的正确输入格式为:/n Point Sceneid Spotname Scenename City");
                    return null;
                }
                list.add(spot);
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

    public static List<Spot> select(String option,String conditon) throws SQLException {//单项搜索
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Spot> list = new ArrayList<>();
        try {
            conn = DBAconnect.getConnection();
            if (conn != null) {
                String sql = "select " + option + " from Spot Where"+conditon;//sql语句进行
                pstmt = conn.prepareStatement(sql);//编译预处理
                rs = pstmt.executeQuery();
                Spot spot = new Spot();
                if(option=="Point")
                    spot.setPoint(rs.getInt(1));
                else if(option=="Sceneid")
                    spot.setSceneid(rs.getString(1));
                else if(option=="Spotname")
                    spot.setSpotname(rs.getString(1));
                else if(option=="Scenename")
                    spot.setScenename(rs.getString(1));
                else if(option=="City")
                    spot.setCity(rs.getString(1));

                else{
                    System.out.print("User输入格式错误，请检查，该表的正确输入格式为:/n Point Sceneid Spotname Scenename City");
                    return null;
                }
                list.add(spot);
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
                String sql="delete  from Spot where "+condition;
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
                String sql="update Spot set"+option+"="+values1+" where"+condition+"="+values2;
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
                String sql="update Spot set"+option+"="+values1+" where"+condition+"="+values2;
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
                String sql="update Spot set"+option+"="+values1+" where"+condition+"="+values2;
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
                String sql="update Spot set"+option+"="+values1+" where"+condition+"="+values2;
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
