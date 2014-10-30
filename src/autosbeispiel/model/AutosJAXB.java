package autosbeispiel.model;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXB;

import autosbeispiel.model.jaxb.AutosType;
import autosbeispiel.model.jaxb.AutosType.AutoType;


public class AutosJAXB 
{
	public static List<Auto> getAutos()
	{
		List<Auto> autos = new ArrayList<Auto>();
		
		AutosType autosType = JAXB.unmarshal(new File("auto.xml"), AutosType.class);
		
		List<AutoType> autoTypeList = autosType.getAutos();
		
		for(int i = 0; i < autoTypeList.size(); i++)
		{
			AutoType autoType = autoTypeList.get(i);
			Auto auto = new Auto(autoType.getId(), autoType.getMarke(), autoType.getFarbe(), autoType.getPs());
			autos.add(auto); 
		}
		
		return autos;
	}
}
