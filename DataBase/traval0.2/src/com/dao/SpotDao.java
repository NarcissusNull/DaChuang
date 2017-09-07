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
    public static List<Spot> selectall() throws SQLException {//搜寻所有spotbi澳中元素
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

    public static List<Spot> select(String option) throws SQLException {//单项搜索，option为搜索的项目名称
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Spot> list = new ArrayList<>();
        try {
            conn = DBAconnect.getConnection();
            if (conn != null) {
                String sql = "select " + option + " from Spot";//sql语句进行
                pstmt = conn.prepareStatement(sql);//编译预处理
                rs = pstmt.executeQuery();//游标，rs为执行后的
                Spot spot = new Spot();
               /*注入，sql语句编译，编译完成后将搜索的信息注入*/
                while(rs.next()) {
                    if (option == "Point")
                        spot.setPoint(rs.getInt("Point"));
                    else if (option == "Sceneid")
                        spot.setSceneid(rs.getString( "Sceneid"));
                    else if (option == "Spotname")
                        spot.setSpotname(rs.getString("Spotname"));
                    else if (option == "Scenename")
                        spot.setScenename(rs.getString( "Scenename"));
                    else if (option == "City")
                        spot.setCity(rs.getString("City"));

                    else {
                        System.out.print("User输入格式错误，请检查，该表的正确输入格式为:/n UserId IdentyId Nickname Realname Point Qq Password");
                        return null;
                    }
                    list.add(spot);
                }

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

    public static List<Spot> select(String option,String condition) throws SQLException {//单项搜索，option为搜索的项目名称
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Spot> list = new ArrayList<>();
        try {
            conn = DBAconnect.getConnection();
            if (conn != null) {
                String sql = "select " + option + " from Spot Where "+condition;//sql语句进行
                pstmt = conn.prepareStatement(sql);//编译预处理
                rs = pstmt.executeQuery();//游标，rs为执行后的
                Spot spot = new Spot();
               /*注入，sql语句编译，编译完成后将搜索的信息注入*/
                while(rs.next()) {
                    if (option == "Point")
                        spot.setPoint(rs.getInt(       "Point"));
                    else if (option == "Sceneid")
                        spot.setSceneid(rs.getString(  "Sceneid"));
                    else if (option == "Spotname")
                        spot.setSpotname(rs.getString( "Spotname"));
                    else if (option == "Scenename")
                        spot.setScenename(rs.getString( "Scenename"));
                    else if (option == "City")
                        spot.setCity(rs.getString(       "City"));

                    else {
                        System.out.print("User输入格式错误，请检查，该表的正确输入格式为:/n UserId IdentyId Nickname Realname Point Qq Password");
                        return null;
                    }
                    list.add(spot);
                }

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
        try {
            conn=DBAconnect.getConnection();
            if(conn!=null){
                String sql="delete  from Spot where "+condition;
                pstmt=conn.prepareStatement(sql);
                pstmt = conn.prepareStatement(sql);//编译预处理
                pstmt.executeUpdate();
            }
        }
        catch (Exception e){//sql抛出
            e.printStackTrace();
        }
        finally {
            pstmt.close();
            conn.close();
        }
    }
    public static void update(String option,String values1,String condition,String values2) throws  SQLException{
        Connection conn = null;
        PreparedStatement pstmt = null;
        try{
            conn=DBAconnect.getConnection();
            if(conn!=null){
                String sql="update Spot set "+option+"="+values1+" where "+condition+"="+values2;
                conn.prepareStatement(sql);
                pstmt = conn.prepareStatement(sql);//编译预处理
                pstmt.executeUpdate(sql);//游标，rs为执行后的
            }
        }
        catch (Exception e){//sql抛出
            e.printStackTrace();
        }
        finally {
            conn.close();
            pstmt.close();
            System.out.println("刷新完成");
            System.out.println("change"+option+"to"+values1+" "+condition+"="+values2);
        }
    }

    public static void update(String option,String values1,String condition,int values2) throws  SQLException{
        Connection conn = null;
        PreparedStatement pstmt = null;
        try{
            conn=DBAconnect.getConnection();
            if(conn!=null){
                String sql="update Spot set "+option+"="+values1+" where "+condition+"="+values2;
                conn.prepareStatement(sql);
                pstmt = conn.prepareStatement(sql);//编译预处理
                pstmt.executeUpdate(sql);//游标，rs为执行后的
            }
        }
        catch (Exception e){//sql抛出
            e.printStackTrace();
        }
        finally {
            conn.close();
            pstmt.close();
            System.out.println("刷新完成");
            System.out.println("change"+option+"to"+values1+" "+condition+"="+values2);
        }
    }

    public static void update(String option,int values1,String condition,String values2) throws  SQLException{
        Connection conn = null;
        PreparedStatement pstmt = null;
        try{
            conn=DBAconnect.getConnection();
            if(conn!=null){
                String sql="update Spot set "+option+"="+values1+" where "+condition+"="+values2;
                conn.prepareStatement(sql);
                pstmt = conn.prepareStatement(sql);//编译预处理
                pstmt.executeUpdate(sql);
            }
        }
        catch (Exception e){//sql抛出
            e.printStackTrace();
        }
        finally {
            conn.close();
            pstmt.close();
            System.out.println("刷新完成");
            System.out.println("change"+option+"to"+values1+" "+condition+"="+values2);
        }
    }

    public static void update(String option,int values1,String condition,int values2) throws  SQLException{
        Connection conn = null;
        PreparedStatement pstmt = null;
        try{
            conn=DBAconnect.getConnection();
            if(conn!=null){
                String sql="update Spot set "+option+"="+values1+" where "+condition+"="+values2;
                conn.prepareStatement(sql);
                pstmt = conn.prepareStatement(sql);//编译预处理
                pstmt.executeUpdate(sql);//游标，rs为执行后的
            }
        }
        catch (Exception e){//sql抛出
            e.printStackTrace();
        }
        finally {
            conn.close();
            pstmt.close();
            System.out.println("刷新完成");
            System.out.println("change "+option+"to"+values1+" "+condition+"="+values2);
        }
    }
}
