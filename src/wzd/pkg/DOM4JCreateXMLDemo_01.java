package wzd.pkg;

import java.io.File;
import java.io.FileWriter;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

public class DOM4JCreateXMLDemo_01 {

	public static void main(String[] args) {
		DOM4JCreateXMLDemo_01.createXMLFile();
	}

	/*
	 * @brief
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
	public static void createXMLFile(){
		
		Document document = DocumentHelper.createDocument();
		
		//创建根节点
		Element rootElement = document.addElement("tel");
		//为根节点添加属性
		rootElement.addAttribute("tel-attribute", "tel-attribute-value");
		
		//创建子节点
		Element tellistElement = rootElement.addElement("tel-list");
		
		Element nameElement = tellistElement.addElement("name");
		nameElement.addText("Lily");
		nameElement.addAttribute("id", "01");
		nameElement.addAttribute("kiss", "no");
		
		Element ageElement = tellistElement.addElement("age");
		ageElement.addText("18");
		
		Element sexElement = tellistElement.addElement("sex");
		sexElement.addText("female");

		Element phoneElement = tellistElement.addElement("phone");
		phoneElement.addText("15212228901");

		try {
			// 下面format用来格式化输出到XML文件，观看的结构清晰
			OutputFormat format = new OutputFormat();
			format.setIndentSize(2);// 缩进字符
			format.setNewlines(true);// 换行
			format.setTrimText(false);
			format.setPadText(true);// 填补
			format.setEncoding("UTF-8");// 字符编码

			XMLWriter output = new XMLWriter(new FileWriter(new File(new File(
					"").getAbsolutePath()
					+ File.separator
					+ "file"
					+ File.separator + "DOM4J_create_xml.xml")), format);

			output.write(document);
			output.close();
			System.out.println("create XML success!");
		} catch (Exception e) {

		}

	}
}
