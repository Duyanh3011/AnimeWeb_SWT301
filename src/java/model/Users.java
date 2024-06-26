package model;

import java.io.Serializable;

public class Users implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;
    private String password;
    private String email;
    private String fullname;
    private Boolean admin;

    public Users() {
    }

    public Users(String id, String password, String email, String fullname, Boolean admin) {
        this.id = id;
        this.password = password;
        this.email = email;
        this.fullname = fullname;
        this.admin = admin;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

    @Override
    public String toString() {
        return "Users{" + "id=" + id + "; password=" + password + "; email=" + email + "; fullname=" + fullname + "; admin=" + admin + '}';
    }  
    
}
