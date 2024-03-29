package br.ifal.app.diskwoman.beans;

import java.io.Serializable;

public class Women implements Serializable {

    private int id;
    private String name;
    private String email;

    public Women(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public Women (String name, String email){
        this.name = name;
        this.email = email;
    }

    public Women() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Women{" +
                "Id =" + id +
                ", name ='" + name + '\'' +
                ", email ='" + email + '\'' +
                '}';
    }
}
