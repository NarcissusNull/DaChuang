package com.dao;
import com.connect.DBAconnect;
import com.vo.Friend;
import com.vo.History;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.vo.History.recentspot;
import static com.vo.History.userid;

/**
 * Created by 13190 on 2017/8/3.
 */
public class HistoryDao {
    public List<History> selectall() throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<History> list = new ArrayList<>();
        try{//主体部分
            conn = DBAconnect.getConnection();
            if (conn != null) {
                String sql = "select * from friend";//sql语句进行
                pstmt = conn.prepareStatement(sql);//编译预处理
                rs = pstmt.executeQuery();//sql执行

                while (rs.next()) {
                    History history = new History();
                    history.setUserid(rs.getInt(1));
                    history.setRecentspot(rs.getString(2));
                    history.setrecentscene(rs.getString(3));
                    history.settime(rs.getString(4));
                    list.add(history);
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
    public List<History> select(String option) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<History> list = new ArrayList<>();
        try {
            conn = DBAconnect.getConnection();
            if (conn != null) {
                String sql = "select " + option + " from History";//sql语句进行
                pstmt = conn.prepareStatement(sql);//编译预处理
                rs = pstmt.executeQuery();
                History history = new History();
                history.setUserid(rs.getInt(1));
                history.setRecentspot(rs.getString(2));
                history.setrecentscene(rs.getString(3));
                history.settime(rs.getString(4));
                list.add(history);

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
    public List<History> select(String option,String condition,String where) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<History> list = new ArrayList<>();
        try {
            conn = DBAconnect.getConnection();
            if (conn != null) {
                String sql = "select " + option + " from History where"+condition+"="+where;//sql语句进行
                pstmt = conn.prepareStatement(sql);//编译预处理
                rs = pstmt.executeQuery();

                // while (rs.next()) {
                History history = new History();
                history.setUserid(rs.getInt(1));
                history.setRecentspot(rs.getString(2));
                history.setrecentscene(rs.getString(3));
                history.settime(rs.getString(4));
                list.add(history);
                // }

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

    public void deluserid(int userid) throws SQLException{
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn=DBAconnect.getConnection();
            if(conn!=null){
                String sql="delete  from history where userid=?";
                pstmt=conn.prepareStatement(sql);
                pstmt = conn.prepareStatement(sql);//编译预处理
                rs= pstmt.executeQuery();
                pstmt.setInt(1,userid);
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
    public void delrecentspot(String recentspot) throws SQLException{
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn=DBAconnect.getConnection();
            if(conn!=null){
                String sql="delete from history where recentspot=?";
                pstmt=conn.prepareStatement(sql);
                pstmt = conn.prepareStatement(sql);//编译预处理
                rs= pstmt.executeQuery();
                pstmt.setString(1,recentspot);
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
    public void delrecentscene(String recentscene) throws SQLException{
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn=DBAconnect.getConnection();
            if(conn!=null){
                String sql="delete from history where recentscene=?";
                pstmt=conn.prepareStatement(sql);
                pstmt = conn.prepareStatement(sql);//编译预处理
                rs= pstmt.executeQuery();
                pstmt.setString(1,recentscene);
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
    public void updaterecentspot(String recentspot,int userid)throws SQLException{
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try{
            conn=DBAconnect.getConnection();
            if(conn!=null){
                String sql="update history set recentspot=? where userid=?";
                conn.prepareStatement(sql);
                pstmt.setString(1,recentspot);
                pstmt.setInt(2,userid);
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
    }

    public void updatetime(String time,int userid)throws SQLException{
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try{
            conn=DBAconnect.getConnection();
            if(conn!=null){
                String sql="update history set time=? where userid=?";
                conn.prepareStatement(sql);
                pstmt.setString(1,time);
                pstmt.setInt(2,userid);
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
    }
public void updateall(String recentspot,String recentscene,String time,int userid) throws SQLException{
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
        try{
        conn=DBAconnect.getConnection();
        if(conn!=null){
            String sql="update history set recentspot=?,recentscenen=? time=? where userid=?";
            conn.prepareStatement(sql);
            pstmt.setString(1,recentspot);
            pstmt.setString(2,recentscene);
            pstmt.setString(3,time);
            pstmt.setInt(4,userid);

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
}

}
