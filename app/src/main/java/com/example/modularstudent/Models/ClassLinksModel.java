package com.example.modularstudent.Models;

import android.os.Parcel;
import android.os.Parcelable;

public class ClassLinksModel  implements Parcelable {

    private String linkName;
    private String linkUploadTime;

    public ClassLinksModel(){}

    public ClassLinksModel(String linkName, String linkUploadTime) {
        this.linkName = linkName;
        this.linkUploadTime = linkUploadTime;
    }

    protected ClassLinksModel(Parcel in) {
        linkName = in.readString();
        linkUploadTime = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(linkName);
        dest.writeString(linkUploadTime);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ClassLinksModel> CREATOR = new Creator<ClassLinksModel>() {
        @Override
        public ClassLinksModel createFromParcel(Parcel in) {
            return new ClassLinksModel(in);
        }

        @Override
        public ClassLinksModel[] newArray(int size) {
            return new ClassLinksModel[size];
        }
    };

    public String getLinkName() {
        return linkName;
    }

    public void setLinkName(String linkName) {
        this.linkName = linkName;
    }

    public String getLinkUploadTime() {
        return linkUploadTime;
    }

    public void setLinkUploadTime(String linkUploadTime) {
        this.linkUploadTime = linkUploadTime;
    }
}
