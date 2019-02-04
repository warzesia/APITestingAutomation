package responses;

import org.json.JSONObject;

import helpers.JSONHelper;

public abstract class Response {
	
	public JSONObject jsonSubject;
	public JSONObject jsonSchema;
	
	public Response(String schemaFilepath) {
		jsonSchema = JSONHelper.parseJSONObjectFromFile(schemaFilepath);
	}
	
	abstract Boolean validateAgainstSchema();
	abstract Boolean validateAgainstRules();

}
