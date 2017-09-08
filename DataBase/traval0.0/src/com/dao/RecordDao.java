package com.dao;

import com.connect.DBAconnect;
import com.vo.Record;
import com.vo.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 13190 on 2017/9/7.
 */
public class RecordDao {
    public static List<Record> selectall() throws SQLException {//搜索所有的用户内容，并返回一个User线性表
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Record> list = new ArrayList<>();
        try{//主体部分
            conn = DBAconnect.getConnection();
            if (conn != null) {
                String sql = "select * from Record";//sql语句进行
                pstmt = conn.prepareStatement(sql);//编译预处理
                rs = pstmt.executeQuery();//sql执行

                while (rs.next()) {//当next指针不为空，即线性表未空
                    Record record=new Record();
                    record.setUserid(rs.getInt(1));
                    record.setTextid(rs.getInt(2));
                    list.add(record);
                }
            }
        }
        catch (SQLException e){//sql抛出
            e.printStackTrace();
        }
        finally {//执行结束，关闭游标，执行域，编译域（希望是这几个名字，没记错）
            rs.close();
            pstmt.close();
            conn.close();
        }
        System.out.println("搜索完成，返回链表");
        return list;
    }

    public static List<Record> select(String option) throws SQLException {//搜索所有的用户内容，并返回一个User线性表
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Record> list = new ArrayList<>();
        try{//主体部分
            conn = DBAconnect.getConnection();
            if (conn != null) {
                String sql = "select "+option+" from Record";//sql语句进行
                pstmt = conn.prepareStatement(sql);//编译预处理
                rs = pstmt.executeQuery();//sql执行

                while (rs.next()) {//当next指针不为空，即线性表未空
                    Record record=new Record();
                    if(option=="UserID")
                    record.setUserid(rs.getInt("UserID"));
                    else if(option=="TextID")
                    record.setTextid(rs.getInt("TextID"));
                    else
                    System.out.println("选项错误，注意，格式为UserID或TextID");
                    list.add(record);
                }
            }
        }
        catch (SQLException e){//sql抛出
            e.printStackTrace();
        }
        finally {//执行结束，关闭游标，执行域，编译域（希望是这几个名字，没记错）
            rs.close();
            pstmt.close();
            conn.close();
        }
        System.out.println("搜索完成，返回链表");
        return list;
    }
}
