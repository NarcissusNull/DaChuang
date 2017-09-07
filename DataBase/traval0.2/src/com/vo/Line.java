package com.vo;

//import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * Created by 13190 on 2017/7/12.
 */
public class Line {
    private static String spotid1;
    private static String spotid2;
    private static String where;
//    private DriverManagerDataSource datasourse;
    public Line(){

    }
    public Line(String Spotid1,String Spotid2,String Where){
        spotid1=Spotid1;
        spotid2=Spotid2;
        where=Where;
    }
    public static void setSpotid1(String Spotid1){
        spotid1=Spotid1;
    }
    public static void setSpotid2(String Spotid2){
        spotid2=Spotid2;
    }
    public static void setWhere(String Where){
        where=Where;
    }
    public static String getSpotid1(){
        return spotid1;
    }
    public static String getSpotid2(){
        return spotid2;
    }
    public static String getWhere(){
        return where;
    }
}
