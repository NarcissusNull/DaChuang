package com.test;

import com.connect.DBAconnect;
import com.vo.Friend;

import java.sql.Connection;
import java.util.List;

/**
 * Created by 13190 on 2017/8/3.
 */
public class Test {
    public static void main(String[] args){
        Connection conn= DBAconnect.getConnection();
        if(conn!=null)
        {
            System.out.println("连接成功");
        }
        else
        {
            System.out.println("连接失败");
        }


    }
}
