package bpos.networking.dto;

import java.io.Serializable;

public class AddressDTO implements Serializable {
    private String id;
    private String country;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public AddressDTO(String id, String country, String city, String county, String street, String numberStreet, String block, String floor, String apartment) {
        this.id = id;
        this.country = country;
        this.city = city;
        this.county = county;
        this.street = street;
        this.numberStreet = numberStreet;
        this.block = block;
        this.floor = floor;
        this.apartment = apartment;
    }

    private String city;
    private String county;
    private String street;
    private String numberStreet;
    private String block;
    private String floor;
    private String apartment;

    public AddressDTO(String country, String city, String county, String street, String numberStreet, String block, String floor, String apartment) {
        this.country = country;
        this.city = city;
        this.county = county;
        this.street = street;
        this.numberStreet = numberStreet;
        this.block = block;
        this.floor = floor;
        this.apartment = apartment;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumberStreet() {
        return numberStreet;
    }

    public void setNumberStreet(String numberStreet) {
        this.numberStreet = numberStreet;
    }

    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getApartment() {
        return apartment;
    }

    public void setApartment(String apartment) {
        this.apartment = apartment;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }
}
