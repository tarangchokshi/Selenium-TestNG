package Models.BuildingComplex;

public class ComplexInvoiceAddressModel {

	String CompanyName;
	String Department;
	String PostalCode;
	String HouseNumber;
	String Email;
	String TaxNumber;
	String Note;
	
	public String getCompanyName() {
		return CompanyName;
	}
	public void setCompanyName(String companyName) {
		CompanyName = companyName;
	}
	public String getDepartment() {
		return Department;
	}
	public void setDepartment(String department) {
		Department = department;
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
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getTaxNumber() {
		return TaxNumber;
	}
	public void setTaxNumber(String taxNumber) {
		TaxNumber = taxNumber;
	}
	public String getNote() {
		return Note;
	}
	public void setNote(String note) {
		Note = note;
	}
	public ComplexInvoiceAddressModel()
	{
		setCompanyName("Complex Invoice address Company name");
		setDepartment("Complex Invoice address Department");
		setPostalCode("2497NX");
		setHouseNumber("223A");
		setEmail("testshanoe1@loekonline.onmicrosoft.com");
		setTaxNumber("123456789B01");
		setNote("Invoice address data for Complex");	
	}
	
}
