package bpos.model;

import java.util.Objects;

public class Student extends Person{
    private Integer year;
    private String group;
    private String faculty;
    private String department;
    private Institution university;

    public Student(LogInfo personLogInfo, Integer points, PersonalData personalDate, MedicalInfo medicalInfo, Institution institution, Integer year, String group, String faculty, String department, Institution university) {
        super(personLogInfo, points, personalDate, medicalInfo, institution);
        this.year = year;
        this.group = group;
        this.faculty = faculty;
        this.department = department;
        this.university = university;
    }

    public Student(String department, String faculty, int an, String grupa, Person person) {
        super(person.getPersonLogInfo(),person.getPoints(),person.getPersonalDate(),person.getMedicalInfo(),person.getInstitution());
        this.department=department;
        this.faculty=faculty;
        this.year=an;
        this.group=grupa;
    }

    public Student() {

    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getGroup() {
        return group;
    }
    public String setGroup(String group) {
        return this.group = group;
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
        return Objects.equals(getYear(), student.getYear()) && Objects.equals(getGroup(), student.getGroup()) && Objects.equals(getFaculty(), student.getFaculty()) && Objects.equals(getUniversity(), student.getUniversity());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getYear(),getGroup(), getFaculty(), getUniversity());
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Student{" +
                "year=" + year +
                ", group='" + group + '\'' +
                ", faculty='" + faculty + '\'' +
                ", department='" + department + '\'' +
                ", university=" + university +
                ", institution=" + institution +
                ", id=" + id +
                "} " + super.toString();
    }
}
