/**
 * 使用jsoup包，解析html文件
 * 采用流水线-消费者-生产者模式多线程方式进行爬取
 * Created by Narcissus on 2017/6/25.
 */

public class Main {
    public static void main(String[] args) {
        SynQueue urlList = new SynQueue();
        //要爬取的网页仓库
        SynQueue imgList = new SynQueue();
        //要下载的图片仓库

        URLSelectThread urlSelectThread = new URLSelectThread(urlList);
        URLHandleThread urlHandleThread = new URLHandleThread(urlList, imgList);
        DownloadThread downloadThread = new DownloadThread(imgList);
        //声明三个线程

        urlSelectThread.start();
        urlHandleThread.start();
        downloadThread.start();
        //开始所有线程
    }
}