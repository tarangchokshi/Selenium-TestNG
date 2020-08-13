package Stepdefinations.BuildingUnit;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Models.BuildingUnit.BuildingUnitInvoiceAddressModel;
import Stepdefinations.Base;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class BuildingUnitInvoiceAddress extends Base {

	WebDriver driver;
	int initialCount;
	int finalCount;
	int removeCount;
	BuildingUnitInvoiceAddressModel modelBuildingUnitInvoiceAddress=new BuildingUnitInvoiceAddressModel();
	@Given("^Open the url and login with the valid unit data invoiceaddress$")
	public void open_an_url_and_login_with_a_valid_unit_data_invoiceaddress() throws Throwable {
		SetProperty();
		driver = Login();	
		wait = new WebDriverWait(driver,WebDriverWaitTimeout);
	}
	
	@When("^User click on the MyApplication and select the buildingunit invoice$")
	public void user_click_on_the_MyApplication_and_select_the_buildingunit_invoice() throws Throwable {
		GoToModule(Module.Building,driver);
		driver.get(BuildingUnitDetailPath);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='container-main']/div[4]/div[1]/div/ul/li[6]/a"));
		
	}
	
	@Then("^click on invoiceadress link from sidebar$")
	public void click_on_the_invoice_from_sidebar() throws Throwable {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='container-main']/div[4]/div[1]/div/ul/li[6]/a")).click();
		Thread.sleep(1000);
		initialCount = GetLocatedElementCount();
		System.out.println("\n Initial Row Counts:: " +initialCount);
	}

	public int GetLocatedElementCount()
	{
		int counter = 0;
		List<WebElement> locatedElements = driver.findElements(By.xpath(".//*[@id='container-main']/div[4]/div[2]/table/tbody/tr")); 

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

	@Then("^verify that the validation error shows below the field for invoiceaddress unit$")
	public void verify_that_the_validation_error_shows_below_the_field() throws Throwable {
        Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='link-item-add']")).click();
		Thread.sleep(3000);

		OpenChildWindow(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,600)");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='page-modal']/div/div/form/div[3]/font[2]/font/input")));
		driver.findElement(By.xpath(".//*[@id='page-modal']/div/div/form/div[3]/font[2]/font/input")).click();
		Thread.sleep(2000);
		WebElement expected = driver.findElement(By.xpath(".//*[@id='validation-tooltip']/div[2]"));
		String errorMessage = expected.getText();
		Assert.assertEquals(errorMessage,modelBuildingUnitInvoiceAddress.getErrorMessage());
		if(errorMessage.equals(modelBuildingUnitInvoiceAddress.getErrorMessage()))
		{
			System.out.println("-------- Field Validation Successfull -------");
		}
		else
		{
			System.out.println("-------- Field Validation Unsuccessfull -------");
		}
		Thread.sleep(3000);
		driver.navigate().refresh();
		Thread.sleep(3000);
	}


	@Then("^click on the Add invoiceaddress button for unit$")
	public void click_on_the_Add_invoiceaddress_button_for_unit() throws Throwable {
		driver.findElement(By.xpath(".//*[@id='container-main']/div[4]/div[2]/a")).click();
		Thread.sleep(3000);

		OpenChildWindow(driver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='CompanyName']")));
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='CompanyName']")).sendKeys(modelBuildingUnitInvoiceAddress.getCompanyName());
		driver.findElement(By.xpath(".//*[@id='Department']")).sendKeys(modelBuildingUnitInvoiceAddress.getDepartment());
		driver.findElement(By.xpath(".//*[@id='PostalCode']")).sendKeys(modelBuildingUnitInvoiceAddress.getPostalCode());      
		driver.findElement(By.xpath(".//*[@id='HouseNumber']")).sendKeys(modelBuildingUnitInvoiceAddress.getHouseNumber());    
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading-overlay")));
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='Email']")).sendKeys(modelBuildingUnitInvoiceAddress.getEmail());     
		driver.findElement(By.xpath(".//*[@id='TaxNumber']")).sendKeys(modelBuildingUnitInvoiceAddress.getTaxNumber());     
		driver.findElement(By.xpath(".//*[@id='Note']")).sendKeys(modelBuildingUnitInvoiceAddress.getNote());  
		Thread.sleep(3000);    
		driver.findElement(By.xpath("//*[@id='page-modal']/div/div/form/div[3]/font[2]/font/input")).click();
		Thread.sleep(6000);
		finalCount = GetLocatedElementCount();
		System.out.println("After Adding new InvoiceAddress :: " + finalCount);
		Assert.assertEquals(initialCount < finalCount, true);
	}


	@Then("^click on remove to remove unit invoiceaddress$")
	public void click_on_remove_button() throws Throwable {
		Thread.sleep(5000);		
		List<WebElement> trInvoiceaddress = driver.findElements(By.xpath("//*[@id='container-main']/div[4]/div[2]/table/tbody/tr"));
		if (trInvoiceaddress.size() > 0) {
			WebElement lastInvoiceaddress = driver.findElement(By.xpath("(.//*[@id='container-main']/div[4]/div[2]/table/tbody/tr)[last()]/td[last()]/a[last()]"));
			if (lastInvoiceaddress != null) {
				lastInvoiceaddress.click();
				Alert alert = driver.switchTo().alert();
				alert.accept();
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading-overlay")));
				Thread.sleep(3000);
				System.out.println("------InvoiceAddress Removed------");
				removeCount = GetLocatedElementCount();	
			}
		}
		System.out.println("\n After remove, Row Count :: " + removeCount);
		Assert.assertEquals(removeCount < finalCount,true);
		Thread.sleep(3000);
		driver.close();
	}

}
