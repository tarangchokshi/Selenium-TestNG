package Models.Building;

public class BuildingInvoiceAddressModel {

	String CompanyName;
	String Department;
	String StreetName;
	String City;
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
	
	public String getStreetName() {
		return StreetName;
	}
	public void setStreetName(String streetName) {
		StreetName = streetName;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public String getNote() {
		return Note;
	}
	public void setNote(String note) {
		Note = note;
	}
	public BuildingInvoiceAddressModel()
	{
		
		setCompanyName("Building Invoice address Company name");
		setDepartment("Building Invoice address Department");
		setStreetName("Binckhorstlaan");
		setCity("'s-Gravenhage");
		setNote("Invoice address data for Building");
	}

	
}
