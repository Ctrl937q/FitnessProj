package com.example.tituh.fitnessproj.networking.responses;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class TrainingResponse {

	@SerializedName("next")
	private Object next;

	@SerializedName("previous")
	private Object previous;

	@SerializedName("count")
	private int count;

	@SerializedName("results")
	private List<ResultsItem> results;

	public void setNext(Object next){
		this.next = next;
	}

	public void setPrevious(Object previous){
		this.previous = previous;
	}

	public void setCount(int count){
		this.count = count;
	}

	public void setResults(List<ResultsItem> results){
		this.results = results;
	}

	public Object getNext() {
		return next;
	}

	public Object getPrevious() {
		return previous;
	}

	public int getCount() {
		return count;
	}

	public List<ResultsItem> getResults() {
		return results;
	}

	@Override
 	public String toString(){
		return 
			"TrainingResponse{" + 
			"next = '" + next + '\'' + 
			",previous = '" + previous + '\'' + 
			",count = '" + count + '\'' + 
			",results = '" + results + '\'' + 
			"}";
		}
}