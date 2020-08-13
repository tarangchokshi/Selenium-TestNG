package Models.Building;

public class BuildingAddModel {

	String Title;
	String Postalcode;
	String Housenumber;
	
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getPostalcode() {
		return Postalcode;
	}
	public void setPostalcode(String postalcode) {
		Postalcode = postalcode;
	}
	public String getHousenumber() {
		return Housenumber;
	}
	public void setHousenumber(String housenumber) {
		Housenumber = housenumber;
	}
	
	public BuildingAddModel()
	{
		setTitle("Gebouw toevoegen | LOEK!");
		setPostalcode("2288DC");
		setHousenumber("299");
	}
}
