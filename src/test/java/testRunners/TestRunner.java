package testRunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(	features = "src/test/resources/Features", 
					glue = { "stepDefinition" }, 
					monochrome = true, 
					plugin = {
								"pretty", "html:target/HtmlReports/report.html",
								"junit:target/JUnitReports/report.xml", 
								"json:target/JSONReports/report.json"								 
								}
				)
public class TestRunner {

}
