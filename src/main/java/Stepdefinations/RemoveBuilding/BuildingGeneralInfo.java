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

public class BuildingGeneralInfo extends Base {

	WebDriver driver;
	WebDriverWait wait;
	@Given("^Open the url and login with the valid datas$")
	public void Open_the_url_and_login_with_the_valid_data() throws Throwable {
		SetProperty();
		driver= Login();
		wait = new WebDriverWait(driver,WebDriverWaitTimeout);
	}
	
	@When("^User click on the MyApplication > Building> select building$")
	public void User_click_on_the_MyApplication_Building_select_building() throws Throwable {
		GoToModule(Module.Building,driver);
		driver.get(BuildingDetailPath);
		Thread.sleep(2000);
	}

	@Then("^User click on the changedata link and update detail$")
	public void user_click_on_the_changedata_link_and_update_detail() throws Throwable {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='container-main']/div[2]/div[3]/div/a[1]")).click();
		Thread.sleep(1000);		
		driver.findElement(By.xpath("//*[@id='BuildingNumber']")).clear();
		driver.findElement(By.xpath("//*[@id='BuildingNumber']")).sendKeys("Test");
		driver.findElement(By.xpath("//*[@id='ManagementCode']")).clear();
		driver.findElement(By.xpath("//*[@id='ManagementCode']")).sendKeys("Managementcode1");
		driver.findElement(By.xpath("//*[@id='CostCentre']")).clear();
		driver.findElement(By.xpath("//*[@id='CostCentre']")).sendKeys("Costcenter1");
		Thread.sleep(3000);
	}
	
	@Then("^Clik on the submit button$")
	public void clik_on_the_submit_button() throws Throwable {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@value='Opslaan']")));
		driver.findElement(By.xpath("//input[@value='Opslaan']")).click();
	}
	
	@Then("^Verify that Change info shown as expected$")
	public void Verify_that_Change_info_shown_as_expected() throws Throwable {
		Thread.sleep(2000);
		Assert.assertEquals(driver.findElement(By.xpath(".//*[@id='display-BuildingNumber']")).getText().contains("Test"),true);
		Assert.assertEquals(driver.findElement(By.xpath(".//*[@id='display-ManagementCode']")).getText(),"Managementcode1");
		Assert.assertEquals(driver.findElement(By.xpath(".//*[@id='display-CostCentre']")).getText(),"Costcenter1");
		System.out.println("Testcase Successfully pass");
	}

	@Then("^user click on the photo icon$")
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
		
		driver.findElement(By.xpath(".//*[@id='image-uploader-close']")).click();
		System.out.println("Image successfully updated");
		Thread.sleep(2000);
		driver.close();
	}	
}