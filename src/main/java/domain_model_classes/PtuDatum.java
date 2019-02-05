package domain_model_classes;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PtuDatum {

	/**
	* 
	* (Required)
	* 
	*/
	@SerializedName("Start")
	@Expose
	public int start;
	/**
	* 
	* (Required)
	* 
	*/
	@SerializedName("Power")
	@Expose
	public int power;
	/**
	* 
	* (Required)
	* 
	*/
	@SerializedName("Price")
	@Expose
	public double price;
	/**
	* 
	* (Required)
	* 
	*/
	@SerializedName("Disposition")
	@Expose
	public String disposition;
	/**
	* 
	* (Required)
	* 
	*/
	@SerializedName("powerScore")
	@Expose
	public double powerScore;
	/**
	* 
	* (Required)
	* 
	*/
	@SerializedName("priceScore")
	@Expose
	public double priceScore;

}
