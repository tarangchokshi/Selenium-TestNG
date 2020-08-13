package Stepdefinations.Building;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Screen;

import Models.Building.BuildingDocumentModel;
import Models.BuildingUnit.BuildingUnitDocumentModel;
import Stepdefinations.Base;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import junit.framework.Assert;


public class BuildingDocument extends Base {

	WebDriver driver;
	BuildingUnitDocumentModel modelBuildingUnitDocument=new BuildingUnitDocumentModel();
	BuildingDocumentModel modelBuildingDocument=new BuildingDocumentModel();
	@Given("^Open the url and login with valid credentials document$")
	public void open_the_url_and_login_with_valid_credentials_document() throws Throwable {	
		SetProperty();
		driver = Login();
		wait = new WebDriverWait(driver,WebDriverWaitTimeout);
	}
	
	@Then("^user click on the document and open fileupload page$")
	public void user_should_be_on_the_building_application_page() throws Throwable {
		GoToModule(Module.Building,driver);	
		driver.get(BuildingDetailPath);
		Thread.sleep(2000);	

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");
		driver.findElement(By.xpath(".//*[@id='container-main']/div[4]/div[1]/div/ul/li[7]/a")).click();
		Thread.sleep(3000);
		js.executeScript("window.scrollBy(0,400)");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='j1_1_anchor']")).click();

		Screen scr = new Screen();
		scr.find(modelBuildingUnitDocument.getImage1());
		scr.doubleClick(modelBuildingUnitDocument.getImage1());
	}

	@Then("^user click on the select and upload file$")
	public void user_click_on_the_select_and_upload_file() throws Throwable {
		Thread.sleep(2000);
		OpenChildWindow(driver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='upload-addfile']/div[2]/div/div[1]/div/label"))).click();
		Thread.sleep(500);
		ImportFile(modelBuildingDocument.getImage2());
		driver.findElement(By.xpath("//*[@id='Description']")).clear();
		driver.findElement(By.xpath("//*[@id='Description']")).sendKeys(modelBuildingDocument.getDescription());
		driver.findElement(By.xpath("//*[@id='upload-addfile']/div[2]/div/div[4]/div/div/input")).clear();
		driver.findElement(By.xpath("//*[@id='upload-addfile']/div[2]/div/div[4]/div/div/input")).sendKeys(modelBuildingUnitDocument.getFileName());
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='btnFileSubmit']")));
		driver.findElement(By.xpath("//input[@id='btnFileSubmit']")).click();
		Thread.sleep(5000);
		if(driver.getPageSource().contains(modelBuildingDocument.getDescription()))
		{
		    System.out.println("Success");
		}
		else
		{
			System.out.println("fail");
		}
		Assert.assertEquals(driver.getPageSource().contains(modelBuildingDocument.getDescription()),true);
		driver.close();
	}
	
	/*@Then("^user click on the added document secureby blockchain button$")
	public void user_click_on_the_added_document_secureby_blockchain_button() throws Throwable {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(1000);
		Screen scr = new Screen();
		Actions action = new Actions(driver);
		WebElement we = driver.findElement(By.xpath(".//*[@id='j1_18_anchor']"));
		action.moveToElement(we).build().perform();
		scr.find("src\\main\\java\\Resources\\Secure.PNG");
		scr.doubleClick("src\\main\\java\\Resources\\Secure.PNG");
		
	}

	@Then("^it should redirect user on the Historypage$")
	public void it_should_redirect_user_on_the_Historypage() throws Throwable {
		OpenChildWindow(driver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='add-inventory-form']/div[2]/table/tbody/tr/td[1]"))).click();
		Thread.sleep(1000);
		String txtdescription=driver.findElement(By.xpath(".//*[@id='add-inventory-form']/div[2]/table/tbody/tr/td[1]")).getText();
		System.out.println("Description::" +txtdescription);
		Assert.assertEquals(txtdescription.contains("Bestand aangemaakt"),true);
	}

	@Then("^in DescriptionAction it shows the File Created text or not$")
	public void in_DescriptionAction_it_shows_the_File_Created_text_or_not() throws Throwable {
	   Thread.sleep(2000);
	   driver.findElement(By.xpath("//*[@id='add-inventory-form']/div[3]/input")).click();
		
	}*/
	

}
