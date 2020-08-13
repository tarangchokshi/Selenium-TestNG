package TestRunner;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import Stepdefinations.Base;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(		
		features = {"src\\main\\java\\Feature\\SmokeTesting\\SmokeTest.feature"},
		glue={"Stepdefinations.SmokeTesting"},
		format= {"pretty","html:test-outout", "json:json_output/cucumber.json", "junit:junit_xml/cucumber.xml"}, 
		plugin = {"com.cucumber.listener.ExtentCucumberFormatter:output/LoekAutomationReport.html"}
		)

public class SmokeTesting_Runner{

	@AfterClass
	public static void teardown() throws Throwable {
		Reporter.loadXMLConfig(new File("src/test/resources/extent-config.xml"));
		Reporter.setSystemInfo("User", System.getProperty("user.name"));
		Reporter.setSystemInfo("OS", System.getProperty("os.name"));
        Reporter.setSystemInfo("OS Version", System.getProperty("os.version"));
        Reporter.setSystemInfo("Java Version", System.getProperty("java.runtime.version"));
        Reporter.setSystemInfo("Working Directory", System.getProperty("user.dir"));
		Base.GenerateReport();
	}
}