package Stepdefinations.BuildingUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Models.BuildingUnit.BuildingUnitContactModel;
import Models.BuildingUnit.BuildingUnitTanentModel;
import Stepdefinations.Base;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class BuildingUnitTenant extends Base {

	WebDriver driver;
	BuildingUnitContactModel modelBuildingUnitContact=new BuildingUnitContactModel();
	BuildingUnitTanentModel modelBuildingUnitTanent=new BuildingUnitTanentModel();
	
	@Given("^Open the url and login with the valid unit tenant detail$")
	public void open_the_url_and_login_with_the_valid_unit_tenant_detail() throws Throwable {
		
		SetProperty();
		driver = Login();
		wait = new WebDriverWait(driver,WebDriverWaitTimeout);
	}

	@When("^User click on the MyApplication and select the buildingunit tenant$")
	public void user_click_on_the_MyApplication_and_select_the_buildingunit_tenant() throws Throwable {
		
		GoToModule(Module.Building,driver);
		driver.get(BuildingUnitDetailPath);
		Thread.sleep(2000);
	}
	@Then("^click on the tenant from sidebar$")
	public void click_on_the_tenant_from_sidebar() throws Throwable {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='container-main']/div[4]/div[1]/div/ul/li[3]/a")).click();
		Thread.sleep(3000);
		js.executeScript("window.scrollBy(0, document.body.scrollHeight)");
		Thread.sleep(3000);
	}

	@Then("^Check validations for Edit building unit tenant$")
	public void check_validations_for_Edit_building_unit_tenant() throws Throwable {
		
		driver.findElement(By.xpath("//*[@id='container-main']/div[4]/div[2]/div[2]/table/tbody/tr[4]/td[8]/a[1]")).click();
		OpenChildWindow(driver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@name='UnitRenter.CompanyName']")));
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@name='UnitRenter.CompanyName']")).clear();
		driver.findElement(By.xpath(".//*[@id='UnitRenter_Phone']")).clear();
		driver.findElement(By.xpath(".//*[@id='UnitRenter_Mobile']")).clear();
		driver.findElement(By.xpath(".//*[@id='UnitRenter_ContactName']")).clear();
		driver.findElement(By.xpath(".//*[@id='UnitRenter_ContactFunction']")).clear();
		driver.findElement(By.xpath(".//*[@id='UnitRenter_Email']")).clear();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@value='Opslaan']")));
		driver.findElement(By.xpath("//input[@value='Opslaan']")).click();
		Thread.sleep(2000);
	}

	@Then("^Verify that proper validations for edit building unit tenant shows or not$")
	public void verify_that_proper_validations_for_edit_building_unit_tenant_shows_or_not() throws Throwable {
		
        JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)");
		WebElement expected = driver.findElement(By.xpath(".//*[@id='UnitRenter_CompanyName']"));
		String Message1 = expected.getAttribute("data-val-required");
		System.out.println("Tooltip::"+Message1);
		Assert.assertEquals(Message1,modelBuildingUnitContact.getErrorMessage());
		if(Message1.equals(modelBuildingUnitContact.getErrorMessage()))
		{
			System.out.println("--------Validation Successfull -------");
		}
		else
		{
			System.out.println("-------- Validation Unsuccessfull -------");
		}
		
		driver.findElement(By.xpath("//*[@id='page-modal']/div/div/form/div[3]/input[1]")).click();	
	}

	@Then("^User click on the Edit button to update unit tenant detail$")
	public void user_click_on_the_Edit_button_to_update_unit_tenant_detail() throws Throwable {
		
		UpdateTenant();
	}
	
	public void UpdateTenant() throws Throwable	{
		
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='container-main']/div[4]/div[2]/div[2]/table/tbody/tr[4]/td[8]/a[1]")).click();
		OpenChildWindow(driver); 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@name='UnitRenter.CompanyName']")));
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@name='UnitRenter.CompanyName']")).clear();
		driver.findElement(By.xpath(".//*[@id='UnitRenter_Phone']")).clear();
		driver.findElement(By.xpath(".//*[@id='UnitRenter_Mobile']")).clear();
		driver.findElement(By.xpath(".//*[@id='UnitRenter_ContactName']")).clear();
		driver.findElement(By.xpath(".//*[@id='UnitRenter_ContactFunction']")).clear();
		driver.findElement(By.xpath(".//*[@id='UnitRenter_Email']")).clear();
		driver.findElement(By.xpath(".//*[@name='UnitRenter.CompanyName']")).sendKeys(modelBuildingUnitTanent.getCompanyName());
		driver.findElement(By.xpath(".//*[@id='UnitRenter_Phone']")).sendKeys(modelBuildingUnitTanent.getPhone());
		driver.findElement(By.xpath(".//*[@id='UnitRenter_Mobile']")).sendKeys(modelBuildingUnitTanent.getMobile());
		driver.findElement(By.xpath(".//*[@id='UnitRenter_ContactName']")).sendKeys(modelBuildingUnitTanent.getContactName());
		driver.findElement(By.xpath(".//*[@id='UnitRenter_ContactFunction']")).sendKeys(modelBuildingUnitTanent.getContactFunction());
		driver.findElement(By.xpath(".//*[@id='UnitRenter_Email']")).sendKeys(modelBuildingUnitTanent.getEmail());
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@value='Opslaan']")).click();
		Thread.sleep(8000);
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id='container-main']/div[4]/div[2]/div[2]/table/tbody/tr[4]/td[3]/font")).getText(),modelBuildingUnitTanent.getCompanyName());
		if(driver.findElement(By.xpath("//*[@id='container-main']/div[4]/div[2]/div[2]/table/tbody/tr[4]/td[3]/font")).getText().equals(modelBuildingUnitTanent.getCompanyName()))
		{
			System.out.println("---- Testcase 1 Pass to verify Company Name added ----");
		}
		else
		{
			System.out.println("---- Testcase 1 Fail to verify Company Name added ----");
		}
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id='container-main']/div[4]/div[2]/div[2]/table/tbody/tr[4]/td[4]/font")).getText(),modelBuildingUnitTanent.getContactName());
		String phoneNumber = driver.findElement(By.xpath("//*[@id='container-main']/div[4]/div[2]/div[2]/table/tbody/tr[4]/td[5]/font")).getText();
		if(phoneNumber.contains("651951133"))
		{
			System.out.println("---- Testcase 2 Pass to verify PhoneNumber added ----");
		}
		else
		{
			System.out.println("---- Testcase 2 Fail to verify PhoneNumber added ----");	
		}
		String mobileNumber = driver.findElement(By.xpath("//*[@id='container-main']/div[4]/div[2]/div[2]/table/tbody/tr[4]/td[6]/font")).getText();
		if(mobileNumber.contains("105174133"))
		{
			System.out.println("---- Testcase 3 Pass to verify MobileNumber added ----");
		}
		else
		{
			System.out.println("---- Testcase 3 Fail to verify MobileNumber added ----");	
		}				
	}
	
	@Then("^click on delete button to remove unit tenant$")
	public void click_on_delete_button_to_remove_unit_tenant() throws Throwable {
		
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='container-main']/div[4]/div[2]/div[2]/table/tbody/tr[4]/td[8]/a[2]")).click();
		wait.until(ExpectedConditions.alertIsPresent());
		Thread.sleep(1000);
		Alert alert = driver.switchTo().alert();
		Thread.sleep(1000);
		alert.accept();
	}

	@Then("^Verify that unit tenant detail removed or not$")
	public void verify_that_unit_tenant_detail_removed_or_not() throws Throwable {
		
		Thread.sleep(8000);
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id='container-main']/div[4]/div[2]/div[2]/table/tbody/tr[4]/td[3]/font")).getText(),"");
		if(driver.findElement(By.xpath("//*[@id='container-main']/div[4]/div[2]/div[2]/table/tbody/tr[4]/td[3]/font")).getText().equals(""))
		{
			System.out.println("---- Testcase 4 Pass to verify Remove CompanyName ----");
		}
		else
		{
			System.out.println("---- Testcase 4 Fail to verify Remove CompanyName ----");
		}
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id='container-main']/div[4]/div[2]/div[2]/table/tbody/tr[4]/td[4]/font")).getText(),"");
		String phoneNumber = driver.findElement(By.xpath("//*[@id='container-main']/div[4]/div[2]/div[2]/table/tbody/tr[4]/td[5]/font")).getText();
		if(phoneNumber.contains(""))
		{
			System.out.println("---- Testcase 5 Pass to verify Remove PhoneNumber ----");
		}
		else
		{
			System.out.println("---- Testcase 5 Fail to verify Remove PhoneNumber ----");	
		}
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id='container-main']/div[4]/div[2]/div[2]/table/tbody/tr[4]/td[6]/font")).getText(),"");
		System.out.println("Record Deleted Successfully...");		
	}

	@Then("^User click on the Edit button to reupdate unit tenant detail$")
	public void user_click_on_the_Edit_button_to_reupdate_unit_tenant_detail() throws Throwable {
		
		UpdateTenant();
		Thread.sleep(3000);
		driver.close();
	}
}