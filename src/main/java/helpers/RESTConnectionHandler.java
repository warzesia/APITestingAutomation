package helpers;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import org.apache.commons.io.IOUtils;
import org.json.JSONObject;


public class RESTConnectionHandler {
	
	HttpURLConnection connection;
	
	public void openHTTPConnection(String endpointURL) throws IOException {
		// open the Endpoint connection
		URL url = new URL(endpointURL);
		connection = (HttpURLConnection) url.openConnection();
		connection.setConnectTimeout(5000);
		connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
		connection.setDoOutput(true);
		connection.setDoInput(true);
	}
	
	public void sendPOSTRequest(String jsonString) throws IOException {
		// sent POST request
		connection.setRequestMethod("POST");
		OutputStream os = connection.getOutputStream();
		os.write(jsonString.getBytes("UTF-8"));
		os.close();
	}
	
	public int getResponseCode() throws IOException {
		return connection.getResponseCode();
	}
	
	public JSONObject getResponseBody() throws IOException {
		String responseBodyString;
		InputStream in = new BufferedInputStream(connection.getInputStream());
		responseBodyString = IOUtils.toString(in, "UTF-8");
		in.close();
		return new JSONObject(responseBodyString);
	}
	
	public void closeHTTPConnection() {
		connection.disconnect();
	}

//	public static void sendPOSTRequest(String endpointURL, String jsonString) {
//           
//           try {
//        	   // open the Endpoint connection
//        	   URL url = new URL(endpointURL);
//        	   HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//        	   conn.setConnectTimeout(5000);
//        	   conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
//        	   conn.setDoOutput(true);
//        	   conn.setDoInput(true);
//        	   
//        	   
//        	   // sent POST request
//        	   conn.setRequestMethod("POST");
//        	   OutputStream os = conn.getOutputStream();
//        	   os.write(jsonString.getBytes("UTF-8"));
//        	   os.close(); 
//        	   
//        	   // check response code
//        	   System.out.println(conn.getResponseCode());
//        	   
//        	   // read the response
//        	   InputStream in = new BufferedInputStream(conn.getInputStream());
//        	   String result = IOUtils.toString(in, "UTF-8");
//        	   in.close();
//        	   
//        	   System.out.println("result BEFORE Reading JSON Response");
//        	   System.out.println(result);
//        	   
//        	   JSONObject myResponse = new JSONObject(result);
//        	   System.out.println("result AFTER Reading JSON Response");
//        	   System.out.println(myResponse);
//        	   
//        	   //close the Endpoint connection 
//        	   
//        	   conn.disconnect();
//        	   
//           } catch (Exception e) {
//   				System.out.println(e);
//           }
//	}
}
