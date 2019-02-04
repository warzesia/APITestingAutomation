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
		URL url = new URL(endpointURL);
        this.connection = (HttpURLConnection) url.openConnection();
        this.connection.setConnectTimeout(5000);
        this.connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
        this.connection.setDoOutput(true);
        this.connection.setDoInput(true);
	}
	
	public void sendPOSTRequest(String jsonBody) throws IOException {
		this.connection.setRequestMethod("POST");
        OutputStream os = this.connection.getOutputStream();
        os.write(jsonBody.getBytes("UTF-8"));
        os.close(); 
	}
	
	public int getResponseCode() throws IOException {
		return this.connection.getResponseCode();
	}
	
	public JSONObject getResponseBody() throws IOException {
        InputStream in = new BufferedInputStream(this.connection.getInputStream());
        String result = IOUtils.toString(in, "UTF-8");
        in.close();
        return new JSONObject(result);
	}
	
	public void closeHTTPConnection() {
		this.connection.disconnect();		
	}

}

