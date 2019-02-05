

import java.io.IOException;

import org.json.JSONObject;

import api.RESTConcurrentConnectionHandler;
import api.RESTConnectionHandler;
import api.RESTConcurrentConnectionHandler.ServerResponseTimeRusults;
import api.responses.FlexScoreResponseHandler;
import helpers.CalculationHelper;
import helpers.Constants;
import helpers.JSONHelper;


public class Main 
{
    public static void main( String[] args ) throws IOException
    {
        String urlEndpoint = Constants.API_ENDPOINT_URL_FLEX_REQUEST;
        JSONObject exampleValidJsonRequest = 
        		JSONHelper.parseJSONObjectFromFile(Constants.VALID_REQUEST_JSON_PATH_1);
        JSONObject exampleInvalidJsonRequest = 
        		JSONHelper.parseJSONObjectFromFile(Constants.INVALID_REQUEST_JSON_PATH_1);
        JSONObject exampleValidJsonResponse = 
        		JSONHelper.parseJSONObjectFromFile(Constants.VALID_RESPONSE_JSON_PATH_1);


        JSONObject responseJSONObject;
        int responseCode;
        
        //*************************************************************************
        // MULTI-THREAD SERVER RESPONSE TEST
        
//        RESTConcurrentConnectionHandler RESTConcurrentConnectionHelper = new RESTConcurrentConnectionHandler();
//        ServerResponseTimeRusults serverResponseTimeRusults = 
//        		RESTConcurrentConnectionHelper.runConnectionSpeedTest(urlEndpoint, exampleValidJsonRequest.toString(), 10);
//			
//		System.out.println("***Results:***");
//		System.out.println("Number of Connections Created:" + serverResponseTimeRusults.numberOfConnectionsCreated);
//		System.out.println("Number of Valid Connections:" + serverResponseTimeRusults.numberOfValidConnections);
//		System.out.println("Number of Invalid Connections:" + serverResponseTimeRusults.numberOfInvalidConnections);
//		System.out.println("Average Server response time:" + serverResponseTimeRusults.averageResponseTime);

        
		
        
//		RESTConnectionHandler connectionHandler = new RESTConnectionHandler();
//		connectionHandler.openHTTPConnection(Constants.API_ENDPOINT_URL_FLEX_REQUEST);
//		connectionHandler.sendPOSTRequest(exampleValidJsonRequest.toString());
//		responseCode = connectionHandler.getResponseCode();
//		responseJSONObject = connectionHandler.getResponseBody();
//		connectionHandler.closeHTTPConnection();
//		
//		System.out.println(responseCode);
//		System.out.println(responseJSONObject);
		
        
//		FlexScoreResponse flexScoreResponse = 
//				JSONHelper.parseFlexScoreResponseFromJSONObject(exampleValidJsonResponse);
//		
//		System.out.println(flexScoreResponse.flexScore.totalScore);
//		System.out.println(flexScoreResponse.flexScore.offerScore);
//		flexScoreResponse.flexScore.ptuData.forEach(ptuDatum->
//			System.out.println(
//					"Start: " + ptuDatum.start + ", " +
//					"Power: " + ptuDatum.power + ", " +
//					"Price: " + ptuDatum.price + ", " +
//					"Disposition: " + ptuDatum.disposition + ", " +
//					"powerScore: " + ptuDatum.powerScore + ", " +
//					"priceScore: " + ptuDatum.priceScore)
//				);
//
//		System.out.println(flexScoreResponse.validateAgainstRules());
        
        
        
        
        
        
        /// TEST SCENARIO
        
    }
}