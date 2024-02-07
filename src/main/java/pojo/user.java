package pojo;


public class user {

    private String email;


    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    private String password;

    public user(String email, String password) {
        this.email = email;
        this.password = password;
    }


}
