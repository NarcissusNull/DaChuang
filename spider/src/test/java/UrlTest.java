import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Narcissus on 2017/7/17.
 */
public class UrlTest {
    public static void main(String[] args) throws IOException {
        String url = new String("http://chanyouji.com/trips/139307#nt/5910916");
        Document document;
        document = Jsoup.connect(url).get();
        File file = new File("test.html");
        file.createNewFile();
        FileWriter fw = new FileWriter(file, true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(document.html());
        bw.flush();
        bw.close();
        fw.close();
    }
}
