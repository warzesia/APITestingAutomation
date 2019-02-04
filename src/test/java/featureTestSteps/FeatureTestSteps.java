package featureTestSteps;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import requests.Request;
import responses.Response;

public class FeatureTestSteps {
	
	//some variable to store server connection?
	
	@Before
	public void startTestScenario(Scenario scenario) {
		System.out.println("Starting ------------------------------");
	}

	@After
	public void finishTestScenario(Scenario scenario){
		System.out.println("Finishing -----------------------------");
	}
}
