package jaxbPackage;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXB;
import javax.xml.bind.annotation.XmlAttribute;

import jaxbPackage.LevelsType.LevelType;
import jaxbPackage.LevelsType.LevelType.Pair;
import model.Level;



public class LevelsJAXB 
{

	
	public static List<Level> getLevels()
	{
		List<Level> levels = new ArrayList<Level>();
			
		LevelsType levelsType = JAXB.unmarshal(new File("levels.xml"), LevelsType.class);
			
		List<LevelType> levelTypeList = levelsType.getLevels();
			
		for(int i = 0; i < levelTypeList.size(); i++)
		{
			LevelType levelType = levelTypeList.get(i);
			Level level = new Level(levelType.getId(),
									levelType.getIntroTexts(), 
									levelType.getQuestion(),
									levelType.isEndLevel(), 
									null);   //autoType.getId()
			if(!level.isEndLevel()){
				for(int j = 0; j < levelType.getPairs().size(); j++)
				{
					Pair pair = levelType.getPairs().get(j); 
					level.addAnswerAndNextLevelPair(pair.getAnswer(), pair.getNextLevelId());
				}
			
			}
							
			levels.add(level); 
		}
			
		return levels;
		
	}
}

