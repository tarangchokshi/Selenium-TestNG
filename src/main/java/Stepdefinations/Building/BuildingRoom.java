package Stepdefinations.Building;

import java.util.List;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Models.BuildingUnit.BuildingUnitRoomModel;
import Stepdefinations.Base;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class BuildingRoom extends Base {

	WebDriver driver;
	int initialCount;
	int finalCount;
	int removeCount;
	BuildingUnitRoomModel modelBuildingUnitRoom=new BuildingUnitRoomModel();

	@Given("^Open the url and login with the valid data room$")
	public void open_an_url_and_login_with_a_valid_deta_room() throws Throwable {
		SetProperty();
		driver = Login();
		wait = new WebDriverWait(driver,WebDriverWaitTimeout);
	}

	@When("^User click on the MyApplication > Building> select building room$")
	public void User_click_on_the_MyApplication_Building_select_building_room() throws Throwable {
		GoToModule(Module.Building,driver);
		driver.get(BuildingDetailPath);
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='container-main']/div[4]/div[1]/div/ul/li[3]/a")).click();
		Thread.sleep(2000); 
		initialCount = GetLocatedElementCount();
		System.out.println("Initial Row Counts  :: " +initialCount);
	}

	public int GetLocatedElementCount()
	{
		int counter = 0;
		List<WebElement> locatedElements = driver.findElements(By.xpath(".//*[@id='container-main']/div[4]/div[2]/table/tbody/tr[@data-search='row']")); 

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

	@Then("^Check validation to add building room$")
	public void Check_validation_to_add_building_room() throws Throwable {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='button-add']")).click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading-overlay")));
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='formAddFloor']/div[3]/font[2]/font/input")).click();
		Thread.sleep(2000);
		WebElement expected = driver.findElement(By.xpath(".//*[@id='validation-tooltip']/div[2]"));
		String errorMessage = expected.getText();
		Assert.assertEquals(errorMessage,modelBuildingUnitRoom.getErrorMessage());
		if(errorMessage.equals(modelBuildingUnitRoom.getErrorMessage()))
		{
			System.out.println("-------- Field Validation Successfull -------");
		}
		else
		{
			System.out.println("-------- Field Validation Unsuccessfull -------");
		}
		Thread.sleep(2000);
	}

	@Then("^Add and verify default building room$")
	public void Add_and_verify_default_building_room() throws Throwable {

		driver.findElement(By.xpath(".//*[@id='Space_Description']")).sendKeys(modelBuildingUnitRoom.getDescription());
		driver.findElement(By.xpath(".//*[@id='Space_Number']")).sendKeys(modelBuildingUnitRoom.getNumber());
		driver.findElement(By.xpath(".//*[@id='Space_Area']")).sendKeys(modelBuildingUnitRoom.getArea());
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='formAddFloor']/div[3]/font[2]/font/input")).click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading-overlay")));
		Thread.sleep(3000);
		finalCount = GetLocatedElementCount();
		System.out.println("After Adding new :: " + finalCount);
		Assert.assertEquals(initialCount < finalCount, true);
	}

	@Then("^Update and verify newfloor building room$")
	public void update_and_verify_newfloor_building_room() throws Throwable {

		Thread.sleep(2000);
		List<WebElement> trElements = driver.findElements(By.xpath(".//*[@id='container-main']/div[4]/div[2]/table/tbody/tr[@data-search='row']"));
		if (trElements.size() > 0) {
			WebElement lastElement = driver.findElement(By.xpath("(.//*[@id='container-main']/div[4]/div[2]/table/tbody/tr[@data-search='row'])[last()]/td[last()]/a[@class='link-item-edit btn btn-edit-small']"));
			if (lastElement != null) {				
				lastElement.click();
				Thread.sleep(2000);
			}
		}
		OpenChildWindow(driver);
		Thread.sleep(2000);	
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='Space_Description']")));
		Thread.sleep(2000);	
		driver.findElement(By.xpath(".//*[@id='formAddFloor']/div[2]/div/div[1]/div/div/div[1]")).click();
		List<WebElement> floorOptions = driver.findElements(By.xpath(".//*[@id='formAddFloor']/div[2]/div/div[1]/div/div/div[2]/div/div"));
		driver.findElement(By.xpath(".//*[@id='formAddFloor']/div[2]/div/div[1]/div/div/div[2]/div/div[" + floorOptions.size() + "]")).click();
		driver.findElement(By.xpath(".//*[@id='Space_Orientation']")).sendKeys(modelBuildingUnitRoom.getOrientation());

		for (int x = 0; x <= floorOptions.size(); x++)
		{
			driver.findElement(By.xpath(".//*[@id='Space_NewBuildingFloorNumber']")).clear();
			driver.findElement(By.xpath(".//*[@id='Space_NewBuildingFloorNumber']")).sendKeys(String.valueOf(x));		
			driver.findElement(By.xpath(".//*[@id='Space_Orientation']")).click();

			List<WebElement> tooltipElements = driver.findElements(By.xpath(".//*[@id='validation-tooltip']/div[2]"));
			if(!(tooltipElements.size() > 0))
			{
				break;
			}
			Thread.sleep(500);
		}
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='formAddFloor']/div[3]/font[2]/font/input")));
		driver.findElement(By.xpath(".//*[@id='formAddFloor']/div[3]/font[2]/font/input")).click();
		Thread.sleep(1000);
		finalCount = GetLocatedElementCount();
		System.out.println("After Adding new :: " + finalCount);
		Assert.assertEquals(initialCount < finalCount, true);
	}

	@Then("^Delete and verify building room$")
	public void Delete_and_verify_building_room() throws Throwable {

		Thread.sleep(3000);
		List<WebElement> trElements = driver.findElements(By.xpath(".//*[@id='container-main']/div[4]/div[2]/table/tbody/tr[@data-search='row']"));
		if (trElements.size() > 0) {
			WebElement lastElement = driver.findElement(By.xpath("(.//*[@id='container-main']/div[4]/div[2]/table/tbody/tr[@data-search='row'])[last()]/td[last()]/a[last()]"));
			if (lastElement != null) {
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading-overlay")));
				lastElement.click();
				Thread.sleep(2000);
				Alert alert = driver.switchTo().alert();
				alert.accept();
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading-overlay")));
				Thread.sleep(3000);
				System.out.println("------Room Removed------");
			}
		}
		removeCount = GetLocatedElementCount();
		Assert.assertEquals(removeCount < finalCount,true);
		Thread.sleep(3000);
		driver.close();
	}
}