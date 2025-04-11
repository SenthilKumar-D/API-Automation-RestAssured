package Week4Day1_Cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/main/java/Week4Day1_Cucumber/CreateIncidentinServicenow.feature",
glue = {"Week4Day1_Cucumber"},
monochrome = true,
dryRun = true,
publish = true)

public class CreateIncidentTestNGRunnner extends AbstractTestNGCucumberTests{
	
	
	
	

}
