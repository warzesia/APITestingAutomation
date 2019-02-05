package APITestingAutomation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.json.JSONObject;

import helpers.CalculationHelper;
import helpers.Constants;
import helpers.JSONHelper;
import helpers.RESTConnectionHandler;
import responses.FlexScoreResponse;


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


        JSONObject responseJSONObject;
        int responseCode;
        
        //*************************************************************************
        // MULTI-THREAD SERVER RESPONSE TEST
        
        int requestCount = 70;
        
				
		List<Long> responseTimesList = new ArrayList<Long>();	
        
        ExecutorService es = Executors.newCachedThreadPool();
        for(int i=0;i<requestCount;i++)
            es.execute(new TestThread(responseTimesList) { /*  your task */ });
        es.shutdown();
        try {
			boolean finished = es.awaitTermination(1, TimeUnit.MINUTES);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        // all tasks have finished or the time has been reached.
        
        System.out.println("***Response Times:***");
        System.out.println(responseTimesList);
        
        int nonZeroResponseTimesCount = 0;
        long responseTimesSum = 0;
        
        for(int i = 0; i<responseTimesList.size(); i++) {
        	long responseTime = responseTimesList.get(i);
        	if(responseTime !=0 ) {
        		nonZeroResponseTimesCount++;
        		responseTimesSum += responseTime;
        	}
        }
       
		long averageResponseTime = 
				responseTimesSum / nonZeroResponseTimesCount;
			
		System.out.println("***Results:***");
		System.out.println("Number of gathered Response Times:" + responseTimesList.size());
		System.out.println("Number of non-zero Response Times:" + nonZeroResponseTimesCount);
		System.out.println("Average Response Time: " + averageResponseTime);
        
 
		
        
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
    }
}
