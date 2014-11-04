package jaxbPackage;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


	
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "levels")
public class LevelsType 
{
	
	@XmlElement(name = "Level")
	List<LevelType> levels = new ArrayList<LevelType>(); // Die jeweiligen Level 
		
	
	public List<LevelType> getLevels() 
	{
		  return levels;
	}

	public void setLevels(List<LevelType> levels) 
	{
		 this.levels = levels;
	}
	

	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "LevelType", propOrder = 
	{ "introTexts", "question", "pairs"})
	public static class LevelType 
	{

		@XmlAttribute
		int id; // Die jeweilige ID
		@XmlAttribute
		boolean endLevel; // Abfrage nach dach dem EndLvl (ob es das EndLvl ist) 
		

		@XmlElementWrapper(name = "IntroTexts")
		@XmlElement(name = "IntroText")
		List<String> introTexts;  // Die IntroTexte (GameTexts) 
		
		@XmlElement(name = "Question")
		String question; // Die Fragen im Spiel 	

		@XmlElementWrapper(name = "AnswerNextLevelPairs")
		@XmlElement(name = "Pair")
		List<Pair> pairs; 
		
		
		public int getId() {
			return id;
		}
		
		public void setId(int id) {
			this.id = id;
		}
		
		public boolean isEndLevel() {
			return endLevel;
		}
		
		public void setEndLevel(boolean endLevel) {
			this.endLevel = endLevel;
		}
		public List<String> getIntroTexts() {
			return introTexts;
		}
		
		public void setIntroTexts(List<String> introTexts) {
			this.introTexts = introTexts;
		}
		
		public String getQuestion() 
		{
			return question;
		}
		public void setQuestion(String question) 
		{
			this.question = question;
		}
		
		public List<Pair> getPairs() {
			return pairs;
		}

		public void setPairs(List<Pair> pairs) {
			this.pairs = pairs;
		}
		

		@XmlAccessorType(XmlAccessType.FIELD)
		@XmlType(name = "Pair", propOrder = 
		{ "answer", "nextLevelId"})		
		public static class Pair
		{

			@XmlElement(name = "Answer")
			String answer; 
			@XmlElement(name = "NextLevelId")
			int nextLevelId;
			
			public String getAnswer() {
				return answer;
			}
			public void setAnswer(String answer) {
				this.answer = answer;
			}
			public int getNextLevelId() {
				return nextLevelId;
			}
			public void setNextLevelId(int nextLevelId) {
				this.nextLevelId = nextLevelId;
			} 
			
		}
		
		
	} 
	
	
} 
		


