package Stepdefinations.Ticket;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Models.Ticket.TicketAppointmentModel;
import Models.Ticket.TicketFailureModel;
import Models.Ticket.TicketInvoiceModel;
import Models.Ticket.TicketKeyModel;
import Models.Ticket.TicketOrderModel;
import Models.Ticket.TicketReporterModel;

public class VerifyTicketDetail {

	public static void VerifyReporterDetails(WebDriver driver, TicketReporterModel ticketOverviewReporterModel) {

		TicketReporterModel ticketDetailReporterModel = new TicketReporterModel();

		ticketDetailReporterModel.setReporterCompanyName(driver.findElement(By.xpath(".//*[@id='display-ReporterCompanyName']")).getText());
		ticketDetailReporterModel.setReporterContactPersonName(driver.findElement(By.xpath(".//*[@id='display-ReporterName']")).getText());
		ticketDetailReporterModel.setReporterPhoneNumber(driver.findElement(By.xpath(".//*[@id='display-ReporterPhone']")).getText());
		ticketDetailReporterModel.setReporterMobileNumber(driver.findElement(By.xpath(".//*[@id='display-ReporterMobilePhone']")).getText());
		ticketDetailReporterModel.setReporterEmailAddress(driver.findElement(By.xpath(".//*[@id='display-ReporterEmail']")).getText());

		Assert.assertEquals(ticketDetailReporterModel.getReporterCompanyName(), ticketOverviewReporterModel.getReporterCompanyName());
		System.out.println("Reporter Company name verified");
		Assert.assertEquals(ticketDetailReporterModel.getReporterContactPersonName(), ticketOverviewReporterModel.getReporterContactPersonName());
		System.out.println("Reporter Contact Person name verified");
		Assert.assertEquals(ticketDetailReporterModel.getReporterEmailAddress(), ticketOverviewReporterModel.getReporterEmailAddress());
		System.out.println("Reporter Email Address verified");
	}

	public static void VerifyFailureDetails(WebDriver driver, TicketFailureModel ticketOverviewFailureModel) {

		TicketFailureModel ticketDetailFailureModel = new TicketFailureModel();

		ticketDetailFailureModel.setFailureLocation(driver.findElement(By.xpath(".//*[@id='display-Problems_0 __Location']")).getText());
		ticketDetailFailureModel.setFailurePreciseLocation(driver.findElement(By.xpath(".//*[@id='display-Problems_0 __LocationDescription']")).getText());
		ticketDetailFailureModel.setFailureSpace(driver.findElement(By.xpath(".//*[@id='display-Problems_0 __Room']")).getText()); 
		ticketDetailFailureModel.setFailureMachineNumber(driver.findElement(By.xpath(".//*[@id='display-Problems_0 __MachineNumber']")).getText());
		ticketDetailFailureModel.setFailureDetailedDescription(driver.findElement(By.xpath(".//*[@id='display-Problems_0 __Description']")).getText());
		ticketDetailFailureModel.setFailurePriority(driver.findElement(By.xpath(".//*[@id='display-Problems_0 __Priority']")).getText());

		Assert.assertEquals(ticketDetailFailureModel.getFailureLocation(), ticketOverviewFailureModel.getFailureLocation());
		System.out.println("Failure Location verified");
		Assert.assertEquals(ticketDetailFailureModel.getFailurePreciseLocation(), ticketOverviewFailureModel.getFailurePreciseLocation());
		System.out.println("Failure Precise Location verified");
		Assert.assertEquals(ticketDetailFailureModel.getFailureSpace(), ticketOverviewFailureModel.getFailureSpace());
		System.out.println("Failure Space verified");
		Assert.assertEquals(ticketDetailFailureModel.getFailureMachineNumber(), ticketOverviewFailureModel.getFailureMachineNumber());
		System.out.println("Failure Machine Number verified");
		Assert.assertEquals(ticketDetailFailureModel.getFailureDetailedDescription(), ticketOverviewFailureModel.getFailureDetailedDescription());
		System.out.println("Failure Detailed Description verified");
		Assert.assertEquals(ticketDetailFailureModel.getFailurePriority(), ticketOverviewFailureModel.getFailurePriority());
		System.out.println("Failure Priority verified");
	}

