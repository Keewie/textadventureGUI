//XML - Experiment!

package model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;


public class XmlLevelInitializer 
{
	public static List<Level> init() throws IOException
	{
		List<Level> levels = null;
		DOM dom = new DOM();
		
		try 
		{
			levels = dom.dom();
		} catch (SAXException e) 
		{
			e.printStackTrace();
		} catch (ParserConfigurationException e) 
		{
			e.printStackTrace();
		}
	
		
		return levels;
	}
	
}

