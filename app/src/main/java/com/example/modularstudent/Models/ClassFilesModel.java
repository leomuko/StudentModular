package com.example.modularstudent.Models;

public class ClassFilesModel {

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
