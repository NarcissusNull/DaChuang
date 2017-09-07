import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

/**
 * 处理网址内容的线程
 * Created by Narcissus on 2017/7/26.
 */
public class URLHandleThread extends Thread {

    private SynQueue urlList;
    private SynQueue imgList;

    public URLHandleThread(SynQueue urlList,SynQueue imgList){
        this.urlList = urlList;
        this.imgList = imgList;
    }

    @Override
    public void run() {

        Document document;
        //存储heml文件的类Document,实际上可以理解为字符串
        Element element;
        //存储一个标签的类，实际上也是字符串，可以理解为截取Document类的一部分字符串
        Elements elements;
        //存储多个标签，实际上就是Element的数组
        XMLFileHandle xmlFileHandle;
        //单个游记XML文件处理对象

        String filename;
        String title;
        String date;
        String author;
        //以上变量用来读取和要爬取的信息

        String titleImageURL;
        //以上变量用来下载图片
        int sum = 0;

        while (true) {
            try {
                String url = urlList.pull();
                document = Jsoup.connect(url).timeout(5000).get();
                //连接网址，获取网页（源代码）
                sum++;
                System.out.println("共爬取了 "+sum+" 篇游记");
//                System.out.println("get");
//                System.out.println(document);
//                //验证爬取的网页是否为所要的
//
//                file = new File("t.html");
//                file.createNewFile();
//                FileWriter fw = new FileWriter(file, true);
//                BufferedWriter bw = new BufferedWriter(fw);
//                bw.write(document.html());
//                bw.flush();
//                bw.close();
//                fw.close();
//                //下载网页源代码

                elements = document.select("head");
                element = elements.get(0);
                elements = element.select("meta");
                element = elements.get(5);
                filename = element.attr("content");
                filename = filename.substring(filename.lastIndexOf("/")+1,filename.length());
                System.out.println(filename);
                //获取游记编号

                elements = document.select("body");
                element = elements.get(0);
                //获取body标签
                if (!Util.match(element.attr("id"), "trips-show")) {
                    //判断是否为私密游记
                    continue;
                }

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

                elements = document.select(".user-avatar");
                element = elements.get(0);
                elements = element.select("a");
                element = elements.get(0);
                author = element.attr("href");
                author = author.substring(author.lastIndexOf("/")+1,author.length());
                //获取游记的作者编号

                elements = document.select(".trip-header");
                element = elements.get(0);
                elements = element.select("img");
                element = elements.get(0);
                titleImageURL = element.attr("src");
                titleImageURL = titleImageURL.substring(0, titleImageURL.lastIndexOf("-"));
                System.out.println(titleImageURL);
                imgList.offer(titleImageURL);
                //获取title的背景图片的网址，添加进图片下载队列

                xmlFileHandle = new XMLFileHandle(filename,title,titleImageURL,date,author);
                //创建xml对象

                elements = document.select(".trip-body");
                element = elements.get(0);
                //获取游记的主体
                elements = element.select(".trip-note,.trip-day,.clearfix,.is-last");
                for (int j = 0; j < elements.size(); j++) {
                    //处理所有主体的div
                    Elements es;
                    String imgurl;
                    String text;
                    element = elements.get(j);
                    String classkind = element.attr("class");

                    if (Util.match("trip-node clearfix",classkind)) {
                        es = element.select("*");
                        text=es.get(es.size()-1).text();
                        xmlFileHandle.addNode("text",text);
                    } else if (Util.match("trip-day",classkind)) {
                        es = element.select("span");
                        if(es.size()==1){
                            xmlFileHandle.addNode("text",es.get(0).text());
                        }else {
                            xmlFileHandle.addNode("text",es.get(0).text(),"text",es.get(1).text());
                        }
                    } else if(Util.match("trip-note",classkind)||Util.match("trip-note is-last",classkind)){
                        es = element.select("*");
                        if(Util.match("note-text",es.get(2).attr("class"))){
                            //如果时单个文字段落，进行处理
                            es = es.get(2).select("p");
                            text = es.get(0).text();
                            for(int k = 1;k < es.size(); k++){
                                text = text + "<br>" + es.get(k).text();
                            }
                            xmlFileHandle.addNode("text",text);
                        } else {
                            //如果是图片，进行处理
                            es = es.get(2).select("*");
                            imgurl = es.get(1).attr("data-src");
                            if (imgurl.lastIndexOf("-")!=-1) {
                                imgurl = imgurl.substring(0,imgurl.lastIndexOf("-"));
                            }
                            imgList.offer(imgurl);
                            imgurl = imgurl.substring(imgurl.lastIndexOf("/")+1,imgurl.length());
                            if (es.get(0).select(".caption").size()==0) {
                                //如果仅有一张图片
                                xmlFileHandle.addNode("photo",imgurl);
                            } else if(es.get(0).select(".caption")!=null){
                                //如果另外有文字
                                text = es.get(0).select(".caption").get(0).text();
                                xmlFileHandle.addNode("photo",imgurl,"text",text);
                            }
                        }
                    }
                }
                xmlFileHandle.createXMLFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}