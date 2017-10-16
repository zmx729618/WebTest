package xml.test;

import java.io.File;
import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;


	/**
	 * @author Alexia
	 * 
	 * Dom4j 解析XML文档
	 */
	public class Dom4jParseXmlDocument implements XmlDocument {

	    @SuppressWarnings("unchecked")
		public void parserXml(String fileName) {
	        File inputXml = new File(fileName);
	        SAXReader saxReader = new SAXReader();
	        try {
	            Document document = saxReader.read(inputXml);
	            Element users = document.getRootElement();
	            for (Iterator<Element> i = users.elementIterator(); i.hasNext();) {
	                Element user =  i.next();
	                for (Iterator<Element> j = user.elementIterator(); j.hasNext();) {
	                    Element node = j.next();
	                    System.out.println(node.getName() + ":" + node.getText());
	                }
	                System.out.println();
	            }
	        } catch (DocumentException e) {
	            System.out.println(e.getMessage());
	        }
  

	}
	    
	    
	    public static void main(String[] args) {
	    	 
	    	 new Dom4jParseXmlDocument().parserXml("D:\\Workspaces\\projects\\testWeb\\src\\xml\\test\\user.xml");
			
		}

}
