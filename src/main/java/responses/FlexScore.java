package responses;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FlexScore {

	/**
	* 
	* (Required)
	* 
	*/
	@SerializedName("totalScore")
	@Expose
	public double totalScore;
	/**
	* 
	* (Required)
	* 
	*/
	@SerializedName("offerScore")
	@Expose
	public double offerScore;
	/**
	* 
	* (Required)
	* 
	*/
	@SerializedName("ptuData")
	@Expose
	public List<PtuDatum> ptuData = null;

}