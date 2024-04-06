package bpos.model;

import java.util.Objects;

public class Donation extends Entity<Integer> {

    private DonationType donationType;

    private Integer points;


    public Donation(DonationType donationType, Integer points) {
        this.donationType = donationType;
        this.points = points;
    }

    public DonationType getDonationType() {
        return donationType;
    }

    public void setDonationType(DonationType donationType) {
        this.donationType = donationType;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Donation donation = (Donation) o;
        return Objects.equals(donationType, donation.donationType) &&
                Objects.equals(points, donation.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(donationType, points);
    }
}

