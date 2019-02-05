package APITestingAutomation;

import java.util.List;

import org.json.JSONObject;

import helpers.Constants;
import helpers.JSONHelper;
import helpers.RESTConnectionHandler;

public class TestThread extends Thread {
	
	String endpointToCall;
	String jsonCallBodyToPass;
	List<Long> responseTimesList;
	
	public TestThread(String endpointToCall, String jsonCallBodyToPass, List<Long> sharedList) {
		this.endpointToCall = endpointToCall;
		this.jsonCallBodyToPass = jsonCallBodyToPass;
		this.responseTimesList = sharedList;
	}
	
    public void run() {
        System.out.println("My name is: " + Thread.currentThread().getName());
        RESTConnectionHandler connectionHandler = new RESTConnectionHandler();
		responseTimesList.add(
				connectionHandler.measureServerResponseTime(
						Constants.API_ENDPOINT_URL_FLEX_REQUEST, 
						JSONHelper.parseJSONObjectFromFile(Constants.VALID_REQUEST_JSON_PATH_1).toString()));
    }
 
}
