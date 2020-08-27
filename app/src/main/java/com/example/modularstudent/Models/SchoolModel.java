package com.example.modularstudent.Models;

public class SchoolModel {
    private String schoolId;
    private String schoolName;

    public SchoolModel(){}

    public SchoolModel(String schoolId, String schoolName) {
        this.schoolId = schoolId;
        this.schoolName = schoolName;
    }

    public String getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }



    @Override
    public String toString() {
        return schoolName;
    }
}
