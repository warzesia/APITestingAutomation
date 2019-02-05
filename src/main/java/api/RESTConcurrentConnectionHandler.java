package api;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import helpers.Constants;
import helpers.JSONHelper;


public class RESTConcurrentConnectionHandler {
	
	public ServerResponseTimeRusults runConnectionSpeedTest(String endpointToCall, String jsonCallBodyToPass, int numberOfConnections) {
		List<Long> responseTimesList = new ArrayList<Long>();	
	    
	    ExecutorService es = Executors.newCachedThreadPool();
	    for(int i=0;i<numberOfConnections;i++)
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
		
		ServerResponseTimeRusults serverResponseTimeRusults = new ServerResponseTimeRusults();
		serverResponseTimeRusults.numberOfConnectionsCreated = responseTimesList.size();
		serverResponseTimeRusults.numberOfValidConnections = nonZeroResponseTimesCount;
		serverResponseTimeRusults.numberOfInvalidConnections = 
				serverResponseTimeRusults.numberOfConnectionsCreated - nonZeroResponseTimesCount;
		serverResponseTimeRusults.averageResponseTime = responseTimesSum / nonZeroResponseTimesCount;
		
		return serverResponseTimeRusults;
	}
	
	
	public class ServerResponseTimeRusults {
		public int numberOfConnectionsCreated;
		public int numberOfValidConnections;
		public int numberOfInvalidConnections;
		public long averageResponseTime;
	}		
	
	private class TestThread extends Thread {
		
		List<Long> responseTimesList;
		
		public TestThread(List<Long> sharedList) {
			this.responseTimesList = sharedList;
		}
		
	    public void run() {
	        RESTConnectionHandler connectionHandler = new RESTConnectionHandler();
			responseTimesList.add(
					connectionHandler.measureServerResponseTime(
							Constants.API_ENDPOINT_URL_FLEX_REQUEST, 
							JSONHelper.parseJSONObjectFromFile(Constants.VALID_REQUEST_JSON_PATH_1).toString()));
	    }
	 
	}

}
