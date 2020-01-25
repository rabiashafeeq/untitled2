package BackingBean;

public class User {
    private  int UserId;
    private String email;
    private String password;
private  String name;


    public User() {
    }

    public int getId() {
        return UserId;
    }

    public void setId(int id) {
        this.UserId = id;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
