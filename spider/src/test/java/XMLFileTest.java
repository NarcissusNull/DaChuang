import java.io.FileNotFoundException;

/**
 * Created by Narcissus on 2017/7/19.
 */
public class XMLFileTest {
    public static void main(String[] args) throws FileNotFoundException {
        XMLFileHandle xmlFileHandle = new XMLFileHandle("1","1","1","1","1");
        xmlFileHandle.addNode("text","sdlfjsljflskdfl");
        xmlFileHandle.addNode("text","ssdafd","photo","skfajlsjflkaj");
        xmlFileHandle.createXMLFile();
    }
}
