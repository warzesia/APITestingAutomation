package APITestingAutomation;

import java.io.IOException;
import org.json.JSONObject;
import helpers.JSONHelper;
import helpers.RESTConnectionHandler;

/**
 * Hello world!
 *
 */
public class Main 
{
    public static void main( String[] args ) throws IOException
    {
    	String endpointURL = "https://api.smartenergyislands.cloud/flex/default/flexScore";
    	
    	String exampleValidJsonRequestPath = "src/main/Resources/jsonRequests/request1.json";
    	String exampleInvalidJsonRequestPath = "src/main/Resources/jsonRequests/request2.json";
    	String exampleValidJsonResponsePath = "src/main/Resources/jsonRequests/response1.json";
        
        JSONObject exampleValidJsonRequest = JSONHelper.parseJSONObjectFromFile(exampleValidJsonRequestPath);
        JSONObject exampleInvalidJsonRequest = JSONHelper.parseJSONObjectFromFile(exampleInvalidJsonRequestPath);
        JSONObject exampleValidJsonResponse = JSONHelper.parseJSONObjectFromFile(exampleValidJsonResponsePath);

//        RESTHelper.sendPOSTRequest(endpointURL, exampleValidJsonRequest.toString());
        
        JSONObject responseJSONObject;
        int responseCode;
        
		RESTConnectionHandler connectionHandler = new RESTConnectionHandler();
		connectionHandler.openHTTPConnection(endpointURL);
		connectionHandler.sendPOSTRequest(exampleValidJsonRequest.toString());
		responseCode = connectionHandler.getResponseCode();
		responseJSONObject = connectionHandler.getResponseBody();
		connectionHandler.closeHTTPConnection();
		
		System.out.println(responseCode);
		System.out.println(responseJSONObject);
		System.out.println(responseJSONObject.equals(exampleValidJsonResponse));
        
    }
}
