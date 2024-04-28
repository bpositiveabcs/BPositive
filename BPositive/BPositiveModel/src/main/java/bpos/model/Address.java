package bpos.model;

import java.util.Objects;

public class Address extends Entity<Integer>{
    private String country;
    private String city;
    private String county;
    private String street;
    private String numberStreet;
    private String block;
    private Integer floor;
    private String apartment;

    public Address(String country, String city, String county, String street, String numberStreet, String block, Integer floor, String apartment) {
        this.country = country;
        this.city = city;
        this.county = county;
        this.street = street;
        this.numberStreet = numberStreet;
        this.block = block;
        this.floor = floor;
        this.apartment = apartment;
    }

    public Address() {

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

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public String getApartment() {
        return apartment;
    }

    public void setApartment(String apartment) {
        this.apartment = apartment;
    }

    @Override
    public String toString() {
        return "Address{" +
                "country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", county='" + county + '\'' +
                ", street='" + street + '\'' +
                ", numberStreet='" + numberStreet + '\'' +
                ", block='" + block + '\'' +
                ", floor=" + floor +
                ", apartment='" + apartment + '\'' +
                ", id=" + id +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address address)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(getCountry(), address.getCountry()) && Objects.equals(getCity(), address.getCity()) && Objects.equals(getCounty(), address.getCounty()) && Objects.equals(getStreet(), address.getStreet()) && Objects.equals(getNumberStreet(), address.getNumberStreet()) && Objects.equals(getBlock(), address.getBlock()) && Objects.equals(getFloor(), address.getFloor()) && Objects.equals(getApartment(), address.getApartment());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getCountry(), getCity(), getCounty(), getStreet(), getNumberStreet(), getBlock(), getFloor(), getApartment());
    }
}
