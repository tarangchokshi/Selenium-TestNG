package Models.Building;

public class BuildingTanentModel {

	String CompanyName;
	String ContactName;
	String ContactFunction;
	public String getCompanyName()
	{
		return CompanyName;
	}
	public void setCompanyName(String companyName)
	{
		CompanyName=companyName;
	}
	public String getContactName()
	{
		return ContactName;
	}
	public void setContactName(String contactName)
	{
		ContactName=contactName;
	}
	public String getContactFunction()
	{
		return ContactFunction;
	}
	public void setContactFunction(String contactFunction)
	{
		ContactFunction=contactFunction;
	}
	
	public BuildingTanentModel()
	{
		setCompanyName("Building Tenant Company name");
		setContactName("Building Tenant Contact");
		setContactFunction("Building Tenant Function");
	}
}
