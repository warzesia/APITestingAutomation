package APITestingAutomation;

import java.io.IOException;
import java.util.List;

import org.json.JSONObject;
import helpers.JSONHelper;
import helpers.RESTConnectionHandler;
import responses.FlexScoreResponse;
import responses.PtuDatum;

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


        
//        JSONObject responseJSONObject;
//        int responseCode;
//        
//		RESTConnectionHandler connectionHandler = new RESTConnectionHandler();
//		connectionHandler.openHTTPConnection(endpointURL);
//		connectionHandler.sendPOSTRequest(exampleValidJsonRequest.toString());
//		responseCode = connectionHandler.getResponseCode();
//		responseJSONObject = connectionHandler.getResponseBody();
//		connectionHandler.closeHTTPConnection();
//		
//		System.out.println(responseCode);
//		System.out.println(responseJSONObject);
//		System.out.println(responseJSONObject.equals(exampleValidJsonResponse));
		
        
        
        System.out.println(exampleValidJsonResponse);
        
		FlexScoreResponse flexScoreResponse = 
				JSONHelper.parseFlexScoreresponseFromJSONObject(exampleValidJsonResponse);
		
		System.out.println(flexScoreResponse.flexScore.totalScore);
		System.out.println(flexScoreResponse.flexScore.offerScore);
		flexScoreResponse.flexScore.ptuData.forEach(ptuDatum->
			System.out.println(
					"Start" + ptuDatum.start + ", " +
					"Power" + ptuDatum.power + ", " +
					"Price" + ptuDatum.price + ", " +
					"Disposition" + ptuDatum.disposition + ", " +
					"powerScore" + ptuDatum.powerScore + ", " +
					"priceScore" + ptuDatum.priceScore)
				);

		System.out.println(flexScoreResponse.validateAgainstRules());
    }
}
