package Textsession;

public class User {
    private String username;
    private String password;
    private String[] hobbies;
    private String sex;

    public User(String username, String password, String hobbies, String sex) {
    }

    public User(String username, String password, String[] hobbies, String sex) {
        this.username = username;
        this.password = password;
        this.hobbies = hobbies;
        this.sex = sex;
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

    public String[] getHobbies() {
        return hobbies;
    }

    public void setHobbies(String[] hobbies) {
        this.hobbies = hobbies;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
