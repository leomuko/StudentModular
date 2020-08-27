package com.example.modularstudent.Models;

public class TeacherModel {

    private String teacherId;
    private String teacherName;
    private String assignedSchoolId;
    private String teacherEmail;
    private String teacherPassword;

    public TeacherModel(){}

    public TeacherModel(String teacherId, String teacherName, String assignedSchool, String teacherEmail, String teacherPassword) {
        this.teacherId = teacherId;
        this.teacherName = teacherName;
        this.assignedSchoolId = assignedSchool;
        this.teacherEmail = teacherEmail;
        this.teacherPassword = teacherPassword;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getAssignedSchoolId() {
        return assignedSchoolId;
    }

    public void setAssignedSchoolId(String assignedSchoolId) {
        this.assignedSchoolId = assignedSchoolId;
    }

    public String getTeacherEmail() {
        return teacherEmail;
    }

    public void setTeacherEmail(String teacherEmail) {
        this.teacherEmail = teacherEmail;
    }

    public String getTeacherPassword() {
        return teacherPassword;
    }

    public void setTeacherPassword(String teacherPassword) {
        this.teacherPassword = teacherPassword;
    }
}
