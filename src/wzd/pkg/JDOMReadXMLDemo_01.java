package wzd.pkg;

import java.io.File;
import java.io.IOException;
import java.util.*;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;




public class JDOMReadXMLDemo_01 {

	public static void main(String[] args) {

        SAXBuilder saxBuilder = null;
        Document doc = null;
		
        //创建一个SAXBuilder对象
        saxBuilder = new SAXBuilder();            
        //读取prop.xml资源
        try {
			doc = saxBuilder.build(new File("").getAbsolutePath()+ File.separator+"file"+File.separator+"jdom_read_source.xml");
		} catch (JDOMException | IOException e) {
			e.printStackTrace();
		}
        
        
        //获取根节点
        Element rootElement = doc.getRootElement();
        System.out.println(rootElement.getName());
        
        @SuppressWarnings("unchecked")
		List<Element> tellistList = rootElement.getChildren();
        
        for( int index=0;index<tellistList.size();index++){
        	//name age sex phone
        	Element nameElement = tellistList.get(index).getChild("name");
        	Element ageElement = tellistList.get(index).getChild("age");
        	Element sexElement = tellistList.get(index).getChild("sex");
        	Element phoneElement = tellistList.get(index).getChild("phone");
        	
        	//get text
        	String nameText = nameElement.getText();
        	String ageText = ageElement.getText();
        	String sexText = sexElement.getText();
        	String phoneText = phoneElement.getText();
        	
        	//get attribute in name.
        	String idAttribute = nameElement.getAttributeValue("id");
        	String kissAttribute = nameElement.getAttributeValue("kiss");
        	
        	//message print.
        	System.out.println("姓名："+nameText+" id="+idAttribute+" kiss= "+kissAttribute);
        	System.out.println("年龄："+ageText);
        	System.out.println("性别："+sexText);
        	System.out.println("电话号码："+phoneText);
        }
	}

}
