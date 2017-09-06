package com.dao;

/**
 * Created by 13190 on 2017/8/3.
 * 用于用户表的运作
 * 同样跟history一样问题，外键
 */

import com.connect.DBAconnect;
import com.vo.Friend;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class FriendDao {//搜寻所有表内信息
    public static List<Friend> selectall() throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Friend> list = new ArrayList<>();
        try{//主体部分
            conn = DBAconnect.getConnection();
            if (conn != null) {
                String sql = "select * from friend";//sql语句进行
                pstmt = conn.prepareStatement(sql);//编译预处理
                rs = pstmt.executeQuery();//sql执行

                while (rs.next()) {
                    Friend friend = new Friend();
                    friend.setUserid(rs.getInt(1));
                    friend.setIdentyid(rs.getString(2));
                    friend.setFriendsid(rs.getInt(3));
                    list.add(friend);
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
public List<Friend> select(String option) throws SQLException{
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    List<Friend> list = new ArrayList<>();
    try{
        conn=DBAconnect.getConnection();
        if (conn != null) {
            String sql = "select "+option+" from friend";//sql语句进行
            pstmt = conn.prepareStatement(sql);//编译预处理
            rs= pstmt.executeQuery();

           // while (rs.next()) {
                Friend friend = new Friend();
                friend.setUserid(rs.getInt(1));
                friend.setIdentyid(rs.getString(2));
                friend.setFriendsid(rs.getInt(3));
                list.add(friend);
           // }

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
  public static List<Friend> select(String option,String condition,String where) throws SQLException{
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Friend> list = new ArrayList<>();
        try{
            conn=DBAconnect.getConnection();
            if (conn != null) {
                String sql = "select "+option+" from friend where"+condition+"="+where;//sql语句进行
                pstmt = conn.prepareStatement(sql);//编译预处理
                rs= pstmt.executeQuery();

                //while (rs.next()) {
                    Friend friend = new Friend();
                    friend.setUserid(rs.getInt(1));
                    friend.setIdentyid(rs.getString(2));
                    friend.setFriendsid(rs.getInt(3));
                    list.add(friend);
              //  }

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

    public static void deluserid(int userid) throws Exception{
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn=DBAconnect.getConnection();
            if(conn!=null){
             String sql="delete from friend where userid ="+userid;
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
    public void delidentyid(String identyid) throws Exception{
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn=DBAconnect.getConnection();
            if(conn!=null){
                String sql="delete from friend where identyid="+identyid;
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
    public static void delfriendsid(int friendsid) throws Exception{
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn=DBAconnect.getConnection();
            if(conn!=null){
                String sql="delete from friend where friendsid="+friendsid;
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
    public static void updateidentyid (String identyid,int userid)throws Exception{
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try{
            conn=DBAconnect.getConnection();
            if(conn!=null){
                String sql="update friends set identyid="+identyid+"where userid="+userid;
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
    public void updateuserid (int friendsid,int userid)throws Exception{//更新表格friedns
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try{
            conn=DBAconnect.getConnection();
            if(conn!=null){
                String sql="update friends set friendsid="+friendsid+" where userid= "+userid;
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
    public static void updateall(int userid,String identyid,int friendsid)throws Exception{//更新全部表格
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try{
            conn=DBAconnect.getConnection();
            if(conn!=null){
                String sql="update friends set friendsid="+friendsid+",identid="+identyid+" where userid="+userid;
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
