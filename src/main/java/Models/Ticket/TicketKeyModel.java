package Models.Ticket;

import Stepdefinations.Base.TicketType;

public class TicketKeyModel {

	String KeyCompanyName;
	String KeyContactPersonName;
	String KeyPostalCode;
	String KeyPlace;
	String KeyEmailAddress;
	String KeyHouseNumber;
	String KeyPhoneNumber;
	String KeyMobileNumber;
	String KeyNote;

	public String getKeyCompanyName() {
		return KeyCompanyName;
	}
	public void setKeyCompanyName(String keyCompanyName) {
		KeyCompanyName = keyCompanyName;
	}
	public String getKeyContactPersonName() {
		return KeyContactPersonName;
	}
	public void setKeyContactPersonName(String keyContactPersonName) {
		KeyContactPersonName = keyContactPersonName;
	}
	public String getKeyPostalCode() {
		return KeyPostalCode;
	}
	public void setKeyPostalCode(String keyPostalCode) {
		KeyPostalCode = keyPostalCode;
	}
	public String getKeyPlace() {
		return KeyPlace;
	}
	public void setKeyPlace(String keyPlace) {
		KeyPlace = keyPlace;
	}
	public String getKeyEmailAddress() {
		return KeyEmailAddress;
	}
	public void setKeyEmailAddress(String keyEmailAddress) {
		KeyEmailAddress = keyEmailAddress;
	}	
	public String getKeyHouseNumber() {
		return KeyHouseNumber;
	}
	public void setKeyHouseNumber(String keyHouseNumber) {
		KeyHouseNumber = keyHouseNumber;
	}
	public String getKeyPhoneNumber() {
		return KeyPhoneNumber;
	}
	public void setKeyPhoneNumber(String keyPhoneNumber) {
		KeyPhoneNumber = keyPhoneNumber;
	}
	public String getKeyMobileNumber() {
		return KeyMobileNumber;
	}
	public void setKeyMobileNumber(String keyMobileNumber) {
		KeyMobileNumber = keyMobileNumber;
	}
	public String getKeyNote() {
		return KeyNote;
	}
	public void setKeyNote(String keyNote) {
		KeyNote = keyNote;
	}

	public TicketKeyModel() {

	}

	public TicketKeyModel(TicketType ticketType)	{
		switch(ticketType){
		case Initial:
			setKeyPhoneNumber("11111111111");
			setKeyMobileNumber("22222222222");
			setKeyEmailAddress("testshanoe8@loekonline.onmicrosoft.com");
			break;
		case Performing:

			break;
		case ExternalPerforming:
			setKeyCompanyName("External Performing Key Company");
			setKeyPostalCode("3012ER");
			setKeyHouseNumber("90");
			setKeyContactPersonName("External Performing Key Contact");
			setKeyPhoneNumber("1234567890");
			setKeyMobileNumber("9876543210");
			setKeyEmailAddress("testshanoe1@loekonline.onmicrosoft.com");
			setKeyNote("External Performing Key Note");
			break;
		case Delegated:
			setKeyCompanyName("Delegated Key Company");
			setKeyPostalCode("3012ER");
			setKeyHouseNumber("90");
			setKeyContactPersonName("Delegated Key Contact");
			setKeyPhoneNumber("1234567890");
			setKeyMobileNumber("9876543210");
			setKeyEmailAddress("testshanoe5@loekonline.onmicrosoft.com");
			setKeyNote("Delegated Key Note");
			break;
		}
	}
}