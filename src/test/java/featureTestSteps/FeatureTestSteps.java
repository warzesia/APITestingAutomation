package featureTestSteps;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import requests.Request;
import responses.Response;

public class FeatureTestSteps {
	
	public Request request;
	public Response response;
	
	
	//some variable to store server connection?
	
	@Before
	public void startTestScenario(Scenario scenario) {
		System.out.println("------------------------------");
	    System.out.println("Starting - " + scenario.getName());
	    System.out.println("------------------------------");
	    //Establish connection with the server;
	}

	@After
	public void finishTestScenario(Scenario scenario){
		System.out.println("------------------------------");
	    System.out.println("Finishing - " + scenario.getName());
	    System.out.println("------------------------------");
	  	//Close connection with the server;
	}
}
