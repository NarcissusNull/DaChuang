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
 *
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
        /*************************测试连接操作*************************************************************************/
        User users=new User();
        List<User> list=new ArrayList<User>();
        String a="UserId";
       int b;
       // list=UserDao.selectall();//select * from User可用

       /**搜素元素数目，说明表非空，可用
        * list=UserDao.select(a);
        * b=list.size();
        * System.out.print(b);*/

       /**更新操作，由于是复制，且用得是重写方式，故而检验一个即可
        *  UserDao.update("IdentyId","123213424234","UserId",1);//可运行，结果不对
       */

       /**删除操作，经检验，可用
        *  UserDao.delete("UserId=0");
        * */
       users.setUserId(0);
       users.setPassword("sdfsafsdfs");
       users.setRealname("sdf");
       users.setPoint(0);
       UserDao.insert(users);
       /***********************************8.15测试UserDao类，基本完成*************************************************/


    }

}
