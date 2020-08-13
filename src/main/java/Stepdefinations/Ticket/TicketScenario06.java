package Stepdefinations.Ticket;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Models.Ticket.TicketAppointmentModel;
import Models.Ticket.TicketFailureModel;
import Models.Ticket.TicketInvoiceModel;
import Models.Ticket.TicketKeyModel;
import Models.Ticket.TicketModel;
import Models.Ticket.TicketOrderModel;
import Stepdefinations.Base;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TicketScenario06 extends Base {

	WebDriver driver;
	int supplierCount;
	TicketModel ticketModel = new TicketModel(TicketType.Delegated);
	TicketFailureModel ticketFailureModel = new TicketFailureModel(TicketType.Delegated);
	TicketAppointmentModel ticketAppointmentModel = new TicketAppointmentModel(TicketType.Delegated);
	TicketKeyModel ticketKeyModel = new TicketKeyModel(TicketType.Delegated);
	TicketOrderModel ticketOrderModel = new TicketOrderModel(TicketType.Delegated);
	TicketInvoiceModel ticketInvoiceModel = new TicketInvoiceModel();

	@Given("^user opens the url and logs in to Loek$")
	public void user_opens_the_url_and_logs_in_to_Loek() throws Throwable {
		SetProperty();
		driver = Login();
		wait = new WebDriverWait(driver, WebDriverWaitTimeout);
	}

	@When("^user goes to MyApplication and opens ticket app$")
	public void user_goes_to_MyApplication_and_opens_ticket_app() throws Throwable {

		GoToModule(Module.Ticket, driver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='checkwizard-navigation']/li[2]")));
		Thread.sleep(2000);		
		SelectTicketFromTicketList(driver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='container-main']/div[1]/div[1]/h1")));
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='container-main']/div[1]/div[2]/div/a[2]")).click();		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='container-main']/form/div/div[1]/h4")));
		Thread.sleep(2000);
	}

	@Then("^add and verify delegated order section data$")
	public void add_and_verify_delegated_order_section_data() throws Throwable {

		driver.findElement(By.xpath(".//*[@id='container-main']/form/div/div[1]/div[1]/div[1]/div[1]/div/div/div[1]")).click();
		Thread.sleep(1000);
		supplierCount = driver.findElements(By.xpath(".//*[@id='container-main']/form/div/div[1]/div[1]/div[1]/div[1]/div/div/div[2]/div/div")).size();
		System.out.println("supplierCount : " + supplierCount);
		if(supplierCount > 0)
		{
			driver.findElement(By.xpath(".//*[@id='container-main']/form/div/div[1]/div[1]/div[1]/div[1]/div/div/div[2]/div/div[1]")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath(".//*[@id='Ticket_Description']")).clear();
			driver.findElement(By.xpath(".//*[@id='Ticket_Description']")).sendKeys(ticketModel.getTicketShortDescription());
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
		else
		{
			System.out.println("No suppliers found");
			Thread.sleep(2000);
			driver.close();
		}
	}

	@Then("^add and verify delegated contact section data$")
	public void add_and_verify_delegated_contact_section_data() throws Throwable {

		if(supplierCount > 0)
		{
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
			js.executeScript("window.scrollBy(0,370)");
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
	}

	@Then("^add and verify delegated financial section data$")
	public void add_and_verify_delegated_financial_section_data() throws Throwable {

		if(supplierCount > 0)
		{
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
			Boolean invoice = driver.findElement(By.xpath(".//*[@id='invoice-other']/div[1]")).isDisplayed();
			System.out.println("invoice : " +invoice);
			if(invoice)
			{
				ticketInvoiceModel.setInvoiceCompanyName(driver.findElement(By.xpath(".//*[@id='Ticket_InvoiceCompanyName']")).getAttribute("value"));
				ticketInvoiceModel.setInvoiceDepartment(driver.findElement(By.xpath(".//*[@id='Ticket_InvoiceDepartment']")).getAttribute("value"));
				ticketInvoiceModel.setInvoicePostalCode(driver.findElement(By.xpath(".//*[@id='Ticket_InvoicePostalCode']")).getAttribute("value"));
				ticketInvoiceModel.setInvoicePlace(driver.findElement(By.xpath(".//*[@id='Ticket_InvoiceCity']")).getAttribute("value"));
				ticketInvoiceModel.setInvoiceCountry(driver.findElement(By.xpath(".//*[@id='invoice-other']/div[8]/div/div/div[1]/div")).getText());
				System.out.println("setInvoiceCountry : " + ticketInvoiceModel.getInvoiceCountry());
				ticketInvoiceModel.setInvoiceEmailAddress(driver.findElement(By.xpath(".//*[@id='Ticket_InvoiceEmail']")).getAttribute("value"));
			}
			else
			{
				ticketInvoiceModel.setInvoiceCompanyName(driver.findElement(By.xpath(".//*[@id='display-Ticket_DuplicatedInvoiceCompanyName']")).getText());
				ticketInvoiceModel.setInvoiceDepartment(driver.findElement(By.xpath(".//*[@id='display-Ticket_DuplicatedInvoiceDepartment']")).getText());
				ticketInvoiceModel.setInvoicePostalCode(driver.findElement(By.xpath(".//*[@id='display-Ticket_DuplicatedInvoicePostalCode']")).getText());
				ticketInvoiceModel.setInvoicePlace(driver.findElement(By.xpath(".//*[@id='display-Ticket_DuplicatedInvoiceCity']")).getText());
				ticketInvoiceModel.setInvoiceCountry(driver.findElement(By.xpath(".//*[@id='display-Ticket_DuplicatedInvoiceCountry']")).getText());
				ticketInvoiceModel.setInvoiceEmailAddress(driver.findElement(By.xpath(".//*[@id='display-Ticket_DuplicatedInvoiceEmail']")).getText());
			}
			driver.findElement(By.xpath(".//*[@id='checkwizard-submit']")).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='container-main']/div[2]/div[1]/h1")));
			Thread.sleep(2000);
		}
	}

	@Then("^verify delegated ticket failure details$")
	public void verify_delegated_ticket_failure_details() throws Throwable {

		if(supplierCount > 0)
		{
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
	}

	@Then("^verify delegated ticket key details$")
	public void verify_delegated_ticket_key_details() throws Throwable {

		if(supplierCount > 0)
		{
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,300)");
			Thread.sleep(2000);

			TicketKeyModel ticketDetailKeyModel = new TicketKeyModel();

			ticketDetailKeyModel.setKeyCompanyName(driver.findElement(By.xpath(".//*[@id='tab-page-problem']/div[3]/div[2]")).getText());
			ticketDetailKeyModel.setKeyContactPersonName(driver.findElement(By.xpath(".//*[@id='tab-page-problem']/div[4]/div[2]")).getText());
			ticketDetailKeyModel.setKeyPostalCode(driver.findElement(By.xpath(".//*[@id='tab-page-problem']/div[6]/div[2]")).getText());
			ticketDetailKeyModel.setKeyPlace(driver.findElement(By.xpath(".//*[@id='tab-page-problem']/div[7]/div[2]")).getText());
			ticketDetailKeyModel.setKeyEmailAddress(driver.findElement(By.xpath(".//*[@id='tab-page-problem']/div[10]/div[2]")).getText());

			Assert.assertEquals(ticketDetailKeyModel.getKeyCompanyName(), ticketKeyModel.getKeyCompanyName());
			System.out.println("Key Company Name verified");
			Assert.assertEquals(ticketDetailKeyModel.getKeyContactPersonName(), ticketKeyModel.getKeyContactPersonName());
			System.out.println("Key Contact Person Name verified");
			Assert.assertEquals(ticketDetailKeyModel.getKeyPostalCode(), ticketKeyModel.getKeyPostalCode());
			System.out.println("Key Postal Code verified");
			Assert.assertEquals(ticketDetailKeyModel.getKeyPlace(), ticketKeyModel.getKeyPlace());
			System.out.println("Key Place verified");
			Assert.assertEquals(ticketDetailKeyModel.getKeyEmailAddress(), ticketKeyModel.getKeyEmailAddress());
			System.out.println("Key Email Address verified");

			Thread.sleep(1000);
			js.executeScript("window.scrollBy(0,-300)");
			Thread.sleep(2000);
		}
	}

	@Then("^verify delegated ticket appointment details$")
	public void verify_delegated_ticket_appointment_details() throws Throwable {

		if(supplierCount > 0)
		{
			driver.findElement(By.xpath(".//*[@id='container-main']/div[4]/div[1]/div/ul/li[2]/a")).click();
			Thread.sleep(2000);
			VerifyTicketDetail.VerifyAppointmentDetails(driver, ticketAppointmentModel);
			Thread.sleep(2000);
		}
	}

	@Then("^verify delegated ticket order details$")
	public void verify_delegated_ticket_order_details() throws Throwable {

		if(supplierCount > 0)
		{
			driver.findElement(By.xpath(".//*[@id='container-main']/div[4]/div[1]/div/ul/li[5]/a")).click();
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
	}

	@Then("^verify delegated ticket invoice details$")
	public void verify_delegated_ticket_invoice_details() throws Throwable {

		if(supplierCount > 0)
		{
			VerifyTicketDetail.VerifyInvoiceDetails(driver, ticketInvoiceModel);
			Thread.sleep(2000);
		}
	}

	@Then("^verify delegated ticket history detail$")
	public void verify_delegated_ticket_history_detail() throws Throwable {

		if(supplierCount > 0)
		{
			driver.findElement(By.xpath(".//*[@id='container-main']/div[4]/div[1]/div/ul/li[7]/a")).click();
			Thread.sleep(2000);
			String history = driver.findElement(By.xpath(".//*[@id='tab-page-history']/table/tbody/tr/td[2]/div")).getText();
			Assert.assertEquals(history,"Opdracht verzonden");
			System.out.println("History verified");
			Thread.sleep(3000);
			driver.close();
		}
	}
}