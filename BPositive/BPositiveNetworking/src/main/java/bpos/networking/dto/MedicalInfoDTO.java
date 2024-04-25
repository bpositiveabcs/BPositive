package bpos.networking.dto;

import bpos.model.Enums.BloodType;
import bpos.model.Enums.Rh;

public class MedicalInfoDTO implements java.io.Serializable{
    private String eligibility;
    private String bloodType;
    private String rh;

    public String getEligibility() {
        return eligibility;
    }

    public void setEligibility(String eligibility) {
        this.eligibility = eligibility;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public String getRh() {
        return rh;
    }

    public void setRh(String rh) {
        this.rh = rh;
    }

    public MedicalInfoDTO(String eligibility, String bloodType, String rh) {
        this.eligibility = eligibility;
        this.bloodType = bloodType;
        this.rh = rh;
    }
}
