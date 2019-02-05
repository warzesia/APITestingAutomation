package cucumber.runner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)

@CucumberOptions(
		features = {"src/test/java/cucumber/feature_steps_definitions/"},
		glue = {"cucumber.feature_steps_implementation"},
		monochrome = true,
		tags = {},
		plugin = {"pretty", "html:target/cucumber", "json:target/cucumber.json",
					"com.cucumber.listener.ExtentCucumberFormatter:target/report.html"}
	)

public class MainRunner {}
