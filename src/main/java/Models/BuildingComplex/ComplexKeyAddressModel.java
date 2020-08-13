package Models.BuildingComplex;

public class ComplexKeyAddressModel {

	String CompanyName;
	String PostalCode;
	String HouseNumber;
	String ContactPerson;
	String Note;
	
	public String getCompanyName() {
		return CompanyName;
	}
	public void setCompanyName(String companyName) {
		CompanyName = companyName;
	}
	public String getPostalCode() {
		return PostalCode;
	}
	public void setPostalCode(String postalCode) {
		PostalCode = postalCode;
	}
	public String getHouseNumber() {
		return HouseNumber;
	}
	public void setHouseNumber(String houseNumber) {
		HouseNumber = houseNumber;
	}
	public String getContactPerson() {
		return ContactPerson;
	}
	public void setContactPerson(String contactPerson) {
		ContactPerson = contactPerson;
	}
	public String getNote() {
		return Note;
	}
	public void setNote(String note) {
		Note = note;
	}
	public ComplexKeyAddressModel()
	{
		setPostalCode("2496XD");
		setCompanyName("Complex Key address Company name");
		setHouseNumber("5");
		setContactPerson("Complex Key address Contact");
		setNote("Key address data for Complex");
	}
	
}
