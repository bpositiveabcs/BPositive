package bpos.networking.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

public class CouponDTO implements Serializable {
    private String id;
    private String necessaryPoints;
    private String name;

    public CouponDTO() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public CouponDTO(String id, String necessaryPoints, String name, String provider, String offer, String unavailableToClaimFrom, String validityPeriod, String series) {
        this.id = id;
        this.necessaryPoints = necessaryPoints;
        this.name = name;
        this.provider = provider;
        this.offer = offer;
        this.unavailableToClaimFrom = unavailableToClaimFrom;
        this.validityPeriod = validityPeriod;
        this.series = series;
    }

    private String provider;
    private String offer;
    private String unavailableToClaimFrom;
    private String validityPeriod;
    private String series;

    public String getNecessaryPoints() {
        return necessaryPoints;
    }

    public void setNecessaryPoints(String necessaryPoints) {
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

    public String getUnavailableToClaimFrom() {
        return unavailableToClaimFrom;
    }

    public void setUnavailableToClaimFrom(String unavailableToClaimFrom) {
        this.unavailableToClaimFrom = unavailableToClaimFrom;
    }

    public String getValidityPeriod() {
        return validityPeriod;
    }

    public void setValidityPeriod(String validityPeriod) {
        this.validityPeriod = validityPeriod;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public CouponDTO(String necessaryPoints, String name, String provider, String offer, String unavailableToClaimFrom, String validityPeriod, String series) {
        this.necessaryPoints = necessaryPoints;
        this.name = name;
        this.provider = provider;
        this.offer = offer;
        this.unavailableToClaimFrom = unavailableToClaimFrom;
        this.validityPeriod = validityPeriod;
        this.series = series;
    }
}
