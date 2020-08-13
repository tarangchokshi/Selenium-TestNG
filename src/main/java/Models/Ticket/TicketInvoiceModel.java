package Models.Ticket;

import Stepdefinations.Base.TicketType;

public class TicketInvoiceModel {

	String InvoiceCompanyName;
	String InvoiceDepartment;
	String InvoicePostalCode;
	String InvoicePlace;
	String InvoiceCountry;
	String InvoiceEmailAddress;
	String InvoiceVatNumber;

	public String getInvoiceCompanyName() {
		return InvoiceCompanyName;
	}
	public void setInvoiceCompanyName(String invoiceCompanyName) {
		InvoiceCompanyName = invoiceCompanyName;
	}
	public String getInvoiceDepartment() {
		return InvoiceDepartment;
	}
	public void setInvoiceDepartment(String invoiceDepartment) {
		InvoiceDepartment = invoiceDepartment;
	}
	public String getInvoicePostalCode() {
		return InvoicePostalCode;
	}
	public void setInvoicePostalCode(String invoicePostalCode) {
		InvoicePostalCode = invoicePostalCode;
	}
	public String getInvoicePlace() {
		return InvoicePlace;
	}
	public void setInvoicePlace(String invoicePlace) {
		InvoicePlace = invoicePlace;
	}
	public String getInvoiceCountry() {
		return InvoiceCountry;
	}
	public void setInvoiceCountry(String invoiceCountry) {
		InvoiceCountry = invoiceCountry;
	}
	public String getInvoiceEmailAddress() {
		return InvoiceEmailAddress;
	}
	public void setInvoiceEmailAddress(String invoiceEmailAddress) {
		InvoiceEmailAddress = invoiceEmailAddress;
	}
	public String getInvoiceVatNumber() {
		return InvoiceVatNumber;
	}
	public void setInvoiceVatNumber(String invoiceVatNumber) {
		InvoiceVatNumber = invoiceVatNumber;
	}
	public TicketInvoiceModel() {

	}

	public TicketInvoiceModel(TicketType ticketType)	{
		switch(ticketType){
		case Initial:
			setInvoiceEmailAddress("testshanoe8@loekonline.onmicrosoft.com");
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