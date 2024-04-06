package bpos.model;

import java.util.Objects;

public class Center extends Entity<Integer>{
    private String institutionDetails;
    private LogInfo logInfo;
    private String centerName;
    private Address address;

    public Center(String institutionDetails, LogInfo logInfo, String centerName, Address address) {
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

    public LogInfo getLogInfo() {
        return logInfo;
    }

    public void setLogInfo(LogInfo logInfo) {
        this.logInfo = logInfo;
    }

    public String getCenterName() {
        return centerName;
    }

    public void setCenterName(String centerName) {
        this.centerName = centerName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Center center)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(getInstitutionDetails(), center.getInstitutionDetails()) && Objects.equals(getLogInfo(), center.getLogInfo()) && Objects.equals(getCenterName(), center.getCenterName()) && Objects.equals(getAddress(), center.getAddress());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getInstitutionDetails(), getLogInfo(), getCenterName(), getAddress());
    }
}