	public static void VerifyKeyDetails(WebDriver driver, TicketKeyModel ticketOverviewKeyModel) {

		TicketKeyModel ticketDetailKeyModel = new TicketKeyModel();

		ticketDetailKeyModel.setKeyCompanyName(driver.findElement(By.xpath(".//*[@id='display-KeyCompanyName']")).getText());
		ticketDetailKeyModel.setKeyContactPersonName(driver.findElement(By.xpath(".//*[@id='display-KeyName']")).getText());
		ticketDetailKeyModel.setKeyPostalCode(driver.findElement(By.xpath(".//*[@id='display-KeyPostalCode']")).getText());
		ticketDetailKeyModel.setKeyPlace(driver.findElement(By.xpath(".//*[@id='display-KeyCity']")).getText());
		ticketDetailKeyModel.setKeyEmailAddress(driver.findElement(By.xpath(".//*[@id='display-KeyEmail']")).getText());

		Assert.assertEquals(ticketDetailKeyModel.getKeyCompanyName(), ticketOverviewKeyModel.getKeyCompanyName());
		System.out.println("Key Company Name verified");
		Assert.assertEquals(ticketDetailKeyModel.getKeyContactPersonName(), ticketOverviewKeyModel.getKeyContactPersonName());
		System.out.println("Key Contact Person Name verified");
		Assert.assertEquals(ticketDetailKeyModel.getKeyPostalCode(), ticketOverviewKeyModel.getKeyPostalCode());
		System.out.println("Key Postal Code verified");
		Assert.assertEquals(ticketDetailKeyModel.getKeyPlace(), ticketOverviewKeyModel.getKeyPlace());
		System.out.println("Key Place verified");
		Assert.assertEquals(ticketDetailKeyModel.getKeyEmailAddress(), ticketOverviewKeyModel.getKeyEmailAddress());
		System.out.println("Key Email Address verified");
	}

	public static void VerifyAppointmentDetails(WebDriver driver, TicketAppointmentModel ticketOverviewAppointmentModel) {

		TicketAppointmentModel ticketDetailAppointmentModel = new TicketAppointmentModel();

		ticketDetailAppointmentModel.setAppointmentCompanyName(driver.findElement(By.xpath(".//*[@id='tab-page-appointment']/div/div[1]/div[1]/div[2]")).getText());
		ticketDetailAppointmentModel.setAppointmentPostalCode(driver.findElement(By.xpath(".//*[@id='tab-page-appointment']/div/div[1]/div[3]/div[2]")).getText());
		ticketDetailAppointmentModel.setAppointmentPlace(driver.findElement(By.xpath(".//*[@id='tab-page-appointment']/div/div[1]/div[4]/div[2]")).getText());
		ticketDetailAppointmentModel.setAppointmentContactPersonName(driver.findElement(By.xpath(".//*[@id='tab-page-appointment']/div/div[1]/div[6]/div[2]")).getText());
		ticketDetailAppointmentModel.setAppointmentEmailAddress(driver.findElement(By.xpath(".//*[@id='tab-page-appointment']/div/div[1]/div[9]/div[2]")).getText());

		Assert.assertEquals(ticketDetailAppointmentModel.getAppointmentCompanyName(), ticketOverviewAppointmentModel.getAppointmentCompanyName());
		System.out.println("Appointment Comapny Name verified");
		Assert.assertEquals(ticketDetailAppointmentModel.getAppointmentPostalCode(), ticketOverviewAppointmentModel.getAppointmentPostalCode());
		System.out.println("Appointment Postal Code verified");
		Assert.assertEquals(ticketDetailAppointmentModel.getAppointmentPlace(), ticketOverviewAppointmentModel.getAppointmentPlace());
		System.out.println("Appointment Place verified");
		Assert.assertEquals(ticketDetailAppointmentModel.getAppointmentContactPersonName(), ticketOverviewAppointmentModel.getAppointmentContactPersonName());
		System.out.println("Appointment Contact Person Name verified");
		Assert.assertEquals(ticketDetailAppointmentModel.getAppointmentEmailAddress(), ticketOverviewAppointmentModel.getAppointmentEmailAddress());
		System.out.println("Appointment Email Address verified");
	}

