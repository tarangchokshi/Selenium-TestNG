package Stepdefinations.Building;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Models.BuildingUnit.BuildingUnitContactModel;
import Stepdefinations.Base;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class BuildingContacts extends Base{

	WebDriver driver;
	int initialCount;
	int finalCount;
	int removeCount;
	BuildingUnitContactModel modelBuildingUnitContact=new BuildingUnitContactModel();

	@Given("^Open the url and login with the valid detailss$")
	public void open_an_url_and_login_with_a_valid_detailss() throws Throwable {
		SetProperty();
		driver = Login();
		wait = new WebDriverWait(driver,WebDriverWaitTimeout);
	}
	
	@When("^User click on the MyApplication Building select building contact$")
	public void User_click_on_the_MyApplication_Building_select_building_contact() throws Throwable {
		
		GoToModule(Module.Building,driver);
		driver.get(BuildingDetailPath);
		Thread.sleep(2000);
	}

	@Then("^click on the contact from sidebar$")
	public void click_on_the_contact_from_sidebar() throws Throwable {				
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,600)");
		Thread.sleep(5000);
		driver.findElement(By.xpath(".//*[@id='container-main']/div[4]/div[1]/div/ul/li[11]/a")).click();
		Thread.sleep(3000);
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

	@Then("^verify that the contact validation error shows below the field$")
	public void verify_that_the_contact_validation_error_shows_below_the_field() throws Throwable {
		driver.findElement(By.xpath(".//*[@id='container-main']/div[4]/div[2]/a")).click();
		Thread.sleep(3000);
		OpenChildWindow(driver);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='page-modal']/div/div/form/div[3]/font[2]/font/input"))).click();
     
        Thread.sleep(2000);
		WebElement expected = driver.findElement(By.xpath(".//*[@id='validation-tooltip']/div[2]"));
		String errorMessage = expected.getText();
		Assert.assertEquals(errorMessage,modelBuildingUnitContact.getErrorMessage());
		if(errorMessage.equals(modelBuildingUnitContact.getErrorMessage()))
		{
			System.out.println("--------Validation Successfull -------");
		}
		else
		{
			System.out.println("-------- Validation Unsuccessfull -------");
		}
		Thread.sleep(3000);
		driver.navigate().refresh();
		Thread.sleep(3000);
	}

	@Then("^click on the Add contact button$")
	public void click_on_the_Add_contact_button() throws Throwable {
		driver.findElement(By.xpath("//*[@id='container-main']/div[4]/div[2]/a")).click();
		Thread.sleep(3000);
		OpenChildWindow(driver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@name='CurrentBuildingContact.CompanyName']"))).sendKeys(modelBuildingUnitContact.getCompanyName());
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='CurrentBuildingContact_PostalCode']")).sendKeys(modelBuildingUnitContact.getPostalCode());  
		driver.findElement(By.xpath(".//*[@id='CurrentBuildingContact_HouseNumber']")).sendKeys(modelBuildingUnitContact.getHouseNumber()); 
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading-overlay")));
		Thread.sleep(3000);   
		driver.findElement(By.xpath(".//*[@id='CurrentBuildingContact_ContactPerson']")).sendKeys(modelBuildingUnitContact.getContactPerson());	
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='page-modal']/div/div/form/div[2]/div/div[9]/div[1]/div/div[1]/div")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='page-modal']/div/div/form/div[2]/div/div[9]/div[1]/div/div[2]/div/div[160]")).click();
		driver.findElement(By.xpath(".//*[@id='CurrentBuildingContact_Phone']")).sendKeys(modelBuildingUnitContact.getPhone()); 
        Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='page-modal']/div/div/form/div[2]/div/div[9]/div[1]/div/div[1]/div")).click();
		driver.findElement(By.xpath("//*[@id='page-modal']/div/div/form/div[2]/div/div[9]/div[1]/div/div[2]/div/div[160]")).click();
		driver.findElement(By.xpath(".//*[@id='CurrentBuildingContact_Mobile']")).sendKeys(modelBuildingUnitContact.getMobile());
		driver.findElement(By.xpath(".//*[@id='CurrentBuildingContact_Email']")).sendKeys(modelBuildingUnitContact.getEmail());    
		driver.findElement(By.xpath(".//*[@id='CurrentBuildingContact_Note']")).sendKeys(modelBuildingUnitContact.getNote());
		Thread.sleep(6000);
	}

	@Then("^click on the contact submit button$")
	public void click_on_the_contact_submit_button() throws Throwable {
		
		driver.findElement(By.xpath("//*[@id='page-modal']/div/div/form/div[3]/font[2]/font/input")).click();
		Thread.sleep(8000);
		finalCount = GetLocatedElementCount();
		System.out.println("After Adding new Contact Address :: " + finalCount);
		Assert.assertEquals(initialCount < finalCount,true);
	}

	@Then("^click on contact remove button$")
	public void click_on_contact_remove_button() throws Throwable {
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='container-main']/div[4]/div[2]/table/tbody/tr["+finalCount+"]/td[6]/a[2]")).click();
		wait.until(ExpectedConditions.alertIsPresent());
		Thread.sleep(1000);
		Alert alert = driver.switchTo().alert();
		alert.accept();
		Thread.sleep(8000);
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
		Thread.sleep(2000);
		driver.close();
	}
}