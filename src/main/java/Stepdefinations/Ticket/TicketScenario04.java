package Stepdefinations.Ticket;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Models.Ticket.InvoiceWorkorderModel;
import Models.Ticket.TicketAppointmentModel;
import Models.Ticket.TicketFailureModel;
import Models.Ticket.TicketInvoiceModel;
import Models.Ticket.TicketModel;
import Models.Ticket.WorkorderModel;
import Stepdefinations.Base;
import Stepdefinations.Base.Environment;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TicketScenario04 extends Base {

	public WebDriver driver;
	Boolean flag;
	String appointmentTitle;
	int initialCount;
	int finalCount;
	int size;

	TicketModel ticketModel = new TicketModel(TicketType.Performing);
	TicketInvoiceModel ticketInvoiceModel = new TicketInvoiceModel();
	TicketAppointmentModel ticketAppointmentModel = new TicketAppointmentModel(TicketType.Performing);
	TicketFailureModel ticketFailureModel = new TicketFailureModel(TicketType.Performing);
	WorkorderModel workorderModel = new WorkorderModel();

	@Given("^Open the url and login with valid credentials$")
	public void Open_the_url_and_login_with_valid_credentials() throws Throwable {
		SetProperty();
		driver = Login();
		wait = new WebDriverWait(driver, WebDriverWaitTimeout);
	}

	@When("^User clicks on MyApplications and selects ticket$")
	public void user_clicks_on_MyApplications_and_selects_ticket() throws Throwable {

		GoToModule(Module.Ticket, driver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='checkwizard-navigation']/li[2]")));
		Thread.sleep(2000);		
		SelectTicketFromTicketList(driver);
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='container-main']/div[1]/div[2]/div/a[1]")).click();		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='container-main']/form/div/div[1]/h4[1]")));
		Thread.sleep(2000);
	}

	public void select_ticket(String ticketReference) throws Throwable {

		List<WebElement> locatedElements = driver.findElements(By.xpath(".//*[@id='tickets-default']//div[@class='tree-table-part']")); 

		for(int i = 1; i<locatedElements.size() ; i++)
		{
			WebElement element = driver.findElement(By.xpath(".//*[@id='tickets-default']//div[@class='tree-table-part']["+i+"]"));
			if(element.isDisplayed())
			{
				System.out.println("datastatus  " + element.getAttribute("data-status"));			
				if(element.getAttribute("data-status").equals("New"))
				{
					String refNo = driver.findElement(By.xpath(".//*[@id='tickets-default']//div[@class='tree-table-part']["+i+"]/a/div[1]")).getText();
					System.out.println("locatedElement " + refNo);
					if(refNo.equals(ticketReference))
					{
						driver.findElement(By.xpath(".//*[@id='tickets-default']//div[@class='tree-table-part']["+i+"]/a")).click();
						break;
					}
				}
			}	
		}
		Thread.sleep(4000);
		driver.findElement(By.xpath(".//*[@id='container-main']/div[1]/div[2]/div/a[1]")).click();	
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='container-main']/form/div/div[1]/h4[1]")));
		Thread.sleep(1000);
	}

	@Then("^fill the details and save ticket$")
	public void fill_the_details_and_save_ticket() throws Throwable {

		driver.findElement(By.xpath(".//*[@id='container-main']/form/div/div[1]/div[1]/div[1]/div[1]/div/div/div[1]/div")).click();
		Thread.sleep(1000);
		if(CurrentEnvironment == Environment.Test)
		{
			driver.findElement(By.xpath(".//*[@id='container-main']/form/div/div[1]/div[1]/div[1]/div[1]/div/div/div[2]/div/div[2]")).click();
			Thread.sleep(1000);
		}
		else
		{
			driver.findElement(By.xpath(".//*[@id='container-main']/form/div/div[1]/div[1]/div[1]/div[1]/div/div/div[2]/div/div[1]")).click();
			Thread.sleep(1000);
		}
		driver.findElement(By.xpath(".//*[@id='Ticket_Description']")).clear();
		driver.findElement(By.xpath(".//*[@id='Ticket_Description']")).sendKeys(ticketModel.getTicketShortDescription());
		Thread.sleep(1000);	
		ticketFailureModel.setFailureLocation(driver.findElement(By.xpath(".//*[@id='container-main']/form/div/div[1]/div[2]/div[1]/div/div[1]/div[2]")).getText());
		System.out.println(ticketFailureModel.getFailureLocation());
		ticketFailureModel.setFailureSpace(driver.findElement(By.xpath(".//*[@id='container-main']/form/div/div[1]/div[2]/div[1]/div/div[2]/div[2]")).getText());
		System.out.println(ticketFailureModel.getFailureSpace());
		ticketFailureModel.setFailurePreciseLocation(driver.findElement(By.xpath(".//*[@id='container-main']/form/div/div[1]/div[2]/div[1]/div/div[3]/div[2]")).getText());
		System.out.println(ticketFailureModel.getFailurePreciseLocation());
		driver.findElement(By.xpath(".//*[@id='Ticket_Problems_0__Description']")).clear();
		driver.findElement(By.xpath(".//*[@id='Ticket_Problems_0__Description']")).sendKeys(ticketFailureModel.getFailureDetailedDescription());
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='container-main']/form/div/div[1]/div[2]/div[1]/div/div[6]/div[2]/div/div[1]/div")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='container-main']/form/div/div[1]/div[2]/div[1]/div/div[6]/div[2]/div/div[2]/div/div[2]")).click();
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)");
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='container-main']/form/div/div[1]/div[3]/div/div[1]/div/div/label")).click();
		Thread.sleep(1000);
		ticketAppointmentModel.setAppointmentCompanyName(driver.findElement(By.xpath(".//*[@id='NewAppointmentCompanyName']")).getAttribute("value"));
		System.out.println(ticketAppointmentModel.getAppointmentCompanyName());
		if(driver.findElement(By.xpath(".//*[@id='NewAppointmentName']")).getAttribute("value").isEmpty())				
		{
			ticketAppointmentModel.setAppointmentContactPersonName("Performing ticket contact person");
			driver.findElement(By.xpath(".//*[@id='NewAppointmentName']")).sendKeys(ticketAppointmentModel.getAppointmentContactPersonName());
			Thread.sleep(1000);
			System.out.println(ticketAppointmentModel.getAppointmentContactPersonName());
		}
		else
		{
			ticketAppointmentModel.setAppointmentContactPersonName(driver.findElement(By.xpath(".//*[@id='NewAppointmentName']")).getAttribute("value"));
			System.out.println(ticketAppointmentModel.getAppointmentContactPersonName());
		}
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(2000);
		ticketAppointmentModel.setAppointmentEmailAddress(driver.findElement(By.xpath(".//*[@id='NewAppointmentEmail']")).getAttribute("value"));
		System.out.println(ticketAppointmentModel.getAppointmentEmailAddress());
		driver.findElement(By.xpath(".//*[@id='NewAppointmentStartDate']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("./html/body/div[3]/div[1]/table/tbody/tr[3]/td[2]")).click();
		Thread.sleep(1000);	
		driver.findElement(By.xpath(".//*[@id='new-appointment']/div[5]/div/div[2]/div/label")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='NewAppointmentStartTime']")).sendKeys("01:00");
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='NewAppointmentEndTime']")).sendKeys("08:00");
		Thread.sleep(1000);
		appointmentTitle = driver.findElement(By.xpath(".//*[@id='NewAppointmentTitle']")).getAttribute("value");
		System.out.println(appointmentTitle);
		driver.findElement(By.xpath(".//*[@id='NewAppointmentTitle']")).getText();
		driver.findElement(By.xpath(".//*[@id='NewAppointmentDescription']")).sendKeys(ticketAppointmentModel.getAppointmentDescription());
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='new-appointment']/div[8]/div/a")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='NewAppointmentInternalDescription']")).sendKeys(ticketAppointmentModel.getAppointmentInternalDescription());
		Thread.sleep(1000);

		driver.findElement(By.xpath(".//*[@id='container-main']/form/div/input")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='container-main']/div[2]/div[1]/h1")));
		Thread.sleep(3000);
	}

	@Then("^verify performing ticket failure details$")
	public void verify_performing_ticket_failure_details() throws Throwable {

		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading-overlay")));
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
		Thread.sleep(3000);
	}

	@Then("^verify performing ticket appointment details$")
	public void verify_performing_ticket_appointment_details() throws Throwable {

		driver.findElement(By.xpath(".//*[@id='container-main']/div[4]/div[1]/div/ul/li[2]/a")).click();
		Thread.sleep(3000);
		String appointmentDetail = driver.findElement(By.xpath(".//*[@id='tab-page-appointment']/div/div[2]/div/div[2]")).getText();
		System.out.println(appointmentDetail);
		TicketAppointmentModel ticketDetailAppointmentModel = new TicketAppointmentModel();
		ticketDetailAppointmentModel.setAppointmentDescription(driver.findElement(By.xpath(".//*[@id='tab-page-appointment']/div/div[2]/div/div[3]")).getText());
		System.out.println(ticketDetailAppointmentModel.getAppointmentDescription());
		ticketDetailAppointmentModel.setAppointmentInternalDescription(driver.findElement(By.xpath(".//*[@id='tab-page-appointment']/div/div[2]/div/div[4]")).getText());
		System.out.println(ticketDetailAppointmentModel.getAppointmentInternalDescription());

		flag = true;
		if(!(appointmentDetail.contains("01:00")))
		{
			flag = false;
		}
		Assert.assertEquals(flag, true);
		System.out.println("Appointment Start Time verified");

		flag = true;
		if(!(appointmentDetail.contains("08:00")))
		{
			flag = false;
		}
		Assert.assertEquals(flag, true);
		System.out.println("Appointment End Time verified");

		flag = true;
		if(!(appointmentDetail.contains(appointmentTitle)))
		{
			flag = false;
		}
		Assert.assertEquals(flag, true);
		System.out.println("Appointment Title verified");

		flag = true;
		if(!(appointmentDetail.contains(ticketAppointmentModel.getAppointmentContactPersonName())))
		{
			flag = false;
		}
		Assert.assertEquals(flag, true);
		System.out.println("Appointment Contact Person Name verified");

		flag = true;
		if(!(appointmentDetail.contains(ticketAppointmentModel.getAppointmentCompanyName().trim())))
		{
			flag = false;
		}
		Assert.assertEquals(flag, true);
		System.out.println("Appointment Company Name verified");

		Assert.assertEquals(ticketDetailAppointmentModel.getAppointmentDescription(), ticketAppointmentModel.getAppointmentDescription());
		System.out.println("Appointment Description verified");

		Assert.assertEquals(ticketDetailAppointmentModel.getAppointmentInternalDescription(), ticketAppointmentModel.getAppointmentInternalDescription());
		System.out.println("Appointment Internal Description verified");
	}
	
	public int GetLocatedElementCount(String path)
	{
		int counter = 0;
		List<WebElement> locatedElements = driver.findElements(By.xpath(path)); 

		for(WebElement locatedElement: locatedElements)
		{   
			List<WebElement> innerElements = locatedElement.findElements(By.xpath("//td"));
			if(innerElements.size() != 1)
			{
				counter++;
			}
		}
		return counter;
	}

	@Then("^fill in workorder and verify data$")
	public void fill_in_workorder_and_verify_data() throws Throwable {

		driver.findElement(By.xpath(".//*[@id='container-main']/div[4]/div[1]/div/ul/li[4]/a")).click();
		Thread.sleep(1000);
		initialCount = GetLocatedElementCount(".//*[@id='workorder-travel']/table/tbody/tr");
		System.out.println("travel initialCount : " + initialCount);
		driver.findElement(By.xpath(".//*[@id='workorder-travel']/a")).click();
		OpenChildWindow(driver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='Travel_From']")));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading-overlay")));
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='Travel_Date']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("./html/body/div[5]/div[1]/table/tbody/tr[2]/td[4]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='Travel_From']")).sendKeys(workorderModel.getTravelDeparture());
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='Travel_To']")).sendKeys(workorderModel.getTravelArrival());
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='page-modal']/div/div/form/div[3]/input[2]")).click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading-overlay")));
		Thread.sleep(3000);
		finalCount = GetLocatedElementCount(".//*[@id='workorder-travel']/table/tbody/tr");
		System.out.println("travel finalCount : " + finalCount);
		Assert.assertEquals(initialCount < finalCount, true);
		System.out.println("Workorder travel added");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");
		Thread.sleep(2000);

		initialCount = GetLocatedElementCount(".//*[@id='workorder']/table/tbody/tr");
		System.out.println("transport initialCount : " + initialCount);
		driver.findElement(By.xpath(".//*[@id='workorder']/a[1]")).click();
		OpenChildWindow(driver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='Transport_MileageDeparture']")));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading-overlay")));
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='Transport_Date']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("./html/body/div[5]/div[1]/table/tbody/tr[2]/td[4]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='Transport_MileageDeparture']")).sendKeys(workorderModel.getTransportDeparture());
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='Transport_MileageArrival']")).sendKeys(workorderModel.getTransportArrival());
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='page-modal']/div/div/form/div[3]/input[2]")).click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading-overlay")));
		Thread.sleep(3000);
		finalCount = GetLocatedElementCount(".//*[@id='workorder']/table/tbody/tr");
		System.out.println("transport finalCount : " + finalCount);
		Assert.assertEquals(initialCount < finalCount, true);
		System.out.println("Workorder transport added");
		js.executeScript("window.scrollBy(0,400)");
		Thread.sleep(2000);

		initialCount = GetLocatedElementCount(".//*[@id='workorder']/table[2]/tbody/tr");
		System.out.println("work performed initialCount : " + initialCount);
		driver.findElement(By.xpath(".//*[@id='workorder']/a[2]")).click();
		OpenChildWindow(driver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='Work_From']")));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading-overlay")));
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='Work_Date']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("./html/body/div[5]/div[1]/table/tbody/tr[2]/td[4]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='Work_From']")).sendKeys(workorderModel.getWorkPerformedStartTime());
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='Work_To']")).sendKeys(workorderModel.getWorkPerformedEndTime());
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='Work_Description']")).sendKeys(workorderModel.getWorkPerformedActivities());
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='page-modal']/div/div/form/div[3]/input[2]")).click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading-overlay")));
		Thread.sleep(3000);
		finalCount = GetLocatedElementCount(".//*[@id='workorder']/table[2]/tbody/tr");
		System.out.println("work performed finalCount : " + finalCount);
		Assert.assertEquals(initialCount < finalCount, true);
		System.out.println("Workorder work performed added");
		js.executeScript("window.scrollBy(0,300)");
		Thread.sleep(2000);

		initialCount = GetLocatedElementCount(".//*[@id='workorder']/table[3]/tbody/tr");
		System.out.println("material initialCount : " + initialCount);
		driver.findElement(By.xpath(".//*[@id='workorder']/a[3]")).click();
		OpenChildWindow(driver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='Amount']")));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading-overlay")));
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='Amount']")).sendKeys(workorderModel.getMaterialSize());
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='page-modal']/div/div/form/div[3]/input[2]")).click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading-overlay")));
		Thread.sleep(3000);
		finalCount = GetLocatedElementCount(".//*[@id='workorder']/table[3]/tbody/tr");
		System.out.println("material finalCount : " + finalCount);
		Assert.assertEquals(initialCount < finalCount, true);
		System.out.println("Workorder material added");
		js.executeScript("window.scrollBy(0,300)");
		Thread.sleep(2000);

		initialCount = GetLocatedElementCount(".//*[@id='workorder']/table[4]/tbody/tr");
		System.out.println("miscellaneous initialCount : " + initialCount);
		driver.findElement(By.xpath(".//*[@id='workorder']/a[4]")).click();
		OpenChildWindow(driver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='Miscellaneous_Supplier']")));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading-overlay")));
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='Miscellaneous_Supplier']")).sendKeys(workorderModel.getMiscellaneousSupplier());
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='Miscellaneous_Description']")).sendKeys(workorderModel.getMiscellaneousDescription());
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='Miscellaneous_Amount']")).sendKeys(workorderModel.getMiscellaneousQuantity());
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='page-modal']/div/div/form/div[2]/div/div[4]/div/div/div[1]/div")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='page-modal']/div/div/form/div[2]/div/div[4]/div/div/div[2]/div/div[18]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='page-modal']/div/div/form/div[3]/input[2]")).click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading-overlay")));
		Thread.sleep(3000);
		finalCount = GetLocatedElementCount(".//*[@id='workorder']/table[4]/tbody/tr");
		System.out.println("miscellaneous finalCount : " + finalCount);
		Assert.assertEquals(initialCount < finalCount, true);
		System.out.println("Workorder miscellaneous added");
		js.executeScript("window.scrollBy(0,-900)");
		Thread.sleep(2000);
	}

	@Then("^verify performing ticket history details$")
	public void verify_performing_ticket_history_details() throws Throwable {

		driver.findElement(By.xpath(".//*[@id='container-main']/div[4]/div[1]/div/ul/li[7]/a")).click();
		Thread.sleep(3000);
		String history = driver.findElement(By.xpath(".//*[@id='tab-page-history']/table/tbody/tr[1]/td[2]/div")).getText();
		System.out.println(history);

		flag = true;
		if(!(history.contains(ticketAppointmentModel.getAppointmentContactPersonName())
				&& history.contains(ticketAppointmentModel.getAppointmentCompanyName())
				&& history.contains(appointmentTitle)))
		{
			flag = false;
		}
		Assert.assertEquals(flag, true);
		System.out.println("History verified");
	}

	@Then("^make performing and initial tickets report ready$")
	public void make_performing_and_initial_tickets_report_ready() throws Throwable {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-200)");
		Thread.sleep(2000);

		//click on report ready
		driver.findElement(By.xpath(".//*[@id='container-main']/div[2]/div[2]/div/a[2]")).click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading-overlay")));
		Thread.sleep(2000);
		String performingReportReadyStatus = driver.findElement(By.xpath(".//*[@id='container-main']/div[2]/div[1]/div/div[1]/div[3]/div[2]")).getText();
		Assert.assertEquals(performingReportReadyStatus, "Technisch gereed");
		System.out.println("Performing ticket report ready status verified");
		Thread.sleep(1000);
		//click on close workorder
		driver.findElement(By.xpath(".//*[@id='save-img']")).click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading-overlay")));
		Thread.sleep(2000);
		String performingCloseWorkorderstatus = driver.findElement(By.xpath(".//*[@id='container-main']/div[2]/div[1]/div/div[1]/div[3]/div[2]")).getText();
		Assert.assertEquals(performingCloseWorkorderstatus, "Afgerond");
		System.out.println("performing ticket close workorder status verified");
		Thread.sleep(1000);
		//click on initial ticket
		driver.findElement(By.xpath(".//*[@id='container-main']/div[1]/a")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='display-TicketNumberDisplay']")));
		Thread.sleep(2000);
		ticketModel.setTicketNumber(driver.findElement(By.xpath(".//*[@id='display-TicketNumberDisplay']")).getText());
		System.out.println("Ticket Number : " + ticketModel.getTicketNumber());
		Thread.sleep(1000);

		js.executeScript("window.scrollBy(0,100)");
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='container-main']/div[4]/div[1]/div/ul/li[7]/a")).click();
		Thread.sleep(1000);
		ticketInvoiceModel.setInvoiceCompanyName(driver.findElement(By.xpath(".//*[@id='display-InvoiceCompanyName']")).getText());
		ticketInvoiceModel.setInvoiceDepartment(driver.findElement(By.xpath(".//*[@id='display-InvoiceDepartment']")).getText());
		ticketInvoiceModel.setInvoicePostalCode(driver.findElement(By.xpath(".//*[@id='display-InvoicePostalCode']")).getText());
		ticketInvoiceModel.setInvoicePlace(driver.findElement(By.xpath(".//*[@id='display-InvoiceCity']")).getText());
		System.out.println(ticketInvoiceModel.getInvoiceCompanyName());
		System.out.println(ticketInvoiceModel.getInvoiceDepartment());
		System.out.println(ticketInvoiceModel.getInvoicePostalCode());
		System.out.println(ticketInvoiceModel.getInvoicePlace());
		System.out.println(ticketInvoiceModel.getInvoiceVatNumber());

		// click on initial ticket report ready
		driver.findElement(By.xpath(".//*[@id='container-main']/div[2]/div[2]/div/a[1]")).click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading-overlay")));
		Thread.sleep(3000);	
		String initialReportReadyStatus = driver.findElement(By.xpath(".//*[@id='container-main']/div[2]/div[1]/div/div[1]/div[4]/div[2]")).getText();
		Assert.assertEquals(initialReportReadyStatus, "Afgerond");
		System.out.println("Initial ticket report ready status verified");
		Thread.sleep(1000);
		// click on ready for billing
		driver.findElement(By.xpath(".//*[@id='container-main']/div[2]/div[2]/div/a[1]")).click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading-overlay")));
		Thread.sleep(3000);
		// click on invoice link
		driver.findElement(By.xpath(".//*[@id='container-main']/div[3]/a/div")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='display-TicketNumber']")));
		Thread.sleep(2000);
		TicketModel invoiceTicketModel = new TicketModel();
		invoiceTicketModel.setTicketNumber(driver.findElement(By.xpath(".//*[@id='display-TicketNumber']")).getText());
		Assert.assertEquals(invoiceTicketModel.getTicketNumber(), ticketModel.getTicketNumber());
		System.out.println("invoice created and verified");
	}

	@Then("^verify invoice specifications$")
	public void verify_invoice_specifications() throws Throwable {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,100)");
		Thread.sleep(2000);

		TicketInvoiceModel invoiceVerificationModel = new TicketInvoiceModel();

		invoiceVerificationModel.setInvoiceCompanyName(driver.findElement(By.xpath(".//*[@id='display-InvoiceCompanyName']")).getText());
		Assert.assertEquals(invoiceVerificationModel.getInvoiceCompanyName(), ticketInvoiceModel.getInvoiceCompanyName());
		System.out.println("invoice Company Name verified");
		invoiceVerificationModel.setInvoiceDepartment(driver.findElement(By.xpath(".//*[@id='display-InvoiceDepartment']")).getText());
		Assert.assertEquals(invoiceVerificationModel.getInvoiceDepartment(), ticketInvoiceModel.getInvoiceDepartment());
		System.out.println("invoice Department verified");
		invoiceVerificationModel.setInvoicePostalCode(driver.findElement(By.xpath(".//*[@id='display-InvoicePostalcode']")).getText());
		Assert.assertEquals(invoiceVerificationModel.getInvoicePostalCode(), ticketInvoiceModel.getInvoicePostalCode());
		System.out.println("invoice Postal Code verified");
		invoiceVerificationModel.setInvoicePlace(driver.findElement(By.xpath(".//*[@id='display-InvoicePlace']")).getText());
		Assert.assertEquals(invoiceVerificationModel.getInvoicePlace(), ticketInvoiceModel.getInvoicePlace());
		System.out.println("invoice Place verified");
		invoiceVerificationModel.setInvoiceVatNumber(driver.findElement(By.xpath(".//*[@id='display-InvoiceTaxNumber']")).getText());

		js.executeScript("window.scrollBy(0,900)");
		Thread.sleep(2000);
		
		initialCount = GetLocatedElementCount(".//*[@id='container-main']/div[5]/table[2]/tbody/tr");
		System.out.println("invoice work performed initialCount : " + initialCount);
		Assert.assertEquals(initialCount >= 1, true);
		System.out.println("invoice work performed verified");
		
		initialCount = GetLocatedElementCount(".//*[@id='container-main']/div[5]/table[3]/tbody/tr");
		System.out.println("invoice Travel initialCount : " + initialCount);
		Assert.assertEquals(initialCount >= 1, true);
		System.out.println("invoice Travel verified");
		
		js.executeScript("window.scrollBy(0,600)");
		Thread.sleep(2000);
		
		initialCount = GetLocatedElementCount(".//*[@id='container-main']/div[5]/table[4]/tbody/tr");
		System.out.println("invoice Transport initialCount : " + initialCount);
		Assert.assertEquals(initialCount >= 1, true);
		System.out.println("invoice Transport verified");
		
		initialCount = GetLocatedElementCount(".//*[@id='container-main']/div[5]/table[5]/tbody/tr");
		System.out.println("invoice Material initialCount : " + initialCount);
		Assert.assertEquals(initialCount >= 1, true);
		System.out.println("invoice Material verified");
		
		initialCount = GetLocatedElementCount(".//*[@id='container-main']/div[5]/table[6]/tbody/tr");
		System.out.println("invoice Miscellaneous initialCount : " + initialCount);
		Assert.assertEquals(initialCount >= 1, true);
		System.out.println("invoice Miscellaneous verified");
	}

	@Then("^add and verify invoice workorder$")
	public void add_and_verify_invoice_workorder() throws Throwable {

		InvoiceWorkorderModel invoiceWorkorderModel = new InvoiceWorkorderModel();
		InvoiceWorkorderModel verificationModel = new InvoiceWorkorderModel();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-900)");
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='container-main']/div[5]/div[1]/a")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='Work_Description']")));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading-overlay")));
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='Work_Description']")).clear();
		driver.findElement(By.xpath(".//*[@id='Work_Description']")).sendKeys(invoiceWorkorderModel.getGeneralDescription());
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='page-modal']/div/div/form/div[3]/input[2]")).click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading-overlay")));
		Thread.sleep(4000);
		verificationModel.setGeneralDescription(driver.findElement(By.xpath(".//*[@id='container-main']/div[5]/div[2]/span")).getText());
		Assert.assertEquals(invoiceWorkorderModel.getGeneralDescription(), verificationModel.getGeneralDescription());
		System.out.println("Invoice General Description added and verified");

		driver.findElement(By.xpath(".//*[@id='container-main']/div[5]/a[1]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='Description']")));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading-overlay")));
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='Description']")).sendKeys(invoiceWorkorderModel.getGeneralItemDescription());
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='page-modal']/div/div/form/div[2]/div/div[2]/div/div/div/div[1]/div")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='page-modal']/div/div/form/div[2]/div/div[2]/div/div/div/div[2]/div/div[4]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='Amount']")).clear();
		driver.findElement(By.xpath(".//*[@id='Amount']")).sendKeys(invoiceWorkorderModel.getGeneralSize());
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='UnitPrice']")).sendKeys(invoiceWorkorderModel.getGeneralPrice());
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='page-modal']/div/div/form/div[3]/input[2]")).click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading-overlay")));
		Thread.sleep(4000);
		verificationModel.setGeneralItemDescription(driver.findElement(By.xpath("(.//*[@id='container-main']/div[5]/table[1]/tbody/tr)[last()]/td[1]")).getText());
		Assert.assertEquals(invoiceWorkorderModel.getGeneralItemDescription(), verificationModel.getGeneralItemDescription());
		System.out.println("Invoice General data added and verified");
		js.executeScript("window.scrollBy(0,350)");
		Thread.sleep(2000);

		initialCount = GetLocatedElementCount(".//*[@id='container-main']/div[5]/table[2]/tbody/tr");
		System.out.println("invoice Labor initialCount : " + initialCount);
		driver.findElement(By.xpath(".//*[@id='container-main']/div[5]/a[2]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='Description']")));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading-overlay")));
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='Description']")).sendKeys(invoiceWorkorderModel.getLaborItemDescription());
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='page-modal']/div/div/form/div[2]/div/div[2]/div/div/div/div[1]")).click();
		Thread.sleep(1000);
		if(CurrentEnvironment == Environment.Test)
		{
			driver.findElement(By.xpath(".//*[@id='page-modal']/div/div/form/div[2]/div/div[2]/div/div/div/div[2]/div/div[2]")).click();
			Thread.sleep(1000);
		}
		else
		{
			driver.findElement(By.xpath(".//*[@id='page-modal']/div/div/form/div[2]/div/div[2]/div/div/div/div[2]/div/div[1]")).click();
			Thread.sleep(1000);
		}
		driver.findElement(By.xpath(".//*[@id='Start']")).sendKeys(invoiceWorkorderModel.getLaborFrom());
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='End']")).sendKeys(invoiceWorkorderModel.getLaborUntil());
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading-overlay")));
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='Amount']")).click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading-overlay")));
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='page-modal']/div/div/form/div[2]/div/div[7]/div/div/div/div/div[1]")).click();
		Thread.sleep(1000);
		size = driver.findElements(By.xpath(".//*[@id='page-modal']/div/div/form/div[2]/div/div[7]/div/div/div/div/div[2]/div/div")).size();
		if(size >= 1)
		{
			driver.findElement(By.xpath(".//*[@id='page-modal']/div/div/form/div[2]/div/div[7]/div/div/div/div/div[2]/div/div[1]")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath(".//*[@id='page-modal']/div/div/form/div[3]/input[@class='btn btn-default']")).click();
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading-overlay")));
			Thread.sleep(3000);
			finalCount = GetLocatedElementCount(".//*[@id='container-main']/div[5]/table[2]/tbody/tr");
			System.out.println("invoice Labor finalCount : " + finalCount);
			Assert.assertEquals(initialCount < finalCount, true);
			System.out.println("Invoice Labor data added and verified");
		}
		else
		{
			driver.findElement(By.xpath(".//*[@id='page-modal']/div/div/form/div[3]/input[1]")).click();
			Thread.sleep(1000);
			System.out.println("Invoice labor not added - Required field's value can't be filled");
		}

		initialCount = GetLocatedElementCount(".//*[@id='container-main']/div[5]/table[3]/tbody/tr");
		System.out.println("invoice Travel initialCount : " + initialCount);
		driver.findElement(By.xpath(".//*[@id='container-main']/div[5]/a[3]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='Description']")));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading-overlay")));
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='Description']")).sendKeys(invoiceWorkorderModel.getTravelItemDescription());
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='page-modal']/div/div/form/div[2]/div/div[2]/div/div/div/div[1]")).click();
		Thread.sleep(1000);
		if(CurrentEnvironment == Environment.Test)
		{
			driver.findElement(By.xpath(".//*[@id='page-modal']/div/div/form/div[2]/div/div[2]/div/div/div/div[2]/div/div[2]")).click();
			Thread.sleep(1000);
		}
		else
		{
			driver.findElement(By.xpath(".//*[@id='page-modal']/div/div/form/div[2]/div/div[2]/div/div/div/div[2]/div/div[1]")).click();
			Thread.sleep(1000);
		}
		driver.findElement(By.xpath(".//*[@id='Start']")).sendKeys(invoiceWorkorderModel.getTravelFrom());
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='End']")).sendKeys(invoiceWorkorderModel.getTravelUntil());
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading-overlay")));
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='Amount']")).click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading-overlay")));
		Thread.sleep(1000);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading-overlay")));
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='page-modal']/div/div/form/div[2]/div/div[7]/div/div/div/div/div[1]")).click();
		Thread.sleep(1000);
		size = driver.findElements(By.xpath(".//*[@id='page-modal']/div/div/form/div[2]/div/div[7]/div/div/div/div/div[2]/div/div")).size();
		if(size >= 1)
		{
			driver.findElement(By.xpath(".//*[@id='page-modal']/div/div/form/div[2]/div/div[7]/div/div/div/div/div[2]/div/div[1]")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath(".//*[@id='page-modal']/div/div/form/div[3]/input[@class='btn btn-default']")).click();
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading-overlay")));
			Thread.sleep(3000);
			finalCount = GetLocatedElementCount(".//*[@id='container-main']/div[5]/table[3]/tbody/tr");
			System.out.println("invoice Travel finalCount : " + finalCount);
			Assert.assertEquals(initialCount < finalCount, true);
			System.out.println("Invoice Travel data added and verified");
		}
		else
		{
			driver.findElement(By.xpath(".//*[@id='page-modal']/div/div/form/div[3]/input[1]")).click();
			Thread.sleep(1000);
			System.out.println("Invoice Travel not added - Required field's value can't be filled");
		}
		js.executeScript("window.scrollBy(0,550)");
		Thread.sleep(2000);

		initialCount = GetLocatedElementCount(".//*[@id='container-main']/div[5]/table[4]/tbody/tr");
		System.out.println("invoice Travel initialCount : " + initialCount);
		driver.findElement(By.xpath(".//*[@id='container-main']/div[5]/a[5]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='Description']")));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading-overlay")));
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='Description']")).sendKeys(invoiceWorkorderModel.getTransportItemDescription());
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='page-modal']/div/div/form/div[2]/div/div[2]/div/div/div/div[1]")).click();
		Thread.sleep(1000);
		if(CurrentEnvironment == Environment.Test)
		{
			driver.findElement(By.xpath(".//*[@id='page-modal']/div/div/form/div[2]/div/div[2]/div/div/div/div[2]/div/div[2]")).click();
			Thread.sleep(1000);
		}
		else
		{
			driver.findElement(By.xpath(".//*[@id='page-modal']/div/div/form/div[2]/div/div[2]/div/div/div/div[2]/div/div[1]")).click();
			Thread.sleep(1000);
		}
		driver.findElement(By.xpath(".//*[@id='Departure']")).sendKeys(invoiceWorkorderModel.getTransportDeparture());
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='Arrival']")).sendKeys(invoiceWorkorderModel.getTransportArrival());
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading-overlay")));
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='Amount']")).click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading-overlay")));
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='page-modal']/div/div/form/div[2]/div/div[7]/div/div/div/div/div[1]")).click();
		Thread.sleep(1000);
		size = driver.findElements(By.xpath(".//*[@id='page-modal']/div/div/form/div[2]/div/div[7]/div/div/div/div/div[2]/div/div")).size();
		if(size >= 1)
		{
			driver.findElement(By.xpath(".//*[@id='page-modal']/div/div/form/div[2]/div/div[7]/div/div/div/div/div[2]/div/div[1]")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath(".//*[@id='page-modal']/div/div/form/div[3]/input[@class='btn btn-default']")).click();
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading-overlay")));
			Thread.sleep(3000);
			finalCount = GetLocatedElementCount(".//*[@id='container-main']/div[5]/table[4]/tbody/tr");
			System.out.println("invoice Transport finalCount : " + finalCount);
			Assert.assertEquals(initialCount < finalCount, true);
			System.out.println("Invoice Transport data added and verified");
		}
		else
		{
			driver.findElement(By.xpath(".//*[@id='page-modal']/div/div/form/div[3]/input[1]")).click();
			Thread.sleep(1000);
			System.out.println("Invoice Transport not added - Required field's value can't be filled");
		}
		
		initialCount = GetLocatedElementCount(".//*[@id='container-main']/div[5]/table[5]/tbody/tr");
		System.out.println("invoice Material initialCount : " + initialCount);
		driver.findElement(By.xpath(".//*[@id='container-main']/div[5]/a[6]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='Amount']")));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading-overlay")));
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='Amount']")).sendKeys(invoiceWorkorderModel.getMaterialSize());
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='page-modal']/div/div/form/div[2]/div/div[7]/div/div/div[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='page-modal']/div/div/form/div[2]/div/div[7]/div/div/div[2]/div/div")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='page-modal']/div/div/form/div[3]/input[@class='btn btn-default']")).click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading-overlay")));
		Thread.sleep(3000);
		verificationModel.setMaterialSize(driver.findElement(By.xpath("(.//*[@id='container-main']/div[5]/table[5]/tbody/tr)[last()]/td[4]")).getText());
		Assert.assertEquals(invoiceWorkorderModel.getMaterialSize(), verificationModel.getMaterialSize());
		System.out.println("Invoice Material data added and verified");
		js.executeScript("window.scrollBy(0,350)");
		Thread.sleep(2000);

		driver.findElement(By.xpath(".//*[@id='container-main']/div[5]/a[7]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='Supplier']")));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading-overlay")));
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='Supplier']")).sendKeys(invoiceWorkorderModel.getMiscellaneousSupplier());
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='Item']")).sendKeys(invoiceWorkorderModel.getMiscellaneousItemDescription());
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='page-modal']/div/div/form/div[2]/div/div[3]/div/div/div[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='page-modal']/div/div/form/div[2]/div/div[3]/div/div/div[2]/div/div[6]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='Amount']")).sendKeys(invoiceWorkorderModel.getMiscellaneousSize());
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='UnitPrice']")).sendKeys(invoiceWorkorderModel.getMiscellaneousPrice());
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='page-modal']/div/div/form/div[3]/input[@class='btn btn-default']")).click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading-overlay")));
		Thread.sleep(3000);
		verificationModel.setMiscellaneousSupplier(driver.findElement(By.xpath("(.//*[@id='container-main']/div[5]/table[6]/tbody/tr)[last()]/td[1]")).getText());
		Assert.assertEquals(invoiceWorkorderModel.getMiscellaneousSupplier(), verificationModel.getMiscellaneousSupplier());
		System.out.println("Invoice Miscellaneous data added and verified");

		js.executeScript("window.scrollBy(0,-2000)");
		Thread.sleep(3000);
		if(driver.findElement(By.xpath(".//*[@id='container-main']/div[1]/div[2]/div/a[1]")).getText().contains("Factuurgegevens wijzigen"))
		{
			driver.findElement(By.xpath(".//*[@id='container-main']/div[1]/div[2]/div/a[1]")).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='CurrentInvoiceAddress_InvoiceCompanyName']")));
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading-overlay")));
			Thread.sleep(3000);
			driver.findElement(By.xpath(".//*[@id='CurrentInvoiceAddress_InvoiceCompanyName']")).sendKeys("Invoice company name");
			Thread.sleep(1000);
			driver.findElement(By.xpath(".//*[@id='CurrentInvoiceAddress_InvoiceDepartment']")).sendKeys("Invoice department name");
			Thread.sleep(1000);
			driver.findElement(By.xpath(".//*[@id='CurrentInvoiceAddress_InvoicePostalcode']")).sendKeys("2516BG");
			Thread.sleep(1000);
			driver.findElement(By.xpath(".//*[@id='CurrentInvoiceAddress_InvoiceHouseNumber']")).sendKeys("176");
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading-overlay")));
			Thread.sleep(2000);
			driver.findElement(By.xpath(".//*[@id='CurrentInvoiceAddress_InvoiceVatNumber']")).sendKeys("VATInvoice123");
			Thread.sleep(1000);
			driver.findElement(By.xpath(".//*[@id='page-modal']/div/div/form/div[3]/input[2]")).click();
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading-overlay")));
			Thread.sleep(4000);
		}
		driver.findElement(By.xpath(".//*[@id='container-main']/div[1]/div[2]/div/a[1]")).click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading-overlay")));
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='container-main']/div[1]/div[2]/div/a[3]")).click();
		Thread.sleep(9000);
		String invoiceText = driver.findElement(By.xpath(".//*[@id='container-main']/div[1]/div[1]/div[2]/div[2]")).getText();
		Assert.assertEquals(invoiceText, "Deze specificatie is gemarkeerd als gefactureerd.");
		System.out.println("Invoice marked as billed");
		driver.quit();
	}
}