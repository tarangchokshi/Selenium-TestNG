//Invoice Address - Change

package Stepdefinations.Building;
import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Models.Building.BuildingInvoiceAddressModel;
import Models.BuildingUnit.BuildingUnitInvoiceAddressModel;
import Stepdefinations.Base;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BuildingInvoiceAddress extends Base {

	WebDriver driver;
	int initialCount;
	int finalCount;
	int removeCount;
	BuildingUnitInvoiceAddressModel modeBuildingUnitInvoiceAddress=new BuildingUnitInvoiceAddressModel();
	BuildingInvoiceAddressModel modelBuildingInvoiceAddress=new BuildingInvoiceAddressModel();
	@Given("^Open an url and login with the valid detail$")
	public void open_an_url_and_login_with_the_valid_detail() throws Throwable {
		SetProperty();
		driver = Login();
		wait = new WebDriverWait(driver,WebDriverWaitTimeout);
	}
	
	@When("^User click on the MyApplication > Building> select building > invoiceaddress$")
	public void User_click_on_the_MyApplication_Building_select_building_invoiceaddress() throws Throwable {
		GoToModule(Module.Building,driver);
		driver.get(BuildingDetailPath);
		Thread.sleep(2000);
	}


	@Then("^click on the invoiceadress from sidebar$")
	public void click_on_the_invoiceadress_from_sidebar() throws Throwable {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='container-main']/div[4]/div[1]/div/ul/li[9]/a")).click();
		Thread.sleep(3000);
		initialCount = GetLocatedElementCount();
		System.out.println("\n Initial Row Counts  :: " +initialCount);
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

	@Then("^keep the new invoiceadress field blank and check validation$")
	public void keep_the_new_invoiceadress_field_blank_and_check_validation() throws Throwable {

		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='link-item-add']")).click();
		Thread.sleep(2000);
		OpenChildWindow(driver);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,600)");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='page-modal']/div/div/form/div[3]/font[2]/font/input"))).click();
		Thread.sleep(2000);
		WebElement expected = driver.findElement(By.xpath(".//*[@id='validation-tooltip']/div[2]"));
		String errorMessage = expected.getText();
		Assert.assertEquals(errorMessage,modeBuildingUnitInvoiceAddress.getErrorMessage());
		if(errorMessage.equals(modeBuildingUnitInvoiceAddress.getErrorMessage()))
		{
			System.out.println("\n --------Field Validation Successfull -------");
		}
		else
		{
			System.out.println("\n -------- Field Validation Unsuccessfull -------");
		}
		Thread.sleep(3000);
		driver.navigate().refresh();
		Thread.sleep(3000);
	}

	@Then("^click on the Add newbilling adress button$")
	public void click_on_the_Add_newbilling_adress_button() throws Throwable {

		driver.findElement(By.xpath(".//*[@id='link-item-add']")).click();
		OpenChildWindow(driver);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading-overlay")));
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='CompanyName']")).sendKeys(modelBuildingInvoiceAddress.getCompanyName());
		driver.findElement(By.xpath(".//*[@id='Department']")).sendKeys(modelBuildingInvoiceAddress.getDepartment());
		driver.findElement(By.xpath(".//*[@id='PostalCode']")).sendKeys(modeBuildingUnitInvoiceAddress.getPostalCode());      
		driver.findElement(By.xpath(".//*[@id='HouseNumber']")).sendKeys(modeBuildingUnitInvoiceAddress.getHouseNumber());
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading-overlay")));
		Thread.sleep(2000);     
		driver.findElement(By.xpath(".//*[@id='Email']")).sendKeys(modeBuildingUnitInvoiceAddress.getEmail());     
		driver.findElement(By.xpath(".//*[@id='TaxNumber']")).sendKeys(modeBuildingUnitInvoiceAddress.getTaxNumber());     
		driver.findElement(By.xpath(".//*[@id='Note']")).sendKeys(modelBuildingInvoiceAddress.getNote());       

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");

		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='submit']")));
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Thread.sleep(5000);
		finalCount = GetLocatedElementCount();
		System.out.println("\n After Adding new :: " + finalCount);
		
		Assert.assertEquals(initialCount < finalCount,true);
	}

	@Then("^click on remove invoice button$")
	public void click_on_remove_invoice_button() throws Throwable {

		Thread.sleep(3000); 

		driver.findElement(By.xpath("//*[@id='container-main']/div[4]/div[2]/table/tbody[2]/tr["+finalCount+"]/td[7]/a[2]")).click();
		Thread.sleep(3000);
		Alert alert = driver.switchTo().alert();
		alert.accept();
		Thread.sleep(3000);

		int removeCount = GetLocatedElementCount();
		System.out.println("\n After remove, Row Count :: " + removeCount);
		if(removeCount < finalCount)
		{
			System.out.println("\n ------->> Remove functionality is working fine and Verified  <<-------");
		}
		else
		{
			System.out.println("\n Error in Remove Functionality!!!");
		}
		Assert.assertEquals(removeCount < finalCount,true);
		Thread.sleep(3000);
		driver.close();
	}

}
