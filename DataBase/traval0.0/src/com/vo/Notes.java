package com.vo;

//import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * Created by 13190 on 2017/7/12.
 */
public class Notes {
    private static int textid;
    private static String content;
    private static String comment;
    private static String uploadtime;
    private static String changetime;
    private static String name;
    private static String autor;
    private  static String where;
    private static String changer;
    //private DriverManagerDataSource datasourse;

    public Notes(){

    }
    public void setTextid(int Textid){
        textid=Textid;
    }
    public void setContent(String Content){
        content=Content;
    }
    public void setComment(String Comment){comment=Comment;}
    public void setUploadtiem(String Uploadtime){
        uploadtime=Uploadtime;
    }
    public void setChangetime(String Changetime){
        changetime=Changetime;
    }
    public void setName(String Name){
        name=Name;
    }
    public void setAutor(String Autor){
        autor=Autor;
    }
    public void setWhere(String Where){
        where=Where;
    }
    public void setChanger(String Changer){
        changer=Changer;
    }
    public int getTextid(){
        return textid;
    }
    public String getContent(){
        return content;
    }
    public String getComment(){return comment;}
    public String getUploadtime(){
        return  uploadtime;
    }
    public String getChangetime(){
        return changetime;
    }
    public String getName(){
        return name;
    }
    public String getAutor(){
        return autor;
    }
    public String getWhere(){
        return where;
    }
    public String getChanger(){
        return changer;
    }
}
