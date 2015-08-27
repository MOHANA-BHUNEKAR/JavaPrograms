import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


public class SAXExample extends DefaultHandler{

	Person obj;
	String data;
	public   List<Person> plist = new ArrayList<>();

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {

		
		SAXExample ex = new SAXExample();
		ex.parseXml();
		
		   ex.printPersonObjects();

	}

	private  void printPersonObjects() {

		
		for( Person person : plist)
		{
			
			System.out.println(" Pid: "+person.getId());
			System.out.println(" Pname: "+ person.getName());
			System.out.println(" Page: "+ person.getAge());
			System.out.println();
		}
	}

	private   void parseXml() throws ParserConfigurationException, SAXException, IOException {
    SAXParserFactory fac = SAXParserFactory.newInstance();
    SAXParser parser = fac.newSAXParser();
    
    parser.parse("Person.xml",this);
    
		
		
	}

	public void startElement(String wc,String localname,String qname, Attributes attributes)
	{
		
		if(qname.equals("person"))
		{
			
			obj = new Person();
			obj.setId(Integer.parseInt((attributes.getValue("id"))));
		}
		
	}
	
	
	public void characters(char[] ch,int start, int length)
	{
		
		data = new String(ch,start,length);
	}
	
	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {

		
		if(qName.equals("name"))
		{
			obj.setName(data);
			
		}
		
		else if(qName.equals("age"))
		{
			
			obj.setAge(Integer.parseInt(data));
		}
		
		else if(qName.equals("person"))
		{
		plist.add(obj)	;
			
		}
	
	}
}
