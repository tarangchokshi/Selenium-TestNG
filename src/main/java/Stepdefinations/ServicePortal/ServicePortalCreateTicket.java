package Stepdefinations.ServicePortal;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Models.PortalCreateTicket;
import Stepdefinations.Base;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import junit.framework.Assert;

public class ServicePortalCreateTicket extends Base{

	WebDriver driver;
	String name;
	String company;
	String email;
	String ticketReference;
	PortalCreateTicket portalCreateTicket = new PortalCreateTicket();
	Stepdefinations.Ticket.TicketScenario04 ticketScenario04 = new Stepdefinations.Ticket.TicketScenario04();

	@Given("^Login with mail site and go to service portal > setting > find and click on portal url$")
	public void login_with_mail_site_and_go_to_service_portal_setting_find() throws Throwable {

		SetProperty();
		driver = Login();	
		wait = new WebDriverWait(driver,WebDriverWaitTimeout);
		GoToModule(Module.ServicePortal, driver);
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='navbar-pronectic']/ul[1]/li[4]/a")).click();
		Thread.sleep(1000);
		List<WebElement> locatedElements = driver.findElements(By.xpath(".//*[@id='container-main']/div/div[2]/table/tbody/tr")); 

		for(int i = 1; i<=locatedElements.size() ; i++)
		{
			String portalUrl = driver.findElement(By.xpath(".//*[@id='container-main']/div/div[2]/table/tbody/tr["+i+"]/td[3]/a")).getText();
			System.out.println("locatedElement " + portalUrl);
			if(portalUrl.contains("loekautomationbu"))
			{
				driver.findElement(By.xpath(".//*[@id='container-main']/div/div[2]/table/tbody/tr["+i+"]/td[3]/a")).click();
				break;
			}
		}
		OpenChildWindow(driver);
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='Email']")).sendKeys(portalCreateTicket.getEmail());
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='Password']")).sendKeys(portalCreateTicket.getPassword());
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='login']/form/div[3]/input")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='navbar-pronectic']/ul[1]/li[2]/a")));
		Thread.sleep(2000);
	}

	@Then("^verify that username and serviceportal page shown as expected$")
	public void verify_that_username_and_serviceportal_page_shown_as_expected() throws Throwable {

		String URL = driver.getCurrentUrl();
		System.out.println("Current URL::"+URL);
		Assert.assertEquals(URL, SiteUrl+"/Serviceportaal/loekautomationbu" );
		Thread.sleep(2000);
	}

	@Then("^go to my profile and get data$")
	public void go_to_my_profile_and_get_data() throws Throwable {

		driver.findElement(By.xpath(".//*[@id='navbar-pronectic']/ul[1]/li[2]/a")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("./html/body/div/h1")));
		Thread.sleep(2000);
		company = driver.findElement(By.xpath("./html/body/div/div[1]/div[2]")).getText();
		name = driver.findElement(By.xpath("./html/body/div/div[2]/div[2]")).getText();
		email = driver.findElement(By.xpath("./html/body/div/div[3]/div[2]")).getText();
		System.out.println("Name : " + name + "\n" + "Company : " + company + "\n" + "Email : " + email );
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='navbar-pronectic']/ul[1]/li[1]/a")).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("./html/body/div/div/div[1]/div[3]/div/div[2]/div/div[2]/a")));	
	}

	@Then("^check validation for creating ticket$")
	public void check_validation_for_creating_ticket() throws Throwable {

		Thread.sleep(1000);
		driver.findElement(By.xpath("html/body/div[1]/div/div[1]/div[3]/div/div[2]/div/div[2]/a")).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='checkwizard-next']"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='checkwizard-next']"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='checkwizard-next']"))).click();
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");
		Thread.sleep(2000);
		if(driver.findElement(By.xpath(".//*[@id='checkwizard-submit']")).isDisplayed())
		{
			driver.findElement(By.xpath(".//*[@id='checkwizard-submit']")).click();
		}
		else
		{
			System.out.println("Fill all the details first - Submit button not found");
		}
		Thread.sleep(4000);
		driver.findElement(By.xpath(".//*[@id='checkwizard-navigation']/li[1]")).click();
		Thread.sleep(2000);		
	}

	@Then("^fill address and ticket section detail$")
	public void fill_address_and_ticket_section_detail() throws Throwable {

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='checkwizard-next']"))).click();
		Thread.sleep(1000);
		if(driver.findElement(By.xpath(".//*[@id='popout-Room']/div")).isDisplayed())
		{
			driver.findElement(By.xpath(".//*[@id='popout-Room']/div")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath(".//*[@id='popout-Room']/ul/li")).click();
			Thread.sleep(1000);
		}
		driver.findElement(By.xpath(".//*[@id='LocationDescription']")).sendKeys(portalCreateTicket.getLocationDescription());
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='Subject']")).sendKeys(portalCreateTicket.getSubject());
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='Description']")).sendKeys(portalCreateTicket.getDescription());
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='checkwizard-page-ticket']/div/div[1]/div[4]/div/div[2]")).click();
		Thread.sleep(1000);
		ImportFile(portalCreateTicket.getImportimage());
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='checkwizard-next']"))).click();		
	} 

	@Then("^verify contact section data$")
	public void verify_contact_section_data() throws Throwable {

		Thread.sleep(2000);
		String contactCompany = driver.findElement(By.xpath(".//*[@id='AppointmentCompanyName']")).getAttribute("value");
		String contactName = driver.findElement(By.xpath(".//*[@id='AppointmentName']")).getAttribute("value");
		String contactEmail = driver.findElement(By.xpath(".//*[@id='AppointmentEmail']")).getAttribute("value");
		Thread.sleep(1000);
		Assert.assertEquals(contactCompany, company);
		System.out.println("Contact Company verified");
		Assert.assertEquals(contactName, name);
		System.out.println("Contact Name verified");
		Assert.assertEquals(contactEmail, email);
		System.out.println("Contact Email verified");
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='checkwizard-next']"))).click();
	}

	@Then("^verify the Overview detail and click on the send notification$")
	public void verify_the_detail_and_click_on_the_send_notification() throws Throwable {

		Thread.sleep(2000);
		Assert.assertEquals(driver.findElement(By.xpath(".//*[@id='summary']/div[1]/div[2]")).getText(),portalCreateTicket.getAddress());
		Assert.assertEquals(driver.findElement(By.xpath(".//*[@id='summary']/div[3]/div[2]")).getText(),portalCreateTicket.getPlace());
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		Assert.assertEquals(driver.findElement(By.xpath(".//*[@id='summary']/div[10]/div[2]")).getText(),portalCreateTicket.getAppointment());
		Assert.assertEquals(driver.findElement(By.xpath(".//*[@id='summary']/div[11]/div[2]")).getText(),portalCreateTicket.getCompany());
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='checkwizard-submit']"))).click();
	}

	@Then("^Verify that detail shown in the reported fault is correct or not$")
	public void verify_the_detail_filled_to_create_the_ticket_in_a_grid() throws Throwable {

		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[1]/div/div[1]/div[3]/div/div[1]/a[1]/div/div[2]"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='display-TicketNumberDisplay']")));
		Thread.sleep(2000);
		ticketReference = driver.findElement(By.xpath(".//*[@id='display-TicketNumberDisplay']")).getText();
		Assert.assertEquals(driver.findElement(By.xpath(".//*[@id='display-Address']")).getText(),portalCreateTicket.getAddress());
		Assert.assertEquals(driver.findElement(By.xpath(".//*[@id='display-PlaceName']")).getText(),portalCreateTicket.getPlace());
		Assert.assertEquals(driver.findElement(By.xpath(".//*[@id='display-Subject']")).getText(),portalCreateTicket.getSubject());
		Assert.assertEquals(driver.findElement(By.xpath(".//*[@id='display-Description']")).getText(),portalCreateTicket.getDescription());
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='page-modal']/div/div/div[3]/input"))).click();	
	}

	@Then("^verify the ticket in ticketapp$")
	public void verify_the_ticket_in_ticketapp() throws Throwable {

		driver.get(SiteUrl+"/TicketApp#New");
		Thread.sleep(4000);
		ticketScenario04.driver = driver;
		ticketScenario04.wait = new WebDriverWait(driver, WebDriverWaitTimeout);
		ticketScenario04.select_ticket(ticketReference);
	}

	@Then("^create performing ticket$")
	public void create_performing_ticket() throws Throwable {

		ticketScenario04.fill_the_details_and_save_ticket();
		ticketScenario04.verify_performing_ticket_failure_details();
		ticketScenario04.verify_performing_ticket_appointment_details();
		ticketScenario04.fill_in_workorder_and_verify_data();
		ticketScenario04.verify_performing_ticket_history_details();
		ticketScenario04.make_performing_and_initial_tickets_report_ready();
		ticketScenario04.verify_invoice_specifications();
		ticketScenario04.add_and_verify_invoice_workorder();
	}
}