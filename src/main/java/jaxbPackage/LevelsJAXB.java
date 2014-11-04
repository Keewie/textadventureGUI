package jaxbPackage;

import generated.jaxbPackage.Levels;
import generated.jaxbPackage.Levels.Level;
import generated.jaxbPackage.Levels.Level.AnswerNextLevelPairs.Pair;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXB;

import jaxbPackage.LevelsType.LevelType;


public class LevelsJAXB 
{

	
	public static List<model.Level> getLevels()
	{
		List<model.Level> levels = new ArrayList<model.Level>();
			
		LevelsType levelsType = JAXB.unmarshal(new File("levels.xml"), LevelsType.class);
			
		List<LevelType> levelTypeList = levelsType.getLevels();
			
		for(int i = 0; i < levelTypeList.size(); i++)
		{
			LevelType levelType = levelTypeList.get(i);
			model.Level level = new model.Level(levelType.getId(),
									levelType.getIntroTexts(), 
									levelType.getQuestion(),
									levelType.isEndLevel(), 
									null);   //autoType.getId()
			if(!level.isEndLevel()){
				for(int j = 0; j < levelType.getPairs().size(); j++)
				{
					jaxbPackage.LevelsType.LevelType.Pair pair = levelType.getPairs().get(j); 
					level.addAnswerAndNextLevelPair(pair.getAnswer(), pair.getNextLevelId());
				}
			
			}
							
			levels.add(level); 
		}
			
		return levels;
		
	}

	public static List<model.Level> getLevelsFromXSDGeneratedClasses() {
		List<model.Level> levels = new ArrayList<model.Level>();
			
		Levels levelsType = JAXB.unmarshal(new File("levels.xml"), Levels.class);
			
		List<Level> levelTypeList = levelsType.getLevel();
			
		for(int i = 0; i < levelTypeList.size(); i++)
		{
			Level levelType = levelTypeList.get(i);
			model.Level level = new model.Level((int) levelType.getId(),
									levelType.getIntroTexts().getIntroText(), 
									levelType.getQuestion(),
									Boolean.parseBoolean(levelType.getEndLevel()), 
									null);   //autoType.getId()
			if(!level.isEndLevel()){
				for(int j = 0; j < levelType.getAnswerNextLevelPairs().getPair().size(); j++)
				{
					Pair pair = levelType.getAnswerNextLevelPairs().getPair().get(j); 
					level.addAnswerAndNextLevelPair(pair.getAnswer(), pair.getNextLevelId());
				}
			
			}
							
			levels.add(level); 
		}
			
		return levels;
	}
}

