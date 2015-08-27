import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class DomExample {

	public static Document doc;
	public static List<Person> plist = new ArrayList<>();
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {

		parseXml();
		parseDocument();
		printPersonObjects();
		
	}
	
	private static void printPersonObjects() {

		
		for( Person person : plist)
		{
			
			System.out.println(" Pid: "+person.getId());
			System.out.println(" Pname: "+ person.getName());
			System.out.println(" Page: "+ person.getAge());
			System.out.println();
		}
	}

	private static void parseXml() throws ParserConfigurationException, SAXException, IOException
	{
		   
		DocumentBuilderFactory fac= DocumentBuilderFactory.newInstance();
	DocumentBuilder dom= fac.newDocumentBuilder();
	
	 doc = dom.parse("Person.xml");
		
	}

	private static void parseDocument()
	{
		
		
		    Element rootel   = doc.getDocumentElement();
		    
		         NodeList personodes=  rootel.getElementsByTagName("person");
		         
		         for(int i=0;i< personodes.getLength();i++)
		         {
		        	 
		        	 Person obj = new Person();
		        	      Element person =  (Element) personodes.item(i);
		        	      
		        	     int id= Integer.parseInt(person.getAttribute("id"));
		        	     obj.setId(id);   
		        	     
		        	            Element el= (Element) person.getElementsByTagName("name").item(0);
		        	          	obj.setName(el.getFirstChild().getNodeValue());	
		        	          	
		        	          	 Element agee= (Element) person.getElementsByTagName("age").item(0);
			        	          	obj.setAge(Integer.parseInt(agee.getFirstChild().getNodeValue()));
			        	          	
			        	          	plist.add(obj);
		        	              }
		         
		        
	}
}
