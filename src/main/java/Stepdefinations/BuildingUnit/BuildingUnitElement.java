package Stepdefinations.BuildingUnit;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Models.BuildingUnit.BuildingUnitElementModel;
import Stepdefinations.Base;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class BuildingUnitElement extends Base{

	WebDriver driver;
	int finalCount;
	int initialCount;
	int removeCount;
	BuildingUnitElementModel modelBuildingUnitElement=new BuildingUnitElementModel();
	
	@Given("^Open an application$")
	public void open_an_application() throws Throwable {
		SetProperty();
		driver = Login();
		wait = new WebDriverWait(driver,WebDriverWaitTimeout);
	}
	
	@When("^User click on the MyApplication and select the buildingunit$")
	public void user_click_on_the_MyApplication_and_select_the_buildingunit() throws Throwable {
		GoToModule(Module.Building,driver);
		driver.get(BuildingUnitDetailPath);
		Thread.sleep(2000);
	}
	
	@Then("^click on the unit element from sidebar$")
	public void click_on_the_unit_element_from_sidebar() throws Throwable {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='container-main']/div[4]/div[1]/div/ul/li[2]/a")).click();
		Thread.sleep(2000);
		initialCount = GetLocatedElementCount();
		System.out.println("\n Initial Row Counts  :: " +initialCount);
	}

	@Then("^User click on the add new element to stay object$")
	public void user_click_on_the_add_new_element_to_stay_object() throws Throwable {
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='button-add']"))).click();
		OpenChildWindow(driver);

		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,600)");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='page-modal']/div/div/form/div[2]/div/div[5]/div/div/div/div[1]"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='page-modal']/div/div/form/div[2]/div/div[5]/div/div/div/div[2]/div/div[4]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='page-modal']/div/div/form/div[2]/div/div[6]/div/div/div/div[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='page-modal']/div/div/form/div[2]/div/div[6]/div/div/div/div[2]/div/div[1]")).click();
	}

	public int GetLocatedElementCount()
	{
		int counter = 0;
		int i = 1;
		List<WebElement> locatedElements = driver.findElements(By.xpath("//*[@id='container-main']/div[4]/div[2]/table/tbody/tr")); 

		for(WebElement locatedElement: locatedElements)
		{
			List<WebElement> innerElements = (locatedElement.findElements(By.xpath("//*[@id='container-main']/div[4]/div[2]/table/tbody/tr["+i+"]/td")));
			if(innerElements.size() > 1)
			{
				counter++;
			}
			
			i++;
		}
		return counter;
	}

	@Then("^Keep the form empty$")
	public void keep_the_form_empty() throws Throwable {
		Thread.sleep(5000);
		driver.findElement(By.xpath(".//*[@id='page-modal']/div/div/form/div[3]/input[2]")).click();
	}

	@Then("^verify that validation message show expected$")
	public void verify_that_validation_message_show_expected() throws Throwable {

		WebElement expected = driver.findElement(By.xpath("//input[@id='Element_Maker']"));
		String Message1 = expected.getAttribute("data-val-required");
		Assert.assertEquals(Message1,modelBuildingUnitElement.getErrorMessage() );
		if (Message1.equals(modelBuildingUnitElement.getErrorMessage())) {
			System.out.println("--------Test Case Pass -------");
		} else {
			System.out.println("--------Test Case Fail -------");
		}
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='page-modal']/div/div/form/div[3]/input[1]")).click();
	}

	@Then("^User again click on the add new element to stay object$")
	public void user_again_click_on_the_add_new_element_to_stay_object() throws Throwable {
		
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='button-add']"))).click();
		OpenChildWindow(driver);
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,400)");
	}

	@Then("^User fill the correct detail and submit$")
	public void user_fill_the_correct_detail() throws Throwable {

		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='page-modal']/div/div/form/div[2]/div/div[4]/div/div/div/div[1]/div"))).click();
		driver.findElement(By.xpath(".//*[@id='page-modal']/div/div/form/div[2]/div/div[4]/div/div/div/div[2]/div/div[3]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='page-modal']/div/div/form/div[2]/div/div[5]/div/div/div/div[1]")).click();
		driver.findElement(By.xpath("//*[@id='page-modal']/div/div/form/div[2]/div/div[5]/div/div/div/div[2]/div/div[4]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='page-modal']/div/div/form/div[2]/div/div[6]/div/div/div/div[1]")).click();
		driver.findElement(By.xpath("//*[@id='page-modal']/div/div/form/div[2]/div/div[6]/div/div/div/div[2]/div/div[3]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='Element_Maker']")).sendKeys(modelBuildingUnitElement.getElementMaker());
		driver.findElement(By.xpath(".//*[@id='Element_Model']")).sendKeys(modelBuildingUnitElement.getElementModel());
		driver.findElement(By.xpath(".//*[@id='Element_Type']")).sendKeys(modelBuildingUnitElement.getElementType());
		driver.findElement(By.xpath(".//*[@id='Element_DateInstalled']")).clear();
		driver.findElement(By.xpath(".//*[@id='Element_DateInstalled']")).sendKeys(modelBuildingUnitElement.getElementDateInstalled());
		driver.findElement(By.xpath(".//*[@id='Element_GuaranteeExpiration']")).clear();
		driver.findElement(By.xpath(".//*[@id='Element_GuaranteeExpiration']")).sendKeys(modelBuildingUnitElement.getElementGuaranteeExpiration());
		driver.findElement(By.xpath(".//*[@id='Element_Size']")).sendKeys(modelBuildingUnitElement.getElementSize());
		driver.findElement(By.xpath(".//*[@id='page-modal']/div/div/form/div[2]/div/div[13]/div/div/div/div[1]/div")).click();
		driver.findElement(By.xpath(".//*[@id='page-modal']/div/div/form/div[2]/div/div[13]/div/div/div/div[2]/div/div[6]")).click();
		driver.findElement(By.xpath(".//*[@id='Element_Orientation']")).sendKeys(modelBuildingUnitElement.getElementOrientation());
		Thread.sleep(1000);
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollBy(0,200)");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='page-modal']/div/div/form/div[3]/input[2]"))).click();
		Thread.sleep(2000);
	}

	@Then("^verify that it should show the data save successfully message$")
	public void verify_that_it_should_show_the_data_save_successfully_message() throws Throwable {
		Thread.sleep(6000);
		finalCount = GetLocatedElementCount();
		System.out.println("After Adding new KeyAddress :: " + finalCount);
		Assert.assertEquals(initialCount < finalCount, true);
	}

	@Then("^click on the delete buttons$")
	public void click_on_the_delete_button() throws Throwable {
		Thread.sleep(2000);
		List<WebElement> trElements = driver.findElements(By.xpath("//*[@id='container-main']/div[4]/div[2]/table/tbody/tr"));

		if (trElements.size() > 0) {
			WebElement lastElement = driver.findElement(By.xpath("(.//*[@id='container-main']/div[4]/div[2]/table/tbody/tr)[last()]/td[last()]/a[last()]"));
			if (lastElement != null) {
				lastElement.click();
				Alert alert = driver.switchTo().alert();
				alert.accept();
				Thread.sleep(8000);
				System.out.println("------Element Removed------");
				removeCount = GetLocatedElementCount();				
			}
		}
		System.out.println("\n After remove, Row Count :: " + removeCount);
		Assert.assertEquals(removeCount < finalCount,true);
		Thread.sleep(3000);
		driver.close();
	}
}
