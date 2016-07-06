package wzd.pkg;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import com.sun.org.apache.xml.internal.serialize.OutputFormat;
import com.sun.org.apache.xml.internal.serialize.XMLSerializer;


public class DOMWriteDemo_01 {

	public static void main(String[] args) {

		System.out.println("=======xml file writing=====");

		DocumentBuilderFactory dbf = null;
		DocumentBuilder db = null;
		Document document = null;
		
		try {
			dbf = DocumentBuilderFactory.newInstance();
			db = dbf.newDocumentBuilder();
			document = db.newDocument();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
		
		/* 创建文件节点 */
		
		//创建根节点,并追加到document中
		Element root = document.createElement("ip_config");
		document.appendChild(root);
		
		//第一层楼信息
		Element floor = document.createElement("floor");
		root.appendChild(floor);
		
		//第一层楼信息
		//  --number
		//  --IP-address
		Element number = document.createElement("number");
		floor.appendChild(number);
		
		Text numberText = document.createTextNode("0001");
		number.appendChild(numberText);
		
		Element ip = document.createElement("IP_address");
		floor.appendChild(ip);
		
		Text ipText = document.createTextNode("192.168.111.2");
		ip.appendChild(ipText);
		
		//第二层楼信息
		floor = document.createElement("floor");
		root.appendChild(floor);
		
		//第二层楼信息
		//  --number
		//  --IP-address
		number = document.createElement("number");
		number.setAttribute("endian", "smallendian");
		number.setAttribute("weather", "rain");
		floor.appendChild(number);
		
		numberText = document.createTextNode("0001");
		number.appendChild(numberText);
		
		ip = document.createElement("IP_address");
		floor.appendChild(ip);
		
		ipText = document.createTextNode("192.168.111.2");
		ip.appendChild(ipText);
		
		/* 输出文件到磁盘 */
		
		//输出文件到磁盘
		FileOutputStream out = null;
		OutputFormat format = null;
		XMLSerializer xmlSerilizer = null;
		
		try {
			out = new FileOutputStream("out.xml");
			format = new OutputFormat(document);
			xmlSerilizer = new XMLSerializer(out, format);
			xmlSerilizer.serialize(document); 
		} catch (FileNotFoundException e) {
			e.printStackTrace();	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("====write complete====");

	}

}
