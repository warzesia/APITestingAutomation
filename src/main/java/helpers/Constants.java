package helpers;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Constants {
	
	public static final String API_ENDPOINT_URL_FLEX_REQUEST;
	
	public static final String REQUEST_SCHEMA_JSON_PATH;
	public static final String RESPONSE_SCHEMA_JSON_PATH ;
	
	public static final String VALID_REQUEST_JSON_PATH_1;
	public static final String VALID_REQUEST_JSON_PATH_2;
	public static final String VALID_REQUEST_JSON_PATH_3;
	
	public static final String INVALID_REQUEST_JSON_PATH_1;
	public static final String INVALID_REQUEST_JSON_PATH_2;
	public static final String INVALID_REQUEST_JSON_PATH_3;
	
	public static final String VALID_RESPONSE_JSON_PATH_1;
	public static final String VALID_RESPONSE_JSON_PATH_2;
	public static final String VALID_RESPONSE_JSON_PATH_3;
	
	public static final String INVALID_RESPONSE_JSON_PATH_1;
	public static final String INVALID_RESPONSE_JSON_PATH_2;
	public static final String INVALID_RESPONSE_JSON_PATH_3;
	
	//initialize all static values by the value from properties.properties file
	static {
		
    	Properties properties = new Properties();
    	InputStream input = null;

    	try {
    		input = new FileInputStream("src/main/Resources/properties.properties");
    		properties.load(input);
    	} catch (IOException ex) {
    		ex.printStackTrace();
    	} finally {
    		if (input != null) {
    			try {
    				input.close();
    			} catch (IOException e) {
    				e.printStackTrace();
    			}
    		}
    	}
    	
		API_ENDPOINT_URL_FLEX_REQUEST = properties.getProperty("URL_ENDPOINT_FLEX_REQUEST");
		
		REQUEST_SCHEMA_JSON_PATH = properties.getProperty("REQUEST_SCHEMA_JSON_PATH");
		RESPONSE_SCHEMA_JSON_PATH = properties.getProperty("RESPONSE_SCHEMA_JSON_PATH");
		
		VALID_REQUEST_JSON_PATH_1 = properties.getProperty("VALID_REQUEST_JSON_PATH_1");
		VALID_REQUEST_JSON_PATH_2 = properties.getProperty("VALID_REQUEST_JSON_PATH_2");
		VALID_REQUEST_JSON_PATH_3 = properties.getProperty("VALID_REQUEST_JSON_PATH_3");
		
		INVALID_REQUEST_JSON_PATH_1 = properties.getProperty("INVALID_REQUEST_JSON_PATH_1");
		INVALID_REQUEST_JSON_PATH_2 = properties.getProperty("INVALID_REQUEST_JSON_PATH_2");
		INVALID_REQUEST_JSON_PATH_3 = properties.getProperty("INVALID_REQUEST_JSON_PATH_3");
		
		VALID_RESPONSE_JSON_PATH_1 = properties.getProperty("VALID_RESPONSE_JSON_PATH_1");
		VALID_RESPONSE_JSON_PATH_2 = properties.getProperty("VALID_RESPONSE_JSON_PATH_2");
		VALID_RESPONSE_JSON_PATH_3 = properties.getProperty("VALID_RESPONSE_JSON_PATH_3");
		
		INVALID_RESPONSE_JSON_PATH_1 = properties.getProperty("INVALID_RESPONSE_JSON_PATH_1");
		INVALID_RESPONSE_JSON_PATH_2 = properties.getProperty("INVALID_RESPONSE_JSON_PATH_2");
		INVALID_RESPONSE_JSON_PATH_3 = properties.getProperty("INVALID_RESPONSE_JSON_PATH_3");
	}

	
}
