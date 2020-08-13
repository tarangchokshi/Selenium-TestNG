package Stepdefinations.BuildingUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Models.BuildingUnit.BuldingUnitAddManualModel;
import Stepdefinations.Base;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class BuildingUnitAddManual extends Base{

	WebDriver driver;
	BuldingUnitAddManualModel modelBuldingAddManual=new BuldingUnitAddManualModel();
	@Given("^Open application URL$")
	public void open_the_application_Url() throws Throwable {
		SetProperty();
		driver = Login();
		wait = new WebDriverWait(driver,WebDriverWaitTimeout);
	}
	@When("^User click on the stayobject from sidebar$")
	public void User_click_on_the_stayobject_from_sidebar() throws Throwable {
		driver.get(BuildingDetailPath);
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='container-main']/div[4]/div[1]/div/ul/li[2]/a")).click();
	}

	@Then("^click on the Addstayobject link$")
	public void click_on_the_Addstayobject_link() throws Throwable {
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='container-main']/div[4]/div[2]/a[2]")).click();
		OpenChildWindow(driver);
	}
	@Then("^Keep the form blank and click on the save$")
	public void Keep_the_form_blank_and_click_on_the_save() throws Throwable {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='Street']")));
		driver.findElement(By.xpath(".//*[@id='Street']")).clear();
		driver.findElement(By.xpath(".//*[@id='FullPostalCode']")).clear();
		driver.findElement(By.xpath(".//*[@id='PlaceName']")).clear();
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='page-modal']/div/div/form/div[3]/input[2]")).click();
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)");

	}
	@Then("^verify that validation message shows expected$")
	public void verify_that_validation_message_shows_expected () throws Throwable {
		Thread.sleep(2000);
		WebElement expected = driver.findElement(By.xpath(".//*[@id='PlaceName']"));
		String Message1 = expected.getAttribute("data-val-required");
		System.out.println("Tooltip::"+Message1);

		Assert.assertEquals(Message1,modelBuldingAddManual.getMessage1());
		if(Message1.equals(modelBuldingAddManual.getMessage1()))
		{
			System.out.println("--------Validation Successfull -------");
		}
		else
		{
			System.out.println("-------- Validation Unsuccessfull -------");
		}
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='page-modal']/div/div/form/div[3]/input[1]")).click();
	}
	
	@Then("^User again click on the Addstayobject link$")
	public void user_again_click_on_the_Addstayobject_link() throws Throwable {
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='container-main']/div[4]/div[2]/a[2]")).click();
		Thread.sleep(1000);
		OpenChildWindow(driver);
	}

	@Then("^user fill the detail$")
	public void user_fill_the_detail() throws Throwable {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='Street']")));
		driver.findElement(By.xpath(".//*[@id='Street']")).clear();
		driver.findElement(By.xpath(".//*[@id='FullPostalCode']")).clear();
		driver.findElement(By.xpath(".//*[@id='PlaceName']")).clear();
		driver.findElement(By.xpath(".//*[@id='Street']")).sendKeys(modelBuldingAddManual.getStreet());
		driver.findElement(By.xpath(".//*[@id='FullHouseNumber']")).sendKeys(modelBuldingAddManual.getFullHouseNumber());
		driver.findElement(By.xpath(".//*[@id='FullPostalCode']")).sendKeys(modelBuldingAddManual.getFullPostalCode());
		driver.findElement(By.xpath(".//*[@id='PlaceName']")).sendKeys(modelBuldingAddManual.getPlaceName());
		driver.findElement(By.xpath(".//*[@id='Description']")).sendKeys(modelBuldingAddManual.getDescription());
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='page-modal']/div/div/form/div[3]/input[2]")));
		driver.findElement(By.xpath(".//*[@id='page-modal']/div/div/form/div[3]/input[2]")).click();
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");
		Thread.sleep(2000);
		driver.close();
	}
}