package bpos.networking.dto;

import bpos.model.MedicalInfo;

import java.io.Serializable;

public class BloodTestDTO implements Serializable {
    private String id;
    private String name;
    private String path;

    public BloodTestDTO(String id, String name, String path, MedicalInfoDTO medicalInfo) {
        this.id = id;
        this.name = name;
        this.path = path;
        this.medicalInfo = medicalInfo;
    }

    public BloodTestDTO() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private MedicalInfoDTO medicalInfo;

    public BloodTestDTO(String name, String path, MedicalInfoDTO medicalInfo) {
        this.name = name;
        this.path = path;
        this.medicalInfo = medicalInfo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public MedicalInfoDTO getMedicalInfo() {
        return medicalInfo;
    }

    public void setMedicalInfo(MedicalInfoDTO medicalInfo) {
        this.medicalInfo = medicalInfo;
    }
}
