package Models.BuildingUnit;

public class BuildingUnitTanentModel {

	String CompanyName;
	String Phone;
	String Mobile;
	String ContactName;
	String ContactFunction;
	String Email;
	
	
	public String getCompanyName() {
		return CompanyName;
	}
	public void setCompanyName(String companyName) {
		CompanyName = companyName;
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
	public String getContactName() {
		return ContactName;
	}
	public void setContactName(String contactName) {
		ContactName = contactName;
	}
	public String getContactFunction() {
		return ContactFunction;
	}
	public void setContactFunction(String contactFunction) {
		ContactFunction = contactFunction;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	
	public BuildingUnitTanentModel()
	{
		setCompanyName("Building Unit Tenant Company name");
		setPhone("651951133");
		setMobile("105174133");
		setContactName("Building Unit Tenant Contact");
		setContactFunction("Building Unit Tenant Function");
		setEmail("testshanoe1@loekonline.onmicrosoft.com");
		
	}
	
	
	
	
	
	
}
