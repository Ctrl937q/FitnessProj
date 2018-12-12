package com.example.tituh.fitnessproj.networking.responses.training;


import com.google.gson.annotations.SerializedName;

public class WorkoutsItem {

	@SerializedName("image")
	private String image;

	@SerializedName("circuit")
	private int circuit;

	@SerializedName("date_edited")
	private String dateEdited;

	@SerializedName("date_created")
	private String dateCreated;

	@SerializedName("training")
	private int training;

	@SerializedName("title")
	private String title;

	@SerializedName("type")
	private int type;

	@SerializedName("repetitions")
	private Repetitions repetitions;

	@SerializedName("duration")
	private double duration;

	@SerializedName("number")
	private int number;

	@SerializedName("id")
	private int id;

	@SerializedName("position")
	private int position;

	@SerializedName("status")
	private int status;

	@SerializedName("info")
	private String info;

	public void setImage(String image){
		this.image = image;
	}

	public void setCircuit(int circuit){
		this.circuit = circuit;
	}

	public void setDateEdited(String dateEdited){
		this.dateEdited = dateEdited;
	}

	public void setDateCreated(String dateCreated){
		this.dateCreated = dateCreated;
	}

	public void setTraining(int training){
		this.training = training;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public void setType(int type){
		this.type = type;
	}

	public void setRepetitions(Repetitions repetitions){
		this.repetitions = repetitions;
	}

	public void setDuration(double duration){
		this.duration = duration;
	}

	public void setNumber(int number){
		this.number = number;
	}

	public void setId(int id){
		this.id = id;
	}

	public void setPosition(int position){
		this.position = position;
	}

	public void setStatus(int status){
		this.status = status;
	}

	public void setInfo(String info){
		this.info = info;
	}

	public String getImage() {
		return image;
	}

	public int getCircuit() {
		return circuit;
	}

	public String getDateEdited() {
		return dateEdited;
	}

	public String getDateCreated() {
		return dateCreated;
	}

	public int getTraining() {
		return training;
	}

	public String getTitle() {
		return title;
	}

	public int getType() {
		return type;
	}

	public Repetitions getRepetitions() {
		return repetitions;
	}

	public double getDuration() {
		return duration;
	}

	public int getNumber() {
		return number;
	}

	public int getId() {
		return id;
	}

	public int getPosition() {
		return position;
	}

	public int getStatus() {
		return status;
	}

	public String getInfo() {
		return info;
	}

	@Override
 	public String toString(){
		return 
			"WorkoutsItem{" + 
			"image = '" + image + '\'' + 
			",circuit = '" + circuit + '\'' + 
			",date_edited = '" + dateEdited + '\'' + 
			",date_created = '" + dateCreated + '\'' + 
			",training = '" + training + '\'' + 
			",title = '" + title + '\'' + 
			",type = '" + type + '\'' + 
			",repetitions = '" + repetitions + '\'' + 
			",duration = '" + duration + '\'' + 
			",number = '" + number + '\'' + 
			",id = '" + id + '\'' + 
			",position = '" + position + '\'' + 
			",status = '" + status + '\'' + 
			",info = '" + info + '\'' + 
			"}";
		}
}