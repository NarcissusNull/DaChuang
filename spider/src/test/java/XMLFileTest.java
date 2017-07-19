import java.io.FileNotFoundException;

/**
 * Created by Narcissus on 2017/7/19.
 */
public class XMLFileTest {
    public static void main(String[] args) throws FileNotFoundException {
        XMLFile xmlFile = new XMLFile("1","1","1","1","1");
        xmlFile.addNode("text","sdlfjsljflskdfl");
        xmlFile.addNode("text","ssdafd","photo","skfajlsjflkaj");
        xmlFile.createXMLFile();
    }
}
