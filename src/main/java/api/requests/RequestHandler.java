package api.requests;

import org.json.JSONObject;


public abstract class RequestHandler {
	
	protected JSONObject jsonSubject;
	protected JSONObject jsonSchema;

	public RequestHandler(JSONObject jsonSchema) {
		this.jsonSchema = jsonSchema;
	}

	//generic RequestHandler methods that need to be implemented per Request Type
	public abstract void initializeAsValidEntry();
	public abstract void initializeAsInvalidEntry();
	
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
