package com.example.modularstudent.Models;

import android.os.Parcel;
import android.os.Parcelable;

public class ClassFilesModel implements Parcelable {

    private String fileTitle;
    private String fileUploadTime;
    private String fileDownloadUrl;
    private String fileStorageRef;

    public ClassFilesModel(){}

    public ClassFilesModel(String fileTitle, String fileUploadTime, String fileDownloadUrl, String fileStorageRef) {
        this.fileTitle = fileTitle;
        this.fileUploadTime = fileUploadTime;
        this.fileDownloadUrl = fileDownloadUrl;
        this.fileStorageRef = fileStorageRef;
    }

    protected ClassFilesModel(Parcel in) {
        fileTitle = in.readString();
        fileUploadTime = in.readString();
        fileDownloadUrl = in.readString();
        fileStorageRef = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(fileTitle);
        dest.writeString(fileUploadTime);
        dest.writeString(fileDownloadUrl);
        dest.writeString(fileStorageRef);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ClassFilesModel> CREATOR = new Creator<ClassFilesModel>() {
        @Override
        public ClassFilesModel createFromParcel(Parcel in) {
            return new ClassFilesModel(in);
        }

        @Override
        public ClassFilesModel[] newArray(int size) {
            return new ClassFilesModel[size];
        }
    };

    public String getFileTitle() {
        return fileTitle;
    }

    public void setFileTitle(String fileTitle) {
        this.fileTitle = fileTitle;
    }

    public String getFileUploadTime() {
        return fileUploadTime;
    }

    public void setFileUploadTime(String fileUploadTime) {
        this.fileUploadTime = fileUploadTime;
    }

    public String getFileDownloadUrl() {
        return fileDownloadUrl;
    }

    public void setFileDownloadUrl(String fileDownloadUrl) {
        this.fileDownloadUrl = fileDownloadUrl;
    }

    public String getFileStorageRef() {
        return fileStorageRef;
    }

    public void setFileStorageRef(String fileStorageRef) {
        this.fileStorageRef = fileStorageRef;
    }
}
