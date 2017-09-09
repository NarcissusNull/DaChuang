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
    public static List<User> selectAll() throws SQLException {//搜索所有的用户内容，并返回一个User线性表
        Connection conn = null;//数据库连接常量申请
        PreparedStatement pstmt = null;//编译预处理区域
        ResultSet rs = null;//游标常量声明
        List<User> list = new ArrayList<>();//创建User线性表
        try{//主体部分
            conn = DBAconnect.getConnection();
            if (conn != null) {//当可以张昌
                String sql = "select * from User";//sql语句，搜索User所有内容
                pstmt = conn.prepareStatement(sql);//编译预处理
                rs = pstmt.executeQuery();//sql执行

                while (rs.next()) {//当next指针不为空，即线性表未空
                    User user=new User();//申请元素，User
                    user.setUserId(rs.getInt(1));
                    user.setIdentyid(rs.getString(2));
                    user.setNickname(rs.getString(3));
                    user.setRealname(rs.getString(4));
                    user.setPoint(rs.getInt(5));
                    user.setQq(rs.getString(6));
                    user.setPhone(rs.getString(7));
                    user.setPassword(rs.getString(8));
                    //填充User单元元素
                    list.add(user);//加入线性表
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
        return list;//返回查找结果
    }
    //测试已毕，可用


    public static List<String> selectOneString(String option) throws SQLException {//用以查找字符串性的
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;//连接，准备区，游标声明
        List<String> list = new ArrayList<>();
        try {
            conn = DBAconnect.getConnection();//申请myql连接
            if (conn != null) {//若连接成功，则退出程序，并展示
                String sql = "select " + option + " from User ";//sql语句进行
                pstmt = conn.prepareStatement(sql);//编译预处理
                rs = pstmt.executeQuery();//游标，rs为执行后的
               // User user = new User();
                //注入，sql语句编译，编译完成后将搜索的信息注入
                while(rs.next()) {//若游标下一个元素存在
                    if (option == "UserId")
                        System.out.println("所查询的项目为整数型数据");
                    else if (option == "IdentyId")
                        list.add(rs.getString("IdentyId"));
                    else if (option == "Nickname")
                        list.add(rs.getString("Nickname"));
                    else if (option == "Realname")
                        list.add(rs.getString("Realname"));
                    else if (option == "Point")
                        System.out.println("所查询的项目为整数型数据");
                    else if (option == "Qq")
                        list.add(rs.getString("Qq"));
                    else if (option == "Phone")
                        list.add(rs.getString("Phone"));
                    else if (option == "Password")
                        list.add(rs.getString("Password"));
                    else {
                        System.out.print("User输入格式错误，请检查，该表的正确输入格式为:/n UserId IdentyId Nickname Realname Point Qq Password");
                        return null;
                    }
                    //若元素为字符主串形式，提出，若非字符传形式，提醒警告
                }

            }
        } catch (SQLException e) {//sql抛出
            e.printStackTrace();
        } finally {//关闭游标，预备区，连接
            rs.close();
            pstmt.close();
            conn.close();
        }
        return list;
    }

    public static ArrayList selectOneInt(String option) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ArrayList list=new ArrayList<>();
        int number=0;
        try {
            conn = DBAconnect.getConnection();
            if (conn != null) {
                String sql = "select " + option + " from User";//sl语句进行
                pstmt = conn.prepareStatement(sql);//编译预处理
                rs = pstmt.executeQuery();//游标，rs为执行后的
                //注入，sql语句编译，编译完成后将搜索的信息注入
                while(rs.next()) {
                    if (option == "UserId")
                        list.add(rs.getInt("UserId"));
                    else if (option == "IdentyId")
                        System.out.println("所查询的项目为字符串型数据");
                    else if (option == "Nickname")
                        System.out.println("所查询的项目为字符串型数据");
                    else if (option == "Realname")
                        System.out.println("所查询的项目为字符串型数据");
                    else if (option == "Point")
                        list.add(rs.getInt("Point"));
                    else if (option == "Qq")
                        System.out.println("所查询的项目为字符串型数据");
                    else if (option == "Phone")
                        System.out.println("所查询的项目为字符串型数据");
                    else if (option == "Password")
                        System.out.println("所查询的项目为字符串型数据");
                    else {
                        System.out.print("User输入格式错误，请检查，该表的正确输入格式为:/n UserId IdentyId Nickname Realname Point Qq Password");
                        return null;
                    }
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

    public static List<User> seLect(String option,String conditon) throws SQLException {//单项搜索，注意有问题，需要检查
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
                else if(option=="IdentyId")
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

    public static void  deLete(String condition)throws SQLException{
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

    public static void upDate(String option,int values1,String condition,int values2) throws  SQLException{
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
    public static void upDate(String option,String values1,String condition,int values2) throws  SQLException{
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
    public static void inSert(User users) throws SQLException{//用于插入完整的记录
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
                pstmt.setInt(   1,users.getUserId());
                pstmt.setString(2,users.getIdentyid());
                pstmt.setString(3,users.getNickname());
                pstmt.setString(4,users.getRealname());
                pstmt.setInt(   5,users.getPoint());
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

    public static void inSert2(User users) throws SQLException{//用于插入无Qq与phone的记录
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
                pstmt.setInt(   1,users.getUserId());
                pstmt.setString(2,users.getIdentyid());
                pstmt.setString(3,users.getNickname());
                pstmt.setString(4,users.getRealname());
                pstmt.setInt(   5,users.getPoint());
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

    //本质上insert1
    /********************************************************************************************************************/

    public static void  grantAll(String option,String users)throws SQLException{//赋权语句
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn=DBAconnect.getConnection();
            if(conn!=null){
                String sql="GRANT "+option+" ON USER TO "+users;
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
        //提示内容
    }

    public static boolean userExit(String name,String psd) throws SQLException {
        boolean flag=false;//旗杆，用以表示密码是否匹配
        Connection conn = null;//创建数据库连接
        PreparedStatement pstmt = null;//创建准本区
        ResultSet rs = null;//游标
        List<String> list = new ArrayList<>();
        List<String> lists=new ArrayList<>();

        try{//主体部分
            conn = DBAconnect.getConnection();
            if(conn!=null){//判断是否可以完成数据库连接
                String sqls="select Nickname from User";
                pstmt=conn.prepareStatement(sqls);//编译预处理
                rs=pstmt.executeQuery();//sql编译
                while(rs.next()){//当游标后内容存在
                    lists.add(rs.getString("Nickname"));
                }

            }
            if(!lists.contains(name)){
                System.out.println("注意检查用户姓名是否存在");
                return flag;
            }
            else{//搜寻用户昵称相应的密码
                String sql = "select password from User Where Nickname="+'"'+name+'"';//sql语句进行
                pstmt = conn.prepareStatement(sql);//编译预处理
                rs = pstmt.executeQuery();//sql执行
                while (rs.next()) {//当next指针不为空，即线性表未空
                    list.add(rs.getString(1));//向线性表中添加string
                }

            }
        }
        catch (SQLException e){//sql抛出
            e.printStackTrace();
        }
        finally {//执行结束，关闭游标，执行域，编译域（希望是这几个名字，没记错）
            rs.close();//关闭游标
            pstmt.close();//关闭准备区
            conn.close();//关闭数据库连接
        }
        if(Util.match(list.get(0),psd)) {//判断字符串是否相等
            flag=true;//改变旗标
        }
        //System.out.println(list.get(0)+"\n"+psd);//展示搜索密码与输入密码

        return flag;//返回旗标

        /**************************************************updeate刷新****************************************************************/
    //注意，condition只能为主键2017。8.17

    /**
     public static List<User> seLect(String option) throws SQLException {//单项搜索，option为搜索的项目名称
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
     //注入，sql语句编译，编译完成后将搜索的信息注入
     while(rs.next()) {
     if (option == "UserId")
     user.setUserId(rs.getInt("UserId"));
     else if (option == "IdentyId")
     user.setIdentyid(rs.getString("IdentyId"));
     else if (option == "Nickname")
     user.setNickname(rs.getString( 1));
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
     */

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

}

}
