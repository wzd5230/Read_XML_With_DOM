package wzd.pkg;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;



public class SAXParseDemo_01 {

	public static void main(String[] args) {

		SAXParserFactory saxParserFactory = null;
		SAXParser saxParser = null;
		
		saxParserFactory = SAXParserFactory.newInstance();
		try {
			saxParser = saxParserFactory.newSAXParser();
		} catch (ParserConfigurationException | SAXException e) {
			e.printStackTrace();
		}
		
		//判断文件是否存在，存在则解析
		File parseFile = new File("D:/STUDY/XML_Parse/file/sax_xml_file.xml");
		
		try {
			if (parseFile.exists()) {
				saxParser.parse(parseFile, new MySAX());
			}else{
				System.out.println("parse false,reason: can't find the file.");
			}
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}


class MySAX extends DefaultHandler{
	private int tabCnt;
	private String preQName=null;
	
	@Override
	public void startDocument() throws SAXException {
		System.out.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		
		this.tabCnt = 0;
	}
	
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		
		if(preQName!=qName){
			MySAX.insertTab(tabCnt);			
		}
		
		this.preQName = qName;
		
		
		System.out.print("<"+qName);
		//输出属性
		if(attributes!=null){
			for(int index=0;index<attributes.getLength();index++){
				System.out.print(" "+attributes.getQName(index)+"=\"");
				System.out.print(attributes.getValue(index));
				System.out.print("\"");
			}
		}
		System.out.print(">");
		
		this.tabCnt++;
	}
	
	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		System.out.print(new String(ch,start,length));
		
	}
	
	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		this.tabCnt--;
		
		System.out.print("</");
		System.out.print(qName);
		System.out.print(">");
		
		
	}
	
	@Override
	public void endDocument() throws SAXException {
		
	}
	
	private static void insertTab(int n){
		
		if(n<0){
			return;
		}
		
		for(int index=0;index<n;index++){
			System.out.print("");
		}
	}
	
}