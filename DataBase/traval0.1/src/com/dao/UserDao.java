package com.dao;

import com.connect.DBAconnect;
import com.mysql.jdbc.Statement;
import com.vo.Friend;
import com.vo.History;
import com.vo.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 13190 on 2017/8/3.
 * 将user打造为范本，将后来的重构一下2017/8.7
 * 笔记：线性表list的使用：基本功能add在末端加一个新元素，clear清空表，remove从线性表删除该元素，size返回线性表元素数目2017/8.15
 * UserDao基本完成2017.8.17
 */
public class UserDao {//操作User类，对应表中的user表
    public static List<User> selectall() throws SQLException {//搜索所有的用户内容，并返回一个User线性表
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<User> list = new ArrayList<>();
        try{//主体部分
            conn = DBAconnect.getConnection();
            if (conn != null) {
                String sql = "select * from User";//sql语句进行
                pstmt = conn.prepareStatement(sql);//编译预处理
                rs = pstmt.executeQuery();//sql执行

                while (rs.next()) {//当next指针不为空，即线性表未空
                    User user=new User();
                    user.setUserId(rs.getInt(1));
                    user.setIdentyid(rs.getString(2));
                    user.setNickname(rs.getString(3));
                    user.setRealname(rs.getString(4));
                    user.setPoint(rs.getInt(5));
                    user.setQq(rs.getString(6));
                    user.setPhone(rs.getString(7));
                    user.setPassword(rs.getString(8));
                    list.add(user);
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
        return list;
    }
    //测试已毕，可用
     public static List<User> select(String option) throws SQLException {//单项搜索，option为搜索的项目名称
            Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<User> list = new ArrayList<>();
        try {
            conn = DBAconnect.getConnection();
            if (conn != null) {
                String sql = "select " + option + " from User";//sql语句进行
                pstmt = conn.prepareStatement(sql);//编译预处理
                rs = pstmt.executeQuery();//游标，rs为执行后的
               User user = new User();
               /*注入，sql语句编译，编译完成后将搜索的信息注入*/
               while(rs.next()) {
                    if (option == "UserId")
                        user.setUserId(rs.getInt("UserId"));
                    else if (option == "IdentyId")
                        user.setIdentyid(rs.getString("IdentyId"));
                    else if (option == "Nickname")
                        user.setNickname(rs.getString( "Nickname"));
                    else if (option == "Realname")
                        user.setRealname(rs.getString("Realname"));
                    else if (option == "Point")
                        user.setPoint(rs.getInt( "Point"));
                    else if (option == "Qq")
                        user.setQq(rs.getString("Qq"));
                    else if (option == "Phone")
                        user.setPhone(rs.getString( "Phone"));
                    else if (option == "Password")
                        user.setPassword(rs.getString("Password"));
                    else {
                        System.out.print("User输入格式错误，请检查，该表的正确输入格式为:/n UserId IdentyId Nickname Realname Point Qq Password");
                        return null;
                    }
                    list.add(user);
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

    public static List<User> select(String option,String conditon) throws SQLException {//单项搜索
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<User> list = new ArrayList<>();
        try {
            conn = DBAconnect.getConnection();
            if (conn != null) {
                String sql = "select " + option + " from User where "+conditon;//sql语句进行
                pstmt = conn.prepareStatement(sql);//编译预处理
                rs = pstmt.executeQuery();
                User user = new User();
                if(option=="UserId")
                    user.setUserId(rs.getInt(option));
                else if(option=="U")
                    user.setIdentyid(rs.getString(option));
                else if(option=="Nickname")
                    user.setNickname(rs.getString(option));
                else if(option=="Realname")
                    user.setRealname(rs.getString(option));
                else if(option=="Point")
                    user.setPoint(rs.getInt(option));
                else if(option=="Qq")
                    user.setQq(rs.getString(option));
                else if(option=="Phone")
                    user.setPhone(rs.getString(option));
                else if(option=="Password")
                    user.setPassword(rs.getString(option));
                else{
                    System.out.print("User输入格式错误，请检查，该表的正确输入格式为:/n UserId IdentyId Nickname Realname Point Qq Password");
                    //反馈错误
                    return null;
                }
                list.add(user);
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
                String sql="delete from User where "+condition;
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
        System.out.println("执行完成！"+condition+"若未删除成功请检查conditon是否正确，注意项目选项为：/nUserId IdentyId Nickname Realname Point Qq Password");
    //提示内容
    }
    /**************************************************updeate刷新****************************************************************/
    //注意，condition只能为主键2017。8.17
    /**
    public static void update(String option,String values1,String condition,String values2) throws  SQLException{
        Connection conn = null;
        PreparedStatement pstmt = null;
        try{
            conn=DBAconnect.getConnection();
            if(conn!=null){
                String sql="update User set "+option+"="+values1+" where "+condition+"="+values2;
                //conn.prepareStatement(sql);
                pstmt = conn.prepareStatement(sql);//编译预处理
                pstmt.executeUpdate();//游标，rs为执行后的
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
    public static void update(String option,int values1,String condition,String values2) throws  SQLException{
        Connection conn = null;
        PreparedStatement pstmt = null;
        try{
            conn=DBAconnect.getConnection();
            if(conn!=null){
                String sql="update User set "+option+" = "+values1+" where "+condition+" ="+values2;
                //conn.prepareStatement(sql);
                pstmt = conn.prepareStatement(sql);//编译预处理
                pstmt.executeUpdate(sql);//游标，rs为执行后的
            }
        }
        catch (Exception e){//sql抛出
            e.printStackTrace();
        }
        finally {
            pstmt.close();
            conn.close();
        }
    }*/
    public static void update(String option,int values1,String condition,int values2) throws  SQLException{
        Connection conn = null;
        PreparedStatement pstmt = null;
        try{
            conn=DBAconnect.getConnection();
            if(conn!=null){
                String sql="update User set "+option+" = "+values1+" where "+condition+"="+values2;
                pstmt = conn.prepareStatement(sql);//编译预处理
                pstmt.executeUpdate();//游标，rs为执行后的
            }
        }
        catch (Exception e){//sql抛出
            e.printStackTrace();
        }
        finally {
            pstmt.close();
            conn.close();
            System.out.println("刷新完成");
            System.out.println("change"+option+"to"+values1+" "+condition+"="+values2);
        }

    }
    public static void update(String option,String values1,String condition,int values2) throws  SQLException{
        //测试通过可用
        Connection conn = null;
        PreparedStatement pstmt = null;
        try{
            conn=DBAconnect.getConnection();
            if(conn!=null){
                String sql="update User set "+option+"="+values1+" where "+condition+"="+values2;
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
    public static void insert1(User users) throws SQLException{//用于插入完整的记录
        Connection conn = null;
        PreparedStatement pstmt = null;
        Statement stmt = null;
       //users=new User();
        try{
            conn=DBAconnect.getConnection();
            if(conn!=null){
              String sql="insert into User(UserId,IdentyId,Nickname,Realname,Point,Qq,Phone,Password) VALUES(?,?,?,?,?,?,?,?)";
                // String sql="insert into User (UserId,IdentyId,Realname,Point,password) VALUES(5,dfsadfsafsa,c,0,d98fa9dfa)";
                //String sql=null;
                //conn.prepareStatement(sql);
               pstmt=conn.prepareStatement(sql);
              // pstmt.execute(sql);//游标，rs为执行后的
               // pstmt = conn.prepareStatement(sql);//编译预处理
                pstmt.setInt(1,users.getUserId());
                pstmt.setString(2,users.getIdentyid());
                pstmt.setString(3,users.getNickname());
                pstmt.setString(4,users.getRealname());
                pstmt.setInt(5,users.getPoint());
                pstmt.setString(6,users.getQq());
                pstmt.setString(7,users.getPhone());
                pstmt.setString(8,users.getPassword());
                pstmt.execute();


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

    public static void insert2(User users) throws SQLException{//用于插入无Qq与phone的记录
        Connection conn = null;
        PreparedStatement pstmt = null;
        Statement stmt = null;
        //users=new User();
        try{
            conn=DBAconnect.getConnection();
            if(conn!=null){
                String sql="insert into User(UserId,IdentyId,Nickname,Realname,Point,Password) VALUES(?,?,?,?,?,?)";
                // String sql="insert into User (UserId,IdentyId,Realname,Point,password) VALUES(5,dfsadfsafsa,c,0,d98fa9dfa)";
                //String sql=null;
                //conn.prepareStatement(sql);
                pstmt=conn.prepareStatement(sql);
                // pstmt.execute(sql);//游标，rs为执行后的
                // pstmt = conn.prepareStatement(sql);//编译预处理
                pstmt.setInt(1,users.getUserId());
                pstmt.setString(2,users.getIdentyid());
                pstmt.setString(3,users.getNickname());
                pstmt.setString(4,users.getRealname());
                pstmt.setInt(5,users.getPoint());
                pstmt.setString(6,users.getPassword());
                pstmt.execute();


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
}
