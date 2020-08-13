package Stepdefinations.Ticket;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Models.Ticket.TicketAppointmentModel;
import Models.Ticket.TicketFailureModel;
import Models.Ticket.TicketKeyModel;
import Models.Ticket.TicketModel;
import Models.Ticket.TicketOrderModel;
import Stepdefinations.Base;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TicketScenario05 extends Base {

	WebDriver driver;
	TicketModel ticketModel = new TicketModel(TicketType.ExternalPerforming);
	TicketFailureModel ticketFailureModel = new TicketFailureModel(TicketType.ExternalPerforming);
	TicketAppointmentModel ticketAppointmentModel = new TicketAppointmentModel(TicketType.ExternalPerforming);
	TicketKeyModel ticketKeyModel = new TicketKeyModel(TicketType.ExternalPerforming);
	TicketOrderModel ticketOrderModel = new TicketOrderModel(TicketType.ExternalPerforming);

	@Given("^user opens the url and login with valid data$")
	public void user_opens_the_url_and_login_with_valid_data() throws Throwable {
		SetProperty();
		driver = Login();
		wait = new WebDriverWait(driver, WebDriverWaitTimeout);
	}

	@When("^user goes to MyApplication and opens ticket module$")
	public void user_goes_to_MyApplication_and_opens_ticket_module() throws Throwable {

		GoToModule(Module.Ticket, driver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='checkwizard-navigation']/li[2]")));
		Thread.sleep(2000);		
		SelectTicketFromTicketList(driver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='container-main']/div[1]/div[1]/h1")));
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='container-main']/div[1]/div[2]/div/a[3]")).click();		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='ExternalCompanyName']")));
		Thread.sleep(2000);
	}

	@Then("^add and verify order section data$")
	public void add_and_verify_order_section_data() throws Throwable {

		int companyCount = driver.findElements(By.xpath(".//*[@id='popout-ExternalCompanyId']")).size();
		System.out.println("companyCount : " + companyCount);
		if(companyCount >= 1)
		{
			driver.findElement(By.xpath(".//*[@id='popout-ExternalCompanyId']/div/div[2]")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath(".//*[@id='popout-ExternalCompanyId']/ul/li[2]")).click();
			Thread.sleep(1000);
			ticketModel.setContact(driver.findElement(By.xpath(".//*[@id='ExternalCompanyContactPerson']")).getAttribute("value"));
			ticketModel.setEmailAddress(driver.findElement(By.xpath(".//*[@id='ExternalCompanyEmail']")).getAttribute("value"));
			ticketModel.setCc(driver.findElement(By.xpath(".//*[@id='ExternalCompanyCCEmails']")).getAttribute("value"));
			ticketModel.setPhoneNumber(driver.findElement(By.xpath(".//*[@id='ExternalCompanyPhone']")).getAttribute("value"));
			Thread.sleep(1000);
		}
		else
		{
			driver.findElement(By.xpath(".//*[@id='ExternalCompanyName']")).sendKeys(ticketModel.getCompanyName());
			Thread.sleep(1000);
			driver.findElement(By.xpath(".//*[@id='ExternalCompanyContactPerson']")).sendKeys(ticketModel.getContact());
			Thread.sleep(1000);
			driver.findElement(By.xpath(".//*[@id='ExternalCompanyEmail']")).sendKeys(ticketModel.getEmailAddress());
			Thread.sleep(1000);
			driver.findElement(By.xpath(".//*[@id='ExternalCompanyCCEmails']")).sendKeys(ticketModel.getCc());
			Thread.sleep(1000);
			driver.findElement(By.xpath(".//*[@id='externalcompany-edit']/div[5]/div[1]/div/div[1]")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath(".//*[@id='externalcompany-edit']/div[5]/div[1]/div/div[2]/div/div[160]")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath(".//*[@id='ExternalCompanyPhone']")).sendKeys(ticketModel.getPhoneNumber());
			Thread.sleep(1000);
		}
		driver.findElement(By.xpath(".//*[@id='Description']")).clear();
		driver.findElement(By.xpath(".//*[@id='Description']")).sendKeys(ticketModel.getTicketShortDescription());
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(2000);
		ticketFailureModel.setFailureLocation(driver.findElement(By.xpath(".//*[@id='display-Ticket_Problems_ 0 __Location']")).getText());
		ticketFailureModel.setFailureSpace(driver.findElement(By.xpath(".//*[@id='display-Ticket_Problems_ 0 __Room']")).getText());
		ticketFailureModel.setFailurePreciseLocation(driver.findElement(By.xpath(".//*[@id='display-Ticket_Problems_ 0 __LocationDescription']")).getText());
		driver.findElement(By.xpath(".//*[@id='Ticket_Problems_0__Description']")).clear();
		driver.findElement(By.xpath(".//*[@id='Ticket_Problems_0__Description']")).sendKeys(ticketFailureModel.getFailureDetailedDescription());
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='checkwizard-next']")).click();
		Thread.sleep(2000);
	}

	@Then("^add and verify contact section data$")
	public void add_and_verify_contact_section_data() throws Throwable {

		ticketAppointmentModel.setAppointmentCompanyName(driver.findElement(By.xpath(".//*[@id='display-Ticket_AppointmentCompanyName']")).getText());
		ticketAppointmentModel.setAppointmentPostalCode(driver.findElement(By.xpath(".//*[@id='display-Ticket_AppointmentPostalCode']")).getText());
		ticketAppointmentModel.setAppointmentPlace(driver.findElement(By.xpath(".//*[@id='display-Ticket_AppointmentCity']")).getText());
		ticketAppointmentModel.setAppointmentContactPersonName(driver.findElement(By.xpath(".//*[@id='display-Ticket_AppointmentName']")).getText());
		ticketAppointmentModel.setAppointmentEmailAddress(driver.findElement(By.xpath(".//*[@id='display-Ticket_AppointmentEmail']")).getText());

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(2000);

		driver.findElement(By.xpath(".//*[@id='container-main']/form/div/div[2]/div[4]/div/div[1]/div/div[2]/div/label")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='key-other']/div[1]/div/div[2]/div/label")).click();
		Thread.sleep(1000);
		js.executeScript("window.scrollBy(0,350)");
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='Ticket_KeyCompanyName']")).clear();
		driver.findElement(By.xpath(".//*[@id='Ticket_KeyPostalCode']")).clear();
		driver.findElement(By.xpath(".//*[@id='Ticket_KeyHouseNumber']")).clear();
		driver.findElement(By.xpath(".//*[@id='Ticket_KeyStreet']")).clear();
		driver.findElement(By.xpath(".//*[@id='Ticket_KeyCity']")).clear();
		driver.findElement(By.xpath(".//*[@id='Ticket_KeyName']")).clear();
		driver.findElement(By.xpath(".//*[@id='Ticket_KeyPhone']")).clear();
		driver.findElement(By.xpath(".//*[@id='Ticket_KeyMobile']")).clear();
		driver.findElement(By.xpath(".//*[@id='Ticket_KeyEmail']")).clear();
		driver.findElement(By.xpath(".//*[@id='Ticket_KeyNote']")).clear();
		driver.findElement(By.xpath(".//*[@id='Ticket_KeyCompanyName']")).sendKeys(ticketKeyModel.getKeyCompanyName());
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='Ticket_KeyPostalCode']")).sendKeys(ticketKeyModel.getKeyPostalCode());
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='Ticket_KeyHouseNumber']")).sendKeys(ticketKeyModel.getKeyHouseNumber());
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading-overlay")));
		Thread.sleep(3000);
		ticketKeyModel.setKeyPlace(driver.findElement(By.xpath(".//*[@id='Ticket_KeyCity']")).getAttribute("value"));
		driver.findElement(By.xpath(".//*[@id='Ticket_KeyName']")).sendKeys(ticketKeyModel.getKeyContactPersonName());
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='Ticket_KeyPhone']")).sendKeys(ticketKeyModel.getKeyPhoneNumber());
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='Ticket_KeyMobile']")).sendKeys(ticketKeyModel.getKeyMobileNumber());
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='Ticket_KeyEmail']")).sendKeys(ticketKeyModel.getKeyEmailAddress());
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='Ticket_KeyNote']")).sendKeys(ticketKeyModel.getKeyNote());
		Thread.sleep(1000);
		js.executeScript("window.scrollBy(0,350)");
		Thread.sleep(2000);

		driver.findElement(By.xpath(".//*[@id='container-main']/form/div/div[2]/div[6]/div/div[1]/div/div[1]/div/label")).click();
		Thread.sleep(1000);
		js.executeScript("window.scrollBy(0,300)");
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='checkwizard-next']")).click();
		Thread.sleep(2000);
	}

	@Then("^add and verify financial section data$")
	public void add_and_verify_financial_section_data() throws Throwable {

		driver.findElement(By.xpath(".//*[@id='Ticket_OrderNumber']")).clear();
		driver.findElement(By.xpath(".//*[@id='Ticket_OrderNumber']")).sendKeys(ticketOrderModel.getOrderNumber());
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='orderdata-other']/div[2]/div/div/div[1]/div/div[1]/div")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='orderdata-other']/div[2]/div/div/div[1]/div/div[2]/div/div[2]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='Ticket_ManagementCode']")).clear();
		driver.findElement(By.xpath(".//*[@id='Ticket_ManagementCode']")).sendKeys(ticketOrderModel.getManagementCode());
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='Ticket_ReferenceNumber']")).clear();
		driver.findElement(By.xpath(".//*[@id='Ticket_ReferenceNumber']")).sendKeys(ticketOrderModel.getAdditionalReference());
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='checkwizard-next']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='checkwizard-submit']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='container-main']/div[2]/div[1]/h1")));
		Thread.sleep(2000);
	}

	@Then("^verify external performing ticket failure details$")
	public void verify_external_performing_ticket_failure_details() throws Throwable {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");
		Thread.sleep(2000);
		TicketFailureModel ticketDetailFailureModel = new TicketFailureModel();
		String element = driver.findElement(By.xpath(".//*[@id='tab-page-problem']/div[2]/div/div[1]/div[1]")).getText();
		if(element.equalsIgnoreCase("Vakgebied"))
		{
			ticketDetailFailureModel.setFailureLocation(driver.findElement(By.xpath(".//*[@id='tab-page-problem']/div[2]/div/div[5]/div[2]")).getText());
			ticketDetailFailureModel.setFailurePreciseLocation(driver.findElement(By.xpath(".//*[@id='tab-page-problem']/div[2]/div/div[6]/div[2]")).getText());
			ticketDetailFailureModel.setFailureSpace(driver.findElement(By.xpath(".//*[@id='tab-page-problem']/div[2]/div/div[7]/div[2]")).getText()); 
			ticketDetailFailureModel.setFailureDetailedDescription(driver.findElement(By.xpath(".//*[@id='tab-page-problem']/div[2]/div/div[9]/div[2]")).getText());
		}
		else
		{
			ticketDetailFailureModel.setFailureLocation(driver.findElement(By.xpath(".//*[@id='tab-page-problem']/div[2]/div/div[1]/div[2]")).getText());
			ticketDetailFailureModel.setFailurePreciseLocation(driver.findElement(By.xpath(".//*[@id='tab-page-problem']/div[2]/div/div[2]/div[2]")).getText());
			ticketDetailFailureModel.setFailureSpace(driver.findElement(By.xpath(".//*[@id='tab-page-problem']/div[2]/div/div[3]/div[2]")).getText()); 
			ticketDetailFailureModel.setFailureDetailedDescription(driver.findElement(By.xpath(".//*[@id='tab-page-problem']/div[2]/div/div[5]/div[2]")).getText());
		}
		Assert.assertEquals(ticketDetailFailureModel.getFailureLocation(), ticketFailureModel.getFailureLocation());
		System.out.println("Failure Location verified");
		Assert.assertEquals(ticketDetailFailureModel.getFailurePreciseLocation(), ticketFailureModel.getFailurePreciseLocation());
		System.out.println("Failure Precise Location verified");
		Assert.assertEquals(ticketDetailFailureModel.getFailureSpace(), ticketFailureModel.getFailureSpace());
		System.out.println("Failure Space verified");
		Assert.assertEquals(ticketDetailFailureModel.getFailureDetailedDescription(), ticketFailureModel.getFailureDetailedDescription());
		System.out.println("Failure Detailed Description verified");
	}

	@Then("^verify external performing ticket key details$")
	public void verify_external_performing_ticket_key_details() throws Throwable {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");
		Thread.sleep(2000);
		VerifyTicketDetail.VerifyKeyDetails(driver, ticketKeyModel);
		Thread.sleep(1000);
		js.executeScript("window.scrollBy(0,-300)");
		Thread.sleep(2000);
	}

	@Then("^verify external performing ticket appointment details$")
	public void verify_external_performing_ticket_appointment_details() throws Throwable {

		driver.findElement(By.xpath(".//*[@id='container-main']/div[4]/div[1]/div/ul/li[2]/a")).click();
		Thread.sleep(2000);
		VerifyTicketDetail.VerifyAppointmentDetails(driver, ticketAppointmentModel);
		Thread.sleep(2000);
	}

	@Then("^verify external performing ticket order details$")
	public void verify_external_performing_ticket_order_details() throws Throwable {

		driver.findElement(By.xpath(".//*[@id='container-main']/div[4]/div[1]/div/ul/li[4]/a")).click();
		Thread.sleep(2000);
		TicketOrderModel ticketOrderDetailModel = new TicketOrderModel();
		ticketOrderDetailModel.setOrderNumber(driver.findElement(By.xpath(".//*[@id='display-OrderNumber']")).getText());
		ticketOrderDetailModel.setManagementCode(driver.findElement(By.xpath(".//*[@id='display-ManagementCode']")).getText());
		ticketOrderDetailModel.setAdditionalReference(driver.findElement(By.xpath(".//*[@id='display-ReferenceNumber']")).getText());
		Assert.assertEquals(ticketOrderDetailModel.getOrderNumber(),ticketOrderModel.getOrderNumber());
		System.out.println("Order Number verified");
		Assert.assertEquals(ticketOrderDetailModel.getManagementCode(),ticketOrderModel.getManagementCode());
		System.out.println("Management Code verified");
		Assert.assertEquals(ticketOrderDetailModel.getAdditionalReference(),ticketOrderModel.getAdditionalReference());
		System.out.println("Additional Reference verified");
	}

	@Then("^verify external performing ticket history detail$")
	public void verify_external_performing_ticket_history_detail() throws Throwable {

		driver.findElement(By.xpath(".//*[@id='container-main']/div[4]/div[1]/div/ul/li[8]/a")).click();
		Thread.sleep(2000);
		String history = driver.findElement(By.xpath(".//*[@id='tab-page-history']/table/tbody/tr/td[2]/div")).getText();
		Assert.assertEquals(history,"Opdracht ontvangen / aangemaakt");
		System.out.println("History verified");
		Thread.sleep(3000);
		driver.close();
	}
}