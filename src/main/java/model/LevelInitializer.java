package model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class LevelInitializer 
{
	public static List<Level> init() throws IOException
	{
		List<Level> levels = new ArrayList<>();
		int levelIdCounter = 0;
		List<String> introTexts;
	
		
//Levels__________________________________________________________________________				
		
		//0_____________________________
		introTexts = new ArrayList<>();
		introTexts.add("Es ist 6 Uhr morgens.");
		introTexts.add("Dein Kater Charlie weckt dich durch einen gezielten Sprung ins Gesicht.");		
		levels.add(new Level(levelIdCounter++, introTexts, "Wie gehst du vor?", false, "Bilder Alltag/lvl charlie.gif"));
		
		
		//1_____________________________
		introTexts = new ArrayList<>();
		introTexts.add("Du richtest dich auf, göhnst noch ein mal kräftig, und öffnest die Augen.");
		introTexts.add("Du siehst die altbekannte Schwärze und beschliesst ins Bad zu schlendern.");
		introTexts.add("Nachdem du dort sturzfrei und unverletzt und deshalb schon recht zufrieden und für den Tag hoch motiviert angekommen bist, beschliesst du die Zähne zu putzen.");		
		levels.add(new Level(levelIdCounter++, introTexts, "Wie stellst du das an?", false, "Bilder Alltag/lvl2.gif"));
		
		//2_____________________________
		introTexts = new ArrayList<>();
		introTexts.add("Mit frischem Atem und sauberen Zähnen machst du dich auf den Weg in die Küche.");
		introTexts.add("Dort beschliesst du dir einen Kaffee zu machen, weil du voll Lust auf Kaffee hast und kein Nasenbluten davon bekommst.");	
		levels.add(new Level(levelIdCounter++, introTexts, "Was möchtest du jetzt tun?", false, "Bilder Alltag/lvl3.gif"));
		
		//3_____________________________
		introTexts = new ArrayList<>();
		introTexts.add("Der Kaffee ist so stark, dass du für den Rest des Tages wieder sehen kannst!!!");
		introTexts.add("Cool oder??");
		introTexts.add("Du hast scheinbar ein Mittel gegen Blindheit gefunden!");
		introTexts.add("Gratulation!");
		introTexts.add("Nebenbei hast du auch noch das Spiel gewonnen! Glanzleistung!!! ");
		introTexts.add("-> hier bitte Happy End einfägen <-");
		levels.add(new Level(levelIdCounter++, introTexts, null, true, "Bilder Alltag/lvl 4.jpg"));
		

		
//Answers_________________________________________________________________________		
		
		//0_____________________________
		levels.get(0).addAnswerAndNextLevelPair("Du packst die Nervensäge, wirfst sie in die Richtung, in der du sein Katzenkörbchen vermutest und versuchst noch 24 kurze Stündchen weiter zu schlafen.", -1);
		levels.get(0).addAnswerAndNextLevelPair("Du schiebst seine 7 Kilo liebevoll von deinem schmerzenden Gesicht und beschließt aufzustehen.", 1);
		levels.get(0).addAnswerAndNextLevelPair("Du packst Charlie mit unter die Bettdecke und knuddelst ihn gegen seinen Willen, da er so dick ist kann er sich sowieso nicht wehren. ", -1);
		levels.get(0).addAnswerAndNextLevelPair("Aus Wut über die unsanfte Weckaktion willst du Charlie eins auswischen und futterst sein Katzenfutter direkt vor seinen traurigen, großen Kulleraugen! (Echt fies! Und extrem eklig... oO)", -1);
		
		//1_____________________________
		levels.get(1).addAnswerAndNextLevelPair("Du schreist Charlie an, dass er dir gefälligst deine Zahnbürste bringen soll. Nachdem du seltsamerweise ignoriert wurdest, setzt du dich eingeschnappt im Flur auf den Boden, kneifst die Augen zusammen und schmollst, warum auch immer...", -1);
		levels.get(1).addAnswerAndNextLevelPair("Du tastest das Waschbecken stundenlang bis spät abends ab und gehst genervt wieder ins Bett wo du zufällig eine Packung Kaugummis findest auf der du herumkaust, bis du einpennst. ", -1);
		levels.get(1).addAnswerAndNextLevelPair("Du tastest nach dem an der Wand befestigten Becherhalter und nimmst die Zahnbürste und die Zahnpasta-Tube aus dem Becher und schrubbst dir die Kauleiste bis sie glaenzt und blinkt..", 2);
		
		//2_____________________________
		levels.get(2).addAnswerAndNextLevelPair("Du schnappst dir ne Packung Kaugummis und überlegst, wie du das Problem angehen könntest", -1);
		levels.get(2).addAnswerAndNextLevelPair("Du gibst nach einigen Tastversuchen total genervt auf und beschliesst dir 4 Mentol-PIzzen für's Frustfressen zu bestellen und ne neue Zahnbürste für danach.", -1);
		levels.get(2).addAnswerAndNextLevelPair("Du erinnerst dich, dass die Kaffeemaschine am rechten Ende der Arbeitsplatte steht und schaltest sie ein, weil du gestern schon alles vorbereitet hast..", 3);
		levels.get(2).addAnswerAndNextLevelPair("Du schmeisst dich auf den Boden und rollst dich schreiend und Kaugummi kauend im Flur hin und her bis dir jemand Kaffee bringt (Das könnte dauern)...", -1);

		
		
		return levels;
	}
}

