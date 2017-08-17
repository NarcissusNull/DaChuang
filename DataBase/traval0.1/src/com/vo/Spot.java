package com.vo;

//import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * Created by 13190 on 2017/7/12.
 */
public class Spot {
    private static int Point;
    private static String Sceneid;
    private static String potname;
    private static String Scenename;
    private static String City;
    private static String Spotname;
   // private DriverManagerDataSource datasourse;
    public Spot(){
    }
    public Spot(int point,String sceneid,String spot,String scenename,String city){
        Point=point;
        Sceneid=sceneid;
        Spotname=spot;
        Scenename=scenename;
        City=city;
    }
    public void setPoint(int point){
        Point=point;
    }
    public void setSceneid(String sceneid){
        Sceneid=sceneid;
    }
    public void setSpotname(String spot){Spotname=spot;}
    public void setScenename(String scenename){
        Scenename=scenename;
    }
    public void setCity(String city){
        city=City;
    }

   // public void setSpotname(String Spot){spot=Spot};
    public int getPoint(){
        return Point;
    }
    public String getSceneid(){
        return Sceneid;
    }
    public String getSpotname(){return Spotname;}
    public String getScenename(){
        return Scenename;
    }
    public String getCity(){
        return City;
    }


}