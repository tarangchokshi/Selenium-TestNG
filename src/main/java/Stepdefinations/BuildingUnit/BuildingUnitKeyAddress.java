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
import Models.BuildingUnit.BuildingUnitKeyAddressModel;
import Stepdefinations.Base;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class BuildingUnitKeyAddress extends Base {

	WebDriver driver;
	int initialCount;
	int finalCount;
	int removeCount;
	BuildingUnitContactModel modelBuildingUnitContact=new BuildingUnitContactModel();
	BuildingUnitKeyAddressModel modelBuildingUnitKeyAddress=new BuildingUnitKeyAddressModel();
	@Given("^Open the url and login with the valid unit data keyaddress$")
	public void open_an_url_and_login_with_a_valid_unit_data_keyaddress() throws Throwable {
		SetProperty();
		driver = Login();
		wait = new WebDriverWait(driver,WebDriverWaitTimeout);
	}

	@When("^User click on the MyApplication and select the buildingunit key address$")
	public void user_click_on_the_MyApplication_and_select_the_buildingunit_keyaddress() throws Throwable {
		GoToModule(Module.Building,driver);
		driver.get(BuildingUnitDetailPath);
		Thread.sleep(2000);
	}
	
	@Then("^click on the key address from sidebar$")
	public void click_on_the_keyaddress_from_sidebar() throws Throwable {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='container-main']/div[4]/div[1]/div/ul/li[5]/a")).click();
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

	@Then("^verify that the validation error shows below the field for keyaddress unit$")
	public void verify_that_the_validation_error_shows_below_the_field() throws Throwable {

		driver.findElement(By.xpath(".//*[@id='container-main']/div[4]/div[2]/a")).click();
		Thread.sleep(3000);

		OpenChildWindow(driver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='page-modal']/div/div/form/div[3]/font[2]/font/input")));
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='page-modal']/div/div/form/div[3]/font[2]/font/input")).click();
		Thread.sleep(2000);
		WebElement expected = driver.findElement(By.xpath(".//*[@id='validation-tooltip']/div[2]"));
		String errorMessage = expected.getText();
		Assert.assertEquals(errorMessage,modelBuildingUnitContact.getErrorMessage());
		if(errorMessage.equals("Bedrijfsnaam is een verplicht veld"))
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

	@Then("^click on the Add keyadress button for unit$")
	public void click_on_the_Add_keyadress_button_for_unit() throws Throwable {
		driver.findElement(By.xpath(".//*[@id='container-main']/div[4]/div[2]/a")).click();
		Thread.sleep(3000);

		OpenChildWindow(driver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='CurrentBuildingUnitKeyAddress_CompanyName']")));
		Thread.sleep(3000);

		driver.findElement(By.xpath(".//*[@id='CurrentBuildingUnitKeyAddress_CompanyName']")).sendKeys(modelBuildingUnitKeyAddress.getCompanyName());
		driver.findElement(By.xpath(".//*[@id='CurrentBuildingUnitKeyAddress_PostalCode']")).sendKeys(modelBuildingUnitKeyAddress.getPostalCode());
		driver.findElement(By.xpath(".//*[@id='CurrentBuildingUnitKeyAddress_HouseNumber']")).sendKeys(modelBuildingUnitKeyAddress.getHouseNumber());
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading-overlay")));
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='CurrentBuildingUnitKeyAddress_ContactPerson']")).sendKeys(modelBuildingUnitKeyAddress.getContactPerson());
		driver.findElement(By.xpath(".//*[@id='CurrentBuildingUnitKeyAddress_Phone']")).sendKeys(modelBuildingUnitKeyAddress.getPhone());
		driver.findElement(By.xpath(".//*[@id='CurrentBuildingUnitKeyAddress_Mobile']")).sendKeys(modelBuildingUnitKeyAddress.getMobile());
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='CurrentBuildingUnitKeyAddress_Email']")).sendKeys(modelBuildingUnitKeyAddress.getEmail());
		driver.findElement(By.xpath(".//*[@id='CurrentBuildingUnitKeyAddress_Note']")).sendKeys(modelBuildingUnitKeyAddress.getNote());
		Thread.sleep(3000);    
	}
	
	@Then("^click on submit button$")
	public void click_on_the_submit_button() throws Throwable {
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='page-modal']/div/div/form/div[3]/font[2]/font/input")));
		driver.findElement(By.xpath("//*[@id='page-modal']/div/div/form/div[3]/font[2]/font/input")).click();
		Thread.sleep(6000);
		finalCount = GetLocatedElementCount();
		System.out.println("After Adding new KeyAddress :: " + finalCount);
		Assert.assertEquals(initialCount < finalCount, true);
	}

	@Then("^click on remove to remove unit keyaddress$")
	public void click_on_remove_button() throws Throwable {

		Thread.sleep(5000); 
		List<WebElement> trKeyaddress = driver.findElements(By.xpath("//*[@id='container-main']/div[4]/div[2]/table/tbody/tr"));
		if (trKeyaddress.size() > 0) {
			WebElement lastKeyaddress = driver.findElement(By.xpath("(.//*[@id='container-main']/div[4]/div[2]/table/tbody/tr)[last()]/td[last()]/a[last()]"));
			if (lastKeyaddress != null) {
				lastKeyaddress.click();
				Alert alert = driver.switchTo().alert();
				alert.accept();
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading-overlay")));
				Thread.sleep(3000);
				System.out.println("------KeyAddress Removed------");
				removeCount = GetLocatedElementCount();	
			}
		}
		System.out.println("\n After remove, Row Count :: " + removeCount);
		Assert.assertEquals(removeCount < finalCount,true);
		Thread.sleep(3000);
		driver.close();
	}
}