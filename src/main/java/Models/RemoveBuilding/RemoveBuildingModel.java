package Models.RemoveBuilding; 

public class RemoveBuildingModel {
	String Postalcode;
	String HouseNumber;
	String Complaxname;
	String ComplexDelete;
	String Buildingunitdelete;
	String BuildingDelete;
	String BuildingExistsInOtherModule;

	public String getPostalcode() {

		return Postalcode;
	}
	public String getBuildingExistsInOtherModule() {
		return BuildingExistsInOtherModule;
	}
	public void setBuildingExistsInOtherModule(String buildingExistsInOtherModule) {
		BuildingExistsInOtherModule = buildingExistsInOtherModule;
	}
	public void setPostalcode(String postalcode) {
		Postalcode = postalcode;
	}
	public String getHouseNumber() {

		return HouseNumber;
	}
	public void setHouseNumber(String houseNumber) {
		HouseNumber = houseNumber;
	}
	public String getComplaxname() {

		return Complaxname;
	}
	public void setComplaxname(String complaxname) {
		Complaxname = complaxname;
	}
	public String getComplexDelete() {

		return ComplexDelete;
	}
	public void setComplexDelete(String complexDelete) {
		ComplexDelete = complexDelete;
	}

	public String getBuildingunitdelete() {

		return Buildingunitdelete;
	}
	public void setBuildingunitdelete(String buildingunitdelete) {
		Buildingunitdelete = buildingunitdelete;
	}
	public String getBuildingDelete() {

		return BuildingDelete;
	}
	public void setBuildingDelete(String buildingDelete) {
		BuildingDelete = buildingDelete;
	}

	public RemoveBuildingModel()
	{
		setPostalcode("3067MH");
		setHouseNumber("5");
		setComplaxname("Remove Function");
		setComplexDelete("Complex toegevoegd");
		setBuildingunitdelete("Verblijfsobject verwijderd");
		setBuildingDelete("Gebouw verwijderd");
		setBuildingExistsInOtherModule("Dit gebouw kan niet verwijderd worden omdat het gekoppeld is aan een Melding of Relatie of Service Portaal");
	}
}