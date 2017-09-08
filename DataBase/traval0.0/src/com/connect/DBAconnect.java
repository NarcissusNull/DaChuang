package com.connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by 13190 on 2017/8/3.
 */
public class DBAconnect {
    private final static String driver="com.mysql.jdbc.Driver";  //URL指向要访问的数据库名mydata
    private final static String url="jdbc:mysql://localhost:3306/travals?useUnicodLle=true&characterEncoding=utf-8";
    private static String name="root"; //MySQL配置时的用户名
    private  static String pwd="625676";//MySQL配置时的密码
    public static Connection getConnection()
    {
        Connection conn=null;
        if(conn==null)
        {
            try
            {
                Class.forName(driver);/**此方法含义是：加载参数指定的类，并且初始化它。
             到这里，不用解释，读者也会明白，在使用jdbc方式连接数据库时，为什
             么要执行Class.forName('驱动类名')方法了：将驱动类的class文
             件装载到内存中，并且形成一个描述此驱动类结构的Class类实例，并且
             初始化此驱动类，这样jvm就可以使用它了，这就是Class.forName()
             方法的含义。
             */
                conn= (Connection) DriverManager.getConnection(url, name, pwd);
            }
            catch ( ClassNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                System.out.println("jar包未导入");
            }
            catch(SQLException e)
            {
                System.out.println("url/name/pwd有无，请检查后重新联结");
            }
        }
        return (Connection) conn;
    }
    public static void Change(String Name,String Pwd){
        name=Name;
        pwd=Pwd;
    }
}
