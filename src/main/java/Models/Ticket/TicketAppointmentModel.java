package Models.Ticket;

import Stepdefinations.Base.TicketType;

public class TicketAppointmentModel {

	String AppointmentCompanyName;
	String AppointmentPostalCode;
	String AppointmentPlace;
	String AppointmentContactPersonName;
	String AppointmentEmailAddress;
	String AppointmentDescription;
	String AppointmentInternalDescription;
	String AppointmentPhoneNumber;	
	String AppointmentMobileNumber;

	public String getAppointmentCompanyName() {
		return AppointmentCompanyName;
	}
	public void setAppointmentCompanyName(String appointmentCompanyName) {
		AppointmentCompanyName = appointmentCompanyName;
	}
	public String getAppointmentPostalCode() {
		return AppointmentPostalCode;
	}
	public void setAppointmentPostalCode(String appointmentPostalCode) {
		AppointmentPostalCode = appointmentPostalCode;
	}
	public String getAppointmentPlace() {
		return AppointmentPlace;
	}
	public void setAppointmentPlace(String appointmentPlace) {
		AppointmentPlace = appointmentPlace;
	}
	public String getAppointmentContactPersonName() {
		return AppointmentContactPersonName;
	}
	public void setAppointmentContactPersonName(String appointmentContactPersonName) {
		AppointmentContactPersonName = appointmentContactPersonName;
	}
	public String getAppointmentEmailAddress() {
		return AppointmentEmailAddress;
	}
	public void setAppointmentEmailAddress(String appointmentEmailAddress) {
		AppointmentEmailAddress = appointmentEmailAddress;
	}
	public String getAppointmentDescription() {
		return AppointmentDescription;
	}
	public void setAppointmentDescription(String appointmentDescription) {
		AppointmentDescription = appointmentDescription;
	}
	public String getAppointmentInternalDescription() {
		return AppointmentInternalDescription;
	}
	public void setAppointmentInternalDescription(String appointmentInternalDescription) {
		AppointmentInternalDescription = appointmentInternalDescription;
	}
	public String getAppointmentPhoneNumber() {
		return AppointmentPhoneNumber;
	}
	public void setAppointmentPhoneNumber(String appointmentPhoneNumber) {
		AppointmentPhoneNumber = appointmentPhoneNumber;
	}
	public String getAppointmentMobileNumber() {
		return AppointmentMobileNumber;
	}
	public void setAppointmentMobileNumber(String appointmentMobileNumber) {
		AppointmentMobileNumber = appointmentMobileNumber;
	}

	public TicketAppointmentModel() {

	}

	public TicketAppointmentModel(TicketType ticketType)	{
		switch(ticketType){
		case Initial:
			setAppointmentPhoneNumber("11111111111");
			setAppointmentMobileNumber("22222222222");
			setAppointmentEmailAddress("testshanoe8@loekonline.onmicrosoft.com");
			break;
		case Performing:
			setAppointmentDescription("Omschrijving A");
			setAppointmentInternalDescription("Interne omschrijving B");
			break;
		case ExternalPerforming:

			break;
		case Delegated:

			break;
		}
	}
}