package Models.BuildingComplex;

public class ComplexContactModel {

	String Message1;
	String CompanyName;
	String PostalCode;
	String HouseNumber;
	String ContactPerson;
	String ContactPhone;
	String MobilePhone;
	String Email;
	String Note;
	
	public String getMessage1() {
		return Message1;
	}
	public void setMessage1(String message1) {
		Message1 = message1;
	}
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
	public String getContactPhone() {
		return ContactPhone;
	}
	public void setContactPhone(String contactPhone) {
		ContactPhone = contactPhone;
	}
	public String getMobilePhone() {
		return MobilePhone;
	}
	public void setMobilePhone(String mobilePhone) {
		MobilePhone = mobilePhone;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getNote() {
		return Note;
	}
	public void setNote(String note) {
		Note = note;
	}
	public ComplexContactModel()
	{
		setMessage1("Bedrijfsnaam is een verplicht veld");
		setCompanyName("Complex Contact Company name");
		setPostalCode("3035AS");
		setHouseNumber("2");
		setContactPerson("Complex Contact");
		setContactPhone("651951112");
		setMobilePhone("105174112");
		setEmail("testshanoe1@loekonline.onmicrosoft.com");
		setNote("Contact data for Complex");
	}
	
	
}
