package com.dao;

import com.connect.DBAconnect;
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
    public class SceneDao{

        public static List<Scene> selectall() throws SQLException {//搜索所有的用户内容，并返回一个User线性表
            Connection conn = null;
            PreparedStatement pstmt = null;
            ResultSet rs = null;
            List<Scene> list = new ArrayList<>();
            try{//主体部分
                conn = DBAconnect.getConnection();
                if (conn != null) {
                    String sql = "select * from Scenen";//sql语句进行
                    pstmt = conn.prepareStatement(sql);//编译预处理
                    rs = pstmt.executeQuery();//sql执行

                    while (rs.next()) {
                        Scene scene=new Scene();
                        scene.setSceneid(rs.getString(1));
                        scene.setCity(rs.getString(2));
                        scene.setName(rs.getString(3));
                        list.add(scene);
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

        public static List<Scene> seLect(String option) throws SQLException {//单项搜索
            Connection conn = null;
            PreparedStatement pstmt = null;
            ResultSet rs = null;
            List<Scene> list = new ArrayList<>();
            try {
                conn = DBAconnect.getConnection();
                if (conn != null) {
                    String sql = "select " + option + " from Scene";//sql语句进行
                    pstmt = conn.prepareStatement(sql);//编译预处理
                    rs = pstmt.executeQuery();
                    Scene scene = new Scene();
                    if(option=="Sceneid")
                        scene.setSceneid(rs.getString("Sceneid"));
                    else if(option=="City")
                        scene.setCity(rs.getString(   "City"));
                    else if(option=="Name")
                        scene.setName(rs.getString(   "Name"));
                    else{
                        System.out.print("输入格式错误，请检查，该表的正确输入格式为:/n Sceneid City  Name");
                        return null;
                    }
                    list.add(scene);
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

        public static List<Scene> seLect(String option,String conditon) throws SQLException {//单项搜索
            Connection conn = null;
            PreparedStatement pstmt = null;
            ResultSet rs = null;
            List<Scene> list = new ArrayList<>();
            try {
                conn = DBAconnect.getConnection();
                if (conn != null) {
                    String sql = "select " + option + " from Scene Where "+conditon;//sql语句进行
                    pstmt = conn.prepareStatement(sql);//编译预处理
                    rs = pstmt.executeQuery();
                    Scene scene = new Scene();
                    if(option=="Sceneid")
                        scene.setSceneid(rs.getString("Sceneid"));
                    else if(option=="City")
                        scene.setCity(rs.getString("City"));
                    else if(option=="Name")
                        scene.setName(rs.getString("Name"));


                    else{
                        System.out.print("输入格式错误，请检查，该表的正确输入格式为:/n Sceneid City  Name");
                        return null;
                    }
                    list.add(scene);
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
                    String sql="delete  from Scene where "+condition;
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
                    String sql="update Scene set "+option+"="+values1+" Where "+condition+"="+values2;
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
                    String sql="update Scene set "+option+"="+values1+" where "+condition+"="+values2;
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
                    String sql="update Scene set "+option+"="+values1+" where "+condition+"="+values2;
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
                    String sql="update Scene set "+option+"="+values1+" where "+condition+"="+values2;
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


