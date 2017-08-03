package com.vo;

//import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * Created by 13190 on 2017/7/12.
 */
public class Scene {
    private static String sceneid;
    private static String city;
    private static String name;
  //  private DriverManagerDataSource datasourse;
    public Scene(){

    }
    public Scene(String Scenenid,String City,String Name){
        sceneid=Scenenid;
        city=City;
        name=Name;
    }
    public void setSceneid(String Sceneid) {
        sceneid=Sceneid;
    }
    public void setCity(String City){
        city=City;
    }
    public void setName(String Name){
        name=Name;
    }
    public String getSceneid(){
        return sceneid;
    }
    public String getCity(){
        return city;
    }
    public String getName(){
        return name;
    }
}
