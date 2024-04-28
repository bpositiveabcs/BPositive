package bpos.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class Coupon extends Entity<Integer>{

    private Integer necessaryPoints;
    private String name;
    private String provider;
    private String offer;
    private LocalDateTime unavailableToClaimFrom;
    private Integer validityPeriod;
    private String series;

    @Override
    public String toString() {
        return "Coupon{" +
                "necessaryPoints=" + necessaryPoints +
                ", name='" + name + '\'' +
                ", provider='" + provider + '\'' +
                ", offer='" + offer + '\'' +
                ", unavailableToClaimFrom=" + unavailableToClaimFrom +
                ", validityPeriod=" + validityPeriod +
                ", series='" + series + '\'' +
                ", id=" + id +
                "} " + super.toString();
    }

    public Coupon(Integer necessaryPoints, String name, String provider, String offer, LocalDateTime unavailableToClaimFrom, Integer validityPeriod, String series) {
        this.necessaryPoints = necessaryPoints;
        this.name = name;
        this.provider = provider;
        this.offer = offer;
        this.unavailableToClaimFrom = unavailableToClaimFrom;
        this.validityPeriod = validityPeriod;
        this.series = series;
    }

    public Coupon() {

    }


    public Integer getNecessaryPoints() {
        return necessaryPoints;
    }

    public void setNecessaryPoints(Integer necessaryPoints) {
        this.necessaryPoints = necessaryPoints;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getOffer() {
        return offer;
    }

    public void setOffer(String offer) {
        this.offer = offer;
    }

    public LocalDateTime getUnavailableToClaimFrom() {
        return unavailableToClaimFrom;
    }

    public void setUnavailableToClaimFrom(LocalDateTime unavailableToClaimFrom) {
        this.unavailableToClaimFrom = unavailableToClaimFrom;
    }

    public Integer getValidityPeriod() {
        return validityPeriod;
    }

    public void setValidityPeriod(Integer validityPeriod) {
        this.validityPeriod = validityPeriod;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coupon coupon = (Coupon) o;
        return Objects.equals(necessaryPoints, coupon.necessaryPoints) &&
                Objects.equals(name, coupon.name) &&
                Objects.equals(provider, coupon.provider) &&
                Objects.equals(offer, coupon.offer) &&
                Objects.equals(unavailableToClaimFrom, coupon.unavailableToClaimFrom) &&
                Objects.equals(validityPeriod, coupon.validityPeriod);
    }

    @Override
    public int hashCode() {
        return Objects.hash(necessaryPoints, name, provider, offer, unavailableToClaimFrom, validityPeriod);
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }
}
