import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.*;

/**
 * 解析或创建XML
 * Created by Narcissus on 2017/7/18.
 */

public class XMLFile {

    private Document document;
    //XML文件主体

    /**
     * 解析时使用的构造方法，解析XML文件成为字符串
     * @param xmlFile               XML文件
     * @throws DocumentException    抛出SAXReader创建时的异常
     */
    public XMLFile(File xmlFile) throws DocumentException {
        SAXReader saxReader = new SAXReader();
        document = saxReader.read(xmlFile);
    }

    /**
     * 创建时使用的构造方法，添加基础标签
     * @param titleText     标题
     * @param src           背景图片存储路径
     * @param titleImgText  背景图片描述
     * @param dateText      时间
     * @param authorText    作者编号
     */
    public XMLFile(String titleText,String src,String titleImgText,String dateText,String authorText){
        Element travel   = DocumentHelper.createElement("travel");
        document = DocumentHelper.createDocument(travel);
        //创建根标签
        Element head     = travel.addElement("head");
        Element body     = travel.addElement("body");
        Element title    = head.addElement("title");
        Element titleImg = head.addElement("titleImg");
        Element date     = head.addElement("date");
        Element author   = head.addElement("author");
        //创建所有基础标签，不包含node标签
        title.addText(titleText);
        titleImg.addText(titleImgText);
        date.addText(dateText);
        author.addText(authorText);
        //为各个标签添加内容
    }

    /**
     * 添加只有一个子标签的node标签
     * @param element   子标签名
     * @param text      子标签内容
     */
    public void addNode(String element,String text){
        Element travel  = document.getRootElement();
        Element body    = travel.element("body");
        Element node    = body.addElement("node");
        Element e       = node.addElement(element);
        e.addText(text);
    }

    /**
     * 添加有两个子标签的node标签
     * @param element1  第一个子标签名
     * @param text1     第一个子标签内容
     * @param element2  第二个子标签名
     * @param text2     第二个子标签内容
     */
    public void addNode(String element1,String text1,String element2,String text2){
        Element travel  = document.getRootElement();
        Element body    = travel.element("body");
        Element node    = body.addElement("node");
        Element e1      = node.addElement(element1);
        Element e2      = node.addElement(element2);
        e1.addText(text1);
        e2.addText(text2);
    }

    /**
     * 创建XML文件
     * @throws FileNotFoundException 抛出创建XMLWriter时的异常
     */
    public void createXMLFile() throws FileNotFoundException {
        OutputFormat outputFormat = new OutputFormat("  ",true);
        //设置是否换行
        outputFormat.setEncoding("UTF-8");
        //设置编码方式
        try {
            XMLWriter xmlWriter = new XMLWriter(new FileOutputStream("test.xml"),outputFormat);
            xmlWriter.write(document);
            xmlWriter.close();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
