package Models.BuildingUnit;

public class BuildingUnitKeyAddressModel {

	String CompanyName;
	String PostalCode;
	String HouseNumber;
	String Address;
	String Place;
	String ContactPerson;
	String Phone;
	String Mobile;
	String Email;
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
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getPlace() {
		return Place;
	}
	public void setPlace(String place) {
		Place = place;
	}
	public String getContactPerson() {
		return ContactPerson;
	}
	public void setContactPerson(String contactPerson) {
		ContactPerson = contactPerson;
	}
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String phone) {
		Phone = phone;
	}
	public String getMobile() {
		return Mobile;
	}
	public void setMobile(String mobile) {
		Mobile = mobile;
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
	
	public BuildingUnitKeyAddressModel()
	{
		setCompanyName("Building Unit Key address Company name");
		setPostalCode("2571PV");
		setHouseNumber("87");
		setAddress("Uitenhagestraat�");
		setPlace("'s-Gravenhage");
		
		setContactPerson("Building Unit Key address Contact");
		setPhone("651952223");
		setMobile("105172223");
		setEmail("testshanoe1@loekonline.onmicrosoft.com");
		setNote("Key address data for Building Unit");
	}
}
