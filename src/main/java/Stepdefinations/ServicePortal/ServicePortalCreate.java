package Stepdefinations.ServicePortal;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Stepdefinations.Base;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import junit.framework.Assert;
import Models.PortalCreateModel;
import Models.PortalCreateUserModel;

public class ServicePortalCreate extends Base{

	WebDriver driver;
	PortalCreateModel portalCreateModel = new PortalCreateModel();
	PortalCreateUserModel  portalCreateUserModel=new PortalCreateUserModel();
	Boolean portalExist = false;

	@Given("^Open the url and login with correct detail$")
	public void open_the_url_and_login_with_correct_detail() throws Throwable {
		
		SetProperty();
		driver = Login();	
		wait = new WebDriverWait(driver,WebDriverWaitTimeout);
	}

	@Then("^User click on the MyApplication >Serviceportal>setting$")
	public void user_click_on_the_MyApplication_Serviceportal_setting() throws Throwable {
		
		GoToModule(Module.ServicePortal, driver);
		driver.findElement(By.xpath(".//*[@id='navbar-pronectic']/ul[1]/li[4]/a")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//a[@class='add-button']")));
		Thread.sleep(2000);
	}

	@Then("^check if portal already exist then first delete it$")
	public void check_if_portal_already_exist_then_first_delete_it() throws Throwable {

		List<WebElement> locatedElements = driver.findElements(By.xpath(".//*[@id='container-main']/div/div[2]/table/tbody/tr")); 

		for(int i = 1; i<=locatedElements.size() ; i++)
		{
			String portalUrl = driver.findElement(By.xpath(".//*[@id='container-main']/div/div[2]/table/tbody/tr["+i+"]/td[3]/a")).getText();
			System.out.println("locatedElement " + portalUrl);
			if(portalUrl.contains("loekautomationbu"))
			{
				driver.findElement(By.xpath(".//*[@id='container-main']/div/div[2]/table/tbody/tr["+i+"]/td[1]/a")).click();
				portalExist = true;
				break;
			}
		}
		Thread.sleep(2000);
		if(portalExist)
		{
			driver.findElement(By.xpath(".//*[@id='container-main']/div/div[2]/div/div/h1/div/a[2]")).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='container-main']/form/h1")));
			Thread.sleep(2000);
			int radioButton = driver.findElements(By.xpath(".//*[@id='container-main']/form/div[@class='radio']")).size();
			System.out.println("radioButton : " + radioButton);
			driver.findElement(By.xpath(".//*[@id='container-main']/form/div["+radioButton+"]/div/label")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath(".//input[@class='btn btn-default']")).click();
			Thread.sleep(1000);
		}
	}

