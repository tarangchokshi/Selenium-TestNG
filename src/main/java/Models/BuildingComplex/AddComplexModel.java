package Models.BuildingComplex;

public class AddComplexModel {

	String ComplexName;
	String Description;
	
	public String getComplexName() {
		return ComplexName;
	}
	public void setComplexName(String complexName) {
		ComplexName = complexName;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public AddComplexModel()
	{
		setComplexName("Regression");
		setDescription("Test");
	}	
	
}
