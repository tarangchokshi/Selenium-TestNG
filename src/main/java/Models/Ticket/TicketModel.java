package Models.Ticket;

import Stepdefinations.Base.TicketType;

public class TicketModel {

	String TicketBuildingUnit;
	String TicketShortDescription;
	String TicketNumber;
	String CompanyName;
	String Contact;
	String EmailAddress;
	String Cc;
	String PhoneNumber;

	public String getTicketBuildingUnit() {
		return TicketBuildingUnit;
	}
	public void setTicketBuildingUnit(String ticketBuildingUnit) {
		TicketBuildingUnit = ticketBuildingUnit;
	}
	public String getTicketShortDescription() {
		return TicketShortDescription;
	}
	public void setTicketShortDescription(String ticketShortDescription) {
		TicketShortDescription = ticketShortDescription;
	}
	public String getTicketNumber() {
		return TicketNumber;
	}
	public void setTicketNumber(String ticketNumber) {
		TicketNumber = ticketNumber;
	}
	public String getCompanyName() {
		return CompanyName;
	}
	public void setCompanyName(String companyName) {
		CompanyName = companyName;
	}
	public String getContact() {
		return Contact;
	}
	public void setContact(String contact) {
		Contact = contact;
	}
	public String getEmailAddress() {
		return EmailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		EmailAddress = emailAddress;
	}
	public String getCc() {
		return Cc;
	}
	public void setCc(String cc) {
		Cc = cc;
	}
	public String getPhoneNumber() {
		return PhoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}

	public TicketModel() {

	}

	public TicketModel(TicketType ticketType)	{
		switch(ticketType){
		case Initial:
			setTicketBuildingUnit("Sir Winston Churchillln 299a");
			setTicketShortDescription("Short description");
			break;
		case Performing:
			setTicketShortDescription("Short description Performing Ticket");
			break;
		case ExternalPerforming:
			setTicketShortDescription("Short description External Performing Ticket");
			setCompanyName("Extrernal Performing Company");
			setContact("Extrernal Performing Contact Name");
			setEmailAddress("testshanoe1@loekonline.onmicrosoft.com");
			setCc("testshanoe1@loekonline.onmicrosoft.com");
			setPhoneNumber("651951133");
			break;
		case Delegated:
			setTicketShortDescription("Short description Delegated Ticket");
			break;
		}
	}
}