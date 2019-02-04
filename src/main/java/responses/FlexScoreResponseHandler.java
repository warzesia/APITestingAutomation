package responses;

import org.json.JSONObject;

import helpers.JSONHelper;

public class FlexScoreResponseHandler extends Response{
	
	
	public FlexScoreResponseHandler(JSONObject jsonSubject) {
		super(jsonSubject, JSONHelper.parseJSONObjectFromFile("/APITestingAutomation/src/main/Resources/jsonSchemas/responseSchema.json"));
	}
	
	Boolean validateAgainstRules(){
		//TODO: implement algorithm validating all variables
		return true;
	}
}
