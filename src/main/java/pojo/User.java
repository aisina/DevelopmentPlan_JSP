package pojo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by innopolis on 26.12.2016.
 */

public class User {

    private String id;
    private String username;
    private String password;

    public User() {
    }

    public User(String id, String username) {
        this.id = id;
        this.username = username;
    }


    public User(String id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
