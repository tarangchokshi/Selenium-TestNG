package Models.Ticket;

public class WorkorderModel {

	String TravelCollaborator;
	String TravelDeparture;
	String TravelArrival;
	String TransportCollaborator;
	String TransportDeparture;
	String TransportArrival;
	String WorkPerformedCollaborator;
	String WorkPerformedStartTime;
	String WorkPerformedEndTime;
	String WorkPerformedActivities;
	String MaterialSize;
	String MiscellaneousSupplier;
	String MiscellaneousDescription;
	String MiscellaneousQuantity;

	public String getTravelCollaborator() {
		return TravelCollaborator;
	}
	public void setTravelCollaborator(String travelCollaborator) {
		TravelCollaborator = travelCollaborator;
	}
	public String getTravelDeparture() {
		return TravelDeparture;
	}
	public void setTravelDeparture(String travelDeparture) {
		TravelDeparture = travelDeparture;
	}
	public String getTravelArrival() {
		return TravelArrival;
	}
	public void setTravelArrival(String travelArrival) {
		TravelArrival = travelArrival;
	}
	public String getTransportCollaborator() {
		return TransportCollaborator;
	}
	public void setTransportCollaborator(String transportCollaborator) {
		TransportCollaborator = transportCollaborator;
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
	public String getWorkPerformedCollaborator() {
		return WorkPerformedCollaborator;
	}
	public void setWorkPerformedCollaborator(String workPerformedCollaborator) {
		WorkPerformedCollaborator = workPerformedCollaborator;
	}
	public String getWorkPerformedStartTime() {
		return WorkPerformedStartTime;
	}
	public void setWorkPerformedStartTime(String workPerformedStartTime) {
		WorkPerformedStartTime = workPerformedStartTime;
	}
	public String getWorkPerformedEndTime() {
		return WorkPerformedEndTime;
	}
	public void setWorkPerformedEndTime(String workPerformedEndTime) {
		WorkPerformedEndTime = workPerformedEndTime;
	}
	public String getWorkPerformedActivities() {
		return WorkPerformedActivities;
	}
	public void setWorkPerformedActivities(String workPerformedActivities) {
		WorkPerformedActivities = workPerformedActivities;
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
	public String getMiscellaneousDescription() {
		return MiscellaneousDescription;
	}
	public void setMiscellaneousDescription(String miscellaneousDescription) {
		MiscellaneousDescription = miscellaneousDescription;
	}
	public String getMiscellaneousQuantity() {
		return MiscellaneousQuantity;
	}
	public void setMiscellaneousQuantity(String miscellaneousQuantity) {
		MiscellaneousQuantity = miscellaneousQuantity;
	}

	public WorkorderModel()
	{
		setTravelCollaborator("Test1 LoekComTwo");
		setTravelDeparture("01:00");
		setTravelArrival("21:00");
		setTransportCollaborator("Test1 LoekComTwo");
		setTransportDeparture("10");
		setTransportArrival("50");
		setWorkPerformedCollaborator("Test1 LoekComTwo");
		setWorkPerformedStartTime("12:00");
		setWorkPerformedEndTime("23:00");
		setWorkPerformedActivities("Werkzaamheden A");
		setMaterialSize("5,00");
		setMiscellaneousSupplier("Leverancier A");
		setMiscellaneousDescription("Omschrijving A");
		setMiscellaneousQuantity("10,00");
	}
}