package autosbeispiel.model.jaxb;


import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "autos")
public class AutosType {
	@XmlElement(name = "auto")
	List<AutoType> autos;
	
	public List<AutoType> getAutos() {
		return autos;
	}
	
	public void setAutos(List<AutoType> autos) {
		this.autos = autos;
	}

	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "auto", propOrder = { "marke", "farbe", "ps" })
	public static class AutoType {

		@XmlAttribute
		int id;
		String marke; 	
		String farbe; 
		int ps; 
		
		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}
		

	//__Marke_______________________________________
		public String getMarke() 
		{
			  return marke;
		}

		public void setMarke(String marke) 
		{
			 this.marke = marke;
		}
		
		
	//__Farbe_______________________________________
		public String getFarbe() 
		{
			  return farbe;
		}

		public void setFarbe(String farbe) 
		{
			 this.farbe = farbe;
		}

		
	//__Farbe_______________________________________
		public int getPs() 
		{
			  return ps;
		}

		public void setPs(int ps) 
		{
			 this.ps = ps;
		}
	} 
} 
	

