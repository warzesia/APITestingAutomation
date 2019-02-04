package featureTestSteps;

import cucumber.api.PendingException;
import cucumber.api.Scenario;
import cucumber.api.java.en.*;
import requests.FlexScoreRequest;

public class CalculateFlexScoreTestSteps extends FeatureTestSteps{

	

	@Given("^System generates a valid FlexScore request$")
	public void system_generates_a_valid_FlexScore_request() throws Throwable {
		request = new FlexScoreRequest();
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}
	
	@When("^Valid FlexScore Request is sent to the FlexScore API Endpoint$")
	public void valid_FlexScore_Request_is_sent_to_the_FlexScore_API_Endpoint() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}
	
	@Then("^FlexScore API Endpoint should generate a response$")
	public void flexscore_API_Endpoint_should_generate_a_response() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}
	
	@Then("^The response should containt Valid Server Code$")
	public void the_response_should_containt_Valid_Server_Code() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}
	
	@Then("^The response should contain JSON body matching the FlexScore Response Schema$")
	public void the_response_should_contain_JSON_body_matching_the_FlexScore_Response_Schema() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}
	
	@Then("^The response JSON body should contain valid FlexScore Content$")
	public void the_response_JSON_body_should_contain_valid_FlexScore_Content() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

}

