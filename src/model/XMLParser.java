package model;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.xml.sax.ContentHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;


public class XMLParser {

	
	private List<Level> levels = new ArrayList<Level>();
	

	public List<Level> XMLParser() 
	{
		
		try 
		{
		XMLReader xmlReader = XMLReaderFactory.createXMLReader(); 
		
		FileReader reader = new FileReader("levels.xml.test"); 
		InputSource inputSource = new InputSource(reader); 
		
		xmlReader.setContentHandler((ContentHandler) new XMLParser()); 
		xmlReader.parse(inputSource); 
		
		} catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		
		} catch (IOException e) 
		{
			e.printStackTrace();
		
		} catch (SAXException e) 
		{
			e.printStackTrace();
		}
		
		return levels;
	}	
	
}
	