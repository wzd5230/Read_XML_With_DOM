package wzd.pkg;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class DOMParseDemo_01 {

	public static void main(String[] args) {
		
		
		System.out.println("=======xml file parsing=====");

		DocumentBuilderFactory dbf = null;
		DocumentBuilder db = null;
		Document doc = null;
		
		dbf = DocumentBuilderFactory.newInstance();
		try {
			db = dbf.newDocumentBuilder();
			doc = db.parse("D:\\STUDY\\XML_Parse\\file\\"+"tel.xml"); 
			
			System.out.println("document url: "+doc.getDocumentURI());
			
		} catch (ParserConfigurationException | SAXException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//获取xml文件 的版本号
		System.out.println("the xml file version is: "+doc.getXmlVersion());
		
		//获取xml文件的编码
		System.out.println("the xml file encoding is: "+doc.getXmlEncoding());
		
		//获取xml文件的standalone值
		System.out.println("the xml file standalone value is: "+doc.getXmlStandalone());
		
		//获取所有name的节点，并打印出name的值
		NodeList nodeList = doc.getElementsByTagName("name");
		System.out.println("--------show all \"name\" element value--------");
		System.out.println("contain \"name\" num: "+nodeList.getLength());
		
		for(int i=0;i<nodeList.getLength();i++){
			Node node = nodeList.item(i);
			System.out.println(" name-" + node.getNodeType());
			node = node.getFirstChild();
			System.out.println("index:-"+i+" value:-"+node.getNodeValue()+" type-"+node.getNodeType()+" name-"+node.getNodeName()
					);
		}
		
		//打印该xml文件中所有的信息
		System.out.println("========print all elements in xml file----------");
		
		Node telNode =  doc.getFirstChild();
		
		
		NodeList tellistNodeList = ((Element)telNode).getElementsByTagName("tel-list");
		
		for( int i=0;i<tellistNodeList.getLength();i++){
			
			
			Element tellistElement = (Element)tellistNodeList.item(i);
			System.out.println("----第"+ i +"个信息----");
			
			NodeList nameNodeList = tellistElement.getElementsByTagName("name");
			NodeList ageNodeList = tellistElement.getElementsByTagName("age");
			NodeList sexNodeList = tellistElement.getElementsByTagName("sex");
			NodeList phoneNodeList = tellistElement.getElementsByTagName("phone");
			
			System.out.println("    "+"name: "+nameNodeList.item(0).getFirstChild().getNodeValue());
			System.out.println("    "+"age: "+ageNodeList.item(0).getFirstChild().getNodeValue());
			System.out.println("    "+"sex: "+sexNodeList.item(0).getFirstChild().getNodeValue());
			System.out.println("    "+"phone: "+phoneNodeList.item(0).getFirstChild().getNodeValue());
			
			
			
			
		}
		
		
	}
	
}
