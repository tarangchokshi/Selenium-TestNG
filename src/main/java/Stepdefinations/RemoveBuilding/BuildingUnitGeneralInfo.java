package Stepdefinations.RemoveBuilding;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Stepdefinations.Base;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class BuildingUnitGeneralInfo extends Base {
	WebDriver driver;

	@Given("^Open the url and login with the valid Info$")
	public void open_the_url_and_login_with_the_valid_Info() throws Throwable {	 
		SetProperty();
		driver= Login();
		wait = new WebDriverWait(driver,WebDriverWaitTimeout);
	}

	@When("^User click on the MyApplication and select the buildingunit editgeneralinfo$")
	public void user_click_on_the_MyApplication_and_select_the_buildingunit_editgeneralinfo() throws Throwable {
		GoToModule(Module.Building, driver);
		driver.get(BuildingUnitDetailPath);
		Thread.sleep(2000);
	}

	@Then("^User click on the stayobjects from sidebar and edit details$")
	public void User_click_on_the_stayobjects_from_sidebar_and_edit_details() throws Throwable {		
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='container-main']/div[2]/div[3]/div/a[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='Description']")).clear();
		driver.findElement(By.xpath(".//*[@id='Description']")).sendKeys("Building unit description");
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='container-main']/div/div[2]/form/div/div[6]/input")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='container-main']/div[2]/div[2]/h1")));
		Thread.sleep(1000);
		String buildingUnit = driver.findElement(By.xpath(".//*[@id='container-main']/div[2]/div[2]/h1")).getText();
		System.out.println("buildingUnit : " + buildingUnit);
		Assert.assertEquals(buildingUnit.toLowerCase().contains("building unit description"), true);
		Thread.sleep(1000);
		System.out.println("Testcase Successfully pass");
	}

	@Then("^user click on the top left photo icon$")
	public void user_click_on_the_photo_icon() throws Throwable {
		Thread.sleep(2000);

		WebElement imageElement =  driver.findElement(By.xpath("//*[@id='container-main']/div[2]/div[1]/div/img"));
		Actions builder = new Actions(driver);
		builder.moveToElement(imageElement).perform();
		builder.moveToElement(imageElement).click().perform();

		Thread.sleep(2000);
		OpenChildWindow(driver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='image-uploader-menu-default-upload']"))).click();
		ImportFile("\\src\\main\\java\\Resources\\Building.jpg");
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='image-uploader-close']")).click();
		System.out.println("Image successfully updated");
		Thread.sleep(2000);
		driver.close();
	}
}