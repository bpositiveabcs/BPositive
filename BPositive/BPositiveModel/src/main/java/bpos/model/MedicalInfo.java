package bpos.model;

import bpos.model.Enums.BloodType;
import bpos.model.Enums.Rh;

import java.util.List;
import java.util.Objects;

public class MedicalInfo extends Entity<Integer> {

    private boolean eligibility;
    private BloodType bloodType;
    private Rh rh;
    private List<BloodTest> medicalHistory;


    public MedicalInfo(boolean eligibility, BloodType bloodType, Rh rh, List<BloodTest> medicalHistory) {
        this.eligibility = eligibility;
        this.bloodType = bloodType;
        this.rh = rh;
        this.medicalHistory = medicalHistory;
    }

    public MedicalInfo() {

    }

    public boolean getEligibility() {
        return eligibility;
    }

    public void setEligibility(boolean eligibility) {
        this.eligibility = eligibility;
    }

    public BloodType getBloodType() {
        return bloodType;
    }

    public void setBloodType(BloodType bloodType) {
        this.bloodType = bloodType;
    }

    public Rh getRh() {
        return rh;
    }

    public void setRh(Rh rh) {
        this.rh = rh;
    }

    public List<BloodTest> getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(List<BloodTest> medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MedicalInfo)) return false;
        MedicalInfo that = (MedicalInfo) o;
        return eligibility == that.eligibility &&
                Objects.equals(bloodType, that.bloodType) &&
                Objects.equals(rh, that.rh) &&
                Objects.equals(medicalHistory, that.medicalHistory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(eligibility, bloodType, rh, medicalHistory);
    }
}

