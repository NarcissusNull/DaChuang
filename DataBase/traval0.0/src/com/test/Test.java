package com.test;

import com.connect.DBAconnect;
import com.dao.*;
import com.vo.*;

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
        /**  DBAconnect.Change("root","625676");
        Connection conn= DBAconnect.getConnection();
        if(conn!=null)
        {
            System.out.println("连接成功");
        }
        else
        {
            System.out.println("连接失败");
        }
     List<String >list=new ArrayList<>();
        //list=UserDao.selectAll();
     list=UserDao.seLect("Nickname");
     int a=list.size();
       for(int i=0;i<a;i++){
           System.out.println(list.get(i));
       }
       //  System.out.println(list.get(0).getNickname());
      if( com.dao.UserDao.userExit("sdfsa","asdfasf"))
           System.out.println("对应");
        else
            System.out.println("不对应");*/


      /**
        Connection conn= DBAconnect.getConnection();
        if(conn!=null)
        {
            System.out.println("连接成功");
        }
        else
        {
            System.out.println("连接失败");
        }
        ************************测试连接操作测试语句*************************************************************************/
       /**
        User users=new User();
        List<User> list=new ArrayList<User>();
        String a="UserId";
       int b;
       // list=UserDao.selectall();//select * from User可用
*****************************************用户记录表测试语句*******************************************************************************/
       /**搜素元素数目，说明表非空，可用
        * list=UserDao.select(a);
        * b=list.size();
        * System.out.print(b);*/

       /**更新操作，由于是复制，且用得是重写方式，故而检验一个即可
        *  //可运行
        *  UserDao.update("Point",8,"UserId",1);
        UserDao.update("IdentyId","123213424234","UserId",1);
        2017.8.17
       */

       /**删除操作，经检验，可用
        *  UserDao.delete("UserId=0");
        * */

       /***********************************8.15测试UserDao类，基本完成*************************************************/
       /**insert1添加记录，添加含有所有选项的记录
        users.setUserId(0);
        users.setIdentyid("234423445");
        users.setNickname("NICNAME");
        users.setRealname("Realname");
        users.setPoint(0);
        users.setQq("3243432532");
        users.setPhone("21342342352");
        users.setPassword("sdfsafsdfs");
        UserDao.insert1(users);
        //测试insert2用于添加含有可空向的项目
        users.setUserId(4);
        users.setIdentyid("213214324343");
        users.setNickname("NICNAME");
        users.setRealname("Realname");
        users.setPoint(0);
        users.setPassword("sdfsafsdfs");
        UserDao.insert2(users);
        2017.8.17*/
        /***************************UserDao完成************************************************/
        /***用户创建
         String psw="abcde";
         String user="a";
         Dao.createuser(user,psw);
         */
        /**用户功能赋予
         *     String psw="abcde";
         String user="a";
         String table="User";
         String option="Select";
         Dao.createuser(user);
         Dao.grantall(option,user,table);*/
     /****************************Dao 用户相关操作（注意区别与用户表）******************/

    // List<Spot> list2=new ArrayList<Spot>();
       /**list2=SpotDao.selectall();
       //list2=SpotDao.select("Point");
       list2=SpotDao.select("Point","Sceneid=0");
       SpotDao.delete("Point=0");*/
       /**
       SpotDao.update("Point",1,"Sceneid","1");
        /************    *****************Spot地点表操作语句测试************************************************
        ******************************2017.9.7****************************************************************/
        /**
       int textid=123434233;
       String content="sadfasfdas";
       Notes note=new Notes();
       note.setTextid(textid);
       note.setContent(content);
       note.setAutor(1);
       note.setPlace("1");
       NotesDao.insert(note);
       ********************************************note游记存储表语句测试*************************************************************/
       /**
        * Record record=new Record();
        List<Record> list3=new ArrayList<Record>();
        list3=RecordDao.selectall();
        list3=RecordDao.select("UserID");
        list3=RecordDao.select("TextID");
        ********************************************record视图操作语句测试**********************************************************************/
  /**   if(UserDao.userExit(4,"sdfsafsdfs"))
   System.out.println("成功");
   else
   System.out.println("失败");
   List<String> list=new ArrayList<>();
   list=UserDao.seLect("Nickname");
   ************************************userdao判断用户是否存在，密码是否对的上*8***********************************************/
/**
     if(UserDao.userExit("dfds","sdfsafsdfs"))
            System.out.println("成功");
        else
            System.out.println("失败");


    }List<String> list=new ArrayList<>();
        list=UserDao.seLect("Nickname");

         *  if(UserDao.userExit("x",";kdsfjadfsda"))
         System.out.println("成功");
         else
         System.out.println("失败");
 ArrayList list=new ArrayList();
 list=UserDao.selectOneInt("UserId");
 int a=list.size();
 for(int i=0;i<a;i++)
 System.out.println(list.get(i));
*/
UserDao.userExit("asdfas","asdfasfasd");

    }
}
