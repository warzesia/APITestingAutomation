package requests;

public class FlexScoreRequest extends Request{
	
	public FlexScoreRequest() {
		super("/APITestingAutomation/src/main/Resources/jsonSchemas/requestSchema.json");
	}
	
	public void initializeAsValidEntry(){
		//setup values of attributes with valid data;
	}
	
	public void initializeAsInvalidEntry(){
		//setup values of attributes with invalid data;
	}

}
