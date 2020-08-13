package Stepdefinations.Building;

import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Models.Building.BuildingAddModel;
import Stepdefinations.Base;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BuildingAdd extends Base {
	WebDriver driver;
	boolean newBuildingAddFlag;
	BuildingAddModel modelBuildingAdd=new BuildingAddModel();
	
	@Given("^Open the application URL$")
	public void open_the_registration_link() throws Throwable {
		SetProperty();
		driver = Login();
		newBuildingAddFlag = false;
		wait = new WebDriverWait(driver,WebDriverWaitTimeout);
	}

	@When("^User click on the MyApplication and select the building$")
	public void user_click_on_the_MyApplication_and_select_the_building() throws Throwable {
		
		GoToModule(Module.Building,driver);
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='container-main']/div[1]/div[2]/div/a[1]")).click();

	}

	@Then("^Verify that title of the page should be As expected$")
	public void Verify_that_title_of_the_page_should_be_As_expected() throws Throwable {
		Thread.sleep(3000);
		String actualTitle = driver.getTitle();
		String expectedTitle = modelBuildingAdd.getTitle();
		Assert.assertEquals(expectedTitle, actualTitle);
		System.out.println("Title verified successfully");
	}

	@Then("^User click on the List tab$")
	public void user_click_on_the_List_tab() throws Throwable {
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='container-main']/div/div[1]/div[1]/div/div[3]")).click();
	}

	@Then("^Enter the pincode and number$")
	public void enter_the_pincode_and_number() throws Throwable {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='search-postalcode']")).sendKeys(modelBuildingAdd.getPostalcode());
		driver.findElement(By.xpath("//input[@id='search-housenumber']")).sendKeys(modelBuildingAdd.getHousenumber());
	}

	@Then("^click on the searchbutton$")
	public void click_on_the_searchbutton() throws Throwable {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@id='btnSearch']")).click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading-overlay")));
	}

	@Then("^click on the add button$")
	public void click_on_the_add_button() throws Throwable {
		Thread.sleep(2000);		

		WebElement addBuildingButton = driver.findElement(By.xpath("//*[@id='button-add']"));
		if(addBuildingButton.isDisplayed())
		{			
			driver.findElement(By.xpath("//*[@id='button-add']")).click();
			newBuildingAddFlag = true;
		}
		else
		{
			System.out.println("--------Building already added -------");
		}
	}

	@Then("^Verify that record save successfully$")
	public void verify_that_record_save_successfully() throws Throwable {
		if(newBuildingAddFlag)
		{
			Thread.sleep(2000);
			String buildingDetails = driver.findElement(By.xpath("//*[@id='queue']/div")).getText();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[@id='button-save']")).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='input-searchbox']")));
			Thread.sleep(3000);
			List<WebElement> locatedElements = driver.findElements(By.xpath("//*[@id='list']/div[1]/div/table/tbody/tr")); 
			int i = 1;
			Boolean buildingAddFlag = false;
			for(WebElement locatedElement: locatedElements)
			{	  
				WebElement innerAddressElement = driver.findElement(By.xpath("//*[@id='list']/div[1]/div/table/tbody/tr[" + i + "]/td[2]"));
				WebElement innerPlaceElement = driver.findElement(By.xpath("//*[@id='list']/div[1]/div/table/tbody/tr[" + i + "]/td[3]"));
				if(buildingDetails.contains(innerAddressElement.getText()) &&  buildingDetails.contains(innerPlaceElement.getText()))
				{
					buildingAddFlag = true;
					break;
				}
				i++;				  
			}
			if(buildingAddFlag)
			{
				System.out.println("--------Test Case Pass successfully -------");
			}
			else
			{
				System.out.println("--------Test Case Fail -------");
			}

			Assert.assertEquals(buildingAddFlag, true);
		}
		Thread.sleep(2000);
		driver.close();
	}
}