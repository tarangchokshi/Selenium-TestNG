package Stepdefinations.BuildingComplex;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Models.BuildingComplex.AddComplexModel;
import Models.BuildingComplex.ComplexContactModel;
import Models.BuildingComplex.ComplexInvoiceAddressModel;
import Models.BuildingComplex.ComplexKeyAddressModel;
import Stepdefinations.Base;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ComplexAdd extends Base{
	
	WebDriver driver;
	int initialCount;
	int finalCount;
	AddComplexModel modelAddComplex=new AddComplexModel();
	ComplexContactModel modelComplexContact=new ComplexContactModel();
	ComplexInvoiceAddressModel modelComplexInvoiceAddress=new ComplexInvoiceAddressModel();
	ComplexKeyAddressModel modelComplexKeyAddress=new ComplexKeyAddressModel();
	boolean isComplexAdded = false;

	@Given("^Open the application URL and login$")
	public void open_the_application_URL_and_login() throws Throwable {

		SetProperty();
		driver = Login();
		wait = new WebDriverWait(driver,WebDriverWaitTimeout);
	}

	@When("^User click on the MyApplication and select the building app$")
	public void user_click_on_the_MyApplication_and_select_the_building_app() throws Throwable {

		GoToModule(Module.Building,driver);
	}

	@Then("^verify validation for adding complex$")
	public void verify_validation_for_adding_complex() throws Throwable {
		
		isComplexAdded = GoToComplex(modelAddComplex.getComplexName() + " " + modelAddComplex.getDescription());		
		System.out.println("isComplexAdded " + isComplexAdded);
		if(!isComplexAdded)
		{
			driver.findElement(By.xpath(".//*[@id='add-complex-button']")).click();
			OpenChildWindow(driver);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='page-modal']/div/div/form/div[3]/input[2]")));
			Thread.sleep(2000);
			driver.findElement(By.xpath(".//*[@id='page-modal']/div/div/form/div[3]/input[2]")).click();
			WebElement expected = driver.findElement(By.xpath(".//*[@id='validation-tooltip']/div[2]"));
			Assert.assertEquals(expected.getText(),"Complex is een verplicht veld");
			if(expected.getText().equals("Complex is een verplicht veld"))
			{
				System.out.println("--------Testcase Passed -------");
			}
			else
			{
				System.out.println("--------Testcase Failed -------");
			}
			Thread.sleep(3000);
			driver.findElement(By.xpath(".//*[@id='page-modal']/div/div/form/div[3]/input[1]")).click();
			Thread.sleep(3000);
		}		
		else
		{
			System.out.println("--------Complex is already available-------");
		}
	}

	@Then("^user add and verify the complex$")
	public void user_add_and_verify_the_complex() throws Throwable {
		if(!isComplexAdded)
		{
			driver.findElement(By.xpath(".//*[@id='add-complex-button']")).click();
			OpenChildWindow(driver);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='ComplexName']")));
			Thread.sleep(2000);
			driver.findElement(By.xpath(".//*[@id='ComplexName']")).sendKeys(modelAddComplex.getComplexName());
			Thread.sleep(1000);
			driver.findElement(By.xpath(".//*[@id='page-modal']/div/div/form/div[3]/input[2]")).click();
			Thread.sleep(8000);
			String complexName = driver.findElement(By.xpath(".//*[@id='container-main']/div[2]/div[2]/h1")).getText();
			System.out.println(complexName.toLowerCase());
			Assert.assertEquals(complexName.toLowerCase(),modelAddComplex.getComplexName().toLowerCase());
			System.out.println("Complex added successfully");	
		}
		else
		{
			System.out.println("--------Complex is already available-------");
		}
	}

	@Then("^modify the general data of complex$")
	public void modify_the_general_data_of_complex() throws Throwable {

		driver.findElement(By.xpath(".//*[@id='container-main']/div[2]/div[3]/div/a[1]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='container-main']/div/div[2]/h1")));
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='Description']")).clear();
		driver.findElement(By.xpath(".//*[@id='Description']")).sendKeys(modelAddComplex.getComplexName() + " " + modelAddComplex.getDescription());
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='container-main']/div/div[1]/div")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='image-uploader-menu-default-upload']")).click();
		Thread.sleep(1000);
		ImportFile("\\src\\main\\java\\Resources\\BuildingComplex.jpg");
		Thread.sleep(5000);
		driver.findElement(By.xpath(".//*[@id='image-uploader-close']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='container-main']/div/div[2]/form/div/div[2]/input")).click();
		Thread.sleep(8000);
		String complexName = driver.findElement(By.xpath(".//*[@id='container-main']/div[2]/div[2]/h1")).getText();
		System.out.println(complexName.toLowerCase());
		Assert.assertEquals(complexName.toLowerCase().contains(modelAddComplex.getDescription().toLowerCase()), true);
		System.out.println("Complex name modified successfully");
	}

	@Then("^add building to complex$")
	public void add_building_to_complex() throws Throwable {
		if(!isComplexAdded)
		{		
			driver.findElement(By.xpath(".//*[@id='container-main']/div[2]/div[3]/div/a[2]")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath(".//*[@id='page-modal']/div/div/form/div[2]/table/tbody/tr[1]/td[1]/div")).click();
			Thread.sleep(2000);
			String addBuilding = driver.findElement(By.xpath(".//*[@id='page-modal']/div/div/form/div[2]/table/tbody/tr[1]/td[2]")).getText();
			driver.findElement(By.xpath(".//*[@id='page-modal']/div/div/form/div[3]/font[2]/font/input")).click();
			Thread.sleep(8000);
			String building = driver.findElement(By.xpath(".//*[@id='container-main']/div[4]/div[2]/table/tbody/tr/td[1]/a")).getText();
			System.out.println("Building to add : " +  addBuilding + "\n" + "Added building : " + building);
			Assert.assertEquals(addBuilding, building);
			System.out.println("Building added to complex successfully");
		}
		else
		{
			System.out.println("Complex is already added");
		}
		Thread.sleep(2000);
	}
	
	@Then("^verify key address validation$")
	public void verify_key_address_validation() throws Throwable {
		
		driver.findElement(By.xpath(".//*[@id='container-main']/div[4]/div[1]/div/ul/li[2]/a")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='container-main']/div[4]/div[2]/a")).click();
		OpenChildWindow(driver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='page-modal']/div/div/form/div[3]/font[2]/font/input")));
		driver.findElement(By.xpath(".//*[@id='page-modal']/div/div/form/div[3]/font[2]/font/input")).click();
		Thread.sleep(1000);
		WebElement expected = driver.findElement(By.xpath(".//*[@id='validation-tooltip']/div[2]"));
		String errorMessage = expected.getText();
		Assert.assertEquals(errorMessage,modelComplexContact.getMessage1());
		if(errorMessage.equals(modelComplexContact.getMessage1()))
		{
			System.out.println("-------- Field Validation Successfull -------");
		}
		else
		{
			System.out.println("-------- Field Validation Unsuccessfull -------");
		}
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='page-modal']/div/div/form/div[3]/font[1]/font/input")).click();
		Thread.sleep(2000);
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

	@Then("^add key address and verify the data$")
	public void add_key_address_and_verify_the_data() throws Throwable {
		initialCount = GetLocatedElementCount(".//*[@id='container-main']/div[4]/div[2]/table/tbody/tr");
		System.out.println("Initial count : " + initialCount);
		driver.findElement(By.xpath(".//*[@id='container-main']/div[4]/div[2]/a")).click();
		OpenChildWindow(driver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='CurrentBuildingComplexKeyAddress_CompanyName']")));
		driver.findElement(By.xpath(".//*[@id='CurrentBuildingComplexKeyAddress_CompanyName']")).sendKeys(modelComplexKeyAddress.getCompanyName());
		Thread.sleep(500);
		driver.findElement(By.xpath(".//*[@id='CurrentBuildingComplexKeyAddress_PostalCode']")).sendKeys(modelComplexKeyAddress.getPostalCode());
		Thread.sleep(500);
		driver.findElement(By.xpath(".//*[@id='CurrentBuildingComplexKeyAddress_HouseNumber']")).sendKeys(modelComplexKeyAddress.getHouseNumber());
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading-overlay")));
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='CurrentBuildingComplexKeyAddress_ContactPerson']")).sendKeys(modelComplexKeyAddress.getContactPerson());
		Thread.sleep(500);
		driver.findElement(By.xpath(".//*[@id='CurrentBuildingComplexKeyAddress_Phone']")).sendKeys(modelComplexContact.getContactPhone());
		Thread.sleep(500);
		driver.findElement(By.xpath(".//*[@id='CurrentBuildingComplexKeyAddress_MobilePhone']")).sendKeys(modelComplexContact.getMobilePhone());
		Thread.sleep(500);
		driver.findElement(By.xpath(".//*[@id='CurrentBuildingComplexKeyAddress_Email']")).sendKeys(modelComplexContact.getEmail());
		Thread.sleep(500);
		driver.findElement(By.xpath(".//*[@id='CurrentBuildingComplexKeyAddress_Note']")).sendKeys(modelComplexKeyAddress.getNote());
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='page-modal']/div/div/form/div[3]/font[2]/font/input")));
		driver.findElement(By.xpath(".//*[@id='page-modal']/div/div/form/div[3]/font[2]/font/input")).click();
		Thread.sleep(10000);
		finalCount = GetLocatedElementCount(".//*[@id='container-main']/div[4]/div[2]/table/tbody/tr");
		System.out.println("Final count : " + finalCount);
		if(finalCount > initialCount)
		{
			System.out.println("Key address added successfully");
		}
		else
		{
			System.out.println("Key address can not be added");
		}
		Assert.assertEquals(finalCount > initialCount,true);
	}

	@Then("^remove key address$")
	public void remove_key_address() throws Throwable {

		List<WebElement> trElements =  driver.findElements(By.xpath(".//*[@id='container-main']/div[4]/div[2]/table/tbody/tr"));
		if(trElements.size() > 0)
		{
			WebElement lastElement =  driver.findElement(By.xpath("(.//*[@id='container-main']/div[4]/div[2]/table/tbody/tr)[last()]/td[last()]/a[last()]"));			
			if(lastElement != null)
			{
				lastElement.click();
				Alert alert = driver.switchTo().alert();
				alert.accept();
				Thread.sleep(8000);
				System.out.println("Key address removed");				
			}
			Assert.assertEquals(lastElement != null,true);
			Thread.sleep(2000);
		}
	}
	
	@Then("^verify invoice address validation$")
	public void verify_invoice_address_validation() throws Throwable {

		driver.findElement(By.xpath(".//*[@id='container-main']/div[4]/div[1]/div/ul/li[3]/a")).click();
		Thread.sleep(3000);	
		driver.findElement(By.xpath(".//*[@id='link-item-add']")).click();
		OpenChildWindow(driver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='page-modal']/div/div/form/div[3]/font[2]//input"))).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath(".//*[@id='page-modal']/div/div/form/div[3]/font[2]//input")).click();
		Thread.sleep(1000);
		WebElement expected = driver.findElement(By.xpath(".//*[@id='validation-tooltip']/div[2]"));
		String Message1 = expected.getText();
		Assert.assertEquals(Message1,modelComplexContact.getMessage1());
		if(Message1.equals(modelComplexContact.getMessage1()))
		{
			System.out.println("-------- Field Validation Successfull -------");
		}
		else
		{
			System.out.println("-------- Field Validation Failed -------");
		}
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='page-modal']/div/div/form/div[3]/font[1]//input")).click();
		Thread.sleep(2000);
	}

	@Then("^add invoice address and verify the data$")
	public void add_invoice_address_and_verify_the_data() throws Throwable {

		initialCount = GetLocatedElementCount(".//*[@id='container-main']/div[4]/div[2]/table/tbody[2]/tr");
		System.out.println("Initial count : " + initialCount);
		driver.findElement(By.xpath(".//*[@id='link-item-add']")).click();
		OpenChildWindow(driver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='CompanyName']"))).click();
		driver.findElement(By.xpath(".//*[@id='CompanyName']")).sendKeys(modelComplexInvoiceAddress.getCompanyName());
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='Department']")).sendKeys(modelComplexInvoiceAddress.getDepartment());
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='PostalCode']")).sendKeys(modelComplexInvoiceAddress.getPostalCode());
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='HouseNumber']")).sendKeys(modelComplexInvoiceAddress.getHouseNumber());
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading-overlay")));
		Thread.sleep(3000);		
		driver.findElement(By.xpath(".//*[@id='Email']")).sendKeys(modelComplexInvoiceAddress.getEmail());
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='TaxNumber']")).sendKeys(modelComplexInvoiceAddress.getTaxNumber());
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='Note']")).sendKeys(modelComplexInvoiceAddress.getNote());
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='page-modal']/div/div/form/div[3]/font[2]//input")));
		driver.findElement(By.xpath(".//*[@id='page-modal']/div/div/form/div[3]/font[2]//input")).click();
		Thread.sleep(8000);
		finalCount = GetLocatedElementCount(".//*[@id='container-main']/div[4]/div[2]/table/tbody[2]/tr");
		System.out.println("Final count : " + finalCount);
		if(finalCount > initialCount)
		{
			System.out.println("Invoice address added successfully");
		}
		else
		{
			System.out.println("Invoice address can not be added");
		}
	}

	@Then("^remove invoice address$")
	public void remove_invoice_address() throws Throwable {

		List<WebElement> trElements =  driver.findElements(By.xpath(".//*[@id='container-main']/div[4]/div[2]/table/tbody[2]/tr"));
		if(trElements.size() > 0)
		{
			WebElement lastElement =  driver.findElement(By.xpath("(.//*[@id='container-main']/div[4]/div[2]/table/tbody[2]/tr)[last()]/td[last()]/a[last()]"));			
			if(lastElement != null)
			{
				lastElement.click();
				Alert alert = driver.switchTo().alert();
				Thread.sleep(1000);
				alert.accept();
				Thread.sleep(8000);
				System.out.println("Invoice address removed");			
			}
			Thread.sleep(2000);
		}
	}
	
	@Then("^verify contact validation$")
	public void verify_contact_validation() throws Throwable {

		driver.findElement(By.xpath(".//*[@id='container-main']/div[4]/div[1]/div/ul/li[5]/a")).click();
		Thread.sleep(3000);	
		driver.findElement(By.xpath(".//*[@id='container-main']/div[4]/div[2]/a")).click();
		OpenChildWindow(driver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='page-modal']/div/div/form/div[3]/font[2]//input")));
		driver.findElement(By.xpath(".//*[@id='page-modal']/div/div/form/div[3]/font[2]//input")).click();
		Thread.sleep(1000);
		WebElement expected = driver.findElement(By.xpath(".//*[@id='validation-tooltip']/div[2]"));
		String Message1 = expected.getText();
		Assert.assertEquals(Message1,modelComplexContact.getMessage1());
		if(Message1.equals(modelComplexContact.getMessage1()))
		{
			System.out.println("-------- Field Validation Successfull -------");
		}
		else
		{
			System.out.println("-------- Field Validation Failed -------");
		}
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='page-modal']/div/div/form/div[3]/font[1]//input")).click();
		Thread.sleep(2000);
	}

	@Then("^add contact and verify the data$")
	public void add_contact_and_verify_the_data() throws Throwable {

		initialCount = GetLocatedElementCount(".//*[@id='container-main']/div[4]/div[2]/table/tbody/tr");
		System.out.println("Initial count : " + initialCount);
		driver.findElement(By.xpath(".//*[@id='container-main']/div[4]/div[2]/a")).click();
		OpenChildWindow(driver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='CurrentBuildingComplexContact_CompanyName']")));
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='CurrentBuildingComplexContact_CompanyName']")).sendKeys(modelComplexContact.getCompanyName());
		Thread.sleep(500);
		driver.findElement(By.xpath(".//*[@id='CurrentBuildingComplexContact_PostalCode']")).sendKeys(modelComplexContact.getPostalCode());
		Thread.sleep(500);
		driver.findElement(By.xpath(".//*[@id='CurrentBuildingComplexContact_HouseNumber']")).sendKeys(modelComplexContact.getHouseNumber());
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading-overlay")));
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='CurrentBuildingComplexContact_ContactPerson']")).sendKeys(modelComplexContact.getContactPerson());
		Thread.sleep(500);
		driver.findElement(By.xpath(".//*[@id='CurrentBuildingComplexContact_Phone']")).sendKeys(modelComplexContact.getContactPhone());
		Thread.sleep(500);
		driver.findElement(By.xpath(".//*[@id='CurrentBuildingComplexContact_MobilePhone']")).sendKeys(modelComplexContact.getMobilePhone());
		Thread.sleep(500);
		driver.findElement(By.xpath(".//*[@id='CurrentBuildingComplexContact_Email']")).sendKeys(modelComplexContact.getEmail());
		Thread.sleep(500);
		driver.findElement(By.xpath(".//*[@id='CurrentBuildingComplexContact_Note']")).sendKeys(modelComplexContact.getNote());
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='page-modal']/div/div/form/div[3]/font[2]//input")));
		driver.findElement(By.xpath(".//*[@id='page-modal']/div/div/form/div[3]/font[2]//input")).click();
		Thread.sleep(8000);
		finalCount = GetLocatedElementCount(".//*[@id='container-main']/div[4]/div[2]/table/tbody/tr");
		System.out.println("Final count : " + finalCount);
		if(finalCount > initialCount)
		{
			System.out.println("Contact added successfully");
		}
		else
		{
			System.out.println("Contact can not be added");
		}
		Assert.assertEquals(finalCount > initialCount,true);
	}

	@Then("^remove contact$")
	public void remove_contact() throws Throwable {

		List<WebElement> trElements =  driver.findElements(By.xpath(".//*[@id='container-main']/div[4]/div[2]/table/tbody/tr"));
		if(trElements.size() > 0)
		{
			WebElement lastElement =  driver.findElement(By.xpath("(.//*[@id='container-main']/div[4]/div[2]/table/tbody/tr)[last()]/td[last()]/a[last()]"));			
			if(lastElement != null)
			{
				lastElement.click();
				Alert alert = driver.switchTo().alert();
				Thread.sleep(1000);
				alert.accept();
				Thread.sleep(8000);
				System.out.println("Contact removed");			
			}
			Assert.assertEquals(lastElement != null,true);
			Thread.sleep(2000);
			driver.close();
		}
	}
}