package bpos.model;

import java.util.Date;
import java.util.Objects;

public class PersonalDate extends Entity<Integer>{
    private Address address;
    private String phoneNumber;
    private String firstName;
    private String lastName;
    private String cnp;
    private String sex;
    private Date birthDate;

    public PersonalDate(Address address, String phoneNumber, String firstName, String lastName, String cnp, String sex, Date birthDate) {
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.cnp = cnp;
        this.sex = sex;
        this.birthDate = birthDate;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PersonalDate that)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(getAddress(), that.getAddress()) && Objects.equals(getPhoneNumber(), that.getPhoneNumber()) && Objects.equals(getFirstName(), that.getFirstName()) && Objects.equals(getLastName(), that.getLastName()) && Objects.equals(getCnp(), that.getCnp()) && Objects.equals(getSex(), that.getSex()) && Objects.equals(getBirthDate(), that.getBirthDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getAddress(), getPhoneNumber(), getFirstName(), getLastName(), getCnp(), getSex(), getBirthDate());
    }
}
