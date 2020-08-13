package Models.Ticket;

public class InvoiceWorkorderModel {

	String GeneralDescription;
	String GeneralItemDescription;
	String GeneralSize;
	String GeneralPrice;
	String LaborItemDescription;
	String LaborFrom;
	String LaborUntil;
	String TravelItemDescription;
	String TravelFrom;
	String TravelUntil;
	String TransportItemDescription;
	String TransportDeparture;
	String TransportArrival;
	String MaterialSize;
	String MiscellaneousSupplier;
	String MiscellaneousItemDescription;
	String MiscellaneousSize;
	String MiscellaneousPrice;

	public String getGeneralDescription() {
		return GeneralDescription;
	}

	public void setGeneralDescription(String generalDescription) {
		GeneralDescription = generalDescription;
	}

	public String getGeneralItemDescription() {
		return GeneralItemDescription;
	}

	public void setGeneralItemDescription(String generalItemDescription) {
		GeneralItemDescription = generalItemDescription;
	}

	public String getGeneralSize() {
		return GeneralSize;
	}

	public void setGeneralSize(String generalSize) {
		GeneralSize = generalSize;
	}

	public String getGeneralPrice() {
		return GeneralPrice;
	}

	public void setGeneralPrice(String generalPrice) {
		GeneralPrice = generalPrice;
	}

	public String getLaborItemDescription() {
		return LaborItemDescription;
	}

	public void setLaborItemDescription(String laborItemDescription) {
		LaborItemDescription = laborItemDescription;
	}

	public String getLaborFrom() {
		return LaborFrom;
	}

	public void setLaborFrom(String laborFrom) {
		LaborFrom = laborFrom;
	}

	public String getLaborUntil() {
		return LaborUntil;
	}

	public void setLaborUntil(String laborUntil) {
		LaborUntil = laborUntil;
	}

	public String getTravelItemDescription() {
		return TravelItemDescription;
	}

	public void setTravelItemDescription(String travelItemDescription) {
		TravelItemDescription = travelItemDescription;
	}

	public String getTravelFrom() {
		return TravelFrom;
	}

	public void setTravelFrom(String travelFrom) {
		TravelFrom = travelFrom;
	}

	public String getTravelUntil() {
		return TravelUntil;
	}

	public void setTravelUntil(String travelUntil) {
		TravelUntil = travelUntil;
	}

	public String getTransportItemDescription() {
		return TransportItemDescription;
	}

	public void setTransportItemDescription(String transportItemDescription) {
		TransportItemDescription = transportItemDescription;
	}

	public String getTransportDeparture() {
		return TransportDeparture;
	}

	public void setTransportDeparture(String transportDeparture) {
		TransportDeparture = transportDeparture;
	}

	public String getTransportArrival() {
		return TransportArrival;
	}

	public void setTransportArrival(String transportArrival) {
		TransportArrival = transportArrival;
	}

	public String getMaterialSize() {
		return MaterialSize;
	}

	public void setMaterialSize(String materialSize) {
		MaterialSize = materialSize;
	}

	public String getMiscellaneousSupplier() {
		return MiscellaneousSupplier;
	}

	public void setMiscellaneousSupplier(String miscellaneousSupplier) {
		MiscellaneousSupplier = miscellaneousSupplier;
	}

	public String getMiscellaneousItemDescription() {
		return MiscellaneousItemDescription;
	}

	public void setMiscellaneousItemDescription(String miscellaneousItemDescription) {
		MiscellaneousItemDescription = miscellaneousItemDescription;
	}

	public String getMiscellaneousSize() {
		return MiscellaneousSize;
	}

	public void setMiscellaneousSize(String miscellaneousSize) {
		MiscellaneousSize = miscellaneousSize;
	}

	public String getMiscellaneousPrice() {
		return MiscellaneousPrice;
	}

	public void setMiscellaneousPrice(String miscellaneousPrice) {
		MiscellaneousPrice = miscellaneousPrice;
	}

	public InvoiceWorkorderModel() {

		setGeneralDescription("Algemene omschrijving test");
		setGeneralItemDescription("Artikelomschrijving A");
		setGeneralSize("10,00");
		setGeneralPrice("50,00");
		setLaborItemDescription("Artikelomschrijving Arbeid");
		setLaborFrom("5:00");
		setLaborUntil("12:00");
		setTravelItemDescription("Artikelomschrijving Travel Expenses");
		setTravelFrom("7:00");
		setTravelUntil("15:00");
		setTransportItemDescription("Artikelomschrijving Transport");
		setTransportDeparture("8");
		setTransportArrival("18");
		setMaterialSize("10,00");
		setMiscellaneousSupplier("Leverancier");
		setMiscellaneousItemDescription("Artikelomschrijving");
		setMiscellaneousSize("10,00");
		setMiscellaneousPrice("50,00");	
	}
}