package bpos.model;

import java.util.ArrayList;
import java.util.List;

public class Person extends Entity<Integer> {
    private LogInfo personLogInfo;
    private Integer points;
    private PersonalDate personalDate;
    private MedicalInfo medicalInfo;
    private List<Donation> donations;
    Institution institution;

    public Person(LogInfo personLogInfo, Integer points, PersonalDate personalDate, MedicalInfo medicalInfo, Institution institution) {
        this.personLogInfo = personLogInfo;
        this.points = points;
        this.personalDate = personalDate;
        this.medicalInfo = medicalInfo;
        this.institution = institution;
        this.donations=new ArrayList<>();
    }

    public LogInfo getPersonLogInfo() {
        return personLogInfo;
    }

    public void setPersonLogInfo(LogInfo personLogInfo) {
        this.personLogInfo = personLogInfo;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public PersonalDate getPersonalDate() {
        return personalDate;
    }

    public void setPersonalDate(PersonalDate personalDate) {
        this.personalDate = personalDate;
    }

    public MedicalInfo getMedicalInfo() {
        return medicalInfo;
    }

    public void setMedicalInfo(MedicalInfo medicalInfo) {
        this.medicalInfo = medicalInfo;
    }

    public List<Donation> getDonations() {
        return donations;
    }

    public void setDonations(List<Donation> donations) {
        this.donations = donations;
    }

    public Institution getInstitution() {
        return institution;
    }

    public void setInstitution(Institution institution) {
        this.institution = institution;
    }
}
