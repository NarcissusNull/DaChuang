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
    private static String monicker;
    private static int autor;
    private  static String place;
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
    public void setMonicker(String Monicker){
        monicker=Monicker;
    }
    public void setAutor(int Autor){
        autor=Autor;
    }
    public void setPlace(String Place){
        place=Place;
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
    public String getMonicker(){
        return monicker;
    }
    public int getAutor(){
        return autor;
    }
    public String getPlace(){
        return place;
    }
    public String getChanger(){
        return changer;
    }
}
