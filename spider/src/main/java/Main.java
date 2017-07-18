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
        Queue<String> URLlist  = new LinkedList<String>();
        //存储待遍历的URL
        //广度优先遍历
        Set<String> visitedURL = new HashSet<String>();
        //存储已经遍历的URL\
        Document document;
        //存储heml文件的类Document,实际上可以理解为字符串
        Element element;
        //存储一个标签的类，实际上也是字符串，可以理解为截取Document类的一部分字符串
        Elements elements;
        //存储多个标签，实际上就是Element的数组
        String href;
        String title;
        String date;
        String titleImage;
        String downloadImage;
        //以上变量用来读取和保存要爬取的信息
        File file;
        Download download;
        //以上变量用来下载图片
        int sum = 0;

        URLlist.offer("http://chanyouji.com/");

        while(!URLlist.isEmpty()){
            try {
                String url = URLlist.poll();
                //出队列
                if(visitedURL.contains(url)){
                    //判断是否已经遍历过
                    continue;
                }
                System.out.println(url);
                visitedURL.add(url);
                //网址入队列，表示已经遍历
                document = Jsoup.connect(url).timeout(5000).get();
                //连接网址，获取网页（源代码）
                elements = document.select("a");
                //挑选出所有a标签
                for(int i = 0;i < elements.size();i++){
                    //遍历所有标签，判断其中的href参数是否为要求的网址
                    element = elements.get(i);
                    href = element.attr("href");
                    if(match("^/.*",href)){
                        //采用正则表达式判断href
                        URLlist.offer("http://chanyouji.com"+href);
                        //入队列，等待爬取
                    }
                }
                if(match("^http://chanyouji.com/trips/.*[0-9]*",url)){
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
                    if(element.attr("id")!="trips-show"){
                        continue;
                    }
                    elements = element.select("div");
                    element = elements.get(0);
                    elements = element.select("div");
                    element = elements.get(2);
                    elements = element.select("div");
                    element = elements.get(0);
                    elements = element.select("h1");
                    element = elements.get(0);
                    title = element.text();
                    System.out.println(title);
                    //获取游记的title

                    elements = document.select(".trip-summary");
                    element = elements.get(0);
                    date = element.text();
                    System.out.println(date);
                    //获取游记的时间

                    elements = document.select(".trip-body");
                    element = elements.get(0);
                    elements = element.select("div");
                    for(int j = 0;j < elements.size();j++){

                    }

//                    elements = document.select(".ctd_cover");
//                    element = elements.get(0);
//                    titleImage = element.attr("src");
//                    //获取title的背景图片
//
//                    file = new File("E:/DaChuang/"+title);
//                    file.mkdirs();
//                    downloadImage = "E:/DaChuang/"+title+"/title.jpg";
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
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static boolean match(String regex, String str) {
        //字符串匹配
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }

}
