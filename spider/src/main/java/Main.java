import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * 使用jsoup包，解析html文件
 * Created by Narcissus on 2017/6/25.
 */
public class Main {
    public static void main(String[] args){


        String title;
        String date;
        String titleImage;
        String downloadImage;
        //以上变量用来读取和要爬取的信息
        File file;
        Download download;
        String titleImageURL;
        //以上变量用来下载图片
        int sum = 0;


                    //如果网址是单个游记的网址，进行爬取
                    sum++;
                    System.out.println(sum);

//                    System.out.println("get");
//                    System.out.println(document);
//                    //验证爬取的网页是否为所要的

//                    file = new File("t.html");
//                    file.createNewFile();
//                    FileWriter fw = new FileWriter(file, true);
//                    BufferedWriter bw = new BufferedWriter(fw);
//                    bw.write(document.html());
//                    bw.flush();
//                    bw.close();
//                    fw.close();
//                    //下载网页源代码

                    elements = document.select("body");
                    element = elements.get(0);
                    //获取body标签
                    if(!match(element.attr("id"),"trips-show")){
                        continue;
                    }
                    //判断是否为私密游记

                    elements = element.select(".trip-title");
                    element = elements.get(0);
                    title = element.text();
                    System.out.println(title);
                    //获取游记的title

                    elements = document.select(".trip-summary");
                    element = elements.get(0);
                    date = element.text();
                    System.out.println(date);
                    //获取游记的时间

                    elements = document.select(".trip-header");
                    element = elements.get(0);
                    elements = element.select("img");
                    element = elements.get(0);
                    titleImageURL = element.attr("src");
                    titleImageURL = titleImageURL.substring(0,titleImageURL.lastIndexOf("-"));
                    System.out.println(titleImageURL);
                    titleImage = titleImageURL.substring(titleImageURL.lastIndexOf("/")+1,titleImageURL.length());
                    System.out.println(titleImage);
                    //获取title的背景图片

                    elements = document.select(".trip-body");
                    element = elements.get(0);
                    //获取游记的主体
                    elements = element.select("div");
                    for(int j = 0;j < elements.size();j++){
                        //处理所有主体的div

                    }


//                    file = new File("E:/DaChuang/"+titleImage.substring(0,titleImage.lastIndexOf("/")).substring(0,titleImage.lastIndexOf("/")));
//                    file.mkdirs();
//                    downloadImage = "E:/DaChuang/"+title+titleImage.substring(titleImage.lastIndexOf("/"),titleImage.length());
//                    download = new Download(titleImage,downloadImage);
//                    download.download();
//                    //下载title的背景图片

//                    elements = document.select(".ctd_content");
//                    element = elements.get(0);
//                    //获取正文
//                    elements = element.select("*");
//                    for(int i = 0;i < elements.size();i++) {
//                        element = elements.get(i);
//                        if(element.attr("clss")=="img"){
//                            Elements es = element.select("*");
//                            Element e;
//                            for(int j = 0;j < es.size();j++){
//                                e = es.get(i);
//                                if(e.attr("class")=="img_blk"){
//                                    Elements ees = e.select("a[href]");
//                                    e = ees.get(0);
//                                    String str = e.attr("href");
//                                    //TODO
//                                }
//                            }
//                        }
//                    }
                }

        }

    public static boolean match(String regex, String str) {
        //字符串匹配
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }

}
