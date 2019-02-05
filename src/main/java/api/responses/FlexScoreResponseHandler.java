package api.responses;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import domain_model_classes.FlexScore;
import helpers.CalculationHelper;
import helpers.Constants;
import helpers.JSONHelper;

public class FlexScoreResponseHandler extends ResponseHandler {

	/**
	* 
	* (Required)
	* 
	*/
	@SerializedName("flexScore")
	@Expose
	public FlexScore flexScore;

	public FlexScoreResponseHandler() {
		super(JSONHelper.parseJSONObjectFromFile(Constants.RESPONSE_SCHEMA_JSON_PATH));
	}
	
	public ResponseHandler generateCastedInstance() {
		return JSONHelper.parseFlexScoreResponseHandlerFromJSONObject(this.jsonSubject);
	}
	
	public Boolean validateAgainstRules(){

		//unknown
		Double calculatedTotalScore = 0.0;
		Double calculatedCombinedPTUScoresSum = 0.0;
		
		//known
		Double receivedTotalScore = this.flexScore.totalScore;
		Double receivedOfferScore = this.flexScore.offerScore;
				
		//calculate and flatten Combined PTU Scores
		List<Double> ptuCombinedScoresList = new ArrayList<Double>();
		this.flexScore.ptuData.forEach(ptuDatum-> 
			ptuCombinedScoresList.add( 
					CalculationHelper.roundDouble3(ptuDatum.powerScore * 0.5) + 
					CalculationHelper.roundDouble3(ptuDatum.priceScore * 0.5005)));
		//sum Combined PTU Scores
		calculatedCombinedPTUScoresSum = ptuCombinedScoresList.stream().mapToDouble(f -> f.doubleValue()).sum();

		//calculate Total Score
		calculatedTotalScore = receivedOfferScore + calculatedCombinedPTUScoresSum;
		
		System.out.println("Received Total Score:");
		System.out.println(receivedTotalScore);
		System.out.println("Calculated Total Score:");
		System.out.println(calculatedTotalScore);
		
		//compare calculated Total Score to the received Total Score; return true if matching
		return calculatedTotalScore.equals(receivedTotalScore);
	}
}



