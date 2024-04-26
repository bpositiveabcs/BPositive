package bpos.networking.dto;

import bpos.model.*;

import java.util.List;

public class PersonDTO implements java.io.Serializable{
    private String id;
    private LogInfoDTO personLogInfo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private String points;
    private PersonalDataDTO personalDate;
    private MedicalInfoDTO medicalInfo; //se preiau din baza de date la need

    InstitutionDTO institution;

    public PersonDTO(String id, LogInfoDTO personLogInfo, String points, PersonalDataDTO personalDate, MedicalInfoDTO medicalInfo, InstitutionDTO institution) {
        this.id = id;
        this.personLogInfo = personLogInfo;
        this.points = points;
        this.personalDate = personalDate;
        this.medicalInfo = medicalInfo;
        this.institution = institution;
    }

    public PersonDTO(LogInfoDTO personLogInfo, String points, PersonalDataDTO personalDate, MedicalInfoDTO medicalInfo, InstitutionDTO institution) {
        this.personLogInfo = personLogInfo;
        this.points = points;
        this.personalDate = personalDate;
        this.medicalInfo = medicalInfo;
        this.institution = institution;
    }

    public LogInfoDTO getPersonLogInfo() {
        return personLogInfo;
    }

    public void setPersonLogInfo(LogInfoDTO personLogInfo) {
        this.personLogInfo = personLogInfo;
    }

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
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

    public InstitutionDTO getInstitution() {
        return institution;
    }

    public void setInstitution(InstitutionDTO institution) {
        this.institution = institution;
    }
}
