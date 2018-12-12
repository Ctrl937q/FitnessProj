package com.example.tituh.fitnessproj.networking.responses.training;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ResultsItem implements Parcelable {

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

	protected ResultsItem(Parcel in) {
		duration = in.readString();
		complexity = in.readInt();
		weeks = in.createStringArrayList();
		dateEdited = in.readString();
		dateCreated = in.readString();
		days = in.createStringArrayList();
		id = in.readInt();
		title = in.readString();
		status = in.readInt();
		info = in.readString();
	}

	public static final Creator<ResultsItem> CREATOR = new Creator<ResultsItem>() {
		@Override
		public ResultsItem createFromParcel(Parcel in) {
			return new ResultsItem(in);
		}

		@Override
		public ResultsItem[] newArray(int size) {
			return new ResultsItem[size];
		}
	};

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

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel parcel, int i) {
		parcel.writeString(duration);
		parcel.writeInt(complexity);
		parcel.writeStringList(weeks);
		parcel.writeString(dateEdited);
		parcel.writeString(dateCreated);
		parcel.writeStringList(days);
		parcel.writeInt(id);
		parcel.writeString(title);
		parcel.writeInt(status);
		parcel.writeString(info);
	}
}