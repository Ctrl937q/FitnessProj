package com.example.tituh.fitnessproj.networking.responses;

import com.google.gson.annotations.SerializedName;

public class Repetitions {

	@SerializedName("advanced")
	private int advanced;

	@SerializedName("beginner")
	private int beginner;

	@SerializedName("intermediate")
	private int intermediate;

	public void setAdvanced(int advanced){
		this.advanced = advanced;
	}

	public int getAdvanced() {
		return advanced;
	}

	public int getBeginner() {
		return beginner;
	}

	public int getIntermediate() {
		return intermediate;
	}

	public void setBeginner(int beginner){
		this.beginner = beginner;
	}

	public void setIntermediate(int intermediate){
		this.intermediate = intermediate;
	}

	@Override
 	public String toString(){
		return 
			"Repetitions{" + 
			"advanced = '" + advanced + '\'' + 
			",beginner = '" + beginner + '\'' + 
			",intermediate = '" + intermediate + '\'' + 
			"}";
		}
}