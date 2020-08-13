/*   Important Note : For use of Smoke test over, 1) Test Environment 2) Production Environment
 *    
 *    For use Production Smoke - Remove Comment line from - line 38 - 41
 *     							and, add comment line from - line 47 -50
 *    For use Test Env Smoke - Add comment line from - line 38-41
 *    							and, remove comment line from - line 47-50  
 * Author : Tarang Chokshi
 * */


package Stepdefinations.SmokeTesting;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Stepdefinations.Base;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.sourceforge.htmlunit.corejs.javascript.ast.TryStatement;

public class SmokeTest extends Base{

	WebDriver driver;

	@Given("^Open Loek and perform smoke testing using mentioned scenarios...$")
	public void Open_the_production_url_and_login_with_the_valid_data() throws Throwable {

		SetProperty();
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver,60);
		driver.manage().window().maximize();

		/* Start Production Smoke credentials  use*/
		//		driver.get(ProductionUrl + "/user/login");
		//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//input[@name='Email']")));
		//		driver.findElement(By.xpath(".//input[@name='Email']")).sendKeys(ProductionLoginEmail);
		//		driver.findElement(By.xpath(".//input[@name='Password']")).sendKeys(LoginPassword);
		/*End Production smoke credentials use*/

		/* Start Test Env Smoke credentials  use*/
		driver.get(SiteUrl + "/user/login");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//input[@name='Email']")));
		driver.findElement(By.xpath(".//input[@name='Email']")).sendKeys(LoginEmail);
		driver.findElement(By.xpath(".//input[@name='Password']")).sendKeys(LoginPassword);
		/*End Test Env smoke credentials use*/

