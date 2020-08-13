package Stepdefinations.Building;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Models.Building.BuildingTanentModel;
import Models.BuildingUnit.BuildingUnitContactModel;
import Models.BuildingUnit.BuildingUnitTanentModel;
import Stepdefinations.Base;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class BuildingTenant extends Base {

	WebDriver driver;	
	BuildingUnitContactModel modelBuildingUnitContact=new BuildingUnitContactModel();
	BuildingUnitTanentModel modelBuildingUnitTanent=new BuildingUnitTanentModel();
	BuildingTanentModel modelBuildingTanent=new BuildingTanentModel();

	@Given("^Open the url and login with the valid data tenant$")
	public void Open_the_url_and_login_with_the_valid_data_tenant() throws Throwable {

		SetProperty();
		driver = Login();
		wait = new WebDriverWait(driver,WebDriverWaitTimeout);
	}

	@When("^User click on the MyApplication > Building> select building tanant$")
	public void User_click_on_the_MyApplication_Building_select_building_tanant() throws Throwable {

		GoToModule(Module.Building,driver);
		driver.get(BuildingDetailPath);
		Thread.sleep(2000);
	}

	@Then("^click on the tanent from sidebar$")
	public void click_on_the_tanent_from_sidebar() throws Throwable {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, document.body.scrollHeight)");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='container-main']/div[4]/div[1]/div/ul/li[6]/a")).click();
		Thread.sleep(3000);
		js.executeScript("window.scrollBy(0, 600)");
		Thread.sleep(3000);
	}

	@Then("^Check validation for Edit building tanent$")
	public void Check_validation_for_Edit_building_tanent() throws Throwable {

		driver.findElement(By.xpath(".//*[@id='container-main']/div[4]/div[2]/div[3]/table/tbody/tr[2]/td[8]/a[1]")).click();
		OpenChildWindow(driver);// switch to popup window
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='Renter_CompanyName']")));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='Renter_CompanyName']")).clear();
		driver.findElement(By.xpath("//input[@id='Renter_Phone']")).clear();
		driver.findElement(By.xpath("//input[@id='Renter_Mobile']")).clear();
		driver.findElement(By.xpath("//input[@id='Renter_ContactName']")).clear();
		driver.findElement(By.xpath("//input[@id='Renter_ContactFunction']")).clear();
		driver.findElement(By.xpath("//input[@id='Renter_Email']")).clear();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@value='Opslaan']")));
		driver.findElement(By.xpath("//input[@value='Opslaan']")).click();
		Thread.sleep(1000);
	}

	@Then("^verify that proper validation for edit building tanent shows or not$")
	public void Update_and_verify_building_tanent() throws Throwable {		

		WebElement expected = driver.findElement(By.xpath(".//*[@id='Renter_CompanyName']"));
		String errorMessage = expected.getAttribute("data-val-required");
		System.out.println("Tooltip::"+errorMessage);
		Assert.assertEquals(errorMessage,modelBuildingUnitContact.getErrorMessage());
		if(errorMessage.equals(modelBuildingUnitContact.getErrorMessage()))
		{
			System.out.println("--------Validation Successfull -------");
		}
		else
		{
			System.out.println("-------- Validation Unsuccessfull -------");
		}
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='page-modal']/div/div/form/div[3]/input[1]")).click();
		Thread.sleep(2000);
	}

	@Then("^User click on the Edit button and update the detail$")
	public void user_click_on_the_Edit_button_and_update_the_detail() throws Throwable {

		UpdateTenant();		
	}	

	public void UpdateTenant() throws Throwable	{

		driver.findElement(By.xpath(".//*[@id='container-main']/div[4]/div[2]/div[3]/table/tbody/tr[2]/td[8]/a[1]")).click();
		OpenChildWindow(driver); 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='Renter_CompanyName']")));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='Renter_CompanyName']")).clear();
		driver.findElement(By.xpath("//input[@id='Renter_Phone']")).clear();
		driver.findElement(By.xpath("//input[@id='Renter_Mobile']")).clear();
		driver.findElement(By.xpath("//input[@id='Renter_ContactName']")).clear();
		driver.findElement(By.xpath("//input[@id='Renter_ContactFunction']")).clear();
		driver.findElement(By.xpath("//input[@id='Renter_Email']")).clear();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='Renter_CompanyName']")).sendKeys(modelBuildingTanent.getCompanyName());
		driver.findElement(By.xpath("//input[@id='Renter_Phone']")).sendKeys(modelBuildingUnitTanent.getPhone());
		driver.findElement(By.xpath("//input[@id='Renter_Mobile']")).sendKeys(modelBuildingUnitTanent.getMobile());
		driver.findElement(By.xpath("//input[@id='Renter_ContactName']")).sendKeys(modelBuildingTanent.getContactName());
		driver.findElement(By.xpath("//input[@id='Renter_ContactFunction']")).sendKeys(modelBuildingTanent.getContactFunction());
		driver.findElement(By.xpath("//input[@id='Renter_Email']")).sendKeys(modelBuildingUnitTanent.getEmail());
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@value='Opslaan']")).click();
		Thread.sleep(8000);
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id='container-main']/div[4]/div[2]/div[3]/table/tbody/tr[2]/td[3]/font")).getText(),"Building Tenant Company name");
		if(driver.findElement(By.xpath("//*[@id='container-main']/div[4]/div[2]/div[3]/table/tbody/tr[2]/td[3]/font")).getText().equals("Building Tenant Company name"))
		{
			System.out.println("----Testcase Pass----");
		}
		else
		{
			System.out.println("----Testcase Fail----");
		}
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id='container-main']/div[4]/div[2]/div[3]/table/tbody/tr[2]/td[4]/font")).getText(),"Building Tenant Contact");
		String phoneNumber = driver.findElement(By.xpath("//*[@id='container-main']/div[4]/div[2]/div[3]/table/tbody/tr[2]/td[5]/font")).getText();
		if(phoneNumber.contains("651951133"))
		{
			System.out.println("----Testcase Pass----");
		}
		else
		{
			System.out.println("----Testcase Fail----");	
		}
		String mobileNumber = driver.findElement(By.xpath("//*[@id='container-main']/div[4]/div[2]/div[3]/table/tbody/tr[2]/td[6]/font")).getText();
		if(mobileNumber.contains("105174133"))
		{
			System.out.println("----Testcase Pass----");
		}
		else
		{
			System.out.println("----Testcase Fail----");	
		}
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id='container-main']/div[4]/div[2]/div[3]/table/tbody/tr[2]/td[7]/a")).getText(),"testshanoe1@loekonline.onmicrosoft.com");
	}

	@Then("^click on a remove buttons$")
	public void click_on_remove_button() throws Throwable {

		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='container-main']/div[4]/div[2]/div[3]/table/tbody/tr[2]/td[8]/a[2]")).click();
		wait.until(ExpectedConditions.alertIsPresent());
		Thread.sleep(1000);
		Alert alert = driver.switchTo().alert();
		Thread.sleep(1000);
		alert.accept();
	}

	@Then("^verify that detail successfully removed or not$")
	public void verify_that_detail_successfully_removed_or_not() throws Throwable {

		Thread.sleep(8000);
		if(driver.findElement(By.xpath("//*[@id='container-main']/div[4]/div[2]/div[3]/table/tbody/tr[2]/td[3]/font")).getText().equals(""))
		{
			System.out.println("----Testcase Pass----");
		}
		else
		{
			System.out.println("----Testcase Fail----");
		}
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id='container-main']/div[4]/div[2]/div[3]/table/tbody/tr[2]/td[4]/font")).getText(),"");
		String phoneNumber = driver.findElement(By.xpath("//*[@id='container-main']/div[4]/div[2]/div[3]/table/tbody/tr[2]/td[5]/font")).getText();
		if(phoneNumber.contains(""))
		{
			System.out.println("----Testcase Pass----");
		}
		else
		{
			System.out.println("----Testcase Fail----");	
		}
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id='container-main']/div[4]/div[2]/div[3]/table/tbody/tr[2]/td[6]/font")).getText(),"");
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id='container-main']/div[4]/div[2]/div[3]/table/tbody/tr[2]/td[7]/a")).getText(),"");
		System.out.println("Record Deleted");			
	}

	@Then("^User click on the Edit button and reupdate the detail$")
	public void user_click_on_the_Edit_button_and_reupdate_the_detail() throws Throwable {

		UpdateTenant();		
		Thread.sleep(3000);
		driver.close();
	}
}