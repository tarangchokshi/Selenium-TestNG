package Models.Building;

public class BuildingDocumentModel {

	
	String Image2;
	String Description;
	
	public String getImage2() {
		return Image2;
	}
	public void setImage2(String image2) {
		Image2 = image2;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}	
	public BuildingDocumentModel()
	{
		setImage2("\\src\\main\\java\\Resources\\Building.jpg");
		setDescription("Documentforbuilding");
	}
}
