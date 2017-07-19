import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * 下载图片
 * Created by Narcissus on 2017/6/25.
 */
public class Download {
    private URL url;
    private String localImageName;

    public Download(String url,String localImageName) throws MalformedURLException {
        this.url = new URL(url);
        this.localImageName = localImageName;
    }

    public void download() throws IOException {
        DataInputStream dataInputStream = new DataInputStream((url.openStream()));
        FileOutputStream fileOutputStream = new FileOutputStream(new File(localImageName));
        byte[] buffer = new byte[1024];
        int length;
        while((length = dataInputStream.read(buffer))>0){
            fileOutputStream.write(buffer,0,length);
        }
        dataInputStream.close();
        fileOutputStream.close();
    }
}
