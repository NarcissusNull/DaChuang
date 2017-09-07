package com.dao;

import com.connect.DBAconnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by 13190 on 2017/8/23.
 */
public class Dao {//创建普通用户，无密码
    public static void  createuser(String users)throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn= DBAconnect.getConnection();
            if(conn!=null){
                String sql="create USER "+users;
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
        // System.out.println("执行完成！"+condition+"若未删除成功请检查conditon是否正确，注意项目选项为：/nUserId IdentyId Nickname Realname Point Qq Password");
        //提示内容
    }

    public static void  createuser(String users,String psw)throws SQLException {//用于创建普通用户，但永固权限需要后来的grant语句赋予
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn= DBAconnect.getConnection();
            if(conn!=null){
                String sql="create USER "+users+" IDENTIFIED by '"+psw+"'";
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
        // System.out.println("执行完成！"+condition+"若未删除成功请检查conditon是否正确，注意项目选项为：/nUserId IdentyId Nickname Realname Point Qq Password");
        //提示内容
    }

    public static void  grant(String option,String users,String table)throws SQLException{//赋权语句
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn=DBAconnect.getConnection();
            if(conn!=null){
                String sql="GRANT "+option+" ON "+table+" TO "+users;
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
        System.out.println("执行完成！"+"若未成功请检查users是否存在\n 并注意项目选项为：\n option: select delete update insert all(所有权限)");
        System.out.println("注意tables是否正确Friend History Line Notes Scene Spot User");
        //提示内容
    }
/**
    public static void  drop(String option,String users,String table)throws SQLException{//赋权语句
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn=DBAconnect.getConnection();
            if(conn!=null){
                String sql="DROP USER "+users;
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
        System.out.println("执行完成！"+"若未成功请检查users是否存在\n 并注意项目选项为：\n option: select delete update insert all(所有权限)");
        System.out.println("注意tables是否正确Friend History Line Notes Scene Spot User");
        //提示内容
    }*/
}
