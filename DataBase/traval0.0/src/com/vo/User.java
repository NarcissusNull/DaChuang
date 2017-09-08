package com.vo;

//import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * Created by 13190 on 2017/6/27.
 * 对应着traval数据库中的Uer表
 */
public class User{
    private int UserId;
    private String IdentyId;
    private String Nickname;
    private String Realname;
    private int Point ;
    private String Qq;
    private String Phone;
    private String Password;
   // private DriverManagerDataSource datasourse;

    public User(int userid,String identyid,String nickname,String realname,int point ,String qq,String phone,String password)    {
        super();
        UserId=userid;
        IdentyId=identyid;
        Nickname=nickname;
        Realname=realname;
        Point=point;
        Qq=qq;
        Phone=phone;
        Password=password;
    }

    public User(int userid,String identyid,String nickname,String realname,int point ,String phone,String password)    {
        super();
        UserId=userid;
        IdentyId=identyid;
        Nickname=nickname;
        Realname=realname;
        Point=point;
        Qq=null;
        Phone=phone;
        Password=password;
    }

    public User()    {
        UserId=0;
        IdentyId=null;
        Nickname=null;
        Realname=null;
        Point=0;
        Qq=null;
        Phone=null;
        Password=null;
    }
    public  void setUserId(int userid){
        UserId=userid;
    }
    public  void setIdentyid(String identyid){
        IdentyId=identyid;
    }
    public void setNickname(String nickname) {
        Nickname=nickname;
    }
    public void setRealname(String realname){Realname=realname;}
    public void setPoint(int point){
        Point=point;
    }
    public void setPhone(String phone){Phone=phone;}
    public void setQq(String qq){Qq=qq;}
    public void setPassword(String password){
        Password=password;
    }
    public  int getUserId(){
        return  UserId;
    }
    public String getIdentyid(){
        return IdentyId;
    }

    public String getNickname() {
        return Nickname;
    }
   public String getRealname(){return Realname;}
    public int getPoint(){
        return Point;
    }
    public String getPhone(){return Phone;}
    public String getQq(){return Qq;}
    public String getPassword(){
        return Password;
    }

    /**public void setDatasourse(DriverManagerDataSource datasourse) {
        this.datasourse = datasourse;
    }

    public DriverManagerDataSource getDatasourse() {
        return datasourse;
    }*/
    public void display(){
        System.out.println(UserId+" "+IdentyId+" "+" "+Nickname+" "+Realname+" "+Point+" "+Password);
    }
}