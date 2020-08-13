package Models.BuildingUnit;

public class BuildingUnitDocumentModel {

	String Image1;
	String Image2;
	String Description;
	String FileName;
	
	
	public String getImage1() {
		return Image1;
	}
	public void setImage1(String image1) {
		Image1 = image1;
	}
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
	public String getFileName() {
		return FileName;
	}
	public void setFileName(String fileName) {
		FileName = fileName;
	}
	public BuildingUnitDocumentModel()
	{
		
		setImage1("src\\main\\java\\Resources\\doc3.PNG");
		setImage2("\\src\\main\\java\\Resources\\BuildingUnit.jpg");
		setDescription("Documentforbuildingunit");
		setFileName("file1");
	}
	
}
