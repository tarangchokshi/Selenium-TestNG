package Models.BuildingUnit;

public class BuldingUnitAddManualModel {

	String Message1;
	String Street;
	String FullHouseNumber;
	String FullPostalCode;
	String PlaceName;
	String Description;
	public String getMessage1() {
		return Message1;
	}
	public void setMessage1(String message1) {
		Message1 = message1;
	}

	public String getStreet() {
		return Street;
	}
	public void setStreet(String street) {
		Street = street;
	}
	public String getFullHouseNumber() {
		return FullHouseNumber;
	}
	public void setFullHouseNumber(String fullHouseNumber) {
		FullHouseNumber = fullHouseNumber;
	}
	public String getFullPostalCode() {
		return FullPostalCode;
	}
	public void setFullPostalCode(String fullPostalCode) {
		FullPostalCode = fullPostalCode;
	}
	public String getPlaceName() {
		return PlaceName;
	}
	public void setPlaceName(String placeName) {
		PlaceName = placeName;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public  BuldingUnitAddManualModel()
	{
		setMessage1("Plaats is een verplicht veld");
		setStreet("Sir Winston Churchillln");
		setFullHouseNumber("1");
		setFullPostalCode("2288DC");
		setPlaceName("Rijswijk");
		setDescription("Manual Building Unit");		
	}
}
