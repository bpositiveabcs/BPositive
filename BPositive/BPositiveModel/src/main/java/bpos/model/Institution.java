package bpos.model;

public class Institution  extends Entity<Integer>{
    private String name;
    private String email;
    private String address;

    public Institution(String name, String email, String address) {
        this.name = name;
        this.email = email;
        this.address = address;
    }

    public Institution() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Institution{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", id=" + id +
                "} " + super.toString();
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
