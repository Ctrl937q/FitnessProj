package com.example.tituh.fitnessproj.networking.responses;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ResultsItem {

	@SerializedName("duration")
	private String duration;

	@SerializedName("complexity")
	private int complexity;

	@SerializedName("weeks")
	private List<String> weeks;

	@SerializedName("date_edited")
	private String dateEdited;

	@SerializedName("workouts")
	private List<WorkoutsItem> workouts;

	@SerializedName("date_created")
	private String dateCreated;

	@SerializedName("equipment")
	private List<EquipmentItem> equipment;

	@SerializedName("days")
	private List<String> days;

	@SerializedName("id")
	private int id;

	@SerializedName("title")
	private String title;

	@SerializedName("status")
	private int status;

	@SerializedName("info")
	private String info;

	public void setDuration(String duration){
		this.duration = duration;
	}

	public void setComplexity(int complexity){
		this.complexity = complexity;
	}

	public void setWeeks(List<String> weeks){
		this.weeks = weeks;
	}

	public void setDateEdited(String dateEdited){
		this.dateEdited = dateEdited;
	}

	public void setWorkouts(List<WorkoutsItem> workouts){
		this.workouts = workouts;
	}

	public void setDateCreated(String dateCreated){
		this.dateCreated = dateCreated;
	}

	public void setEquipment(List<EquipmentItem> equipment){
		this.equipment = equipment;
	}

	public void setDays(List<String> days){
		this.days = days;
	}

	public void setId(int id){
		this.id = id;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public void setStatus(int status){
		this.status = status;
	}

	public String getDuration() {
		return duration;
	}

	public int getComplexity() {
		return complexity;
	}

	public List<String> getWeeks() {
		return weeks;
	}

	public String getDateEdited() {
		return dateEdited;
	}

	public List<WorkoutsItem> getWorkouts() {
		return workouts;
	}

	public String getDateCreated() {
		return dateCreated;
	}

	public List<EquipmentItem> getEquipment() {
		return equipment;
	}

	public List<String> getDays() {
		return days;
	}

	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public int getStatus() {
		return status;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info){
		this.info = info;
	}

	@Override
 	public String toString(){
		return 
			"ResultsItem{" + 
			"duration = '" + duration + '\'' + 
			",complexity = '" + complexity + '\'' + 
			",weeks = '" + weeks + '\'' + 
			",date_edited = '" + dateEdited + '\'' + 
			",workouts = '" + workouts + '\'' + 
			",date_created = '" + dateCreated + '\'' + 
			",equipment = '" + equipment + '\'' + 
			",days = '" + days + '\'' + 
			",id = '" + id + '\'' + 
			",title = '" + title + '\'' + 
			",status = '" + status + '\'' + 
			",info = '" + info + '\'' + 
			"}";
		}
}