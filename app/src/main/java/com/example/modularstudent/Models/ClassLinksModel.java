package com.example.modularstudent.Models;

public class ClassLinksModel {

    private String linkName;
    private String linkUploadTime;

    public ClassLinksModel(){}

    public ClassLinksModel(String linkName, String linkUploadTime) {
        this.linkName = linkName;
        this.linkUploadTime = linkUploadTime;
    }

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
