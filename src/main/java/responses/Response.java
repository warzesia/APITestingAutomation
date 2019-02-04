package responses;

import org.json.JSONObject;

import helpers.JSONHelper;

public abstract class Response {
	
	public JSONObject jsonSubject;
	public JSONObject jsonSchema;
	
	public Response(JSONObject jsonSubject, JSONObject jsonSchema) {
		this.jsonSubject = jsonSubject;
		this.jsonSchema = jsonSchema;
	}
	
	public Boolean validateAgainstSchema(){
		return JSONHelper.validateJSONSubjectAgainstSchema(this.jsonSubject, this.jsonSchema);
	}
	
	abstract Boolean validateAgainstRules();

}
