package testRunner;


import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features= "src/test/java/features/RetailFormRegistration.feature", 
glue= {"stepDefinition"},
//tags= {"@Scenario1"} //Execute Single tag
//tags= {"@Regression","@Sanity"} //AND Condition
//tags= {"@Regression, @Sanity"} // OR Condition
tags= {"@Assignment02"}// Entire feature file
//tags= {"@Functional","~@Sanity"} // Run Feature file, excluding Sanity tag
		)

public class testRunner {

}
