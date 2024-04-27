package bpos.networking.dto;

import bpos.model.Institution;
import bpos.model.LogInfo;
import bpos.model.PersonalData;

public class StudentDTO implements java.io.Serializable{
    private String id;
    private String year;
    LogInfoDTO personLogInfo;
    Integer points;
    PersonalDataDTO personalDate;
    MedicalInfoDTO medicalInfo;

    public StudentDTO() {

    }

    public LogInfoDTO getPersonLogInfo() {
        return personLogInfo;
    }

    public void setPersonLogInfo(LogInfoDTO personLogInfo) {
        this.personLogInfo = personLogInfo;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public PersonalDataDTO getPersonalDate() {
        return personalDate;
    }

    public void setPersonalDate(PersonalDataDTO personalDate) {
        this.personalDate = personalDate;
    }

    public MedicalInfoDTO getMedicalInfo() {
        return medicalInfo;
    }

    public void setMedicalInfo(MedicalInfoDTO medicalInfo) {
        this.medicalInfo = medicalInfo;
    }

    public StudentDTO(String id, String year, LogInfoDTO personLogInfo, Integer points, PersonalDataDTO personalDate, MedicalInfoDTO medicalInfo, String group, String faculty, String department, InstitutionDTO university) {
        this.id = id;
        this.year = year;
        this.personLogInfo = personLogInfo;
        this.points = points;
        this.personalDate = personalDate;
        this.medicalInfo = medicalInfo;
        this.group = group;
        this.faculty = faculty;
        this.department = department;
        this.university = university;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public StudentDTO(String id, String year, String group, String faculty, String department, InstitutionDTO university) {
        this.id = id;
        this.year = year;
        this.group = group;
        this.faculty = faculty;
        this.department = department;
        this.university = university;
    }

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
