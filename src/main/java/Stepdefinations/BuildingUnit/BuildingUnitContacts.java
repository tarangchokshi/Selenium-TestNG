package Stepdefinations.BuildingUnit;

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

public class BuildingUnitContacts extends Base{

	WebDriver driver;
	int initialCount;
	int finalCount;
	int removeCount;
	BuildingUnitContactModel modelBuildingUnitContact=new BuildingUnitContactModel();

	@Given("^Open the url and login with the valid details$")
	public void open_an_url_and_login_with_a_valid_detailss() throws Throwable {
		SetProperty();
		driver = Login();
		wait = new WebDriverWait(driver,WebDriverWaitTimeout);
	}
	
	@When("^User click on the MyApplication and select the building unit$")
	 public void user_click_on_the_MyApplication_and_select_the_building() throws Throwable {
	  GoToModule(Module.Building,driver);
	  driver.get(BuildingUnitDetailPath);
	  Thread.sleep(2000);
	 }
	 
	 @Then("^click on the unit contact from sidebar$")
	 public void click_on_the_element_from_sidebar() throws Throwable {
	  JavascriptExecutor js = (JavascriptExecutor) driver;
	  js.executeScript("window.scrollBy(0,500)");
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//*[@id='container-main']/div[4]/div[1]/div/ul/li[8]/a")).click();
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

	@Then("^verify that the unit contact validation error shows below the field$")
	public void verify_that_the_contact_validation_error_shows_below_the_field() throws Throwable {
		driver.findElement(By.xpath(".//*[@id='container-main']/div[4]/div[2]/a")).click();
		Thread.sleep(3000);
		OpenChildWindow(driver);
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='page-modal']/div/div/form/div[3]/font[2]/font/input")));
		driver.findElement(By.xpath(".//*[@id='page-modal']/div/div/form/div[3]/font[2]/font/input")).click();
		Thread.sleep(1000);
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

	@Then("^click on the Add unit contact button$")
	public void click_on_the_Add_contact_button() throws Throwable {
		driver.findElement(By.xpath("//*[@id='container-main']/div[4]/div[2]/a")).click();
		Thread.sleep(3000);
		OpenChildWindow(driver);
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@name='CurrentBuildingUnitContact.CompanyName']")));
		driver.findElement(By.xpath(".//*[@name='CurrentBuildingUnitContact.CompanyName']")).sendKeys(modelBuildingUnitContact.getCompanyName());
		driver.findElement(By.xpath(".//*[@id='CurrentBuildingUnitContact_PostalCode']")).sendKeys(modelBuildingUnitContact.getPostalCode());  
		driver.findElement(By.xpath(".//*[@id='CurrentBuildingUnitContact_HouseNumber']")).sendKeys(modelBuildingUnitContact.getHouseNumber()); 
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading-overlay")));
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='CurrentBuildingUnitContact_ContactPerson']")).sendKeys(modelBuildingUnitContact.getContactPerson());
		driver.findElement(By.xpath(".//*[@id='CurrentBuildingUnitContact_Phone']")).sendKeys(modelBuildingUnitContact.getPhone()); 
		driver.findElement(By.xpath(".//*[@id='CurrentBuildingUnitContact_Mobile']")).sendKeys(modelBuildingUnitContact.getMobile());     

		driver.findElement(By.xpath(".//*[@id='CurrentBuildingUnitContact_Email']")).sendKeys(modelBuildingUnitContact.getEmail());    
		driver.findElement(By.xpath(".//*[@id='CurrentBuildingUnitContact_Note']")).sendKeys(modelBuildingUnitContact.getNote());
		Thread.sleep(6000);    
     }
	@Then("^click on the unit contact submit button$")
	public void click_on_the_contact_submit_button() throws Throwable {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='page-modal']/div/div/form/div[3]/font[2]/font/input")));
		driver.findElement(By.xpath("//*[@id='page-modal']/div/div/form/div[3]/font[2]/font/input")).click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading-overlay")));
		Thread.sleep(3000);
		finalCount = GetLocatedElementCount();
		System.out.println("After Adding new Contact Address :: " + finalCount);
		Assert.assertEquals(initialCount < finalCount,true);
	}

	@Then("^click on unit contact remove button$")
	public void click_on_contact_remove_button() throws Throwable {
		Thread.sleep(3000);
		
		List<WebElement> trContactAddress = driver.findElements(By.xpath("//*[@id='container-main']/div[4]/div[2]/table/tbody/tr"));
		if (trContactAddress.size() > 0) {
			WebElement lastContactaddress = driver.findElement(By.xpath("(.//*[@id='container-main']/div[4]/div[2]/table/tbody/tr)[last()]/td[last()]/a[last()]"));
			if (lastContactaddress != null) {
				lastContactaddress.click();
				Alert alert = driver.switchTo().alert();
				alert.accept();
				Thread.sleep(3000);
				System.out.println("------Contact Address Removed------");
				removeCount = GetLocatedElementCount();	
			}
		}
		System.out.println("\n After remove, Row Count :: " + removeCount);
		Assert.assertEquals(removeCount < finalCount,true);
		Thread.sleep(3000);
		driver.close();
		}

}
