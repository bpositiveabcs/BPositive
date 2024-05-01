package bpos.model;
import java.util.Objects;

public class DonationType extends Entity<Integer>{

    private String name;
    private Integer waitingInterval;

    public DonationType(String name, Integer waitingInterval) {
        this.name = name;
        this.waitingInterval = waitingInterval;
    }

    public DonationType() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getWaitingInterval() {
        return waitingInterval;
    }


    public void setWaitingInterval(Integer waitingInterval) {
        this.waitingInterval = waitingInterval;
    }

    @Override
    public String toString() {
        return "DonationType{" +
                "name='" + name + '\'' +
                ", waitingInterval=" + waitingInterval +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DonationType that = (DonationType) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(waitingInterval, that.waitingInterval);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, waitingInterval);
    }
}

