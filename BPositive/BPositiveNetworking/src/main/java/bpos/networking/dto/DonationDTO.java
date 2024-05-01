package bpos.networking.dto;

import java.io.Serializable;

public class DonationDTO implements Serializable {
    private String id;
    private DonationTypeDTO donationType;

    private String points;

    public DonationDTO() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public DonationDTO(String id, DonationTypeDTO donationType, String points) {
        this.id = id;
        this.donationType = donationType;
        this.points = points;
    }

    public DonationDTO(DonationTypeDTO donationType, String points) {
        this.donationType = donationType;
        this.points = points;
    }

    public DonationTypeDTO getDonationType() {
        return donationType;
    }

    public void setDonationType(DonationTypeDTO donationType) {
        this.donationType = donationType;
    }

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
    }
}
