package bpos.model;

import java.util.ArrayList;
import java.util.List;

public class Person extends Entity<Integer> {
    private LogInfo personLogInfo;
    private Integer points;
    private PersonalData personalDate;
    private MedicalInfo medicalInfo; //se preiau din baza de date la need
    private List<Donation> donations;//se preiau din baza de date la need
    private List<Event> events;
    Institution institution;
    public Person(){}
    public Person(LogInfo personLogInfo, Integer points, PersonalData personalDate, MedicalInfo medicalInfo, Institution institution) {
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

    public PersonalData getPersonalDate() {
        return personalDate;
    }

    public void setPersonalDate(PersonalData personalDate) {
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

    @Override
    public String toString() {
        return "Person{" +
                "personLogInfo=" + personLogInfo +
                ", points=" + points +
                ", personalDate=" + personalDate +
                ", medicalInfo=" + medicalInfo +
                ", donations=" + donations +
                ", events=" + events +
                ", institution=" + institution +
                ", id=" + id +
                "} " + super.toString();
    }

    public void setInstitution(Institution institution) {
        this.institution = institution;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }
}
