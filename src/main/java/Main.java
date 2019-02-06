import java.io.IOException;
import org.json.JSONObject;
import api.RESTConcurrentConnectionHandler;
import api.RESTConcurrentConnectionHandler.ServerResponseTimeRusults;
import helpers.Constants;
import helpers.JSONHelper;


public class Main 
{
    public static void main( String[] args ) throws IOException
    {
        String urlEndpoint = Constants.API_ENDPOINT_URL_FLEX_REQUEST;
        JSONObject exampleValidJsonRequest = 
        		JSONHelper.parseJSONObjectFromFile(Constants.VALID_REQUEST_JSON_PATH_1);
        
        //*************************************************************************
        // MULTI-THREAD SERVER RESPONSE TEST
        
        RESTConcurrentConnectionHandler RESTConcurrentConnectionHelper = new RESTConcurrentConnectionHandler();
        ServerResponseTimeRusults serverResponseTimeRusults = 
        		RESTConcurrentConnectionHelper.runConnectionSpeedTest(urlEndpoint, exampleValidJsonRequest.toString(), 10);
			
		System.out.println("***Results:***");
		System.out.println("Number of Connections Created: " + serverResponseTimeRusults.numberOfConnectionsCreated);
		System.out.println("Number of Valid Connections: " + serverResponseTimeRusults.numberOfValidConnections);
		System.out.println("Number of Invalid Connections: " + serverResponseTimeRusults.numberOfInvalidConnections);
		System.out.println("Average Server response time: " + serverResponseTimeRusults.averageResponseTime);
           
		
		// the method to be fixed:
		JSONObject jsonRequestSchema = 
        		JSONHelper.parseJSONObjectFromFile(Constants.REQUEST_SCHEMA_JSON_PATH);
		System.out.println(
				JSONHelper.validateJSONSubjectAgainstSchema(exampleValidJsonRequest, jsonRequestSchema)
					);
	
    }
}