		Thread.sleep(2000);
		driver.findElement(By.xpath(".//button[@id='submitInloggen']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='container-main']/div/div[1]/h5[1]")));
		System.out.println("Home page redirection successful");
		Thread.sleep(3000);
	}

	public void GoToPath(String xPath, String waitElementPath, String message, long miliSeconds) throws Throwable
	{
		driver.findElement(By.xpath(xPath)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(waitElementPath)));
		if(message != null && message != "") {		
			System.out.println(message);
		}
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading-overlay")));
		Thread.sleep(miliSeconds);
	}

	@When("^user goes to dashboard and performs smoke test > Click On Company Profile, Company Public Profile, My Profile, My Public Profile$")
	public void user_goes_to_dashboard_and_performs_smoke_test() throws Throwable {
		try {
			GoToPath(".//*[@id='myheader']/header/div/div/div[2]/div/div[2]/a[3]", "", "Company profile page redirection successful", 3000);
			GoToPath(".//*[@id='container-main']/a[1]", ".//*[@id='container-main']/div/div[1]/div[1]/div[2]/h1", "Company public profile page redirection successful", 3000);
			GoToPath(".//*[@id='myheader']/header/div/div/div[2]/div/div[2]/a[4]", ".//*[@id='container-main']/h1", "My profile page redirection successful", 3000);
			GoToPath(".//*[@id='container-main']/a[1]", ".//*[@id='container-main']/div/div[1]/div[1]/div[2]/h1", "My public profile page redirection successful", 3000);

		} catch (Exception e) {
			System.out.println(e);}
	}

	@Then("^go to building app and perform smoke test > Click On Building, Building Unit, Building Room, Building Element, Building Surface, Building tenant, Building document, Building key, Building invoice, Building disturbance, Building contact$")
	public void go_to_building_app_and_perform_smoke_test() throws Throwable {

		GoToModule(Module.Building, driver);

		try {
			GoToPath(".//*[@id='list']/div[1]/div/table/tbody/tr[1]/td[1]/a", ".//*[@id='container-main']/div[2]/div[2]/h1", "Building page redirection successful", 3000);
			GoToPath(".//*[@id='container-main']/div[4]/div[1]/div/ul/li[2]/a", ".//*[@id='container-main']/div[4]/div[2]/h4", "Building unit tab redirection successful", 3000);
			GoToPath(".//*[@id='container-main']/div[4]/div[1]/div/ul/li[3]/a", ".//*[@id='input-searchbox']", "Building room tab redirection successful", 3000);
			GoToPath(".//*[@id='container-main']/div[4]/div[1]/div/ul/li[4]/a", ".//*[@id='input-searchbox']", "Building element tab redirection successful", 3000);
			GoToPath(".//*[@id='container-main']/div[4]/div[1]/div/ul/li[5]/a", ".//*[@id='container-main']/div[4]/div[2]/h4", "Building surface tab redirection successful", 3000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,500)");
			Thread.sleep(2000);
			GoToPath(".//*[@id='container-main']/div[4]/div[1]/div/ul/li[6]/a", ".//*[@id='input-searchbox']", "Building tenant tab redirection successful", 3000);
			js.executeScript("window.scrollBy(0,500)");
			Thread.sleep(2000);
			GoToPath(".//*[@id='container-main']/div[4]/div[1]/div/ul/li[7]/a", ".//*[@id='container-main']/div[4]/div[2]/div/div/div[2]/div[1]/h4", "Building document tab redirection successful", 3000);
			js.executeScript("window.scrollBy(0,500)");
			Thread.sleep(2000);
			GoToPath(".//*[@id='container-main']/div[4]/div[1]/div/ul/li[8]/a", ".//*[@id='container-main']/div[4]/div[2]/h4", "Building key address tab redirection successful", 3000);
			js.executeScript("window.scrollBy(0,500)");
			Thread.sleep(2000);
			GoToPath(".//*[@id='container-main']/div[4]/div[1]/div/ul/li[9]/a", ".//*[@id='container-main']/div[4]/div[2]/h4", "Building invoice address tab redirection successful", 3000);
			js.executeScript("window.scrollBy(0,500)");
			Thread.sleep(2000);
			GoToPath(".//*[@id='container-main']/div[4]/div[1]/div/ul/li[10]/a", ".//*[@id='container-main']/div[4]/div[2]/h4", "Building disturbance tab redirection successful", 3000);
			js.executeScript("window.scrollBy(0,500)");
			Thread.sleep(2000);
			GoToPath(".//*[@id='container-main']/div[4]/div[1]/div/ul/li[11]/a", ".//*[@id='container-main']/div[4]/div[2]/h4", "Building contact tab redirection successful", 3000);

		} catch (Exception e) {
			System.out.println(e);		}

	}

	@Then("^go to building unit and perform smoke test > Click On BuildingUnit, Building unit element, Building unit tenant, Building unit document, Building unit key address, Building unit invoice address, Building unit disturbance, Building unit contact$")
	public void go_to_building_unit_and_perform_smoke_test() throws Throwable {

		try {
			driver.findElement(By.xpath(".//*[@id='container-main']/div[4]/div[1]/div/ul/li[2]/a")).click();
			Thread.sleep(2000);
			GoToPath(".//*[@id='container-main']/div[4]/div[2]/table/tbody/tr[1]/td[2]/a", ".//*[@id='container-main']/div[2]/div[2]/h1", "Building unit page redirection successful", 3000);
			GoToPath(".//*[@id='container-main']/div[4]/div[1]/div/ul/li[2]/a", "//*[@id='container-main']/div[4]/div[2]/h4", "Building unit element tab redirection successful", 3000);
			GoToPath(".//*[@id='container-main']/div[4]/div[1]/div/ul/li[3]/a", ".//*[@id='input-searchbox']", "Building unit tenant tab redirection successful", 3000);
			GoToPath(".//*[@id='container-main']/div[4]/div[1]/div/ul/li[4]/a", ".//*[@id='container-main']/div[4]/div[2]/div/div/div[2]/div[1]/h4", "Building unit document tab redirection successful", 3000);
			GoToPath(".//*[@id='container-main']/div[4]/div[1]/div/ul/li[5]/a", ".//*[@id='container-main']/div[4]/div[2]/h4", "Building unit key address tab redirection successful", 3000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,500)");
			Thread.sleep(2000);
			GoToPath(".//*[@id='container-main']/div[4]/div[1]/div/ul/li[6]/a", ".//*[@id='container-main']/div[4]/div[2]/h4", "Building unit invoice address tab redirection successful", 3000);
			js.executeScript("window.scrollBy(0,500)");
			Thread.sleep(2000);
			GoToPath(".//*[@id='container-main']/div[4]/div[1]/div/ul/li[7]/a", ".//*[@id='container-main']/div[4]/div[2]/h4", "Building unit disturbance tab redirection successful", 3000);
			js.executeScript("window.scrollBy(0,500)");
			Thread.sleep(2000);
			GoToPath(".//*[@id='container-main']/div[4]/div[1]/div/ul/li[8]/a", ".//*[@id='container-main']/div[4]/div[2]/h4", "Building unit contact tab redirection successful", 3000);

		} catch (Exception e) {
			System.out.println(e);		}
	}

	@Then("^go to building complex and perform smoke test > Click On BuildingComplex, Building complex key address, Building complex invoice address, Building complex disturbance, Building complex contact$")
	public void go_to_building_complex_and_perform_smoke_test() throws Throwable {

		try {
			driver.findElement(By.xpath(".//*[@id='navbar-pronectic']/ul[1]/li[1]/a")).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='container-main']/h1")));	

			boolean flag = false;
			int pageScrollLimit = 5;

			while(!flag && pageScrollLimit > 0)
			{		
				List<WebElement> locatedElements = driver.findElements(By.xpath(".//*[@id='list']/div"));
				for(int i = 1; i <= locatedElements.size(); i++)
				{ 
					if(IsElementExists(driver,".//*[@id='list']/div["+i+"]/div/a"))
					{
						flag = true;
						driver.findElement(By.xpath(".//*[@id='list']/div["+i+"]/div/a")).click();
						break;
					}
				}
				if(flag)
				{
					break;
				}
				pageScrollLimit --;
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0,600)");
				Thread.sleep(3000);
			}
			System.out.println("Flag = " + flag);
			System.out.println("Building complex page redirection successful");
			Thread.sleep(3000);
			GoToPath(".//*[@id='container-main']/div[4]/div[1]/div/ul/li[2]/a", ".//*[@id='container-main']/div[4]/div[2]/h4", "Building complex key address tab redirection successful", 3000);
			GoToPath(".//*[@id='container-main']/div[4]/div[1]/div/ul/li[3]/a", ".//*[@id='container-main']/div[4]/div[2]/h4", "Building complex invoice address tab redirection successful", 3000);
			GoToPath(".//*[@id='container-main']/div[4]/div[1]/div/ul/li[4]/a", ".//*[@id='container-main']/div[4]/div[2]/h4", "Building complex disturbance tab redirection successful", 3000);
			GoToPath(".//*[@id='container-main']/div[4]/div[1]/div/ul/li[5]/a", ".//*[@id='container-main']/div[4]/div[2]/h4", "Building complex contact tab redirection successful", 3000);

		} catch (Exception e) {
			System.out.println(e);		}
	}

	@Then("^go to ticket app and perform smoke test > Click On TicketApp, Work assignment, Archive, Invoice, Report, Article, External article, Settings, Prices, Surcharges, Cost category, External company, Attachments for external assignments, Interface, User rights$")
	public void go_to_ticket_app_and_perform_smoke_test() throws Throwable {

		GoToModule(Module.Ticket, driver);

		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='checkwizard-navigation']/li[2]")));
			Thread.sleep(2000);
			System.out.println("Ticket page redirection successful");
			GoToPath(".//*[@id='navbar-pronectic']/ul[1]/li[2]/a", ".//*[@id='search']", "Work assignment page redirection successful", 3000);
			GoToPath(".//*[@id='navbar-pronectic']/ul[1]/li[3]/a", ".//*[@id='search']", "Archive page redirection successful", 3000);
			GoToPath(".//*[@id='navbar-pronectic']/ul[1]/li[4]/a", ".//*[@id='search']", "Invoice specification page redirection successful", 3000);
			GoToPath(".//*[@id='navbar-pronectic']/ul[1]/li[5]/a", ".//*[@id='container-main']/h1", "Report page redirection successful", 3000);
			GoToPath(".//*[@id='navbar-pronectic']/ul[1]/li[6]/a", ".//*[@id='container-main']/div/div[2]/h1", "Article page redirection successful", 3000);
			GoToPath(".//*[@id='container-main']/div/div[1]/div/ul/li[2]/a", ".//*[@id='input-searchbox']", "External article tab redirection successful", 3000);
			GoToPath(".//*[@id='navbar-pronectic']/ul[1]/li[7]/a", ".//*[@id='container-main']/div/div[2]/h1", "Settings page redirection successful", 3000);
			GoToPath(".//*[@id='container-main']/div/div[1]/div/ul/li[2]/a", ".//*[@id='container-main']/div/div[2]/div[1]/h4", "Prices tab redirection successful", 3000);
			GoToPath(".//*[@id='container-main']/div/div[1]/div/ul/li[3]/a", ".//*[@id='container-main']/div/div[2]/h1", "Surcharges tab redirection successful", 3000);
			GoToPath(".//*[@id='container-main']/div/div[1]/div/ul/li[4]/a", ".//*[@id='container-main']/div/div[2]/h1", "Cost category tab redirection successful", 3000);
			GoToPath(".//*[@id='container-main']/div/div[1]/div/ul/li[5]/a", ".//*[@id='container-main']/div/div[2]/h1", "External company tab redirection successful", 3000);
			GoToPath(".//*[@id='container-main']/div/div[1]/div/ul/li[6]/a", ".//*[@id='container-main']/div/div[2]/h1", "Attachments for external assignments tab redirection successful", 3000);
			GoToPath(".//*[@id='container-main']/div/div[1]/div/ul/li[7]/a", ".//*[@id='container-main']/div/div[2]/form/h1", "Interface tab redirection successful", 3000);
			GoToPath(".//*[@id='container-main']/div/div[1]/div/ul/li[8]/a", ".//*[@id='container-main']/div/div[2]/h1", "User rights tab redirection successful", 3000);

		} catch (Exception e) {
			System.out.println(e);		}
	}


	@Then("^go to ticket pending tab and perform smoke test > Click On Ticket Pending, Ticket detail, Work order ticket$")
	public void go_to_ticket_pending_tab_and_perform_smoke_test() throws Throwable {
		try {
			driver.findElement(By.xpath(".//*[@id='navbar-pronectic']/ul[1]/li[1]/a")).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='search']")));
			Thread.sleep(2000);
			GoToPath(".//*[@id='checkwizard-navigation']/li[3]", ".//*[@id='tickets-default']/div/div[1]/div[1]", "Ticket pending tab redirection successful", 1000);
			SelectTicketFromTicketList(driver);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='container-main']/div[2]/div[1]/h1")));
			Thread.sleep(3000);
			System.out.println("Ticket detail page redirection successful");
			driver.findElement(By.xpath(".//*[@id='container-main']/div[1]/span")).click();
			Thread.sleep(1000);
			GoToPath(".//*[@id='container-main']/div[1]/span/ul/li/a", ".//*[@id='container-main']/div[2]/div[1]/h1", "Related ticket redirection successful", 3000);

		} catch (Exception e) {
			System.out.println(e);}
	}

	@Then("^go to invoice specification and perform smoke test > Click On Invoice Specification, Invoice rounded, Invoice detail$")
	public void go_to_invoice_specification_and_perform_smoke_test() throws Throwable {
		try {
			GoToPath(".//*[@id='navbar-pronectic']/ul[1]/li[4]/a", ".//*[@id='search']", null, 2000);
			GoToPath(".//*[@id='checkwizard-navigation']/li[2]", ".//*[@id='container-main']/div[5]/div[2]/div[1]/div[2]", "Invoice rounded tab redirection successful", 1000);
			GoToPath(".//*[@id='container-main']/div[5]/div[2]/div[2]/a", ".//*[@id='container-main']/div[1]/div[1]/h1", "Invoice detail page redirection successful", 3000);

		} catch (Exception e) {
			System.out.println(e);}
	}	

	@Then("^go to service portal and perform smoke test > Click On Service, Service portal user detail, Service portal news, Service portal news detail, Service portal maintenance, Service portal maintenance detail, Service portal settings, Service portal user rights$")
	public void go_to_service_portal_and_perform_smoke_test() throws Throwable {

		GoToModule(Module.ServicePortal, driver);
		try {
			System.out.println("Service portal redirection successful");
			GoToPath(".//*[@id='navbar-pronectic']/ul[1]/li[2]/a", ".//*[@id='container-main']/h1", "Service portal news redirection successful", 3000);
			GoToPath(".//*[@id='container-main']/table/tbody/tr[1]/td[1]/a", ".//*[@id='container-main']/div[1]/div[1]/h1", "Service portal news detail page redirection successful", 3000);
			GoToPath(".//*[@id='navbar-pronectic']/ul[1]/li[3]/a", ".//*[@id='container-main']/h1", "Service portal maintenance redirection successful", 3000);
			GoToPath(".//*[@id='container-main']/table/tbody/tr[1]/td[1]/a", ".//*[@id='container-main']/div[1]/div[1]/h1", "Service portal maintenance detail page redirection successful", 3000);
			GoToPath(".//*[@id='navbar-pronectic']/ul[1]/li[4]/a", ".//*[@id='container-main']/div/div[2]/h1", "Service portal settings redirection successful", 3000);
			GoToPath(".//*[@id='container-main']/div/div[1]/div/ul/li[2]/a", ".//*[@id='container-main']/div/div[2]/h1", "Service portal user rights tab redirection successful", 3000);

		} catch (Exception e) {
			System.out.println(e);		}
	}

	@Then("^go to external service portal and login > Click On external service portal, External Service portal login$")
	public void go_to_external_service_portal_and_login() throws Throwable {

		try {
			driver.get("https://app.loekonline.nl/Serviceportaal/co4it");
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='Email']")));
			Thread.sleep(3000);
			driver.findElement(By.xpath(".//*[@id='Email']")).sendKeys(ProductionLoginEmail);
			Thread.sleep(1000);
			driver.findElement(By.xpath(".//*[@id='Password']")).sendKeys(LoginPassword);
			Thread.sleep(2000);
			GoToPath(".//*[@id='login']/form/div[3]/input", "/html/body/div/div/div[1]/div[1]/h5", "External Service portal login successful", 3000);

		} catch (Exception e) {
			System.out.println(e);		}
	}

	@Then("^go to external service portal ticket and perform smoke test > Click On external service portal ticket, External service portal ticket detail$")
	public void go_to_external_service_portal_ticket_and_perform_smoke_test() throws Throwable {

		try {
			driver.findElement(By.xpath("/html/body/div/div/div[1]/div[3]/div/div[1]/a[1]/div")).click();
			OpenChildWindow(driver);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='page-modal']/div/div/div[2]/div[1]/div[1]")));
			Thread.sleep(3000);
			System.out.println("External service portal ticket detail page redirection successful");
			driver.findElement(By.xpath(".//*[@id='page-modal']/div/div/div[3]/input")).click();
			Thread.sleep(3000);

		} catch (Exception e) {
			System.out.println(e);		}
	}

	@Then("^perform smoke test on external service portal > Click On external service portal, External Service portal my profile, External Service portal news redirection, External Service portal ticket$")
	public void perform_smoke_test_on_external_service_portal() throws Throwable {

		try {
			GoToPath(".//*[@id='navbar-pronectic']/ul[1]/li[2]/a", "/html/body/div/h1", "External Service portal my profile redirection successful", 3000);
			GoToPath(".//*[@id='navbar-pronectic']/ul[1]/li[3]/a", "/html/body/div/h1", "External Service portal news redirection successful", 3000);
			GoToPath(".//*[@id='navbar-pronectic']/ul[1]/li[4]/a", "/html/body/div/h1", "External Service portal ticket redirection successful", 3000);

		} catch (Exception e) {
			System.out.println(e);		}
	}

	@Then("^perform smoke test on external service portal news and logout > Click On external service portal news, External Service portal news detail, logged out from external service portal$")
	public void perform_smoke_test_on_external_service_portal_news_and_logout() throws Throwable {

		try {
			driver.findElement(By.xpath(".//*[@id='navbar-pronectic']/ul[1]/li[1]/a")).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div[1]/div[1]/h5")));
			Thread.sleep(3000);
			GoToPath("/html/body/div/div/div[1]/div[1]/div/div[1]/a[1]/div", "/html/body/div/h1", "External Service portal news detail page redirection successful", 3000);
			GoToPath(".//*[@id='navbar-pronectic']/ul[2]/li/a", ".//*[@id='Email']", "Successfully logged out from external service portal", 3000);

		} catch (Exception e) {
			System.out.println();		}
		driver.close();
	}
}