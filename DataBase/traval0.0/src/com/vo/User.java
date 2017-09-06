package com.vo;

//import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * Created by 13190 on 2017/6/27.
 * 对应着traval数据库中的Uer表
 */
public class User{
    private int UserID;
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
        UserID=userid;
        IdentyId=identyid;
        Nickname=nickname;
        Realname=realname;
        Point=point;
        Qq=qq;
        Phone=phone;
        Password=password;
    }

    public User()    {

    }
    public  void setUserID(int userid){
        UserID=userid;
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
    public  int getUserID(){
        return  UserID;
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
        System.out.println(UserID+" "+IdentyId+" "+" "+Nickname+" "+Realname+" "+Point+" "+Password);
    }
}