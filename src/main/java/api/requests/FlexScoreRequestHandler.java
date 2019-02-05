package api.requests;

import helpers.Constants;
import helpers.JSONHelper;

public class FlexScoreRequestHandler extends RequestHandler{
	

	public FlexScoreRequestHandler() {
		super(JSONHelper.parseJSONObjectFromFile(Constants.REQUEST_SCHEMA_JSON_PATH));
	}
	
	public void initializeAsValidEntry(){
		this.jsonSubject = JSONHelper.parseJSONObjectFromFile(Constants.VALID_REQUEST_JSON_PATH_1);
	}
	
	public void initializeAsInvalidEntry(){
		this.jsonSubject = JSONHelper.parseJSONObjectFromFile(Constants.INVALID_REQUEST_JSON_PATH_1);
	}

}
