package bpos.networking.dto;

import bpos.model.DonationType;

import java.io.Serializable;

public class DonationDTO implements Serializable {
    private DonationTypeDTO donationType;

    private String points;

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
