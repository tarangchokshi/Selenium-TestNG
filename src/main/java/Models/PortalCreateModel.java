package Models;

public class PortalCreateModel {
	
	String Name;
	String Logo;
	String PrimaryColor;
	String BackColor;
	String Url;
	String EmergencyPhone;
	String CompanyName;
	String AddressStreet;
	String AddressHouseNumber;
	String AddressPostalCode;
	String AddressCity;
	String ContactDetailPhone;
	String ContactDetailEmail;
	
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getLogo() {
		return Logo;
	}
	public void setLogo(String logo) {
		Logo = logo;
	}
	public String getPrimaryColor() {
		return PrimaryColor;
	}
	public void setPrimaryColor(String primaryColor) {
		PrimaryColor = primaryColor;
	}
	public String getBackColor() {
		return BackColor;
	}
	public void setBackColor(String backColor) {
		BackColor = backColor;
	}
	public String getUrl() {
		return Url;
	}
	public void setUrl(String url) {
		Url = url;
	}
	public String getEmergencyPhone() {
		return EmergencyPhone;
	}
	public void setEmergencyPhone(String emergencyPhone) {
		EmergencyPhone = emergencyPhone;
	}
	public String getCompanyName() {
		return CompanyName;
	}
	public void setCompanyName(String companyName) {
		CompanyName = companyName;
	}
	
	public String getAddressStreet() {
		return AddressStreet;
	}
	public void setAddressStreet(String addressStreet) {
		AddressStreet = addressStreet;
	}
	public String getAddressPostalCode() {
		return AddressPostalCode;
	}
	public void setAddressPostalCode(String addressPostalCode) {
		AddressPostalCode = addressPostalCode;
	}
	public String getAddressHouseNumber() {
		return AddressHouseNumber;
	}
	public void setAddressHouseNumber(String addressHouseNumber) {
		AddressHouseNumber = addressHouseNumber;
	}
	public String getAddressCity() {
		return AddressCity;
	}
	public void setAddressCity(String addressCity) {
		AddressCity = addressCity;
	}
	public String getContactDetailPhone() {
		return ContactDetailPhone;
	}
	public void setContactDetailPhone(String contactDetailPhone) {
		ContactDetailPhone = contactDetailPhone;
	}
	
	public String getContactDetailEmail() {
		return ContactDetailEmail;
	}
	public void setContactDetailEmail(String contactDetailEmail) {
		ContactDetailEmail = contactDetailEmail;
	}
	public PortalCreateModel()
	{
		setName("Loek SP Buildingunit");
		setLogo("\\src\\main\\java\\Resources\\Building.jpg");
		setPrimaryColor("#F28A35");
		setBackColor("#0A0808");
		setUrl("loekautomationbu");
		setEmergencyPhone("105172222");
		setCompanyName("SP Building Company");
		setAddressStreet("SIR WINSTON CHURCHILLLN");
		setAddressPostalCode("228ABC");
		setAddressHouseNumber("299");
		setAddressCity("'s-Gravenhage");
		setContactDetailPhone("105172222");
		setContactDetailEmail("testshanoe1@loekonline.onmicrosoft.com");
	}
}