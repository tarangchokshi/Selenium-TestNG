package Stepdefinations.ServicePortal;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Models.PortalNewsModel;
import Models.ServicePortalMaintainance;
import Stepdefinations.Base;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;

public class ServiceportalMaintainance extends Base {

	WebDriver driver;
	Boolean messagePresent;
	PortalNewsModel portalNewsModel=new PortalNewsModel();
	ServicePortalMaintainance servicePortalMaintainance=new ServicePortalMaintainance();
	
	@Given("^Open the url and login with right information$")
	public void open_the_url_and_login_with_right_information() throws Throwable {
		
		SetProperty();
		driver = Login();	
		wait = new WebDriverWait(driver,WebDriverWaitTimeout);
		GoToModule(Module.ServicePortal, driver);	
	}
	
	@Then("^User click on the MyApplication >Serviceportal>maintainance$")
	public void user_click_on_the_MyApplication_Serviceportal_maintainance() throws Throwable {
		
		driver.findElement(By.xpath("//*[@id='navbar-pronectic']/ul[1]/li[3]/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='container-main']/div/div[2]/div/a")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='checkwizard-navigation']/li[1]")));
		Thread.sleep(3000);	
	}

	@Then("^User click on the MaintainanceTab and fill detail and verify validations$")
	public void user_cleck_on_the_MaintainanceTab_and_fill_detail() throws Throwable {

		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading-overlay")));
		Thread.sleep(1000);	
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@data-id='"+ buildingUnitDataId +"']")).click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading-overlay")));
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='checkwizard-next']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='button-add-calendar']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='Subject']")).sendKeys(servicePortalMaintainance.getTopic());
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='container-main']/form/div[3]/div[2]/div/div[1]/div/div[2]/div/label/span")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='Message']")).clear();
		driver.findElement(By.xpath(".//*[@id='Message']")).sendKeys(servicePortalMaintainance.getTopicDescription());
		Thread.sleep(1000);
		js.executeScript("window.scrollBy(0,400)");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='table-calendar']/tbody/tr[1]/td[1]/input[2]")).sendKeys(servicePortalMaintainance.getTopic() + " 1");
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='table-calendar']/tbody/tr[1]/td[2]/input")).clear();
		driver.findElement(By.xpath(".//*[@id='table-calendar']/tbody/tr[1]/td[2]/input")).sendKeys("10-07-2018");
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='table-calendar']/tbody/tr[1]/td[3]/input")).click();
		driver.findElement(By.xpath(".//*[@id='table-calendar']/tbody/tr[1]/td[3]/input")).sendKeys(servicePortalMaintainance.getFrom());
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='table-calendar']/tbody/tr[1]/td[4]/input")).clear();
		driver.findElement(By.xpath(".//*[@id='table-calendar']/tbody/tr[1]/td[4]/input")).sendKeys("15-07-2018");
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='table-calendar']/tbody/tr[1]/td[5]/input")).click();
		driver.findElement(By.xpath(".//*[@id='table-calendar']/tbody/tr[1]/td[5]/input")).sendKeys(servicePortalMaintainance.getTo());
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='table-calendar']/tbody/tr[2]/td[1]/input[2]")).sendKeys(servicePortalMaintainance.getTopic() + " 2");
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='table-calendar']/tbody/tr[2]/td[2]/input")).clear();
		driver.findElement(By.xpath(".//*[@id='table-calendar']/tbody/tr[2]/td[2]/input")).sendKeys("17-07-2018");
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='table-calendar']/tbody/tr[2]/td[3]/input")).click();
		driver.findElement(By.xpath(".//*[@id='table-calendar']/tbody/tr[2]/td[3]/input")).sendKeys("05:00");
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='table-calendar']/tbody/tr[2]/td[4]/input")).clear();
		driver.findElement(By.xpath(".//*[@id='table-calendar']/tbody/tr[2]/td[4]/input")).sendKeys("19-07-2018");
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='table-calendar']/tbody/tr[2]/td[5]/input")).click();
		driver.findElement(By.xpath(".//*[@id='table-calendar']/tbody/tr[2]/td[5]/input")).sendKeys("12:00");
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='newsItemSubmit']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='container-main']/div[1]/div[1]/h1")));
		Thread.sleep(3000);
		String frmdate=driver.findElement(By.xpath(".//*[@id='container-main']/div[1]/div[1]/table/tbody/tr[1]/td[2]")).getText();
		String todate=driver.findElement(By.xpath(".//*[@id='container-main']/div[1]/div[1]/table/tbody/tr[1]/td[3]")).getText();
		System.out.println("FromDate::"+frmdate);
		System.out.println("ToDate::"+todate);
		Assert.assertEquals(frmdate,"10-07-2018 01:00");
		Assert.assertEquals(todate,"15-07-2018 23:00");
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,300)");
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id='container-main']/table/tbody/tr/td[3]")).getText(),servicePortalMaintainance.getBuildingAddress());
		Assert.assertEquals(servicePortalMaintainance.getAddress().toLowerCase().contains(driver.findElement(By.xpath("//*[@id='container-main']/table/tbody/tr/td[4]")).getText().toLowerCase()), true);
		Thread.sleep(1000);
		js.executeScript("window.scrollBy(0,-250)", "");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='container-main']/div[1]/div[2]/div/a[1]")).click();
		Thread.sleep(1000);
		String message=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='toast-container']/div/div"))).getText();
		System.out.println("Publish Message::"+message);
		Assert.assertEquals(message,"Bericht gepubliceerd");
		Thread.sleep(5000);
		driver.navigate().to(SiteUrl+"/Serviceportaal/loekautomationbu/Login");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='Email']")).sendKeys(portalNewsModel.getEmail());
		driver.findElement(By.xpath("//*[@id='Password']")).sendKeys(portalNewsModel.getPassword());
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='login']/form/div[3]/input"))).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='navbar-pronectic']/ul[1]/li[3]/a"))).click();
		Thread.sleep(2000);
		String unreadmessage=driver.findElement(By.xpath("(html/body/div[1]/table/tbody/tr)[last()]/td[4]")).getText();
		System.out.println("Message read::" + unreadmessage);
		messagePresent = false;
		if(unreadmessage.contains("Ongelezen") || unreadmessage.contains("Unread"))
		{
			messagePresent = true;
		}
		Assert.assertEquals(messagePresent,true);
		Thread.sleep(1000);

		List<WebElement> rows = driver.findElements(By.xpath("html/body/div[1]/table/tbody/tr"));
		int count = rows.size();
		System.out.println("Initial ROW COUNT : "+count);

		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(html/body/div[1]/table/tbody/tr)[last()]/td[1]/a"))).click();
		Thread.sleep(1000);
		driver.navigate().back();
		Thread.sleep(1000);
		driver.navigate().refresh();
		String readonmessage=driver.findElement(By.xpath("html/body/div[1]/table/tbody/tr[last()]/td[4]")).getText();
		Thread.sleep(2000);
		System.out.println("Message ReadON::" +readonmessage);
		messagePresent = false;
		if(readonmessage.contains("Gelezen op") || readonmessage.contains("Read on"))
		{
			messagePresent = true;
		}
		Assert.assertEquals(messagePresent,true);
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='navbar-pronectic']/ul[1]/li[1]/a"))).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("html/body/div[1]/div/div[1]/div[1]/div/div[1]/a[1]/div/p[1]")).click();
		Thread.sleep(1000);
		js.executeScript("window.scrollBy(0,200)");
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//a[@class='btn btn-default']")).click();
		Thread.sleep(2000);
		Alert alt=driver.switchTo().alert();
		alt.accept();
		Thread.sleep(1000);
		List<WebElement> rowslast = driver.findElements(By.xpath("html/body/div[1]/table/tbody/tr"));
		int counts = rowslast.size();
		System.out.println("Final ROW COUNT : "+counts);	
		driver.close();
	}	
}