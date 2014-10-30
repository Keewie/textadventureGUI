package model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.Icon;

public class Level 
{
	
	private int id;
	private boolean endLevel;
	private List<String> introTexts = new ArrayList<>();
	private String question;
	private String imagePath; 
	private List<String> answers = new ArrayList<>();
	private List<Integer> nextLevelIds = new ArrayList<>();

	
//Das Level!__________________________________________________________________________________________________________ 
	public Level(int id, List<String> introTexts, String question, boolean endLevel, String imgPath) 
	{
		this.id = id; // Die ID des Levels (als Int) 
		this.introTexts = introTexts;	// IntroTxts! (Als String List) 
		this.question = question;	// Die Fragen
		this.endLevel = endLevel;	// boolean Abfrage ob Endlvl 
		this.imagePath = imgPath; 	// Das zum Level dazugehörige Lvl Bild 
	}

	
	public int getId() 
	{
		return id; // <-- gibt Id zurück 
	}

	public boolean isEndLevel() 
	{
		return endLevel; // <-- gibt die Endlevel boolean Abfrage zurück 
	}

	public List<String> getIntroTexts() 
	{
		return introTexts; // <-- gibt die Intro- GameTexte zurück 
	}

	public String getQuestion() 
	{
		return question; // <-- gibt Die Fragen zurück 
	}

	public List<String> getAnswers() 
	{
		return answers; // <-- gibt Antworten zurück (Bekommt die Antworten aus dem Antwort-ID-Pärchen) 
	}

	public List<Integer> getNextLevelIds() 
	{
		return nextLevelIds; // <-- gibt Id für nächsten Level zurück (ArrayList) (Bekommt die IDs aus dem Antwort-ID-Pärchen) 
	}
	
	public String getImagePath() 
	{
		return imagePath;  // <-- gibt den Pfad des Pics zurück (Als String) 
	}

	
// Das "Antwort - ID - Pärchen"_______________________________________________________________________________________________________________________________
	
	public void addAnswerAndNextLevelPair(String answer, int nextLevelId) //Antwort-ID-Pärchen: (String = Antwort selbst) & (int = die nächste Level ID) 
	{
		answers.add(answer); // Gibt Antworten an das Antwort-ID-Pärchen 
		nextLevelIds.add(nextLevelId); // Gibt die ID des nächsten Lvls an das Antwort-ID-Pärchen 
	}	
}

 