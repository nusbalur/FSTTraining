package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "src/test/java/feature/assignment.feature" }, glue = { "stepDefinition" }, plugin = {
		"pretty", "json:target/cucumber-reports/report.json" }, monochrome = true)
public class testRunner {

}
