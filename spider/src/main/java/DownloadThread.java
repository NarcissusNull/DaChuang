import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Queue;

/**
 * 图片下载线程
 * Created by Narcissus on 2017/7/21.
 */
public class DownloadThread extends Thread{

    SynQueue imgList;

    public  DownloadThread(SynQueue synQueue){
        this.imgList = synQueue;
    }

    @Override
    public void run() {

        String url;
        //图片的下载网址
        String img;
        //图片名
        String downloadImage;
        //图片的下载地址
        Download download;
        //下载对象
        int sum = 0;

        while (true) {
            url = imgList.pull();
//            if(!Util.match("(http|ftp|https):\\/\\/([\\w.]+\\/?)\\S*",url)){
//            }
            img = url.substring(url.lastIndexOf("/") + 1, url.length());
            System.out.println(url);
            downloadImage = "F:/DaChuang/" + img;
            try {
                download = new Download(url, downloadImage);
                download.download();
                sum++;
                System.out.println("共下载： "+sum+" 张图片");
                //下载title的背景图片
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
