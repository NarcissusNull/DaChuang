package com.test;

import com.connect.DBAconnect;
import com.dao.FriendDao;
import com.dao.UserDao;
import com.vo.Friend;
import com.vo.History;
import com.vo.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by 13190 on 2017/8/3.
 */
public class Test {
    public static void main(String[] args) throws SQLException {
        Connection conn= DBAconnect.getConnection();
        if(conn!=null)
        {
            System.out.println("连接成功");
        }
        else
        {
            System.out.println("连接失败");
        }
        List<User> list = new ArrayList<>();

    }
}
