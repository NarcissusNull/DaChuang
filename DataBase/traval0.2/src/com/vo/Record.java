package com.vo;

/**
 * Created by 13190 on 2017/9/7.
 */
public class Record {
    int userid;
    int textid;
    public void setUserid(int Userid){
          userid=Userid;
    }
    public void setTextid(int Textid){
        textid=Textid;
    }
    public int getUserid(){
        return userid;
    }
    public int getTextid(){
        return textid;
    }
}
