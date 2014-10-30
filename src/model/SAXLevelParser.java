package model;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import model.Level;

public class SAXLevelParser extends DefaultHandler
{

	private List<Level> levels = new ArrayList<Level>(); // Die jeweiligen Level 
	private Level tempLevel; // Die derzeitigen Level 
	private int id; // Die jeweilige ID
	private List<String> introTexts;  // Die IntroTexte (GameTexts) 
	private String question; // Die Fragen im Spiel 
	private boolean endLevel; // Abfrage nach dach dem EndLvl (ob es das EndLvl ist) 
	private String imgPath; //Der Pic - Pfad 
	private String answer; // Die möglichen Antworten im Spiel 
	private int nextLevelId; // Die Id des nächsten Lvls (Teil des Lvl-ID-Pärchens) 
	private String tempValue; // Der derzeitige Wert 

	public List<Level> parse(File file) 
	{
		SAXParserFactory spf = SAXParserFactory.newInstance();

		
//__________________________________________________________________________		
		try {

			SAXParser sp = spf.newSAXParser();
			sp.parse(file, this);

		} catch (SAXException se) 
		{
			se.printStackTrace();
		} catch (ParserConfigurationException pce) 
		{
			pce.printStackTrace();
		} catch (IOException ie) 
		{
			ie.printStackTrace();
		}

		return levels;
	}
//___________________________________________________________________________
	
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException 
	{

		if (qName.equalsIgnoreCase("Level")) 
		{
			id = Integer.parseInt(attributes.getValue("id"));
			endLevel = Boolean.parseBoolean(attributes.getValue("endLevel"));
			introTexts = new ArrayList<String>();
			question = null;
			imgPath = null;
			System.out.println("Level: ID = " + id + " / endLevel = "
					+ endLevel);
		}
	}

	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException 
	{
		tempValue = new String(ch, start, length);
	}

	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException 
	{

		if (qName.equalsIgnoreCase("IntroText")) 
		{
			introTexts.add(tempValue);
			System.out.println("IntroText" + introTexts.size() + " = "
					+ tempValue);
		}

		if (qName.equalsIgnoreCase("Question")) 
		{
			question = tempValue;
			tempLevel = new Level(id, introTexts, question, endLevel, imgPath);
			System.out.println("Question" + " = " + tempValue);
		}

		if (qName.equalsIgnoreCase("Answer")) 
		{
			answer = tempValue;
			System.out.println("Answer" + " = " + tempValue);
		}

		if (qName.equalsIgnoreCase("NextLevelId")) 
		{
			nextLevelId = Integer.parseInt(tempValue);
			tempLevel.addAnswerAndNextLevelPair(answer, nextLevelId);
			System.out.println("NextLevelId" + " = " + tempValue);
		}

		if (qName.equalsIgnoreCase("Level")) 
		{
			levels.add(tempLevel);
			System.out.println();
		}
	}

}

