package TestRunner;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import Stepdefinations.Base;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions
(
		features = {"src\\main\\java\\Feature\\Building\\BuildingAdd.feature",
				"src\\main\\java\\Feature\\Building\\BuildingRoom.feature",
				"src\\main\\java\\Feature\\Building\\BuildingElement.feature",
				"src\\main\\java\\Feature\\Building\\BuildingSurface.feature",
				"src\\main\\java\\Feature\\Building\\BuildingTenant.feature",
				"src\\main\\java\\Feature\\Building\\BuildingDocument.feature",
				"src\\main\\java\\Feature\\Building\\BuildingKeyAddress.feature",
				"src\\main\\java\\Feature\\Building\\BuildingInvoiceAddress.feature",
				"src\\main\\java\\Feature\\Building\\BuildingContacts.feature"
		},
		glue={"Stepdefinations.Building"}, 
		format= {"pretty","html:test-outout", "json:json_output/cucumber.json", "junit:junit_xml/cucumber.xml"}, 
		plugin = {"com.cucumber.listener.ExtentCucumberFormatter:output/LoekAutomationReport.html"}
		)

public class Building_Runner{

	@AfterClass
	public static void teardown() throws Throwable {
		Reporter.loadXMLConfig(new File("src/test/resources/extent-config.xml"));
		Reporter.setSystemInfo("User", System.getProperty("user.name"));
		Reporter.setSystemInfo("OS", System.getProperty("os.name"));
		Reporter.setSystemInfo("version", System.getProperty("java.runtime.version"));
		Base.GenerateReport();
	}
}