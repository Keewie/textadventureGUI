package jaxbPackage;

import java.util.List;

import model.Level;


public class JaxbTest 
{


		public static void main(String[] args)  
		{
			List<Level> levelList = LevelsJAXB.getLevels();
			System.out.println(levelList.size());
			for( int i = 0; i < levelList.size(); i++)
			{
				System.out.println(levelList.get(i));
			}
		}
} 

