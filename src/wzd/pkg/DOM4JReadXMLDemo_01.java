package wzd.pkg;

import java.io.File;
import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class DOM4JReadXMLDemo_01 {

	public static void main(String[] args) {

		DOM4JReadXMLDemo_01.parseXML();
	}

	/**
	 * 解析工程目录下xml文件。
	 * 文件路径：/file/DOM4J_source_xml.xml
	 */
	public static void parseXML(){
		
		SAXReader reader = null;
		Document   document = null;

		reader = new SAXReader();
		try {
			document = reader.read(new File(new File("").getAbsolutePath()
					+ File.separator + "file" + File.separator
					+ "DOM4J_source_xml.xml"));
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		
		//获取根节点
		Element rootElement = document.getRootElement();
		
		//获取根节点下的所有子节点的迭代对象
		@SuppressWarnings("unchecked")
		Iterator<Element> iterator = rootElement.elementIterator();
		
		while(iterator.hasNext()){
			Element tellistElement = (Element)iterator.next();
			
			//获取name节点
			Element nameElement = tellistElement.element("name");
			
			String idString = nameElement.attributeValue("id");
			String kissString = nameElement.attributeValue("kiss");
			
			String nameText = nameElement.getText();
			
			
			//获取age节点
			Element ageElement = tellistElement.element("age");
			
			String ageText = ageElement.getText();
			
			//获取sex节点
			Element sexElement = tellistElement.element("sex");
			
			String sexText = sexElement.getText();
			
			
			//获取phone节点
			Element phoneElement = tellistElement.element("phone");
			
			String phoneText = phoneElement.getText();
			
			System.out.println("姓名： "+nameText+" id:"+idString+" kiss:"+kissString);
			System.out.println("年龄："+ageText);
			System.out.println("性别："+sexText);
			System.out.println("手机："+phoneText);
			System.out.println("");
			
			
		}
		
		
		System.out.println("------file parse complete-----");
	}
}
