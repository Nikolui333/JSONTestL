
package com.semenov.jsontestl;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class USD implements Parcelable{

    @SerializedName("Name")
    @Expose
    private String name;
    @SerializedName("Value")
    @Expose
    private double value;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }


    protected USD(Parcel in) {
        name = in.readString();
        value = in.readDouble();
    }

/*    protected USD (){

    }

    protected USD (String name, double value){

    }*/

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeDouble(value);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<USD> CREATOR = new Parcelable.Creator<USD>() {
        @Override
        public USD createFromParcel(Parcel in) {
            return new USD(in);
        }

        @Override
        public USD[] newArray(int size) {
            return new USD[size];
        }
    };
}
