package Models.Ticket;

import Stepdefinations.Base.TicketType;

public class TicketOrderModel {

	String OrderNumber;
	String TypeOfAmount;
	String OrderAmount;
	String CostCenter;
	String CostCategory;
	String ManagementCode;
	String AdditionalReference;

	public String getOrderNumber() {
		return OrderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		OrderNumber = orderNumber;
	}
	public String getTypeOfAmount() {
		return TypeOfAmount;
	}
	public void setTypeOfAmount(String typeOfAmount) {
		TypeOfAmount = typeOfAmount;
	}
	public String getOrderAmount() {
		return OrderAmount;
	}
	public void setOrderAmount(String orderAmount) {
		OrderAmount = orderAmount;
	}
	public String getCostCenter() {
		return CostCenter;
	}
	public void setCostCenter(String costCenter) {
		CostCenter = costCenter;
	}
	public String getCostCategory() {
		return CostCategory;
	}
	public void setCostCategory(String costCategory) {
		CostCategory = costCategory;
	}
	public String getManagementCode() {
		return ManagementCode;
	}
	public void setManagementCode(String managementCode) {
		ManagementCode = managementCode;
	}
	public String getAdditionalReference() {
		return AdditionalReference;
	}
	public void setAdditionalReference(String additionalReference) {
		AdditionalReference = additionalReference;
	}
	public TicketOrderModel() {

	}

	public TicketOrderModel(TicketType ticketType)	{
		switch(ticketType){
		case Initial:
			setOrderNumber("Order Loek01");
			setOrderAmount("100");
			setAdditionalReference("Additional reference");
			break;
		case Performing:

			break;
		case ExternalPerforming:
			setOrderNumber("External Performing Order1");
			setManagementCode("External Performing Management Code");
			setAdditionalReference("External Performing Additional Reference");
			break;
		case Delegated:
			setOrderNumber("Delegated Order1");
			setManagementCode("Delegated Management Code");
			setAdditionalReference("Delegated Additional Reference");
			break;
		}
	}
}