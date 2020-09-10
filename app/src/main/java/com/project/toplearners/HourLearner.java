package com.project.toplearners;

import android.os.Parcel;
import android.os.Parcelable;

public class HourLearner implements Parcelable {

    private String name;
    private int hours;
    private String country;
    private String badgeUrl;

    public HourLearner(String name, int hours, String country, String badgeUrl) {
        this.name = name;
        this.hours = hours;
        this.country = country;
        this.badgeUrl = badgeUrl;
    }

    public String getName() {
        return name;
    }

    public int getHours() {
        return hours;
    }

    public String getCountry(){
        return country;
    }

    public String getBadgeUrl(){ return badgeUrl;}

    public HourLearner(Parcel in) {

        name = in.readString();
        hours = in.readInt();
        country = in.readString();
        badgeUrl = in.readString();

    }

    public static final Parcelable.Creator<HourLearner> CREATOR = new Parcelable.Creator<HourLearner>() {
        @Override
        public HourLearner createFromParcel(Parcel in) {
            return new HourLearner(in);
        }

        @Override
        public HourLearner[] newArray(int size) {

            return new HourLearner[size];
        }

    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(hours);
        dest.writeString(country);
        dest.writeString(badgeUrl);
    }
}
