package Stepdefinations.Building;

import java.util.List;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Models.Building.BuildingKeyaddressModel;
import Models.BuildingUnit.BuildingUnitContactModel;
import Models.BuildingUnit.BuildingUnitKeyAddressModel;
import Stepdefinations.Base;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class BuildingKeyAddress extends Base {

	WebDriver driver;
	int initialCount;
	int finalCount;
	int removeCount;
	BuildingUnitKeyAddressModel modelBuildingUnitKeyAddress=new BuildingUnitKeyAddressModel();
	BuildingUnitContactModel modelBuildingUnitContact=new BuildingUnitContactModel();
	BuildingKeyaddressModel modelBuildingKeyaddress=new BuildingKeyaddressModel();
	@Given("^Open the url and login with the valid data keyaddress$")
	public void open_an_url_and_login_with_a_valid_deta_keyaddress() throws Throwable {
		SetProperty();
		driver = Login();
		wait = new WebDriverWait(driver,WebDriverWaitTimeout);
	}
	@When("^User click on the MyApplication > Building> select building > keyaddress$")
	public void User_click_on_the_MyApplication_Building_select_building_keyaddress() throws Throwable {
		GoToModule(Module.Building,driver);
		driver.get(BuildingDetailPath);
		Thread.sleep(2000);
	}
	@Then("^click on the keyadress from sidebar$")
	public void click_on_the_keyadress_from_sidebar() throws Throwable {
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='container-main']/div[4]/div[1]/div/ul/li[8]/a")).click();
		Thread.sleep(2000); 
		initialCount = GetLocatedElementCount();
		System.out.println("Initial Row Counts  :: " +initialCount);
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

	@Then("^verify that the validation error shows below the field$")
	public void verify_that_the_validation_error_shows_below_the_field() throws Throwable {

		driver.findElement(By.xpath(".//*[@id='container-main']/div[4]/div[2]/a")).click();
		Thread.sleep(3000);

		OpenChildWindow(driver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='page-modal']/div/div/form/div[3]/font[2]/font/input"))).click();
		Thread.sleep(2000);
		WebElement expected = driver.findElement(By.xpath(".//*[@id='validation-tooltip']/div[2]"));
		String errorMessage = expected.getText();
		Assert.assertEquals(errorMessage,modelBuildingUnitContact.getErrorMessage());
		if(errorMessage.equals(modelBuildingUnitContact.getErrorMessage()))
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

	@Then("^click on the Add keyadress button$")
	public void click_on_the_Add_keyadress_button() throws Throwable {
		driver.findElement(By.xpath(".//*[@id='container-main']/div[4]/div[2]/a")).click();
		Thread.sleep(3000);
		OpenChildWindow(driver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='CurrentBuildingKeyAddress_CompanyName']"))).sendKeys(modelBuildingKeyaddress.getCompanyName());
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='CurrentBuildingKeyAddress_PostalCode']")).sendKeys(modelBuildingUnitKeyAddress.getPostalCode());
		driver.findElement(By.xpath(".//*[@id='CurrentBuildingKeyAddress_HouseNumber']")).sendKeys(modelBuildingUnitKeyAddress.getHouseNumber());
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading-overlay")));
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='CurrentBuildingKeyAddress_ContactPerson']")).sendKeys(modelBuildingUnitKeyAddress.getContactPerson());
		driver.findElement(By.xpath(".//*[@id='CurrentBuildingKeyAddress_Phone']")).sendKeys(modelBuildingUnitKeyAddress.getPhone());
		driver.findElement(By.xpath(".//*[@id='CurrentBuildingKeyAddress_Mobile']")).sendKeys(modelBuildingUnitKeyAddress.getMobile());
		driver.findElement(By.xpath(".//*[@id='CurrentBuildingKeyAddress_Email']")).sendKeys(modelBuildingUnitKeyAddress.getEmail());
		driver.findElement(By.xpath(".//*[@id='CurrentBuildingKeyAddress_Note']")).sendKeys(modelBuildingUnitKeyAddress.getNote());
		Thread.sleep(3000);    
	}

	@Then("^click on submit$")
	public void click_on_the_submit_button() throws Throwable {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='page-modal']/div/div/form/div[3]/font[2]/font/input")));
		driver.findElement(By.xpath(".//*[@id='page-modal']/div/div/form/div[3]/font[2]/font/input")).click();
		Thread.sleep(6000);
		finalCount = GetLocatedElementCount();
		System.out.println("After Adding new KeyAddress :: " + finalCount);

		Assert.assertEquals(initialCount < finalCount, true);
	}

	@Then("^click on remove$")
	public void click_on_remove_button() throws Throwable {
		Thread.sleep(5000); 
		driver.findElement(By.xpath(".//*[@id='container-main']/div[4]/div[2]/table/tbody/tr["+finalCount+"]/td[5]/a[2]")).click();
		Thread.sleep(3000);
		Alert alert = driver.switchTo().alert();
		alert.accept();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading-overlay")));
		Thread.sleep(3000);
		
		int removeCount = GetLocatedElementCount();
		System.out.println("\n After remove, Row Count :: " + removeCount);
		if(removeCount < finalCount)
		{
			System.out.println("------->> Remove functionality is working fine and Verified  <<-------");
		}
		else
		{
			System.out.println("Error in Remove Functionality!!!");
		}
		Assert.assertEquals(removeCount < finalCount,true);
		Thread.sleep(3000);
		driver.close();
	}

}
