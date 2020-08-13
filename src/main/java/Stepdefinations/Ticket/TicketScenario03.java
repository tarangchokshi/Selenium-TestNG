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

public class TicketScenario03 extends Base {

	WebDriver driver;
	Boolean flag = true;

	TicketModel ticketOverviewModel = new TicketModel();
	TicketReporterModel ticketOverviewReporterModel = new TicketReporterModel();
	TicketFailureModel ticketOverviewFailureModel = new TicketFailureModel();
	TicketAppointmentModel ticketOverviewAppointmentModel = new TicketAppointmentModel();
	TicketKeyModel ticketOverviewKeyModel = new TicketKeyModel();
	TicketOrderModel ticketOverviewOrderModel = new TicketOrderModel();
	TicketInvoiceModel ticketOverviewInvoiceModel = new TicketInvoiceModel();

	@Given("^Open url and login with valid credentials$")
	public void Open_url_and_login_with_valid_credentials() throws Throwable {
		SetProperty();
		driver = Login();
		wait = new WebDriverWait(driver,60);
	}

	@When("^User click on MyApplications and select ticket$")
	public void user_click_on_MyApplications_and_select_ticket() throws Throwable {		
		GoToModule(Module.Ticket, driver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='checkwizard-navigation']/li[2]")));
		Thread.sleep(2000);		
		SelectTicketFromTicketList(driver);
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='container-main']/div[1]/div[2]/div/a[4]")).click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading-overlay")));
		Thread.sleep(3000);
	}

	@Then("^go to detector section and update the data using address book$")
	public void go_to_detector_section_and_update_the_data_using_address_book() throws Throwable {

		driver.findElement(By.xpath(".//*[@id='checkwizard-navigation']/li[2]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='ticketApp']/div/div[2]/div[2]/div[1]/div[1]/div/div[2]/div/label")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='ticketApp']/div/div[2]/div[1]/div/h4/span")).click();
		OpenChildWindow(driver);		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='page-modal']/div/div/div[4]/div[2]")));
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='page-modal']/div/div/div[4]/div[2]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='page-modal']/div/div/div[5]/input[2]")).click();
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(2000);
		WebElement checkBoxSaveReporter = driver.findElement(By.xpath(".//*[@id='Ticket_SaveReporterBuildingContact']"));
		if(checkBoxSaveReporter.getAttribute("checked") == null) // if not Checked 
		{
			driver.findElement(By.xpath(".//*[@id='reporter-edit']/div[11]/div/div[2]/label")).click();
			Thread.sleep(2000);
		}
		driver.findElement(By.xpath(".//*[@id='checkwizard-next']")).click();
		Thread.sleep(2000);
	}

	@Then("^go to contact section and update the data using address book$")
	public void go_to_contact_section_and_update_the_data_using_address_book() throws Throwable {

		driver.findElement(By.xpath(".//*[@id='checkwizard-navigation']/li[4]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='ticketApp']/div/div[4]/div[2]/div[1]/div[1]/div/div[3]/div/label")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='ticketApp']/div/div[4]/div[1]/div/h4/span")).click();
		OpenChildWindow(driver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='page-modal']/div/div/div[4]/div[2]")));
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='page-modal']/div/div/div[4]/div[2]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='page-modal']/div/div/div[5]/input[2]")).click();
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)");
		Thread.sleep(2000);
		WebElement checkBoxSaveAppointment = driver.findElement(By.xpath(".//*[@id='Ticket_SaveAppointmentBuildingContact']"));
		if(checkBoxSaveAppointment.getAttribute("checked") == null) // if not Checked 
		{
			driver.findElement(By.xpath(".//*[@id='appointment-edit-other']/div[11]/div/div[2]/label")).click();
			Thread.sleep(2000);
		}

		driver.findElement(By.xpath(".//*[@id='ticketApp']/div/div[4]/div[4]/div/div[1]/div/div[2]/div/label")).click();
		Thread.sleep(1000);
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='ticketApp']/div/div[4]/div[3]/div/h4/span")).click();
		OpenChildWindow(driver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='page-modal']/div/div/div[4]/div[2]")));
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='page-modal']/div/div/div[4]/div[2]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='page-modal']/div/div/div[5]/input[2]")).click();
		Thread.sleep(3000);
		js.executeScript("window.scrollBy(0,300)");
		Thread.sleep(2000);
		WebElement checkBoxSaveKey = driver.findElement(By.xpath(".//*[@id='Ticket_SaveKeyContact']"));
		if(checkBoxSaveKey.getAttribute("checked") == null) // if not Checked 
		{
			driver.findElement(By.xpath(".//*[@id='key-required']/div[13]/div/div/label")).click();
			Thread.sleep(2000);
		}
		driver.findElement(By.xpath(".//*[@id='checkwizard-next']")).click();
		Thread.sleep(2000);

	}

	@Then("^go to financial section and update the data using address book$")
	public void go_to_financial_section_and_update_the_data_using_address_book() throws Throwable {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,650)");
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='ticketApp']/div/div[5]/div/div[1]/h4[3]/span")).click();
		OpenChildWindow(driver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='page-modal']/div/div/div[4]/div[2]")));
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='page-modal']/div/div/div[4]/div[2]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='page-modal']/div/div/div[5]/input[2]")).click();
		Thread.sleep(3000);
		WebElement checkBoxSaveInvoice = driver.findElement(By.xpath(".//*[@id='Ticket_SaveInvoiceAddress']"));
		if(checkBoxSaveInvoice.getAttribute("checked") == null) // if not Checked 
		{
			driver.findElement(By.xpath(".//*[@id='ticketApp']/div/div[5]/div/div[1]/div[12]/div/div/label")).click();
			Thread.sleep(2000);
		}
		driver.findElement(By.xpath(".//*[@id='checkwizard-next']")).click();
		Thread.sleep(2000);
	}

	@Then("^go to overview section and verify all the data$")
	public void go_to_overview_section_and_verify_all_the_data() throws Throwable {

		ticketOverviewModel.setTicketBuildingUnit(driver.findElement(By.xpath(".//*[@id='summary']/div[1]/div[2]")).getText());
		ticketOverviewModel.setTicketShortDescription(driver.findElement(By.xpath(".//*[@id='summary']/div[15]/div[2]")).getText());		

		ticketOverviewReporterModel.setReporterCompanyName(driver.findElement(By.xpath(".//*[@id='summary']/div[4]/div[2]")).getText());
		ticketOverviewReporterModel.setReporterContactPersonName(driver.findElement(By.xpath(".//*[@id='summary']/div[10]/div[2]")).getText());
		ticketOverviewReporterModel.setReporterPhoneNumber(driver.findElement(By.xpath(".//*[@id='summary']/div[11]/div[2]")).getText());
		ticketOverviewReporterModel.setReporterMobileNumber(driver.findElement(By.xpath(".//*[@id='summary']/div[12]/div[2]")).getText());
		ticketOverviewReporterModel.setReporterEmailAddress(driver.findElement(By.xpath(".//*[@id='summary']/div[13]/div[2]")).getText());

		ticketOverviewFailureModel.setFailurePreciseLocation(driver.findElement(By.xpath(".//*[@id='summary']/div[18]/div[2]")).getText());
		ticketOverviewFailureModel.setFailureDetailedDescription(driver.findElement(By.xpath(".//*[@id='summary']/div[19]/div[2]")).getText());		
		ticketOverviewFailureModel.setFailureMachineNumber(driver.findElement(By.xpath(".//*[@id='summary']/div[22]/div[2]")).getText());
		ticketOverviewFailureModel.setFailureLocation(driver.findElement(By.xpath(".//*[@id='summary']/div[16]/div[2]")).getText());
		ticketOverviewFailureModel.setFailureSpace(driver.findElement(By.xpath(".//*[@id='summary']/div[17]/div[2]")).getText());
		ticketOverviewFailureModel.setFailurePriority(driver.findElement(By.xpath(".//*[@id='summary']/div[20]/div[2]")).getText());

		ticketOverviewAppointmentModel.setAppointmentCompanyName(driver.findElement(By.xpath(".//*[@id='summary']/div[25]/div[2]")).getText());
		ticketOverviewAppointmentModel.setAppointmentPostalCode(driver.findElement(By.xpath(".//*[@id='summary']/div[26]/div[2]")).getText());
		ticketOverviewAppointmentModel.setAppointmentPlace(driver.findElement(By.xpath(".//*[@id='summary']/div[29]/div[2]")).getText());
		ticketOverviewAppointmentModel.setAppointmentContactPersonName(driver.findElement(By.xpath(".//*[@id='summary']/div[31]/div[2]")).getText());
		ticketOverviewAppointmentModel.setAppointmentEmailAddress(driver.findElement(By.xpath(".//*[@id='summary']/div[34]/div[2]")).getText());

		ticketOverviewKeyModel.setKeyCompanyName(driver.findElement(By.xpath(".//*[@id='summary']/div[38]/div[2]")).getText());
		ticketOverviewKeyModel.setKeyContactPersonName(driver.findElement(By.xpath(".//*[@id='summary']/div[44]/div[2]")).getText());
		ticketOverviewKeyModel.setKeyPostalCode(driver.findElement(By.xpath(".//*[@id='summary']/div[39]/div[2]")).getText());
		ticketOverviewKeyModel.setKeyPlace(driver.findElement(By.xpath(".//*[@id='summary']/div[42]/div[2]")).getText());
		ticketOverviewKeyModel.setKeyEmailAddress(driver.findElement(By.xpath(".//*[@id='summary']/div[47]/div[2]")).getText());

		ticketOverviewOrderModel.setOrderNumber(driver.findElement(By.xpath(".//*[@id='summary']/div[49]/div[2]")).getText());
		ticketOverviewOrderModel.setTypeOfAmount(driver.findElement(By.xpath(".//*[@id='summary']/div[50]/div[2]")).getText());
		ticketOverviewOrderModel.setAdditionalReference(driver.findElement(By.xpath(".//*[@id='summary']/div[54]/div[2]")).getText());	
		ticketOverviewOrderModel.setCostCenter(driver.findElement(By.xpath(".//*[@id='summary']/div[51]/div[2]")).getText());
		ticketOverviewOrderModel.setCostCategory(driver.findElement(By.xpath(".//*[@id='summary']/div[52]/div[2]")).getText());
		ticketOverviewOrderModel.setManagementCode(driver.findElement(By.xpath(".//*[@id='summary']/div[53]/div[2]")).getText());

		ticketOverviewInvoiceModel.setInvoiceCompanyName(driver.findElement(By.xpath(".//*[@id='summary']/div[55]/div[2]")).getText());
		ticketOverviewInvoiceModel.setInvoiceDepartment(driver.findElement(By.xpath(".//*[@id='summary']/div[56]/div[2]")).getText());
		ticketOverviewInvoiceModel.setInvoicePostalCode(driver.findElement(By.xpath(".//*[@id='summary']/div[57]/div[2]")).getText());
		ticketOverviewInvoiceModel.setInvoicePlace(driver.findElement(By.xpath(".//*[@id='summary']/div[60]/div[2]")).getText());
		ticketOverviewInvoiceModel.setInvoiceCountry(driver.findElement(By.xpath(".//*[@id='summary']/div[61]/div[2]")).getText());
		ticketOverviewInvoiceModel.setInvoiceEmailAddress(driver.findElement(By.xpath(".//*[@id='summary']/div[62]/div[2]")).getText());

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
		Thread.sleep(4000);
	}

	@Then("^verify ticket reporter data$")
	public void verify_ticket_reporter_data() throws Throwable {

		VerifyTicketDetail.VerifyReporterDetails(driver, ticketOverviewReporterModel);
		Thread.sleep(2000);
	}

	@Then("^verify ticket failure data$")
	public void verify_ticket_failure_data() throws Throwable {

		driver.findElement(By.xpath(".//*[@id='container-main']/div[3]/div[1]/div/ul/li[2]/a")).click();
		Thread.sleep(1000);
		VerifyTicketDetail.VerifyFailureDetails(driver, ticketOverviewFailureModel);		
		Thread.sleep(2000);
	}

	@Then("^verify ticket key data$")
	public void verify_ticket_key_data() throws Throwable {

		VerifyTicketDetail.VerifyKeyDetails(driver, ticketOverviewKeyModel);
		Thread.sleep(3000);
	}

	@Then("^verify ticket appointment data$")
	public void verify_ticket_appointment_data() throws Throwable {

		driver.findElement(By.xpath(".//*[@id='container-main']/div[3]/div[1]/div/ul/li[3]/a")).click();
		Thread.sleep(1000);
		VerifyTicketDetail.VerifyAppointmentDetails(driver, ticketOverviewAppointmentModel);		
		Thread.sleep(3000);
	}

	@Then("^verify ticket order data$")
	public void verify_ticket_order_data() throws Throwable {

		driver.findElement(By.xpath(".//*[@id='container-main']/div[3]/div[1]/div/ul/li[7]/a")).click();
		Thread.sleep(1000);
		VerifyTicketDetail.VerifyOrderDetails(driver, flag, ticketOverviewOrderModel);
		Thread.sleep(2000);
	}

	@Then("^verify ticket invoice data$")
	public void verify_ticket_invoice_data() throws Throwable {

		VerifyTicketDetail.VerifyInvoiceDetails(driver, ticketOverviewInvoiceModel);	
		Thread.sleep(3000);
	}

	@Then("^verify ticket history data$")
	public void verify_ticket_history_data() throws Throwable {

		driver.findElement(By.xpath(".//*[@id='container-main']/div[3]/div[1]/div/ul/li[9]/a")).click();
		Thread.sleep(1000);
		String history = driver.findElement(By.xpath(".//*[@id='tab-page-history']/table/tbody/tr/td[2]/div")).getText();
		Assert.assertEquals(history,"Melding geregisteerd");
		System.out.println("History verified");
		Thread.sleep(2000);
		driver.close();
	}






}