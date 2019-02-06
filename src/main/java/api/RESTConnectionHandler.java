package api;
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
	
	public void openHTTPConnection(String endpointURL){
		try {
			URL url = new URL(endpointURL);
			this.connection = (HttpURLConnection) url.openConnection();
	        this.connection.setConnectTimeout(5000);
	        this.connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
	        this.connection.setDoOutput(true);
	        this.connection.setDoInput(true);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void sendPOSTRequest(String jsonBody){
		try {
			this.connection.setRequestMethod("POST");
	        OutputStream os = this.connection.getOutputStream();
	        os.write(jsonBody.getBytes("UTF-8"));
	        os.close(); 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int getResponseCode(){
		try {
			return this.connection.getResponseCode();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}
	
	public JSONObject getResponseBody(){
		try {
	        InputStream in = new BufferedInputStream(this.connection.getInputStream());
	        String result;
			result = IOUtils.toString(in, "UTF-8");
	        in.close();
	        return new JSONObject(result);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public void closeHTTPConnection() {
		this.connection.disconnect();		
	}
	
	//dummy method for measuring Server response time
	public long measureServerResponseTime(String endpointURL, String jsonBody) {
		long result = 0;
		this.openHTTPConnection(endpointURL);
		try {
			this.connection.setRequestMethod("POST");
	        OutputStream os = this.connection.getOutputStream();
	        
	        long start = System.currentTimeMillis();
	        //start
	        os.write(jsonBody.getBytes("UTF-8"));
	        this.connection.getResponseCode();
	        //stop
	        long end = System.currentTimeMillis();
	        result = end - start;
	        os.close();
	        
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		this.closeHTTPConnection();
		return result;
	}

}

