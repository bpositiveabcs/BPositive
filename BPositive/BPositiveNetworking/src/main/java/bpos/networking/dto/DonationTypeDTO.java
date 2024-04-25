package bpos.networking.dto;

public class DonationTypeDTO implements java.io.Serializable{
    private String name;
    private String waitingInterval;

    public DonationTypeDTO(String name, String waitingInterval) {
        this.name = name;
        this.waitingInterval = waitingInterval;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWaitingInterval() {
        return waitingInterval;
    }

    public void setWaitingInterval(String waitingInterval) {
        this.waitingInterval = waitingInterval;
    }
}
