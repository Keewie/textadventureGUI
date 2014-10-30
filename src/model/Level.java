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
		this.imagePath = imgPath; 	// Das zum Level dazugeh�rige Lvl Bild 
	}

	
	public int getId() 
	{
		return id; // <-- gibt Id zur�ck 
	}

	public boolean isEndLevel() 
	{
		return endLevel; // <-- gibt die Endlevel boolean Abfrage zur�ck 
	}

	public List<String> getIntroTexts() 
	{
		return introTexts; // <-- gibt die Intro- GameTexte zur�ck 
	}

	public String getQuestion() 
	{
		return question; // <-- gibt Die Fragen zur�ck 
	}

	public List<String> getAnswers() 
	{
		return answers; // <-- gibt Antworten zur�ck (Bekommt die Antworten aus dem Antwort-ID-P�rchen) 
	}

	public List<Integer> getNextLevelIds() 
	{
		return nextLevelIds; // <-- gibt Id f�r n�chsten Level zur�ck (ArrayList) (Bekommt die IDs aus dem Antwort-ID-P�rchen) 
	}
	
	public String getImagePath() 
	{
		return imagePath;  // <-- gibt den Pfad des Pics zur�ck (Als String) 
	}

	
// Das "Antwort - ID - P�rchen"_______________________________________________________________________________________________________________________________
	
	public void addAnswerAndNextLevelPair(String answer, int nextLevelId) //Antwort-ID-P�rchen: (String = Antwort selbst) & (int = die n�chste Level ID) 
	{
		answers.add(answer); // Gibt Antworten an das Antwort-ID-P�rchen 
		nextLevelIds.add(nextLevelId); // Gibt die ID des n�chsten Lvls an das Antwort-ID-P�rchen 
	}	
}

 