	public static void VerifyOrderDetails(WebDriver driver, Boolean flag, TicketOrderModel ticketOverviewOrderModel) {

		TicketOrderModel ticketOrderDetailModel = new TicketOrderModel();

		ticketOrderDetailModel.setOrderNumber(driver.findElement(By.xpath(".//*[@id='display-OrderNumber']")).getText());
		ticketOrderDetailModel.setTypeOfAmount(driver.findElement(By.xpath(".//*[@id='display-OrderAmountType']")).getText());
		ticketOrderDetailModel.setOrderAmount(driver.findElement(By.xpath(".//*[@id='display-OrderAmount']")).getText());
		ticketOrderDetailModel.setCostCenter(driver.findElement(By.xpath(".//*[@id='display-CostCentre']")).getText());
		ticketOrderDetailModel.setCostCategory(driver.findElement(By.xpath(".//*[@id='display-CostDescription']")).getText());
		ticketOrderDetailModel.setManagementCode(driver.findElement(By.xpath(".//*[@id='display-ManagementCode']")).getText());
		ticketOrderDetailModel.setAdditionalReference(driver.findElement(By.xpath(".//*[@id='display-ReferenceNumber']")).getText());

		Assert.assertEquals(ticketOrderDetailModel.getOrderNumber(),ticketOverviewOrderModel.getOrderNumber());
		System.out.println("Order Number verified");

		flag = true;
		if(!(ticketOverviewOrderModel.getTypeOfAmount().contains(ticketOrderDetailModel.getTypeOfAmount())))
		{
			flag = false;
		}
		Assert.assertEquals(flag, true);
		System.out.println("Type of Amount verified");

		flag = true;
		String[] orderAmount = ticketOrderDetailModel.getOrderAmount().split(" ");
		if(!(ticketOverviewOrderModel.getTypeOfAmount().contains(orderAmount[1])))
		{
			flag = false;
		}
		Assert.assertEquals(flag, true);
		System.out.println("Order Amount verified");
		Assert.assertEquals(ticketOrderDetailModel.getCostCenter(),ticketOverviewOrderModel.getCostCenter());
		System.out.println("Cost Center verified");
		Assert.assertEquals(ticketOrderDetailModel.getCostCategory(),ticketOverviewOrderModel.getCostCategory());
		System.out.println("Cost Category verified");
		Assert.assertEquals(ticketOrderDetailModel.getManagementCode(),ticketOverviewOrderModel.getManagementCode());
		System.out.println("Management Code verified");
		Assert.assertEquals(ticketOrderDetailModel.getAdditionalReference(),ticketOverviewOrderModel.getAdditionalReference());
		System.out.println("Additional Reference verified");
	}

	public static void VerifyInvoiceDetails(WebDriver driver, TicketInvoiceModel ticketOverviewInvoiceModel) {

		TicketInvoiceModel ticketDetailInvoiceModel = new TicketInvoiceModel();

		ticketDetailInvoiceModel.setInvoiceCompanyName(driver.findElement(By.xpath(".//*[@id='display-InvoiceCompanyName']")).getText());
		ticketDetailInvoiceModel.setInvoiceDepartment(driver.findElement(By.xpath(".//*[@id='display-InvoiceDepartment']")).getText());
		ticketDetailInvoiceModel.setInvoicePostalCode(driver.findElement(By.xpath(".//*[@id='display-InvoicePostalCode']")).getText());
		ticketDetailInvoiceModel.setInvoicePlace(driver.findElement(By.xpath(".//*[@id='display-InvoiceCity']")).getText());
		ticketDetailInvoiceModel.setInvoiceCountry(driver.findElement(By.xpath(".//*[@id='display-InvoiceCountry']")).getText());
		ticketDetailInvoiceModel.setInvoiceEmailAddress(driver.findElement(By.xpath(".//*[@id='display-InvoiceEmail']")).getText());

		Assert.assertEquals(ticketDetailInvoiceModel.getInvoiceCompanyName(),ticketOverviewInvoiceModel.getInvoiceCompanyName());
		System.out.println("Invoice Company Name verified");
		Assert.assertEquals(ticketDetailInvoiceModel.getInvoiceDepartment(),ticketOverviewInvoiceModel.getInvoiceDepartment());
		System.out.println("Invoice Department verified");
		Assert.assertEquals(ticketDetailInvoiceModel.getInvoicePostalCode(),ticketOverviewInvoiceModel.getInvoicePostalCode());
		System.out.println("Invoice Postal Code verified");
		Assert.assertEquals(ticketDetailInvoiceModel.getInvoicePlace().trim(),ticketOverviewInvoiceModel.getInvoicePlace().trim());
		System.out.println("Invoice Place verified");
		Assert.assertEquals(ticketDetailInvoiceModel.getInvoiceCountry(),ticketOverviewInvoiceModel.getInvoiceCountry());
		System.out.println("Invoice Country verified");
		Assert.assertEquals(ticketDetailInvoiceModel.getInvoiceEmailAddress(),ticketOverviewInvoiceModel.getInvoiceEmailAddress());
		System.out.println("Invoice Email Address verified");
	}
}