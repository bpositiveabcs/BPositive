package bpos.model;

import java.util.Objects;

public class LogInfo extends Entity<Integer>{
    private String username;
    private String password;
    private String email;
    private String seed;
    public LogInfo(String username, String password, String email, String seed) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.seed = seed;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSeed() {
        return seed;
    }

    public void setSeed(String seed) {
        this.seed = seed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LogInfo that)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(getUsername(), that.getUsername()) && Objects.equals(getPassword(), that.getPassword()) && Objects.equals(getEmail(), that.getEmail()) && Objects.equals(getSeed(), that.getSeed());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getUsername(), getPassword(), getEmail(), getSeed());
    }
}
