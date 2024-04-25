package bpos.networking.dto;

import bpos.model.Institution;

public class StudentDTO implements java.io.Serializable{
    private String year;
    private String group;
    private String faculty;
    private String department;
    private InstitutionDTO university;

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public InstitutionDTO getUniversity() {
        return university;
    }

    public void setUniversity(InstitutionDTO university) {
        this.university = university;
    }

    public StudentDTO(String year, String group, String faculty, String department, InstitutionDTO university) {
        this.year = year;
        this.group = group;
        this.faculty = faculty;
        this.department = department;
        this.university = university;
    }
}
