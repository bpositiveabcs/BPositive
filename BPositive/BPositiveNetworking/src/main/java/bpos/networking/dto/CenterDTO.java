package bpos.networking.dto;

import bpos.model.LogInfo;

public class CenterDTO implements java.io.Serializable{
    private String id;
    private String institutionDetails;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public CenterDTO(String id, String institutionDetails, LogInfoDTO logInfo, String centerName, String address) {
        this.id = id;
        this.institutionDetails = institutionDetails;
        this.logInfo = logInfo;
        this.centerName = centerName;
        this.address = address;
    }

    private LogInfoDTO logInfo;
    private String centerName;
    private String address;

    public CenterDTO(String institutionDetails, LogInfoDTO logInfo, String centerName, String address) {
        this.institutionDetails = institutionDetails;
        this.logInfo = logInfo;
        this.centerName = centerName;
        this.address = address;
    }

    public String getInstitutionDetails() {
        return institutionDetails;
    }

    public void setInstitutionDetails(String institutionDetails) {
        this.institutionDetails = institutionDetails;
    }

    public LogInfoDTO getLogInfo() {
        return logInfo;
    }

    public void setLogInfo(LogInfoDTO logInfo) {
        this.logInfo = logInfo;
    }

    public String getCenterName() {
        return centerName;
    }

    public void setCenterName(String centerName) {
        this.centerName = centerName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
