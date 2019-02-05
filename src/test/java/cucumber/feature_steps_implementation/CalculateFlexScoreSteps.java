package cucumber.feature_steps_implementation;

import api.RESTConnectionHandler;
import api.requests.FlexScoreRequestHandler;
import api.requests.RequestHandler;
import api.responses.FlexScoreResponseHandler;
import api.responses.ResponseHandler;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.*;
import helpers.Constants;

import static org.junit.Assert.*;

public class CalculateFlexScoreSteps {
	
	RESTConnectionHandler connectionHandler;
	RequestHandler requestHandler = new FlexScoreRequestHandler();
	ResponseHandler responseHandler = new FlexScoreResponseHandler();
	
	//****
	// Before & After steps
	
	@Before
	public void startTestScenario(Scenario scenario){
		connectionHandler = new RESTConnectionHandler();	
		connectionHandler.openHTTPConnection(Constants.API_ENDPOINT_URL_FLEX_REQUEST);
	}

	@After
	public void finishTestScenario(Scenario scenario){
		connectionHandler.closeHTTPConnection();
	}

	//****
	// Feature steps
	
	@Given("^System generates a valid FlexScore request$")
	public void system_generates_a_valid_FlexScore_request() throws Throwable {
	    this.requestHandler.initializeAsValidEntry();
	}
	
	@Given("^System generates an invalid FlexScore request$")
	public void system_generates_an_invalid_FlexScore_request() throws Throwable {
		this.requestHandler.initializeAsInvalidEntry();
	}
	
	@When("^The FlexScore Request is sent to the FlexScore API Endpoint$")
	public void the_FlexScore_Request_is_sent_to_the_FlexScore_API_Endpoint() throws Throwable {
		connectionHandler.sendPOSTRequest(this.requestHandler.getJsonSubject().toString());
	}
	
	@Then("^The response should contain Valid Server Code$")
	public void the_response_should_contain_Valid_Server_Code() throws Throwable {
		assertEquals(200, connectionHandler.getResponseCode());
	}
	
	@Then("^The response should contain Invalid Server Code$")
	public void the_response_should_contain_Invalid_Server_Code() throws Throwable {
		assertEquals(502, connectionHandler.getResponseCode());
	}
	
	@Then("^The response should contain JSON body matching the FlexScore Response Schema$")
	public void the_response_should_contain_JSON_body_matching_the_FlexScore_Response_Schema() throws Throwable {
		setResponseBody(connectionHandler);
		assertEquals(true, this.responseHandler.validateAgainstSchema());
	}
	
	@Then("^The response JSON body should contain valid FlexScore Content$")
	public void the_response_JSON_body_should_contain_valid_FlexScore_Content() throws Throwable {
		setResponseBody(connectionHandler);
		this.responseHandler = this.responseHandler.generateCastedInstance();
		assertTrue(this.responseHandler.validateAgainstRules());
	}
	
	
	//helper methods
	private void setResponseBody(RESTConnectionHandler connectionHandler) {
		//do not read the RESPONSE twice if it's already been read
		if(this.responseHandler.getJsonSubject() == null)
			this.responseHandler.setJsonSubject(connectionHandler.getResponseBody());
	}

}

