package com.example.tituh.fitnessproj.networking.responses.recipes;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class IngredientsItem implements Parcelable {

	@SerializedName("dosage")
	private String dosage;

	@SerializedName("title")
	private String title;

	protected IngredientsItem(Parcel in) {
		dosage = in.readString();
		title = in.readString();
	}

	public static final Creator<IngredientsItem> CREATOR = new Creator<IngredientsItem>() {
		@Override
		public IngredientsItem createFromParcel(Parcel in) {
			return new IngredientsItem(in);
		}

		@Override
		public IngredientsItem[] newArray(int size) {
			return new IngredientsItem[size];
		}
	};

	public void setDosage(String dosage){
		this.dosage = dosage;
	}

	public String getDosage(){
		return dosage;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return title;
	}

	@Override
 	public String toString(){
		return 
			"IngredientsItem{" + 
			"dosage = '" + dosage + '\'' + 
			",title = '" + title + '\'' + 
			"}";
		}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel parcel, int i) {
		parcel.writeString(dosage);
		parcel.writeString(title);
	}
}