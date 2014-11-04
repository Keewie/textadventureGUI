package autosbeispiel.model;

import java.util.List;

public class AutoTest {

	public static void main(String[] args)  
	{
		List<Auto> autoList = AutosJAXB.getAutos();
		for( int i = 0; i < autoList.size(); i++)
		{
			System.out.println(autoList.get(i));
		}
	}
} 

