package com.example.modularstudent.Models;

import java.util.ArrayList;
import java.util.List;

public class ClassModel {

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
}
