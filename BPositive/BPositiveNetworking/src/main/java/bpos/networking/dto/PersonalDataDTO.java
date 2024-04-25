package bpos.networking.dto;

import bpos.model.Address;

import java.time.LocalDate;

public class PersonalDataDTO implements java.io.Serializable{
    private AddressDTO address;
    private String phoneNumber;
    private String firstName;
    private String lastName;
    private String cnp;
    private String sex;
    private String birthDate;

    public AddressDTO getAddress() {
        return address;
    }

    public void setAddress(AddressDTO address) {
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

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public PersonalDataDTO(AddressDTO address, String phoneNumber, String firstName, String lastName, String cnp, String sex, String birthDate) {
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.cnp = cnp;
        this.sex = sex;
        this.birthDate = birthDate;
    }
}
