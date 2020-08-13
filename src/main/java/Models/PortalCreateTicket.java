package Models;

public class PortalCreateTicket {

	String Email;
	String Password;
	String Uploadimage;
	String Importimage;
	String LocationDescription;
	String Subject;
	String Description;
	String StreetName;
	String PostalCode;
	String Place;
	String Address;
	String Appointment;
	String Company;
	String Country;
	
	public String getCountry() {
		return Country;
	}
	public void setCountry(String country) {
		Country = country;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	
	public String getUploadimage() {
		return Uploadimage;
	}
	public void setUploadimage(String uploadimage) {
		Uploadimage = uploadimage;
	}
	public String getImportimage() {
		return Importimage;
	}
	public void setImportimage(String importimage) {
		Importimage = importimage;
	}
	
	public String getLocationDescription() {
		return LocationDescription;
	}
	public void setLocationDescription(String locationDescription) {
		LocationDescription = locationDescription;
	}
	public String getSubject() {
		return Subject;
	}
	public void setSubject(String subject) {
		Subject = subject;
	}
	public String getStreetName() {
		return StreetName;
	}
	public void setStreetName(String streetName) {
		StreetName = streetName;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getPostalCode() {
		return PostalCode;
	}
	public void setPostalCode(String postalCode) {
		PostalCode = postalCode;
	}
	public String getPlace() {
		return Place;
	}
	public void setPlace(String place) {
		Place = place;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getAppointment() {
		return Appointment;
	}
	public void setAppointment(String appointment) {
		Appointment = appointment;
	}
	public String getCompany() {
		return Company;
	}
	public void setCompany(String company) {
		Company = company;
	}
	
	public PortalCreateTicket()
	{
		setEmail("tar.a.ngcho.kshiqa@gmail.com");
		setPassword("qwerty");
		setLocationDescription("Precieze locatie Test");
		setSubject("SP Ticket Subject");
		setDescription("SP Ticket Description");
		setUploadimage("\\src\\main\\java\\Resources\\uploadfileticket.PNG");
		setImportimage("\\src\\main\\java\\Resources\\Building.jpg");
		setStreetName("Sir Winston Churchillln");
		setPostalCode("2288DC");
		setPlace("Rijswijk");
		setAddress("Sir Winston Churchillln 299a");
		setAppointment("Mijzelf");
		setCountry("Nederland");
		setCompany("SPUserCompany");
	}
	
}
