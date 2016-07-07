package wzd.pkg;



import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.jdom.*;
import org.jdom.output.*;


/*
 * 创建如下所示的xml文件。
 * 
 *  <?xml version="1.0" encoding="UTF-8"?>
 *
 *	
 *  <tel tel-attribute="tel-attribute-value">
 *  	<tel-list>
 *  		<name id="01" kiss="no">Lily</name>
 *  		<age>18</age>
 *  		<sex>female</sex>
 *  		<phone>15212228901</phone>
 *  	</tel-list>
 *  </tel>
 * 
 * 
 */



public class JDOMWriteXMLDemo_01 {

	public static void main(String[] args) {
		
		//创建根节点
		Element root = new Element("tel");
		
		//创建其他子节点
		Element tellist = new Element("tel-list");
		Element nameElement = new Element("name");
		Element ageElement = new Element("age");
		Element sexElement = new Element("sex");
		Element phoneElement = new Element("phone");
		
		
		//设置节点 的文本
		nameElement.setText("Lily");
		ageElement.setText("18");
		sexElement.setText("female");
		phoneElement.setText("15212228901");
		
		//设置根节点的属性
		root.setAttribute("tel-attribute", "tel-attribute-value");
		
		//设置其他节点的属性
		nameElement.setAttribute("id", "01");
		nameElement.setAttribute("kiss", "no");
		
		//设置节点间的关系
		tellist.addContent(nameElement);
		tellist.addContent(ageElement);
		tellist.addContent(sexElement);
		tellist.addContent(phoneElement);
		
		root.addContent(tellist);
		
		
		
		Document document = new Document(root);
		
		// 设置显示格式
		Format format = Format.getRawFormat();
		format.setIndent("    ");
		XMLOutputter out = new XMLOutputter(format.setEncoding("UTF-8"));
		try {
			out.output(document, new FileOutputStream(new File(new File("").getAbsolutePath()+File.separator+ "file"+File.separator+"JDOM_create_file.xml")));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("=====xml file create complete=====");
		
	}

}
