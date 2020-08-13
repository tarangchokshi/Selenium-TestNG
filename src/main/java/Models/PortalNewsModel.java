package Models;

public class PortalNewsModel {

	
	String Subject;
	String Message;
	String Buildingdescription;
	String Buildingunitdescription;
	String Email;
	String Password;
	String Publish;
	public String getSubject() {
		return Subject;
	}
	public void setSubject(String subject) {
		Subject = subject;
	}
	
	public String getMessage() {
		return Message;
	}
	public void setMessage(String message) {
		Message = message;
	}
	public String getBuildingunitdescription() {
		return Buildingunitdescription;
	}
	public void setBuildingunitdescription(String buildingunitdescription) {
		Buildingunitdescription = buildingunitdescription;
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
	public String getBuildingdescription() {
		return Buildingdescription;
	}
	public void setBuildingdescription(String buildingdescription) {
		Buildingdescription = buildingdescription;
	}
	public String getPublish() {
		return Publish;
	}
	public void setPublish(String publish) {
		Publish = publish;
	}
	
	public PortalNewsModel()
	{
		setSubject("Loek News Title Automation");
		setMessage("Loek News Description Automation");
		setBuildingunitdescription("building unit description - Sir Winston Churchillln 299 a");
		setBuildingdescription("Kantoor, Overige");
		setEmail("tar.a.ngcho.kshiqa@gmail.com");
		setPassword("qwerty");
		setPublish("Bericht gepubliceerd");
	}
}
