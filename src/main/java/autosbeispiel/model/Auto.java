package autosbeispiel.model;

public class Auto {
	
	int id;
	String marke; 
	String farbe; 
	int ps; 
	
	Auto(int id, String marke, String farbe, int ps)
	{
		this.id = id;
		this.marke = marke; 
		this.ps = ps;
		this.farbe = farbe;
	}
	

	public void setId(int id) {
		this.id = id;
	}

	public void setMarke(String marke) {
		this.marke = marke; 
	}

	public void setFarbe(String farbe) {
		this.farbe = farbe; 
	}

	public void setPs(int ps) { 
		this.ps = ps;
	}


	@Override
	public String toString() {
		return "Auto [id=" + id + ", marke=" + marke + ", farbe=" + farbe
				+ ", ps=" + ps + "]";
	}
	
	
}


