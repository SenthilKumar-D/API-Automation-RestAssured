package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src\\test\\java\\features\\CreateIncidentinServicenow2_with_Background.feature",
glue = {"stepDefinitions"},
monochrome = true,
dryRun = false,
tags = "@smoke",
plugin = {"html:reports/cucumber-report.html"},
publish = true)

public class CreateIncidentTestNGRunnner extends AbstractTestNGCucumberTests{
	
	
	
	

}
