import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 挑选所需网页的线程
 * Created by Narcissus on 2017/7/21.
 */
public class URLSelectThread extends Thread{

    private SynQueue urlList;

    public URLSelectThread(SynQueue urlList){
        this.urlList = urlList;
    }

    @Override
    public void run(){
        Queue<String> URLlist  = new LinkedList<String>();
        //存储待遍历的URL
        //广度优先遍历
        Set<String> visitedURL = new HashSet<String>();
        //存储已经遍历的URL\
        Document document = null;
        //存储heml文件的类Document,实际上可以理解为字符串
        Element element;
        //存储一个标签的类，实际上也是字符串，可以理解为截取Document类的一部分字符串
        Elements elements;
        //存储多个标签，实际上就是Element的数组
        String href;
        //href参数

        URLlist.offer("http://chanyouji.com/");

        while(!URLlist.isEmpty()){
                String url = URLlist.poll();
                //出队列
                if(visitedURL.contains(url)){
                    //判断是否已经遍历过
                    continue;
                }
                visitedURL.add(url);
                //网址入队列，表示已经遍历
            try {
                document = Jsoup.connect(url).timeout(5000).get();
                //连接网址，获取网页（源代码）
            } catch (IOException e) {
                e.printStackTrace();
            }
            elements = document.select("a");
            //挑选出所有a标签
            for (int i = 0; i < elements.size(); i++) {
                //遍历所有标签，判断其中的href参数是否为要求的网址
                element = elements.get(i);
                href = element.attr("href");
                if (Util.match("^/.*", href)) {
                    //采用正则表达式判断href
                    URLlist.offer("http://chanyouji.com" + href);
                    //入队列，等待爬取
                }
            }
            if(Util.match("^http://chanyouji.com/trips/.*[0-9]*",url)){
                urlList.offer(url);
            }
        }
    }
}