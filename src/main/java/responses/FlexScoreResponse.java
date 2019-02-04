package responses;

import helpers.JSONHelper;

public class FlexScoreResponse extends Response{
	
	public FlexScoreResponse() {
		super("/APITestingAutomation/src/main/Resources/jsonSchemas/responseSchema.json");
	}

	Boolean validateAgainstSchema(){
		return JSONHelper.validateJSONSubjectAgainstSchema(this.jsonSubject, this.jsonSchema);
	}
	
	Boolean validateAgainstRules(){
		//TODO: implement algorithm validating all variables
		return true;
	}
}
