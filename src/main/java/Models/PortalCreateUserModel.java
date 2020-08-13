package Models;

public class PortalCreateUserModel {

	String Searchtextbox;
	String EmailAddress;
	String CompanyName;
	String Contact;
	String Password;
	String Phone;
	String Mobile;
	
	public String getSearchtextbox() {
		return Searchtextbox;
	}
	public void setSearchtextbox(String searchtextbox) {
		Searchtextbox = searchtextbox;
	}
	
	public String getEmailAddress() {
		return EmailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		EmailAddress = emailAddress;
	}
	
	public String getCompanyName() {
		return CompanyName;
	}
	public void setCompanyName(String companyName) {
		CompanyName = companyName;
	}
	
	public String getContact() {
		return Contact;
	}
	public void setContact(String contact) {
		Contact = contact;
	}
	
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
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
	
	public PortalCreateUserModel()
	{
		setSearchtextbox("Regression Test");
		setEmailAddress("tar.a.ngcho.kshiqa@gmail.com");
		setCompanyName("SPUserCompany");
		setContact("SPUserContact");
		setPassword("qwerty");	
		setPhone("1234567890");
		setMobile("9876543210");
	}
}