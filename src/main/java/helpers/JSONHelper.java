package helpers;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.everit.json.schema.Schema;
import org.everit.json.schema.ValidationException;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;

import com.google.gson.Gson;

import responses.FlexScoreResponse;

//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.IOException;
//import java.util.Iterator;

public class JSONHelper {
	
	public static Boolean validateJSONSubjectAgainstSchema(JSONObject jsonSubject, JSONObject jsonSchema){
		Schema schema = SchemaLoader.load(jsonSchema);
	    schema.validate(jsonSchema);  
	    try {
	    	schema.validate(jsonSchema);
	    } catch (ValidationException e) {
	    	return false;
	    }
	    return true;
	}
	
	public static JSONObject parseJSONObjectFromFile(String filepath){
		JSONObject jsonObject;
		try {
			jsonObject = new JSONObject(new JSONTokener(new FileInputStream(new File(filepath))));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("We got caught trying to read from a file; I'm setting the JSON object to null!");
			jsonObject = null;
		}
		return jsonObject;
	}
	
	public static FlexScoreResponse parseFlexScoreresponseFromJSONObject(JSONObject jsonObject) {
		Gson gson = new Gson();  
		return gson.fromJson(jsonObject.toString(), FlexScoreResponse.class);  
	}
	
	
	
//	public static JSONObject parseJSONObject2(String path) {
//		JSONParser parser = new JSONParser();
//		Object obj = new Object();
//		try {
//			obj = parser.parse(new FileReader(path));
//		} catch (IOException | ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return (JSONObject) obj;
//	}
	
	
}