	@Then("^User click on the Create serviceportal and check the validation$")
	public void user_click_on_the_Create_serviceportal_and_check_the_validation() throws Throwable {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//a[@class='add-button']")).click();
		OpenChildWindow(driver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='ServicePortalDetail_Name']")));
		Thread.sleep(2000);
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='checkwizard-submit']")).click();
		Thread.sleep(3000);
		WebElement expected = driver.findElement(By.xpath(".//*[@id='validation-tooltip']/div[2]"));
		String errorMessage = expected.getText();
		Assert.assertEquals(errorMessage,"Naam portaal is een verplicht veld");
		if(errorMessage.equals("Naam portaal is een verplicht veld"))
		{
			System.out.println("--------Validation Successfull -------");
		}
		else
		{
			System.out.println("-------- Validation Unsuccessfull -------");
		}

	}
	@Then("^user fill the correct detail and Save it$")
	public void user_clear_the_detail_and_fill_the_correct_detail() throws Throwable {

		driver.findElement(By.xpath(".//*[@id='ServicePortalDetail_Name']")).sendKeys(portalCreateModel.getName());
		driver.findElement(By.xpath(".//*[@id='container-main']/form/div[1]/div[1]/div[2]/div/label")).click();
		ImportFile(portalCreateModel.getLogo());
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-1000)");
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='ServicePortalDetail_PrimaryColorHex']")).clear();
		driver.findElement(By.xpath(".//*[@id='ServicePortalDetail_PrimaryColorHex']")).sendKeys(portalCreateModel.getPrimaryColor());
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='ServicePortalDetail_BackColorHex']")).clear();
		driver.findElement(By.xpath(".//*[@id='ServicePortalDetail_BackColorHex']")).sendKeys(portalCreateModel.getBackColor());
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,300)");
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='ServicePortalDetail_Url']")).click();
		driver.findElement(By.xpath(".//*[@id='ServicePortalDetail_Url']")).sendKeys(portalCreateModel.getUrl());
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='ServicePortalDetail_EmergencyPhone']")).sendKeys(portalCreateModel.getEmergencyPhone());
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='ServicePortalDetail_CompanyName']")).sendKeys(portalCreateModel.getCompanyName());
		Thread.sleep(1000);
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='ServicePortalDetail_Address_Street']")).sendKeys(portalCreateModel.getAddressStreet());
		driver.findElement(By.xpath(".//*[@id='ServicePortalDetail_Address_HouseNumber']")).sendKeys(portalCreateModel.getAddressHouseNumber());
		driver.findElement(By.xpath(".//*[@id='ServicePortalDetail_Address_PostalCode']")).sendKeys(portalCreateModel.getAddressPostalCode());
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='ServicePortalDetail_Address_City']")).sendKeys(portalCreateModel.getAddressCity());
		driver.findElement(By.xpath(".//*[@id='ServicePortalDetail_ContactDetail_Phone']")).sendKeys(portalCreateModel.getContactDetailPhone());
		driver.findElement(By.xpath(".//*[@id='ServicePortalDetail_ContactDetail_Email']")).sendKeys(portalCreateModel.getContactDetailEmail());
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();	
	}

	@Then("^verify that it shows the message portal created successfully$")
	public void user_click_on_the_save_button_it_shows_the_message_portal_created_successfully() throws Throwable {

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='container-main']/div/div[2]/div/div/div[1]/div[2]")));
		Assert.assertEquals(driver.findElement(By.xpath(".//*[@id='container-main']/div/div[2]/div/div/div[1]/div[2]")).getText(), portalCreateModel.getName());
		Assert.assertEquals(driver.findElement(By.xpath(".//*[@id='container-main']/div/div[2]/div/div/div[7]/div[2]")).getText().contains(portalCreateModel.getEmergencyPhone()),true);
		Assert.assertEquals(driver.findElement(By.xpath(".//*[@id='container-main']/div/div[2]/div/div/div[9]/div[2]")).getText(),portalCreateModel.getCompanyName());
		Assert.assertEquals(driver.findElement(By.xpath(".//*[@id='container-main']/div/div[2]/div/div/div[10]/div[2]")).getText(),portalCreateModel.getAddressStreet());
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,400)");
		Assert.assertEquals(driver.findElement(By.xpath(".//*[@id='container-main']/div/div[2]/div/div/div[12]/div[2]")).getText(),portalCreateModel.getAddressPostalCode());
		Assert.assertEquals(driver.findElement(By.xpath(".//*[@id='container-main']/div/div[2]/div/div/div[13]/div[2]")).getText(),portalCreateModel.getAddressCity());
		Assert.assertEquals(driver.findElement(By.xpath(".//*[@id='container-main']/div/div[2]/div/div/div[15]/div[2]/a")).getText(),portalCreateModel.getContactDetailEmail());
		//driver.close();
	}

	@Then("^click on the UserTab and select the AddUser$")
	public void click_on_the_UserTab_nad_select_the_AddUser() throws Throwable {
		
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='navbar-pronectic']/ul[1]/li[1]/a")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='input-searchbox']")));
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='container-main']/div[1]/div[2]/div/a")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='container-main']/h1")));
		Thread.sleep(1000);
	}

	@Then("^Fill the valid detail and click on the next$")
	public void fill_the_valid_detail_and_click_on_the_next() throws Throwable {
		
		Thread.sleep(2000);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading-overlay")));
		Thread.sleep(3000);
		Actions builder = new Actions(driver);
		builder.moveToElement(driver.findElement(By.xpath(".//*[@id='page-buildings']/div[1]/div[1]/div[1]/div[1]/div"))).perform();
		builder.moveToElement(driver.findElement(By.xpath(".//*[@id='page-buildings']/div[1]/div[1]/div[1]/div[1]/div"))).click().perform();

		List<WebElement> locatedElements = driver.findElements(By.xpath(".//*[@id='page-buildings']/div[1]/div[1]/div[1]/div[2]/div/div"));
		System.out.println("locatedElements.size() " + locatedElements.size());
		if(locatedElements.size() == 1)
		{
			driver.findElement(By.xpath(".//*[@id='page-buildings']/div[1]/div[1]/div[1]/div[1]/div")).click();
			Thread.sleep(100);
			String portal = driver.findElement(By.xpath(".//*[@id='page-buildings']/div[1]/div[1]/div[1]/div[2]/div/div[1]")).getText();
			if(portal.toLowerCase().trim().equals(portalCreateModel.getName().toLowerCase().trim()))
			{
				driver.findElement(By.xpath(".//*[@id='page-buildings']/div[1]/div[1]/div[1]/div[2]/div/div[1]")).click();
			}
		}
		else
		{
			boolean flag = false;
			for (int i = 1; i <= locatedElements.size(); i++)
			{
				Thread.sleep(100);
				driver.findElement(By.xpath(".//*[@id='page-buildings']/div[1]/div[1]/div[1]/div[1]/div")).click();
				Thread.sleep(100);
				String portal = driver.findElement(By.xpath(".//*[@id='page-buildings']/div[1]/div[1]/div[1]/div[2]/div/div[" + i + "]")).getText();
				Thread.sleep(100);
				System.out.println("portal.toLowerCase() " + portal.toLowerCase());
				System.out.println("portalCreateModel.getName() " + portalCreateModel.getName());
				if(portal.toLowerCase().trim().equals(portalCreateModel.getName().toLowerCase().trim()))
				{	
					flag = true;
					driver.findElement(By.xpath(".//*[@id='page-buildings']/div[1]/div[1]/div[1]/div[2]/div/div[" + i + "]")).click();
					break;
				}
			}
			if(!flag)
			{
				for (int i = 2; i <= locatedElements.size(); i++)
				{
					Thread.sleep(100);
					driver.findElement(By.xpath(".//*[@id='page-buildings']/div[1]/div[1]/div[1]/div[1]/div")).click();
					Thread.sleep(100);
					String portal = driver.findElement(By.xpath(".//*[@id='page-buildings']/div[1]/div[1]/div[1]/div[2]/div/div[" + i + "]")).getText();
					Thread.sleep(100);
					System.out.println("portal.toLowerCase() " + portal.toLowerCase());
					System.out.println("portalCreateModel.getName() " + portalCreateModel.getName());
					if(portal.toLowerCase().trim().equals(portalCreateModel.getName().toLowerCase().trim()))
					{	
						driver.findElement(By.xpath(".//*[@id='page-buildings']/div[1]/div[1]/div[1]/div[2]/div/div[" + i + "]")).click();
						break;
					}
				}
			}
		}
		
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='buildingbrowser-buildingunits']/div/div[1]/input")).sendKeys(portalCreateUserModel.getSearchtextbox());
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading-overlay")));
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");
		Thread.sleep(2000);
		//driver.findElement(By.xpath(".//*[@id='buildingbrowser-buildingunits']/div/div[1]/div/i")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@data-id='"+ buildingUnitDataId +"']")).click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading-overlay")));
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,300)");
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='page-buildings']/button[2]"))).click();
	}

	@Then("^Fill the detail of the Add User and submit$")
	public void Fill_the_detail_of_the_Add_User() throws Throwable{

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='page-input']/form/table/tbody/tr/td[3]/input")));
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='page-input']/form/table/tbody/tr/td[3]/input")).clear();
		driver.findElement(By.xpath(".//*[@id='page-input']/form/table/tbody/tr/td[3]/input")).sendKeys(portalCreateUserModel.getEmailAddress());
		driver.findElement(By.xpath(".//*[@id='page-input']/form/table/tbody/tr/td[4]/input")).clear();
		driver.findElement(By.xpath(".//*[@id='page-input']/form/table/tbody/tr/td[4]/input")).sendKeys(portalCreateUserModel.getCompanyName());
		driver.findElement(By.xpath(".//*[@id='page-input']/form/table/tbody/tr/td[5]/input")).clear();
		driver.findElement(By.xpath(".//*[@id='page-input']/form/table/tbody/tr/td[5]/input")).sendKeys(portalCreateUserModel.getContact());
		driver.findElement(By.xpath(".//*[@id='page-input']/form/table/tbody/tr/td[7]/input")).clear();
		driver.findElement(By.xpath(".//*[@id='page-input']/form/table/tbody/tr/td[7]/input")).sendKeys(portalCreateUserModel.getPhone());
		driver.findElement(By.xpath(".//*[@id='page-input']/form/table/tbody/tr/td[9]/input")).clear();
		driver.findElement(By.xpath(".//*[@id='page-input']/form/table/tbody/tr/td[9]/input")).sendKeys(portalCreateUserModel.getMobile());
		driver.findElement(By.xpath(".//*[@id='page-input']/form/table/tbody/tr/td[11]/input")).sendKeys(portalCreateUserModel.getPassword());
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='Button-Add']")).click();
		Thread.sleep(2000);
		if(!isAlertPresent(driver))
		{
			OpenChildWindow(driver);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='button-save']"))).click();
		}
		Thread.sleep(2000);
		Alert alert=driver.switchTo().alert();
		alert.accept();
	}

	@Then("^verify that detail of the respective user shown as expected$")
	public void verify_that_detail_of_the_respective_user_shown_as_expected() throws Throwable {

		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading-overlay")));
		Thread.sleep(4000);
		System.out.println(IsTextOnPagePresent(driver,portalCreateUserModel.getEmailAddress()));
		Assert.assertEquals(IsTextOnPagePresent(driver,portalCreateUserModel.getEmailAddress()),true);
		Assert.assertEquals(IsTextOnPagePresent(driver,portalCreateUserModel.getContact()),true);
		Assert.assertEquals(IsTextOnPagePresent(driver,portalCreateUserModel.getCompanyName()),true);
		Thread.sleep(3000);
		driver.close();
	}
}