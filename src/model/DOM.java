package model;

import java.io.File; 
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


public class DOM 
{
	
	private List<Level> levels = new ArrayList<Level>();
	
	public List<Level> dom() throws SAXException, IOException, ParserConfigurationException 
	{
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance(); // <- neue Instanz erzeugen von DocumentBuilderFactory
		DocumentBuilder builder = factory.newDocumentBuilder(); // <-  DocumentBuilder erzeugen 
		Document document = builder.parse(new File ("levels.xml")); // <- Pfad des Xmls  
		
		Element root = document.getDocumentElement(); // Wurzelelement holen "Levels"
		NodeList levelNodes = root.getElementsByTagName("Level"); // Level holen aus "Levels" 
		
		if(levelNodes != null && levelNodes.getLength() > 0) // Prüfen ob levelNodes Elemente hat 
		{
			for(int i = 0; i < levelNodes.getLength(); i++) 
			{
				
					
				int id; 
				boolean endLevel; 
				List<String> introTexts = new ArrayList<String>(); 
				String question = null;	
				List<String> answers = new ArrayList<String>(); 
				List<Integer> nextLevelIds = new ArrayList<Integer>(); 
				
				
//______________ID und endLvl vom Level________________________________________________________________
				Element levelElement = (Element) levelNodes.item(i);
				id = Integer.parseInt(levelElement.getAttribute("id"));
				endLevel = Boolean.getBoolean(levelElement.getAttribute("endLevel")); 
			//	System.out.println("Level ID: " + id); 
			//	System.out.println("is endLevel: " + endLevel);
				
				
//______________introTxt_______________________________________________________________________________				
				NodeList introNodes = levelElement.getElementsByTagName("IntroText");
				if(introNodes != null && introNodes.getLength() > 0) 
				{
					for(int j = 0; j < introNodes.getLength(); j++) 
					{
						Element introElement = (Element) introNodes.item(j); 
						introTexts.add(introElement.getFirstChild().getNodeValue());
					//	System.out.println("IntroText " + (j+1) + ": " + introElement.getFirstChild().getNodeValue());
					}
				}
				
//______________Question______________________________________________________________________________				
				NodeList questNodes = levelElement.getElementsByTagName("Question");
				if(questNodes != null && questNodes.getLength() > 0) 
				{
					question = questNodes.item(0).getFirstChild().getNodeValue();
					//	System.out.println("Question: " + question);
				}
				
				
//______________Answers_______________________________________________________________________________			
				NodeList answerNodes = levelElement.getElementsByTagName("Answer");
				if(answerNodes != null && answerNodes.getLength() > 0) 
				{
					for(int j = 0; j < answerNodes.getLength(); j++) 
					{
						Element answerElement = (Element) answerNodes.item(j); 
						answers.add(answerElement.getFirstChild().getNodeValue());
					//	System.out.println("Answer " + (j+1) + ": " + answerElement.getFirstChild().getNodeValue());
					}
				}
				
//______________NextLvlId______________________________________________________________________________				
				NodeList idNodes = levelElement.getElementsByTagName("NextLevelId");
				if(idNodes != null && idNodes.getLength() > 0) 
				{
					for(int j = 0; j < idNodes.getLength(); j++) 
					{
						Element idElement = (Element) idNodes.item(j); 
						nextLevelIds.add(Integer.parseInt(idElement.getFirstChild().getNodeValue()));
					//	System.out.println("NextLevelId" + (j+1) + ": " + idElement.getFirstChild().getNodeValue());
					}
				}
				
				
				//Zusammenfügen des Levels____________________________________________
				Level level = new Level(id, introTexts, question, endLevel, null);
				if(!endLevel) // Prüfen ob KEIN EndLvl
				{
					for(int j = 0; j < answers.size(); j++)
					{
						level.addAnswerAndNextLevelPair(answers.get(j), nextLevelIds.get(j)); // hier Paarweise dem Lvl hinzufügen (je nachdem wie viele Antworten) 
					}
				}
				
				levels.add(level); //level zur Levelliste hinzufügen
				
		
			}
		}
		
		return levels; // <-- Gibt Liste der Levels zurück 
		
	}
	
	
	public static void main(String[] args) 
	{
		try 
		{
			new DOM().dom();
		} catch(Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	
}


