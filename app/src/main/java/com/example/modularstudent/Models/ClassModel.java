package com.example.modularstudent.Models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

public class ClassModel implements Parcelable {

    private String classId;
    private String createdBy;
    private String assignedSchool;
    private String classTitle;
    private List<ClassFilesModel> classFiles= new ArrayList<>();
    private List<ClassLinksModel> classLinks = new ArrayList<>();

    public ClassModel(){}



    public ClassModel(String classId, String classTitle, List<ClassFilesModel> classFiles, List<ClassLinksModel> classLinks) {
        this.classId = classId;
        this.classTitle = classTitle;
        this.classFiles = classFiles;
        this.classLinks = classLinks;
    }

    protected ClassModel(Parcel in) {
        classId = in.readString();
        createdBy = in.readString();
        assignedSchool = in.readString();
        classTitle = in.readString();
    }

    public static final Creator<ClassModel> CREATOR = new Creator<ClassModel>() {
        @Override
        public ClassModel createFromParcel(Parcel in) {
            return new ClassModel(in);
        }

        @Override
        public ClassModel[] newArray(int size) {
            return new ClassModel[size];
        }
    };

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getClassTitle() {
        return classTitle;
    }

    public void setClassTitle(String classTitle) {
        this.classTitle = classTitle;
    }

    public List<ClassFilesModel> getClassFiles() {
        return classFiles;
    }

    public void setClassFiles(List<ClassFilesModel> classFiles) {
        this.classFiles = classFiles;
    }

    public List<ClassLinksModel> getClassLinks() {
        return classLinks;
    }

    public void setClassLinks(List<ClassLinksModel> classLinks) {
        this.classLinks = classLinks;
    }
    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getAssignedSchool() {
        return assignedSchool;
    }

    public void setAssignedSchool(String assignedSchool) {
        this.assignedSchool = assignedSchool;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(classId);
        dest.writeString(createdBy);
        dest.writeString(assignedSchool);
        dest.writeString(classTitle);
    }
}
