package Models.BuildingUnit;

public class BuildingUnitRoomModel {

	
	String ErrorMessage;
	String Description;
	String Number;
	String Area;
	String Orientation;
	public String getErrorMessage() {
		return ErrorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		ErrorMessage = errorMessage;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	
	public String getNumber() {
		return Number;
	}
	public void setNumber(String number) {
		Number = number;
	}
	public String getArea() {
		return Area;
	}
	public void setArea(String area) {
		Area = area;
	}
	public String getOrientation() {
		return Orientation;
	}
	public void setOrientation(String orientation) {
		Orientation = orientation;
	}
	public BuildingUnitRoomModel()
	{
		setErrorMessage("Omschrijving is een verplicht veld");
		setDescription("Extra Kamer");
		setNumber("1BU");
		setArea("3");
		setOrientation("Zuiden");
	}
	
}
