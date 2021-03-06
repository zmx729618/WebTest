package xml.test;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DomParseXmlDocument implements XmlDocument {

	@Override
	public void parserXml(String fileName) {
		
		        try {
		            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		            DocumentBuilder db = dbf.newDocumentBuilder();
		            Document document = db.parse(fileName);
		            NodeList users = document.getChildNodes();
		            
		            for (int i = 0; i < users.getLength(); i++) {
		                Node user = users.item(i);
		                NodeList userInfo = user.getChildNodes();
		                
		                for (int j = 0; j < userInfo.getLength(); j++) {
		                    Node node = userInfo.item(j);
		                    NodeList userMeta = node.getChildNodes();
		                    
		                    for (int k = 0; k < userMeta.getLength(); k++) {
		                        if(userMeta.item(k).getNodeName() != "#text")
		                            System.out.println(userMeta.item(k).getNodeName()
		                                    + ":" + userMeta.item(k).getTextContent());
		                    }
		                    
		                    System.out.println();
		                }
		            }
		            
		        } catch (FileNotFoundException e) {
		            e.printStackTrace();
		        } catch (ParserConfigurationException e) {
		            e.printStackTrace();
		        } catch (SAXException e) {
		            e.printStackTrace();
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
		    }
		
     public static void main(String[] args) {
    	 
    	 new DomParseXmlDocument().parserXml("D:\\Workspaces\\projects\\testWeb\\src\\xml\\test\\user.xml");
		
	}

}
