package com.vo;

//import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * Created by 13190 on 2017/7/12.
 */
public class Spot {
    private static int point;
    private static String sceneid;
    private static String spotname;
    private static String scenename;
    private static String city;
    private static String spot;
   // private DriverManagerDataSource datasourse;
    public Spot(){
    }
    public Spot(int Point,String Sceneid,String Spotname,String Scenename,String City){
        point=Point;
        sceneid=Sceneid;
        spot=Spotname;
        scenename=Scenename;
        city=City;
    }
    public void setPoint(int Point){
        point =Point;
    }
    public void setSceneid(String Sceneid){
        sceneid=Sceneid;
    }
    public void setSpotname(String Spotname){spotname=Spotname;}
    public void setScenename(String Scenename){
        scenename=Scenename;
    }
    public void setCity(String City){
        city=City;
    }

   // public void setSpotname(String Spot){spot=Spot};
    public int getPoint(){
        return point;
    }
    public String getSceneid(){
        return sceneid;
    }
    public String getSpotname(){return spotname;}
    public String getScenename(){
        return scenename;
    }
    public String getCity(){
        return city;
    }


}