package Models.BuildingUnit;

public class BuildingUnitElementModel {

	String ErrorMessage;
	String ElementMaker;
	String ElementModel;
	String ElementType;
	String ElementDateInstalled;
	String ElementGuaranteeExpiration;
	String ElementSize;
	String ElementOrientation;
	
	public String getErrorMessage() {
		return ErrorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		ErrorMessage = errorMessage;
	}
	public String getElementMaker() {
		return ElementMaker;
	}
	public void setElementMaker(String elementMaker) {
		ElementMaker = elementMaker;
	}
	public String getElementModel() {
		return ElementModel;
	}
	public void setElementModel(String elementModel) {
		ElementModel = elementModel;
	}
	public String getElementType() {
		return ElementType;
	}
	public void setElementType(String elementType) {
		ElementType = elementType;
	}
	public String getElementDateInstalled() {
		return ElementDateInstalled;
	}
	public void setElementDateInstalled(String elementDateInstalled) {
		ElementDateInstalled = elementDateInstalled;
	}
	
	public String getElementGuaranteeExpiration() {
		return ElementGuaranteeExpiration;
	}
	public void setElementGuaranteeExpiration(String elementGuaranteeExpiration) {
		ElementGuaranteeExpiration = elementGuaranteeExpiration;
	}
	public String getElementSize() {
		return ElementSize;
	}
	public void setElementSize(String elementSize) {
		ElementSize = elementSize;
	}
	public String getElementOrientation() {
		return ElementOrientation;
	}
	public void setElementOrientation(String elementOrientation) {
		ElementOrientation = elementOrientation;
	}
	public BuildingUnitElementModel()
	{
		setErrorMessage("Fabrikant / Leverancier is een verplicht veld");
		setElementMaker("Phillips");
		setElementModel("MerkLoek");
		setElementType("TypeLoek");
		setElementDateInstalled("01-01-2018");
		setElementGuaranteeExpiration("01-01-2020");
		setElementSize("1");
		setElementOrientation("South");
	}
}
