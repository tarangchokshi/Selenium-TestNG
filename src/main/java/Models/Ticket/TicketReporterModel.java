package Models.Ticket;

import Stepdefinations.Base.TicketType;

public class TicketReporterModel {

	String ReporterCompanyName;
	String ReporterContactPersonName;
	String ReporterPhoneNumber;
	String ReporterMobileNumber;
	String ReporterEmailAddress;

	public String getReporterCompanyName() {
		return ReporterCompanyName;
	}
	public void setReporterCompanyName(String reporterCompanyName) {
		ReporterCompanyName = reporterCompanyName;
	}
	public String getReporterContactPersonName() {
		return ReporterContactPersonName;
	}
	public void setReporterContactPersonName(String reporterContactPersonName) {
		ReporterContactPersonName = reporterContactPersonName;
	}
	public String getReporterPhoneNumber() {
		return ReporterPhoneNumber;
	}
	public void setReporterPhoneNumber(String reporterPhoneNumber) {
		ReporterPhoneNumber = reporterPhoneNumber;
	}
	public String getReporterMobileNumber() {
		return ReporterMobileNumber;
	}
	public void setReporterMobileNumber(String reporterMobileNumber) {
		ReporterMobileNumber = reporterMobileNumber;
	}
	public String getReporterEmailAddress() {
		return ReporterEmailAddress;
	}
	public void setReporterEmailAddress(String reporterEmailAddress) {
		ReporterEmailAddress = reporterEmailAddress;
	}	

	public TicketReporterModel() {

	}

	public TicketReporterModel(TicketType ticketType)	{
		switch(ticketType){
		case Initial:
			setReporterPhoneNumber("11111111111");
			setReporterMobileNumber("22222222222");
			setReporterEmailAddress("testshanoe8@loekonline.onmicrosoft.com");
			break;
		case Performing:

			break;
		case ExternalPerforming:

			break;
		case Delegated:

			break;
		}
	}
}