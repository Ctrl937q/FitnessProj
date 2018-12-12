package com.example.tituh.fitnessproj.networking.responses.recipes;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class DirectionsItem implements Parcelable {

	@SerializedName("position")
	private int position;

	@SerializedName("text")
	private String text;

	protected DirectionsItem(Parcel in) {
		position = in.readInt();
		text = in.readString();
	}

	public static final Creator<DirectionsItem> CREATOR = new Creator<DirectionsItem>() {
		@Override
		public DirectionsItem createFromParcel(Parcel in) {
			return new DirectionsItem(in);
		}

		@Override
		public DirectionsItem[] newArray(int size) {
			return new DirectionsItem[size];
		}
	};

	public void setPosition(int position){
		this.position = position;
	}

	public int getPosition(){
		return position;
	}

	public void setText(String text){
		this.text = text;
	}

	public String getText(){
		return text;
	}

	@Override
 	public String toString(){
		return 
			"DirectionsItem{" + 
			"position = '" + position + '\'' + 
			",text = '" + text + '\'' + 
			"}";
		}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel parcel, int i) {
		parcel.writeInt(position);
		parcel.writeString(text);
	}
}