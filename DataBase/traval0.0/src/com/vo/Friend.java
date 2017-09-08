package com.vo;

//import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * Created by 13190 on 2017/7/
 * 对应这friend表
 */
public class Friend {
    private static int userid;
    private String identyid;
    private int friendsid;
  //  private DriverManagerDataSource datasourse;
    public Friend(int Userid,String Identyid,int Friendsid){//构造函数
        userid=Userid;
        identyid=Identyid;
        friendsid=Friendsid;
    }
    public Friend(){

    }
    public static void setUserid(int UserId){
        userid= UserId;
    }
    public void setIdentyid(String IdentyId){
        identyid=IdentyId;
    }
    public void setFriendsid(int FriendsId){
        friendsid=FriendsId;
    }

    public int getUserid(){
        return userid;
    }
    public String getIdentyid(){
        return identyid;
    }
    public int getFriendid(){
        return friendsid;
    }
}
