package Stepdefinations.Ticket;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Models.Ticket.TicketAppointmentModel;
import Models.Ticket.TicketFailureModel;
import Models.Ticket.TicketInvoiceModel;
import Models.Ticket.TicketKeyModel;
import Models.Ticket.TicketModel;
import Models.Ticket.TicketOrderModel;
import Models.Ticket.TicketReporterModel;
import Stepdefinations.Base;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TicketScenario02 extends Base {

	WebDriver driver;
	Boolean flag = true;

	TicketReporterModel ticketReporterModel = new TicketReporterModel(TicketType.Initial);
	TicketAppointmentModel ticketAppointmentModel = new TicketAppointmentModel(TicketType.Initial);
	TicketKeyModel ticketKeyModel = new TicketKeyModel(TicketType.Initial);
	TicketInvoiceModel ticketInvoiceModel = new TicketInvoiceModel(TicketType.Initial);

	TicketModel ticketOverviewModel = new TicketModel();
	TicketReporterModel ticketOverviewReporterModel = new TicketReporterModel();
	TicketFailureModel ticketOverviewFailureModel = new TicketFailureModel();
	TicketAppointmentModel ticketOverviewAppointmentModel = new TicketAppointmentModel();
	TicketKeyModel ticketOverviewKeyModel = new TicketKeyModel();
	TicketOrderModel ticketOverviewOrderModel = new TicketOrderModel();
	TicketInvoiceModel ticketOverviewInvoiceModel = new TicketInvoiceModel();

	@Given("^Open the url and login with the valid data$")
	public void Open_the_url_and_login_with_the_valid_data() throws Throwable {
		SetProperty();
		driver = Login();
		wait = new WebDriverWait(driver,60);
	}

	@When("^User click on MyApplications and select the ticket$")
	public void user_click_on_MyApplications_and_select_the_ticket() throws Throwable {
		GoToModule(Module.Ticket, driver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='checkwizard-navigation']/li[2]")));
		Thread.sleep(2000);		
		SelectTicketFromTicketList(driver);
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='container-main']/div[1]/div[2]/div/a[4]")).click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading-overlay")));
		Thread.sleep(3000);
	}

	@Then("^go to detector section and update the data$")
	public void go_to_detector_section_and_update_the_data() throws Throwable {
	
		driver.findElement(By.xpath(".//*[@id='checkwizard-navigation']/li[2]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='Ticket_ReporterCompanyName']")).sendKeys(" Test");
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='Ticket_ReporterPostalCode']")).clear();
		driver.findElement(By.xpath(".//*[@id='Ticket_ReporterPostalCode']")).sendKeys("228ABC");
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='Ticket_ReporterHouseNumber']")).sendKeys(" Test");
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='Ticket_ReporterStreetName']")).sendKeys(" Test");
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='Ticket_ReporterCity']")).sendKeys(" Test");
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='reporter-edit']/div[6]/div/div/div[1]/div")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='reporter-edit']/div[6]/div/div/div[2]/div/div[150]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='Ticket_ReporterName']")).sendKeys(" Test");
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='Ticket_ReporterPhone']")).clear();
		driver.findElement(By.xpath(".//*[@id='Ticket_ReporterPhone']")).sendKeys(ticketReporterModel.getReporterPhoneNumber());
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='Ticket_ReporterMobilePhone']")).clear();
		driver.findElement(By.xpath(".//*[@id='Ticket_ReporterMobilePhone']")).sendKeys(ticketReporterModel.getReporterMobileNumber());
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='Ticket_ReporterEmail']")).clear();		
		driver.findElement(By.xpath(".//*[@id='Ticket_ReporterEmail']")).sendKeys(ticketReporterModel.getReporterEmailAddress());
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='reporter-edit']/div[11]/div/div[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='checkwizard-next']")).click();
		Thread.sleep(1000);
	}

	@Then("^go to notification section and update the data$")
	public void go_to_notification_section_and_update_the_data() throws Throwable {

		driver.findElement(By.xpath(".//*[@id='Ticket_Description']")).sendKeys(" Test");
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='problems']/div/div[1]/div/div/div[1]/div")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='problems']/div/div[1]/div/div/div[2]/div/div[2]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='Ticket_Problems_0__LocationDescription']")).sendKeys(" Test");
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='Ticket_Problems_0__Description']")).sendKeys(" Test");
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='problems']/div/div[5]/div/div/div[1]/div")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='problems']/div/div[5]/div/div/div[2]/div/div[2]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='Ticket_Problems_0__MachineNumber']")).sendKeys(" Test");
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='checkwizard-next']")).click();
		Thread.sleep(1000);
	}

	@Then("^go to contact section and update the data$")
	public void go_to_contact_section_and_update_the_data() throws Throwable {

		driver.findElement(By.xpath(".//*[@id='ticketApp']/div/div[4]/div[2]/div[1]/div[1]/div/div[2]/div/label")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='Ticket_AppointmentCompanyName']")).sendKeys(" Test");
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='Ticket_AppointmentPostalCode']")).clear();
		driver.findElement(By.xpath(".//*[@id='Ticket_AppointmentPostalCode']")).sendKeys("228ABC");
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='Ticket_AppointmentHouseNumber']")).sendKeys(" Test");
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='Ticket_AppointmentStreetName']")).sendKeys(" Test");
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='Ticket_AppointmentCity']")).sendKeys(" Test");
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='appointment-edit-other']/div[6]/div/div/div[1]/div")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='appointment-edit-other']/div[6]/div/div/div[2]/div/div[150]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='Ticket_AppointmentName']")).sendKeys(" Test");
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='Ticket_AppointmentPhone']")).clear();
		driver.findElement(By.xpath(".//*[@id='Ticket_AppointmentPhone']")).sendKeys(ticketAppointmentModel.getAppointmentPhoneNumber());
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='Ticket_AppointmentMobilePhone']")).clear();
		driver.findElement(By.xpath(".//*[@id='Ticket_AppointmentMobilePhone']")).sendKeys(ticketAppointmentModel.getAppointmentMobileNumber());
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='Ticket_AppointmentEmail']")).clear();		
		driver.findElement(By.xpath(".//*[@id='Ticket_AppointmentEmail']")).sendKeys(ticketAppointmentModel.getAppointmentEmailAddress());
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='appointment-edit-other']/div[11]/div/div[1]/label")).click();
		Thread.sleep(2000);

		js.executeScript("window.scrollBy(0,300)");
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='ticketApp']/div/div[4]/div[4]/div/div[1]/div/div[2]/div/label")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='Ticket_KeyCompanyName']")).sendKeys(" Test");
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='Ticket_KeyPostalCode']")).clear();
		driver.findElement(By.xpath(".//*[@id='Ticket_KeyPostalCode']")).sendKeys("249ABC");
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='Ticket_KeyHouseNumber']")).sendKeys(" Test");
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading-overlay")));
		Thread.sleep(1000);
		js.executeScript("window.scrollBy(0,400)");
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='Ticket_KeyStreet']")).sendKeys(" Test");
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='Ticket_KeyCity']")).sendKeys(" Test");
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='key-required']/div[7]/div/div/div[1]/div")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='key-required']/div[7]/div/div/div[2]/div/div[150]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='Ticket_KeyName']")).sendKeys(" Test");
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='Ticket_KeyPhone']")).clear();
		driver.findElement(By.xpath(".//*[@id='Ticket_KeyPhone']")).sendKeys(ticketKeyModel.getKeyPhoneNumber());
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='Ticket_KeyMobile']")).clear();
		driver.findElement(By.xpath(".//*[@id='Ticket_KeyMobile']")).sendKeys(ticketKeyModel.getKeyMobileNumber());
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='Ticket_KeyEmail']")).clear();		
		driver.findElement(By.xpath(".//*[@id='Ticket_KeyEmail']")).sendKeys(ticketKeyModel.getKeyEmailAddress());
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='Ticket_KeyNote']")).sendKeys(" Test");
		Thread.sleep(1000);
		WebElement checkBoxSaveKey = driver.findElement(By.xpath(".//*[@id='Ticket_SaveKeyContact']"));
		if(checkBoxSaveKey.getAttribute("checked") == null) // if not Checked 
		{
			driver.findElement(By.xpath(".//*[@id='key-required']/div[13]/div/div/label")).click();
			Thread.sleep(1000);
		}
		driver.findElement(By.xpath(".//*[@id='checkwizard-next']")).click();
		Thread.sleep(1000);
	}

	@Then("^go to financial section and update the data$")
	public void go_to_financial_section_and_update_the_data() throws Throwable {

		driver.findElement(By.xpath(".//*[@id='Ticket_OrderNumber']")).sendKeys(" Test");
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='Ticket_ReferenceNumber']")).sendKeys(" Test");
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,700)");
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='Ticket_InvoiceCompanyName']")).sendKeys(" Test");
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='Ticket_InvoiceDepartment']")).sendKeys(" Test");
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='Ticket_InvoicePostalCode']")).clear();
		driver.findElement(By.xpath(".//*[@id='Ticket_InvoicePostalCode']")).sendKeys("251ABC");
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='Ticket_InvoiceHouseNumber']")).sendKeys(" Test");
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading-overlay")));
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='Ticket_InvoiceStreetName']")).sendKeys(" Test");
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='Ticket_InvoiceCity']")).sendKeys(" Test");
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='invoiceaddress-edit']/div[7]/div/div/div[1]/div")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='invoiceaddress-edit']/div[7]/div/div/div[2]/div/div[150]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='Ticket_InvoiceEmail']")).clear();		
		driver.findElement(By.xpath(".//*[@id='Ticket_InvoiceEmail']")).sendKeys(ticketInvoiceModel.getInvoiceEmailAddress());
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='ticketApp']/div/div[5]/div/div[1]/div[12]/div/div/label")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='checkwizard-next']")).click();
		Thread.sleep(1000);
	}

	@Then("^go to overview section and verify the data$")
	public void go_to_overview_section_and_verify_the_data() throws Throwable {

		ticketOverviewModel.setTicketBuildingUnit(driver.findElement(By.xpath(".//*[@id='summary']/div[1]/div[2]")).getText());
		ticketOverviewModel.setTicketShortDescription(driver.findElement(By.xpath(".//*[@id='summary']/div[14]/div[2]")).getText());		

		ticketOverviewReporterModel.setReporterCompanyName(driver.findElement(By.xpath(".//*[@id='summary']/div[4]/div[2]")).getText());
		ticketOverviewReporterModel.setReporterContactPersonName(driver.findElement(By.xpath(".//*[@id='summary']/div[10]/div[2]")).getText());
		ticketOverviewReporterModel.setReporterPhoneNumber(driver.findElement(By.xpath(".//*[@id='summary']/div[11]/div[2]")).getText());
		ticketOverviewReporterModel.setReporterMobileNumber(driver.findElement(By.xpath(".//*[@id='summary']/div[12]/div[2]")).getText());
		ticketOverviewReporterModel.setReporterEmailAddress(driver.findElement(By.xpath(".//*[@id='summary']/div[13]/div[2]")).getText());

		ticketOverviewFailureModel.setFailurePreciseLocation(driver.findElement(By.xpath(".//*[@id='summary']/div[17]/div[2]")).getText());
		ticketOverviewFailureModel.setFailureDetailedDescription(driver.findElement(By.xpath(".//*[@id='summary']/div[18]/div[2]")).getText());		
		ticketOverviewFailureModel.setFailureMachineNumber(driver.findElement(By.xpath(".//*[@id='summary']/div[21]/div[2]")).getText());
		ticketOverviewFailureModel.setFailureLocation(driver.findElement(By.xpath(".//*[@id='summary']/div[15]/div[2]")).getText());
		ticketOverviewFailureModel.setFailureSpace(driver.findElement(By.xpath(".//*[@id='summary']/div[16]/div[2]")).getText());
		ticketOverviewFailureModel.setFailurePriority(driver.findElement(By.xpath(".//*[@id='summary']/div[19]/div[2]")).getText());

		ticketOverviewAppointmentModel.setAppointmentCompanyName(driver.findElement(By.xpath(".//*[@id='summary']/div[24]/div[2]")).getText());
		ticketOverviewAppointmentModel.setAppointmentPostalCode(driver.findElement(By.xpath(".//*[@id='summary']/div[25]/div[2]")).getText());
		ticketOverviewAppointmentModel.setAppointmentPlace(driver.findElement(By.xpath(".//*[@id='summary']/div[28]/div[2]")).getText());
		ticketOverviewAppointmentModel.setAppointmentContactPersonName(driver.findElement(By.xpath(".//*[@id='summary']/div[30]/div[2]")).getText());
		ticketOverviewAppointmentModel.setAppointmentEmailAddress(driver.findElement(By.xpath(".//*[@id='summary']/div[33]/div[2]")).getText());

		ticketOverviewKeyModel.setKeyCompanyName(driver.findElement(By.xpath(".//*[@id='summary']/div[36]/div[2]")).getText());
		ticketOverviewKeyModel.setKeyContactPersonName(driver.findElement(By.xpath(".//*[@id='summary']/div[42]/div[2]")).getText());
		ticketOverviewKeyModel.setKeyPostalCode(driver.findElement(By.xpath(".//*[@id='summary']/div[37]/div[2]")).getText());
		ticketOverviewKeyModel.setKeyPlace(driver.findElement(By.xpath(".//*[@id='summary']/div[40]/div[2]")).getText());
		ticketOverviewKeyModel.setKeyEmailAddress(driver.findElement(By.xpath(".//*[@id='summary']/div[45]/div[2]")).getText());

		ticketOverviewOrderModel.setOrderNumber(driver.findElement(By.xpath(".//*[@id='summary']/div[47]/div[2]")).getText());
		ticketOverviewOrderModel.setTypeOfAmount(driver.findElement(By.xpath(".//*[@id='summary']/div[48]/div[2]")).getText());
		ticketOverviewOrderModel.setAdditionalReference(driver.findElement(By.xpath(".//*[@id='summary']/div[52]/div[2]")).getText());	
		ticketOverviewOrderModel.setCostCenter(driver.findElement(By.xpath(".//*[@id='summary']/div[49]/div[2]")).getText());
		ticketOverviewOrderModel.setCostCategory(driver.findElement(By.xpath(".//*[@id='summary']/div[50]/div[2]")).getText());
		ticketOverviewOrderModel.setManagementCode(driver.findElement(By.xpath(".//*[@id='summary']/div[51]/div[2]")).getText());

		ticketOverviewInvoiceModel.setInvoiceCompanyName(driver.findElement(By.xpath(".//*[@id='summary']/div[53]/div[2]")).getText());
		ticketOverviewInvoiceModel.setInvoiceDepartment(driver.findElement(By.xpath(".//*[@id='summary']/div[54]/div[2]")).getText());
		ticketOverviewInvoiceModel.setInvoicePostalCode(driver.findElement(By.xpath(".//*[@id='summary']/div[55]/div[2]")).getText());
		ticketOverviewInvoiceModel.setInvoicePlace(driver.findElement(By.xpath(".//*[@id='summary']/div[58]/div[2]")).getText());
		ticketOverviewInvoiceModel.setInvoiceCountry(driver.findElement(By.xpath(".//*[@id='summary']/div[59]/div[2]")).getText());
		ticketOverviewInvoiceModel.setInvoiceEmailAddress(driver.findElement(By.xpath(".//*[@id='summary']/div[60]/div[2]")).getText());

		System.out.println("BuildingUnit : " + ticketOverviewModel.getTicketBuildingUnit() + "\n" +
				"ShortDescription : " + ticketOverviewModel.getTicketShortDescription() + "\n" +
				"ReporterCompanyName : " + ticketOverviewReporterModel.getReporterCompanyName() + "\n" +
				"ReporterContactPersonName : " + ticketOverviewReporterModel.getReporterContactPersonName() + "\n" +
				"ReporterPhoneNumber : " + ticketOverviewReporterModel.getReporterPhoneNumber() + "\n" +
				"ReporterMobileNumber : " + ticketOverviewReporterModel.getReporterMobileNumber() + "\n" +
				"ReporterEmailAddress : " + ticketOverviewReporterModel.getReporterEmailAddress() + "\n" +
				"FailurePreciseLocation : " + ticketOverviewFailureModel.getFailurePreciseLocation() + "\n" +
				"FailureDetailedDescription : " + ticketOverviewFailureModel.getFailureDetailedDescription() + "\n" +
				"FailureMachineNumber : " + ticketOverviewFailureModel.getFailureMachineNumber() + "\n" +
				"FailureLocation : " + ticketOverviewFailureModel.getFailureLocation() + "\n" +
				"FailureSpace : " + ticketOverviewFailureModel.getFailureSpace() + "\n" +
				"FailurePriority : " + ticketOverviewFailureModel.getFailurePriority() + "\n" +
				"AppointmentCompanyName : " + ticketOverviewAppointmentModel.getAppointmentCompanyName() + "\n" +
				"AppointmentPostalCode : " + ticketOverviewAppointmentModel.getAppointmentPostalCode() + "\n" +
				"AppointmentPlace : " + ticketOverviewAppointmentModel.getAppointmentPlace() + "\n" +
				"AppointmentContactPersonName : " + ticketOverviewAppointmentModel.getAppointmentContactPersonName() + "\n" +
				"AppointmentEmailAddress : " + ticketOverviewAppointmentModel.getAppointmentEmailAddress() + "\n" +
				"KeyCompanyName : " + ticketOverviewKeyModel.getKeyCompanyName() + "\n" +
				"KeyContactPersonName : " + ticketOverviewKeyModel.getKeyContactPersonName() + "\n" +
				"KeyPostalCode : " + ticketOverviewKeyModel.getKeyPostalCode() + "\n" +
				"KeyPlace : " + ticketOverviewKeyModel.getKeyPlace() + "\n" +
				"KeyEmailAddress : " + ticketOverviewKeyModel.getKeyEmailAddress() + "\n" +
				"OrderNumber : " + ticketOverviewOrderModel.getOrderNumber() + "\n" +
				"TypeOfAmount : " + ticketOverviewOrderModel.getTypeOfAmount() + "\n" +
				"AdditionalReference : " + ticketOverviewOrderModel.getAdditionalReference() + "\n" +
				"CostCenter : " + ticketOverviewOrderModel.getCostCenter() + "\n" +
				"CostCategory : " + ticketOverviewOrderModel.getCostCategory() + "\n" +
				"ManagementCode : " + ticketOverviewOrderModel.getManagementCode() + "\n" +
				"InvoiceCompanyName : " + ticketOverviewInvoiceModel.getInvoiceCompanyName() + "\n" +
				"InvoiceDepartment : " + ticketOverviewInvoiceModel.getInvoiceDepartment() + "\n" +
				"InvoicePostalCode : " + ticketOverviewInvoiceModel.getInvoicePostalCode() + "\n" +
				"InvoicePlace : " + ticketOverviewInvoiceModel.getInvoicePlace() + "\n" +
				"InvoiceCountry : " + ticketOverviewInvoiceModel.getInvoiceCountry() + "\n" +
				"InvoiceEmailAddress : " + ticketOverviewInvoiceModel.getInvoiceEmailAddress());

		Thread.sleep(2000);	
		driver.findElement(By.xpath(".//*[@id='ticketApp']/div/button[3]")).click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading-overlay")));
		Thread.sleep(4000);
	}	

	@Then("^verify ticket reporter detail$")
	public void verify_ticket_reporter_detail() throws Throwable {

		VerifyTicketDetail.VerifyReporterDetails(driver, ticketOverviewReporterModel);
		Thread.sleep(2000);
	}

	@Then("^verify ticket failure detail$")
	public void verify_ticket_failure_detail() throws Throwable {

		driver.findElement(By.xpath(".//*[@id='container-main']/div[3]/div[1]/div/ul/li[2]/a")).click();
		Thread.sleep(1000);
		VerifyTicketDetail.VerifyFailureDetails(driver, ticketOverviewFailureModel);		
		Thread.sleep(2000);
	}

	@Then("^verify ticket key detail$")
	public void verify_ticket_key_detail() throws Throwable {

		VerifyTicketDetail.VerifyKeyDetails(driver, ticketOverviewKeyModel);
		Thread.sleep(3000);
	}

	@Then("^verify ticket appointment detail$")
	public void verify_ticket_appointment_detail() throws Throwable {

		driver.findElement(By.xpath(".//*[@id='container-main']/div[3]/div[1]/div/ul/li[3]/a")).click();
		Thread.sleep(1000);
		VerifyTicketDetail.VerifyAppointmentDetails(driver, ticketOverviewAppointmentModel);		
		Thread.sleep(3000);
	}

	@Then("^verify ticket order detail$")
	public void verify_ticket_order_detail() throws Throwable {

		driver.findElement(By.xpath(".//*[@id='container-main']/div[3]/div[1]/div/ul/li[7]/a")).click();
		Thread.sleep(1000);
		VerifyTicketDetail.VerifyOrderDetails(driver, flag, ticketOverviewOrderModel);
		Thread.sleep(2000);
	}

	@Then("^verify ticket invoice detail$")
	public void verify_ticket_invoice_detail() throws Throwable {

		VerifyTicketDetail.VerifyInvoiceDetails(driver, ticketOverviewInvoiceModel);	
		Thread.sleep(3000);
	}

	@Then("^verify ticket history detail$")
	public void verify_ticket_history_detail() throws Throwable {

		driver.findElement(By.xpath(".//*[@id='container-main']/div[3]/div[1]/div/ul/li[9]/a")).click();
		Thread.sleep(1000);
		String history = driver.findElement(By.xpath(".//*[@id='tab-page-history']/table/tbody/tr/td[2]/div")).getText();
		Assert.assertEquals(history,"Melding geregisteerd");
		System.out.println("History verified");
		Thread.sleep(2000);
	}

	@Then("^remove test suffix$")
	public void remove_test_suffix() throws Throwable {

		driver.findElement(By.xpath(".//*[@id='container-main']/div[1]/div[2]/div/a[4]")).click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading-overlay")));
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='checkwizard-navigation']/li[2]")).click();
		Thread.sleep(2000);
		ResetValue(".//*[@id='Ticket_ReporterCompanyName']");
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='Ticket_ReporterHouseNumber']")).clear();
		driver.findElement(By.xpath(".//*[@id='Ticket_ReporterHouseNumber']")).sendKeys("299");		
		Thread.sleep(1000);
		ResetValue(".//*[@id='Ticket_ReporterStreetName']");		
		Thread.sleep(1000);	
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(1000);
		ResetValue(".//*[@id='Ticket_ReporterCity']");
		Thread.sleep(1000);
		ResetValue(".//*[@id='Ticket_ReporterName']");
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='reporter-edit']/div[11]/div/div[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='checkwizard-next']")).click();
		Thread.sleep(1000);
		ResetValue(".//*[@id='Ticket_Description']");
		Thread.sleep(1000);
		ResetValue(".//*[@id='Ticket_Problems_0__LocationDescription']");
		Thread.sleep(1000);
		ResetValue(".//*[@id='Ticket_Problems_0__Description']");
		Thread.sleep(1000);
		js.executeScript("window.scrollBy(0,300)");
		Thread.sleep(1000);
		ResetValue(".//*[@id='Ticket_Problems_0__MachineNumber']");
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='checkwizard-next']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='ticketApp']/div/div[4]/div[2]/div[1]/div[1]/div/div[2]/div/label")).click();
		Thread.sleep(2000);
		ResetValue(".//*[@id='Ticket_AppointmentCompanyName']");
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='Ticket_AppointmentHouseNumber']")).clear();
		driver.findElement(By.xpath(".//*[@id='Ticket_AppointmentHouseNumber']")).sendKeys("299");		
		Thread.sleep(1000);
		js.executeScript("window.scrollBy(0,300)");
		Thread.sleep(1000);
		ResetValue(".//*[@id='Ticket_AppointmentStreetName']");
		Thread.sleep(1000);
		ResetValue(".//*[@id='Ticket_AppointmentCity']");
		Thread.sleep(1000);
		ResetValue(".//*[@id='Ticket_AppointmentName']");
		Thread.sleep(1000);
		js.executeScript("window.scrollBy(0,300)");
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='appointment-edit-other']/div[11]/div/div[1]/label")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='ticketApp']/div/div[4]/div[4]/div/div[1]/div/div[2]/div/label")).click();
		Thread.sleep(2000);
		ResetValue(".//*[@id='Ticket_KeyCompanyName']");
		Thread.sleep(1000);
		ResetValue(".//*[@id='Ticket_KeyHouseNumber']");
		Thread.sleep(1000);
		ResetValue(".//*[@id='Ticket_KeyStreet']");
		Thread.sleep(1000);
		js.executeScript("window.scrollBy(0,300)");
		Thread.sleep(1000);
		ResetValue(".//*[@id='Ticket_KeyCity']");
		Thread.sleep(1000);
		ResetValue(".//*[@id='Ticket_KeyName']");
		Thread.sleep(1000);
		ResetValue(".//*[@id='Ticket_KeyNote']");
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='checkwizard-next']")).click();
		Thread.sleep(1000);
		ResetValue(".//*[@id='Ticket_OrderNumber']");
		Thread.sleep(1000);
		ResetValue(".//*[@id='Ticket_ReferenceNumber']");
		Thread.sleep(1000);
		js.executeScript("window.scrollBy(0,700)");
		Thread.sleep(1000);
		ResetValue(".//*[@id='Ticket_InvoiceCompanyName']");
		Thread.sleep(1000);
		ResetValue(".//*[@id='Ticket_InvoiceDepartment']");
		Thread.sleep(1000);
		ResetValue(".//*[@id='Ticket_InvoiceHouseNumber']");
		Thread.sleep(1000);
		ResetValue(".//*[@id='Ticket_InvoiceStreetName']");
		Thread.sleep(1000);
		ResetValue(".//*[@id='Ticket_InvoiceCity']");
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='ticketApp']/div/div[5]/div/div[1]/div[12]/div/div/label")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='checkwizard-next']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='ticketApp']/div/button[3]")).click();
		Thread.sleep(4000);
		driver.close();
	}

	public void ResetValue(String xpath)
	{
		String value = driver.findElement(By.xpath(xpath)).getAttribute("value").replaceAll("Test", "").trim();
		driver.findElement(By.xpath(xpath)).clear();
		driver.findElement(By.xpath(xpath)).sendKeys(value);
	}
}