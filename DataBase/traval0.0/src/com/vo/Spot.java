package com.vo;

//import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * Created by 13190 on 2017/7/12.
 */
public class Spot {
    private static String point;
    private static String sceneid;
    private static String spotname;
    private static String scenename;
    private static String city;
   // private DriverManagerDataSource datasourse;
    public Spot(){
    }
    public Spot(String Point,String Sceneid,String Spotname,String Scenename,String City){
        point=Point;
        sceneid=Sceneid;
        scenename=Scenename;
        city=City;
    }
    public void setPoint(String Point){
        point =Point;
    }
    public void setSceneid(String Sceneid){
        sceneid=Sceneid;
    }
    public void setScenename(String Scenename){
        scenename=Scenename;
    }
    public void setCity(String City){
        city=City;
    }
    public String getPoint(){
        return point;
    }
    public String getSceneid(){
        return sceneid;
    }
    public String getScenename(){
        return scenename;
    }
    public String getCity(){
        return city;
    }
}