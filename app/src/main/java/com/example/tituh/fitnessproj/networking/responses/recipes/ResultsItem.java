package com.example.tituh.fitnessproj.networking.responses.recipes;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ResultsItem implements Parcelable {

	@SerializedName("image")
	private String image;

	@SerializedName("directions")
	private ArrayList<DirectionsItem> directions;

	@SerializedName("date_edited")
	private String dateEdited;

	@SerializedName("date_created")
	private String dateCreated;

	@SerializedName("author")
	private int author;

	@SerializedName("ingredients")
	private ArrayList<IngredientsItem> ingredients;

	@SerializedName("id")
	private int id;

	@SerializedName("title")
	private String title;

	@SerializedName("type")
	private int type;

	@SerializedName("status")
	private int status;

	protected ResultsItem(Parcel in) {
		image = in.readString();
		dateEdited = in.readString();
		dateCreated = in.readString();
		author = in.readInt();
		id = in.readInt();
		title = in.readString();
		type = in.readInt();
		status = in.readInt();
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

	public void setImage(String image){
		this.image = image;
	}

	public String getImage(){
		return image;
	}

	public void setDirections(ArrayList<DirectionsItem> directions){
		this.directions = directions;
	}

	public ArrayList<DirectionsItem> getDirections(){
		return directions;
	}

	public void setDateEdited(String dateEdited){
		this.dateEdited = dateEdited;
	}

	public String getDateEdited(){
		return dateEdited;
	}

	public void setDateCreated(String dateCreated){
		this.dateCreated = dateCreated;
	}

	public String getDateCreated(){
		return dateCreated;
	}

	public void setAuthor(int author){
		this.author = author;
	}

	public int getAuthor(){
		return author;
	}

	public void setIngredients(ArrayList<IngredientsItem> ingredients){
		this.ingredients = ingredients;
	}

	public ArrayList<IngredientsItem> getIngredients(){
		return ingredients;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return title;
	}

	public void setType(int type){
		this.type = type;
	}

	public int getType(){
		return type;
	}

	public void setStatus(int status){
		this.status = status;
	}

	public int getStatus(){
		return status;
	}

	@Override
 	public String toString(){
		return 
			"ResultsItem{" + 
			"image = '" + image + '\'' + 
			",directions = '" + directions + '\'' + 
			",date_edited = '" + dateEdited + '\'' + 
			",date_created = '" + dateCreated + '\'' + 
			",author = '" + author + '\'' + 
			",ingredients = '" + ingredients + '\'' + 
			",id = '" + id + '\'' + 
			",title = '" + title + '\'' + 
			",type = '" + type + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel parcel, int i) {
		parcel.writeString(image);
		parcel.writeString(dateEdited);
		parcel.writeString(dateCreated);
		parcel.writeInt(author);
		parcel.writeInt(id);
		parcel.writeString(title);
		parcel.writeInt(type);
		parcel.writeInt(status);
	}
}