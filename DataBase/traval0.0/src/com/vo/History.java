package com.vo;

//import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * Created by 13190 on 2017/7/12.
 */
public class History {
    public static int userid;
    public static String recentspot;
    public static String recentscene;
    public static String time;
    //private DriverManagerDataSource datasourse;
    public History(){

    }
    public History(int Userid,String Recentspot,String Recentscene,String Time){
        userid=Userid;
        recentspot=Recentspot;
        recentscene=Recentscene;
        time=Time;
    }
    public static void setUserid(int Userid){
        userid=Userid;
    }
    public static void setRecentspot(String Recentspot){
        recentspot=Recentspot;
    }
    public static void setrecentscene(String Recentscene){
        recentscene=Recentscene;
    }
   public static void settime(String Time){
        time=Time;
   }
   public static int getUserid(){
       return userid;
   }
   public static String getRecentspot(){
       return recentspot;
   }
   public static String getRecentscene(){
       return  recentscene;
   }
   public static String getTime(){
       return time;
    }
}
