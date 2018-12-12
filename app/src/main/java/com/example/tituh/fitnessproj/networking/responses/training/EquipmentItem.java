package com.example.tituh.fitnessproj.networking.responses.training;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class EquipmentItem implements Parcelable {

	@SerializedName("image")
	private String image;

	@SerializedName("date_edited")
	private String dateEdited;

	@SerializedName("date_created")
	private String dateCreated;

	@SerializedName("id")
	private int id;

	@SerializedName("title")
	private String title;

	@SerializedName("status")
	private int status;

	protected EquipmentItem(Parcel in) {
		image = in.readString();
		dateEdited = in.readString();
		dateCreated = in.readString();
		id = in.readInt();
		title = in.readString();
		status = in.readInt();
	}

	public static final Creator<EquipmentItem> CREATOR = new Creator<EquipmentItem>() {
		@Override
		public EquipmentItem createFromParcel(Parcel in) {
			return new EquipmentItem(in);
		}

		@Override
		public EquipmentItem[] newArray(int size) {
			return new EquipmentItem[size];
		}
	};

	public void setImage(String image){
		this.image = image;
	}

	public void setDateEdited(String dateEdited){
		this.dateEdited = dateEdited;
	}

	public void setDateCreated(String dateCreated){
		this.dateCreated = dateCreated;
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

	public String getImage() {
		return image;
	}

	public String getDateEdited() {
		return dateEdited;
	}

	public String getDateCreated() {
		return dateCreated;
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

	@Override
 	public String toString(){
		return 
			"EquipmentItem{" + 
			"image = '" + image + '\'' + 
			",date_edited = '" + dateEdited + '\'' + 
			",date_created = '" + dateCreated + '\'' + 
			",id = '" + id + '\'' + 
			",title = '" + title + '\'' + 
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
		parcel.writeInt(id);
		parcel.writeString(title);
		parcel.writeInt(status);
	}
}