package bpos.model;

import java.util.Objects;

public class Student extends Person{
    private Integer year;
    private String bloodType;
    private String faculty;
    private Institution university;

    public Student(LogInfo personLogInfo, Integer points, PersonalData personalDate, MedicalInfo medicalInfo, Institution institution, Integer year, String bloodType, String faculty, Institution university) {
        super(personLogInfo, points, personalDate, medicalInfo, institution);
        this.year = year;
        this.bloodType = bloodType;
        this.faculty = faculty;
        this.university = university;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public Institution getUniversity() {
        return university;
    }

    public void setUniversity(Institution university) {
        this.university = university;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student student)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(getYear(), student.getYear()) && Objects.equals(getBloodType(), student.getBloodType()) && Objects.equals(getFaculty(), student.getFaculty()) && Objects.equals(getUniversity(), student.getUniversity());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getYear(), getBloodType(), getFaculty(), getUniversity());
    }
}
