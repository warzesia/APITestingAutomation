package APITestingAutomation;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

import org.json.JSONObject;

import helpers.Constants;
import helpers.JSONHelper;
import helpers.RESTConnectionHandler;
import responses.FlexScoreResponse;
import responses.PtuDatum;


public class Main 
{
    public static void main( String[] args ) throws IOException
    {
        
        JSONObject exampleValidJsonRequest = 
        		JSONHelper.parseJSONObjectFromFile(Constants.VALID_REQUEST_JSON_PATH_1);
        JSONObject exampleInvalidJsonRequest = 
        		JSONHelper.parseJSONObjectFromFile(Constants.INVALID_REQUEST_JSON_PATH_1);
        JSONObject exampleValidJsonResponse = 
        		JSONHelper.parseJSONObjectFromFile(Constants.VALID_RESPONSE_JSON_PATH_1);


//        JSONObject responseJSONObject;
//        int responseCode;
//        
//		RESTConnectionHandler connectionHandler = new RESTConnectionHandler();
//		connectionHandler.openHTTPConnection(Constants.API_ENDPOINT_URL_FLEX_REQUEST);
//		connectionHandler.sendPOSTRequest(exampleValidJsonRequest.toString());
//		responseCode = connectionHandler.getResponseCode();
//		responseJSONObject = connectionHandler.getResponseBody();
//		connectionHandler.closeHTTPConnection();
//		
//		System.out.println(responseCode);
//		System.out.println(responseJSONObject);
		
        
		FlexScoreResponse flexScoreResponse = 
				JSONHelper.parseFlexScoreResponseFromJSONObject(exampleValidJsonResponse);
		
		System.out.println(flexScoreResponse.flexScore.totalScore);
		System.out.println(flexScoreResponse.flexScore.offerScore);
		flexScoreResponse.flexScore.ptuData.forEach(ptuDatum->
			System.out.println(
					"Start: " + ptuDatum.start + ", " +
					"Power: " + ptuDatum.power + ", " +
					"Price: " + ptuDatum.price + ", " +
					"Disposition: " + ptuDatum.disposition + ", " +
					"powerScore: " + ptuDatum.powerScore + ", " +
					"priceScore: " + ptuDatum.priceScore)
				);

		System.out.println(flexScoreResponse.validateAgainstRules());
    }
}
