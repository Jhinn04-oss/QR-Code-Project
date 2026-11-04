package com.attendance.model;

public class Student {

    private String studentId;
    private String fullName;
    private String strand;
    private String section;
    private String photo;
    private String qrCode;

    public Student() {
    }

    public Student(String studentId, String fullName, String strand,
                   String section, String photo, String qrCode) {

        this.studentId = studentId;
        this.fullName = fullName;
        this.strand = strand;
        this.section = section;
        this.photo = photo;
        this.qrCode = qrCode;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getStrand() {
        return strand;
    }

    public void setStrand(String strand) {
        this.strand = strand;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }
}