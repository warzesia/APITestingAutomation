package featureSteps;

import org.json.JSONObject;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.*;
import helpers.Constants;
import helpers.JSONHelper;
import helpers.RESTConnectionHandler;
import responses.FlexScoreResponse;

import static org.junit.Assert.*;

public class CalculateFlexScoreSteps {
	
	RESTConnectionHandler connectionHandler;
	JSONObject jsonRequest;
	JSONObject jsonResponse;
	
	@Before
	public void startTestScenario(Scenario scenario) {
		System.out.println("Before - " + scenario.getName());
		connectionHandler = new RESTConnectionHandler();	
		connectionHandler.openHTTPConnection(Constants.API_ENDPOINT_URL_FLEX_REQUEST);
	}

	@After
	public void finishTestScenario(Scenario scenario){
		System.out.println("After - " + scenario.getName());
		connectionHandler.closeHTTPConnection();
	}

	@Given("^System generates a valid FlexScore request$")
	public void system_generates_a_valid_FlexScore_request() throws Throwable {
	    System.out.println("generate_valid_request");
	    this.jsonRequest = JSONHelper.parseJSONObjectFromFile(Constants.VALID_REQUEST_JSON_PATH_1);
	}
	
	@Given("^System generates an invalid FlexScore request$")
	public void system_generates_an_invalid_FlexScore_request() throws Throwable {
	    System.out.println("generate_invalid_request");
	    this.jsonRequest = JSONHelper.parseJSONObjectFromFile(Constants.INVALID_REQUEST_JSON_PATH_1);
	}
	
	@When("^The FlexScore Request is sent to the FlexScore API Endpoint$")
	public void the_FlexScore_Request_is_sent_to_the_FlexScore_API_Endpoint() throws Throwable {
		System.out.println("request_is_sent");
		connectionHandler.sendPOSTRequest(this.jsonRequest.toString());
	}
	
	@Then("^The response should contain Valid Server Code$")
	public void the_response_should_contain_Valid_Server_Code() throws Throwable {
		System.out.println("response_contains_Valid_Server_Code");
		assertEquals(200, connectionHandler.getResponseCode());
	}
	
	@Then("^The response should contain Invalid Server Code$")
	public void the_response_should_contain_Invalid_Server_Code() throws Throwable {
		System.out.println("response_contains_Invalid_Server_Code");
		assertEquals(502, connectionHandler.getResponseCode());
	}
	
	@Then("^The response should contain JSON body matching the FlexScore Response Schema$")
	public void the_response_should_contain_JSON_body_matching_the_FlexScore_Response_Schema() throws Throwable {
		System.out.println("response_contains_JSON_body_matching_Schema() - to be implemented");
	}
	
	@Then("^The response JSON body should contain valid FlexScore Content$")
	public void the_response_JSON_body_should_contain_valid_FlexScore_Content() throws Throwable {
		System.out.println("response_contains_JSON_body_contains_valid_Content");
		this.jsonResponse = connectionHandler.getResponseBody();
		connectionHandler.closeHTTPConnection();
		FlexScoreResponse flexScoreResponse = JSONHelper.parseFlexScoreResponseFromJSONObject(this.jsonResponse);
		assertEquals(true, flexScoreResponse.validateAgainstRules());
	}

}

