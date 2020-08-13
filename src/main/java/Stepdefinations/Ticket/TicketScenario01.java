package Stepdefinations.Ticket;

import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Models.Ticket.TicketAppointmentModel;
import Models.Ticket.TicketFailureModel;
import Models.Ticket.TicketInvoiceModel;
import Models.Ticket.TicketModel;
import Models.Ticket.TicketOrderModel;
import Models.Ticket.TicketReporterModel;
import Stepdefinations.Base;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TicketScenario01 extends Base {

	WebDriver driver;
	Boolean flag = true;

	//data to add
	TicketModel ticketModel = new TicketModel(TicketType.Initial);	
	TicketFailureModel ticketFailureModel = new TicketFailureModel(TicketType.Initial);	
	TicketOrderModel ticketOrderModel = new TicketOrderModel(TicketType.Initial);

	//data to compare	
	TicketModel ticketOverviewModel = new TicketModel();
	TicketReporterModel ticketOverviewReporterModel = new TicketReporterModel();
	TicketFailureModel ticketOverviewFailureModel = new TicketFailureModel();
	TicketAppointmentModel ticketOverviewAppointmentModel = new TicketAppointmentModel();
	TicketOrderModel ticketOverviewOrderModel = new TicketOrderModel();
	TicketInvoiceModel ticketOverviewInvoiceModel = new TicketInvoiceModel();

	@Given("^Open the url and login with the valid data ticket$")
	public void Open_the_url_and_login_with_the_valid_data_ticket() throws Throwable {
		SetProperty();
		driver = Login();
		wait = new WebDriverWait(driver,60);
	}

	@When("^User click on the MyApplication and select the ticket$")
	public void user_click_on_the_MyApplication_and_select_the_ticket() throws Throwable {
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='navbar-pronectic']/ul[2]/li[2]/a")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='dropdown-applications-ticketapp']/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='container-main']/a")).click();
		Thread.sleep(2000);
	}

	@Then("^update the details$")
	public void update_the_details() throws Throwable {		
		
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading-overlay")));
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='buildingbrowser-buildingunits']/div/div[1]/input")).sendKeys("Sir Winston Churchillln 299");
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading-overlay")));
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//div[@data-id='"+ buildingUnitDataId +"']")).click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading-overlay")));
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='checkwizard-next']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='checkwizard-next']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='Ticket_Description']")).sendKeys(ticketModel.getTicketShortDescription());
		Thread.sleep(1000);
		int roomCount = driver.findElements(By.xpath("//*[@id='popout-']/ul/li")).size();
		System.out.println("roomCount : " + roomCount);
		if(roomCount > 1)
		{
			driver.findElement(By.xpath(".//*[@id='popout-']/div")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath(".//*[@id='popout-']/ul/li[1]")).click();
			Thread.sleep(1000);
		}
		driver.findElement(By.xpath(".//*[@id='Ticket_Problems_0__LocationDescription']")).sendKeys(ticketFailureModel.getFailurePreciseLocation());
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='Ticket_Problems_0__Description']")).clear();
		driver.findElement(By.xpath(".//*[@id='Ticket_Problems_0__Description']")).sendKeys(ticketFailureModel.getFailureDetailedDescription());
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");
		Thread.sleep(2000);
		if(driver.findElement(By.xpath(".//*[@id='problems']/div/div[6]/label")).getText().contains("Storing"))
		{
			driver.findElement(By.xpath(".//*[@id='problems']/div/div[6]/div/div/div[3]/ul/li[2]")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath(".//*[@id='problems']/div/div[6]/div/div/div[3]/ul/li[1]")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath(".//*[@id='problems']/div/div[6]/div/div/div[3]/ul/li[1]")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath(".//*[@id='problems']/div/div[6]/div/div/div[3]/ul/li[1]")).click();
			Thread.sleep(1000);
		}
		driver.findElement(By.xpath(".//*[@id='Ticket_Problems_0__MachineNumber']")).sendKeys(ticketFailureModel.getFailureMachineNumber());
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='ticketApp']/div/div[3]/div/div[1]/div[4]/div/div/div[2]")).click();
		ImportFile("\\src\\main\\java\\Resources\\BuildingUnit.jpg");		
		driver.findElement(By.xpath(".//*[@id='checkwizard-next']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='checkwizard-next']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='Ticket_OrderNumber']")).sendKeys(ticketOrderModel.getOrderNumber());
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='Ticket_OrderAmount']")).sendKeys(ticketOrderModel.getOrderAmount());
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='ticketApp']/div/div[5]/div/div[1]/div[4]/div/div/div[1]")).click();
		Thread.sleep(1000);
		int costCategoryCount = driver.findElements(By.xpath(".//*[@id='ticketApp']/div/div[5]/div/div[1]/div[4]/div/div/div[2]/div/div")).size();
		System.out.println("costCategoryCount : " + costCategoryCount);
		if(costCategoryCount > 0)
		{	
			driver.findElement(By.xpath(".//*[@id='ticketApp']/div/div[5]/div/div[1]/div[4]/div/div/div[2]")).click();
			Thread.sleep(1000);
		}
		driver.findElement(By.xpath(".//*[@id='Ticket_ReferenceNumber']")).sendKeys(ticketOrderModel.getAdditionalReference());
		Thread.sleep(1000);
		js.executeScript("window.scrollBy(0,100)");
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='ticketOrderFileUpload']/div/div/div[2]")).click();
		ImportFile("\\src\\main\\java\\Resources\\BuildingComplex.jpg");
		driver.findElement(By.xpath(".//*[@id='checkwizard-next']")).click();
		Thread.sleep(3000);
	}

	@Then("^verify overview data should be as inserted$")
	public void verify_overview_data_should_be_as_inserted() throws Throwable {

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

		ticketOverviewAppointmentModel.setAppointmentCompanyName(driver.findElement(By.xpath(".//*[@id='summary']/div[23]/div[2]")).getText());
		ticketOverviewAppointmentModel.setAppointmentPostalCode(driver.findElement(By.xpath(".//*[@id='summary']/div[24]/div[2]")).getText());
		ticketOverviewAppointmentModel.setAppointmentPlace(driver.findElement(By.xpath(".//*[@id='summary']/div[27]/div[2]")).getText());
		ticketOverviewAppointmentModel.setAppointmentContactPersonName(driver.findElement(By.xpath(".//*[@id='summary']/div[29]/div[2]")).getText());
		ticketOverviewAppointmentModel.setAppointmentEmailAddress(driver.findElement(By.xpath(".//*[@id='summary']/div[32]/div[2]")).getText());

		ticketOverviewOrderModel.setOrderNumber(driver.findElement(By.xpath(".//*[@id='summary']/div[34]/div[2]")).getText());
		ticketOverviewOrderModel.setTypeOfAmount(driver.findElement(By.xpath(".//*[@id='summary']/div[35]/div[2]")).getText());
		ticketOverviewOrderModel.setAdditionalReference(driver.findElement(By.xpath(".//*[@id='summary']/div[39]/div[2]")).getText());	
		ticketOverviewOrderModel.setCostCenter(driver.findElement(By.xpath(".//*[@id='summary']/div[36]/div[2]")).getText());
		ticketOverviewOrderModel.setCostCategory(driver.findElement(By.xpath(".//*[@id='summary']/div[37]/div[2]")).getText());
		ticketOverviewOrderModel.setManagementCode(driver.findElement(By.xpath(".//*[@id='summary']/div[38]/div[2]")).getText());

		ticketOverviewInvoiceModel.setInvoiceCompanyName(driver.findElement(By.xpath(".//*[@id='summary']/div[40]/div[2]")).getText());
		ticketOverviewInvoiceModel.setInvoiceDepartment(driver.findElement(By.xpath(".//*[@id='summary']/div[41]/div[2]")).getText());
		ticketOverviewInvoiceModel.setInvoicePostalCode(driver.findElement(By.xpath(".//*[@id='summary']/div[42]/div[2]")).getText());
		ticketOverviewInvoiceModel.setInvoicePlace(driver.findElement(By.xpath(".//*[@id='summary']/div[45]/div[2]")).getText());
		ticketOverviewInvoiceModel.setInvoiceCountry(driver.findElement(By.xpath(".//*[@id='summary']/div[46]/div[2]")).getText());
		ticketOverviewInvoiceModel.setInvoiceEmailAddress(driver.findElement(By.xpath(".//*[@id='summary']/div[47]/div[2]")).getText());	

		if(!(ticketOverviewModel.getTicketBuildingUnit().contains(ticketModel.getTicketBuildingUnit())))
		{
			flag = false;
		}
		Assert.assertEquals(flag, true);
		System.out.println("Building Unit verified successfully");
		Assert.assertEquals(ticketOverviewModel.getTicketShortDescription(), ticketModel.getTicketShortDescription());
		System.out.println("Short Description verified successfully");
		Assert.assertEquals(ticketOverviewFailureModel.getFailurePreciseLocation(), ticketFailureModel.getFailurePreciseLocation());
		System.out.println("Precise Location verified successfully");
		Assert.assertEquals(ticketOverviewFailureModel.getFailureDetailedDescription(), ticketFailureModel.getFailureDetailedDescription());
		System.out.println("Detailed Description verified successfully");
		Assert.assertEquals(ticketOverviewFailureModel.getFailureMachineNumber(), ticketFailureModel.getFailureMachineNumber());
		System.out.println("Machine Number verified successfully");
		Assert.assertEquals(ticketOverviewOrderModel.getOrderNumber(), ticketOrderModel.getOrderNumber());
		System.out.println("Order Number verified successfully");
		flag = true;
		if(!(ticketOverviewOrderModel.getTypeOfAmount().contains(ticketOrderModel.getOrderAmount())))
		{
			flag = false;
		}
		Assert.assertEquals(flag, true);
		System.out.println("Order Amount verified successfully");
		Assert.assertEquals(ticketOverviewOrderModel.getAdditionalReference(), ticketOrderModel.getAdditionalReference());
		System.out.println("Additional Reference verified successfully");
		Thread.sleep(2000);
	}

	@Then("^click on save and verify unit details$")
	public void click_on_save_and_verify_unit_details() throws Throwable {

		driver.findElement(By.xpath(".//*[@id='ticketApp']/div/button[3]")).click();		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='display-BuildingUnit_Address']")));
		Thread.sleep(1000);
		String currentUrl = driver.getCurrentUrl();
		if(currentUrl.contains("https://apptest.loekonline.nl/TicketApp/InitialTicket/Details"))
		{
			System.out.println("current url matched");
		}
		else
		{
			System.out.println("current url not matched");
		}

		TicketModel ticketDetailsModel = new TicketModel();
		ticketDetailsModel.setTicketBuildingUnit(driver.findElement(By.xpath(".//*[@id='display-BuildingUnit_Address']")).getText());

		flag = true;
		if(!(ticketDetailsModel.getTicketBuildingUnit().contains(ticketModel.getTicketBuildingUnit())))
		{
			flag = false;
		}
		Assert.assertEquals(flag, true);
		System.out.println("Building Unit verified successfully");
		Thread.sleep(1000);
	}

	@Then("^verify ticket building details$")
	public void verify_ticket_building_details() throws Throwable {

		driver.findElement(By.xpath(".//*[@id='display-Complex_Description']/a")).click();
		Thread.sleep(3000);
		String buildingComplexAddress = driver.findElement(By.xpath(".//*[@id='container-main']/div[2]/div[2]/h1")).getText();
		flag = true;
		if(!(buildingComplexAddress.toLowerCase().contains("regression test")))
		{
			flag = false;
		}
		Assert.assertEquals(flag, true);
		System.out.println("Successfully redirected to Buiding Complex");
		driver.navigate().back();
		Thread.sleep(2000);

		driver.findElement(By.xpath(".//*[@id='display-Building_Description']/a")).click();
		Thread.sleep(3000);
		String buildingAddress = driver.findElement(By.xpath(".//*[@id='container-main']/div[2]/div[2]/h1")).getText();
		flag = true;
		if(!(buildingAddress.toLowerCase().contains("kantoor, overige")))
		{
			flag = false;
		}
		Assert.assertEquals(flag, true);
		System.out.println("Successfully redirected to Building");
		driver.navigate().back();
		Thread.sleep(2000);

		driver.findElement(By.xpath(".//*[@id='display-BuildingUnit_Address']/a")).click();
		Thread.sleep(3000);
		String buildingUnitAddress = driver.findElement(By.xpath(".//*[@id='container-main']/div[2]/div[2]/h1")).getText();
		flag = true;
		if(!(buildingUnitAddress.toLowerCase().contains(ticketModel.getTicketBuildingUnit().toLowerCase())))
		{
			flag = false;
		}
		Assert.assertEquals(flag, true);
		System.out.println("Successfully redirected to Building Unit");
		driver.navigate().back();
		Thread.sleep(2000);
	}

	@Then("^verify ticket reporter details$")
	public void verify_ticket_reporter_details() throws Throwable {

		VerifyTicketDetail.VerifyReporterDetails(driver, ticketOverviewReporterModel);
		Thread.sleep(2000);
	}


	@Then("^verify ticket failure details$")
	public void verify_ticket_failure_details() throws Throwable {

		driver.findElement(By.xpath(".//*[@id='container-main']/div[3]/div[1]/div/ul/li[2]/a")).click();
		Thread.sleep(1000);
		VerifyTicketDetail.VerifyFailureDetails(driver, ticketOverviewFailureModel);		
		Thread.sleep(3000);
	}

	@Then("^verify ticket appointment details$")
	public void verify_ticket_appointment_details() throws Throwable {

		driver.findElement(By.xpath(".//*[@id='container-main']/div[3]/div[1]/div/ul/li[3]/a")).click();
		Thread.sleep(1000);
		VerifyTicketDetail.VerifyAppointmentDetails(driver, ticketOverviewAppointmentModel);		
		Thread.sleep(3000);
	}

	@Then("^verify the validation for ticket note$")
	public void verify_the_validation_for_ticket_note() throws Throwable {
		driver.findElement(By.xpath(".//*[@id='container-main']/div[3]/div[1]/div/ul/li[4]/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='tab-page-notes']/a")).click();
		OpenChildWindow(driver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='Note']")));
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='page-modal']/div/div/form/div[3]/font[2]/input")).click();
		WebElement expected = driver.findElement(By.xpath(".//*[@id='validation-tooltip']/div[2]"));
		Assert.assertEquals(expected.getText(),"Notitie is verplicht");
		if(expected.getText().equals("Notitie is verplicht"))
		{
			System.out.println("--------Testcase Passed -------");
		}
		else
		{
			System.out.println("--------Testcase Failed -------");
		}
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='page-modal']/div/div/form/div[3]/font[1]/input")).click();
		Thread.sleep(2000);
	}

	@Then("^add ticket note and verify data$")
	public void add_ticket_note_and_verify_data() throws Throwable {

		driver.findElement(By.xpath(".//*[@id='tab-page-notes']/a")).click();
		OpenChildWindow(driver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='Note']")));
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='Note']")).sendKeys("TC01 - Initial ticket note");
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='page-modal']/div/div/form/div[3]/font[2]/input")).click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading-overlay")));
		Thread.sleep(3000);		
		String note = driver.findElement(By.xpath(".//*[@id='tab-page-notes']/div/div[2]")).getText();
		Assert.assertEquals(note,"TC01 - Initial ticket note");
		System.out.println("Note added and verified");
		Thread.sleep(3000);
	}

	@Then("^remove ticket note$")
	public void remove_ticket_note() throws Throwable {
		List<WebElement> Elements =  driver.findElements(By.xpath("//*[@id='tab-page-notes']/div"));
		if(Elements.size() > 0)
		{
			driver.findElement(By.xpath(".//*[@id='tab-page-notes']/div[1]/div[1]/a[2]")).click();
			Thread.sleep(2000);
			Alert alert = driver.switchTo().alert();
			alert.accept();
			Thread.sleep(3000);
			System.out.println("Note removed");
		}
	}

	public boolean GetLocatedElement(String size)
	{
		List<WebElement> locatedElements = driver.findElements(By.xpath(".//*[@id='tab-page-material']/table/tbody/tr")); 
		WebElement lastElement = locatedElements.get(locatedElements.size() - 1);
		if(lastElement != null)
		{
			WebElement sizeElement = lastElement.findElements(By.xpath("//td")).get(2);			
			if(sizeElement.getText().equals(size))
			{
				return true;
			}
		}		
		return false;
	}

	@Then("^add ticket material and verify data$")
	public void add_ticket_material_and_verify_data() throws Throwable {

		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading-overlay")));
		driver.findElement(By.xpath(".//*[@id='container-main']/div[3]/div[1]/div/ul/li[5]/a")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='tab-page-material']/a")).click();
		OpenChildWindow(driver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='Amount']")));
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='Amount']")).clear();
		driver.findElement(By.xpath(".//*[@id='Amount']")).sendKeys("1");
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='page-modal']/div/div/form/div[3]/font[2]/font/input")).click();
		Thread.sleep(8000);
		Assert.assertEquals(GetLocatedElement("1,00"), true);
		System.out.println("Material added and verified");	
		Thread.sleep(3000);
	}

	@Then("^remove ticket material$")
	public void remove_ticket_material() throws Throwable {
		List<WebElement> trElements =  driver.findElements(By.xpath("//*[@id='tab-page-material']/table/tbody/tr"));
		if(trElements.size() > 0)
		{
			WebElement lastElement =  driver.findElement(By.xpath("(.//*[@id='tab-page-material']/table/tbody/tr)[last()]/td[last()]/a[last()]"));			
			if(lastElement != null)
			{
				lastElement.click();
				Thread.sleep(8000);
				System.out.println("Material Removed");
				Thread.sleep(2000);
			}
		}				
	}

	@Then("^verify ticket attachments$")
	public void verify_ticket_attachments() throws Throwable {

		driver.findElement(By.xpath(".//*[@id='container-main']/div[3]/div[1]/div/ul/li[6]/a")).click();
		Thread.sleep(1000);
		String attachment = driver.findElement(By.xpath(".//*[@id='tab-page-files']/div/div/div/div[2]/strong")).getText();
		Assert.assertEquals(attachment,"BuildingUnit");
		System.out.println("Attachment verified");
	}

	@Then("^verify ticket order details$")
	public void verify_ticket_order_details() throws Throwable {

		driver.findElement(By.xpath(".//*[@id='container-main']/div[3]/div[1]/div/ul/li[7]/a")).click();
		Thread.sleep(1000);
		VerifyTicketDetail.VerifyOrderDetails(driver, flag, ticketOverviewOrderModel);
		String orderAttachment = driver.findElement(By.xpath(".//*[@id='tab-page-financial']/div[2]/div/div/div[2]/strong")).getText();
		Assert.assertEquals(orderAttachment,"BuildingComplex");
		System.out.println("Order attachment verified");
	}

	@Then("^verify ticket invoice details$")
	public void verify_ticket_invoice_details() throws Throwable {

		VerifyTicketDetail.VerifyInvoiceDetails(driver, ticketOverviewInvoiceModel);		
		Thread.sleep(3000);
	}

	@Then("^verify ticket history details$")
	public void verify_ticket_history_details() throws Throwable {

		driver.findElement(By.xpath(".//*[@id='container-main']/div[3]/div[1]/div/ul/li[9]/a")).click();
		Thread.sleep(1000);
		String history = driver.findElement(By.xpath(".//*[@id='tab-page-history']/table/tbody/tr/td[2]/div")).getText();
		Assert.assertEquals(history,"Melding geregisteerd");
		System.out.println("History verified");
		Thread.sleep(2000);
		driver.close();
	}
}