package bpos.networking.dto;

public class LogInfoDTO implements java.io.Serializable{
    private String id;
    private String username;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LogInfoDTO(String id, String username, String password, String email, String seed) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.seed = seed;
    }

    private String password;
    private String email;
    private String seed;

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

    public LogInfoDTO(String username, String password, String email, String seed) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.seed = seed;
    }
}
