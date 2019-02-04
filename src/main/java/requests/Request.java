package requests;

import org.json.JSONObject;

import helpers.JSONHelper;

public abstract class Request {
	
	public JSONObject jsonSubject;
	public JSONObject jsonSchema;
	
	public Request(String schemaFilepath) {
		jsonSchema = JSONHelper.parseJSONObjectFromFile(schemaFilepath);
	}

	public abstract void initializeAsValidEntry();
	public abstract void initializeAsInvalidEntry();
	
}
