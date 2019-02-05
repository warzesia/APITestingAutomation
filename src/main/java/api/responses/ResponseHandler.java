package api.responses;

import org.json.JSONObject;

import helpers.JSONHelper;

public abstract class ResponseHandler {
	
	protected JSONObject jsonSubject;
	protected JSONObject jsonSchema;
	
	public ResponseHandler(JSONObject jsonSchema) {
		this.jsonSchema = jsonSchema;
	}
	
	public Boolean validateAgainstSchema(){
		//TODO: implement schema validation
		//return JSONHelper.validateJSONSubjectAgainstSchema(this.jsonSubject, this.jsonSchema);
		return true;
	}

	//generic ResponseHandler methods that need to be implemented per Response Type
	public abstract Boolean validateAgainstRules();
	public abstract ResponseHandler generateCastedInstance();

	//getters & setters
	public JSONObject getJsonSubject() {
		return jsonSubject;
	}

	public void setJsonSubject(JSONObject jsonSubject) {
		this.jsonSubject = jsonSubject;
	}

	public JSONObject getJsonSchema() {
		return jsonSchema;
	}

	public void setJsonSchema(JSONObject jsonSchema) {
		this.jsonSchema = jsonSchema;
	}
}
