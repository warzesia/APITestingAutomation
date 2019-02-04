package responses;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import helpers.CalculationHelper;
import helpers.JSONHelper;

public class FlexScoreResponse extends Response {

	/**
	* 
	* (Required)
	* 
	*/
	@SerializedName("flexScore")
	@Expose
	public FlexScore flexScore;

	public FlexScoreResponse(JSONObject jsonSubject) {
		super(jsonSubject, JSONHelper.parseJSONObjectFromFile("/APITestingAutomation/src/main/Resources/jsonSchemas/responseSchema.json"));
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

//Scoring is done at various level:
//1. Total Offer Cost.  
	//1. Calculate Offer Score
//2. Each PTU
	//1. Offered power is evaluated against requested power to give Power Score
	//2. Offered price is evaluated against the requested power cost to give Price Score 
	//3. Calculate Combined PTU Score as (Score Power * Power Weighting) + (Price Score * Price Weighting)
//3. Offer Total Score is calculated as Sum of Combined PTU Scores plus the Offer Score.

