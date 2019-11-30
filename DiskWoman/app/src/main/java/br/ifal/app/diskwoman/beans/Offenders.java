package br.ifal.app.diskwoman.beans;

import java.io.Serializable;

public class Offenders implements Serializable {

    private int id;
    private String name;
    private String appearence;

    public Offenders(int id, String name, String appearence) {
        id = id;
        name = name;
        appearence = appearence;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {

        id = id;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        name = name;
    }

    public String getAppearence()
    {
        return appearence;
    }

    public void setAppearence(String appearence) {
        appearence = appearence;
    }

    @Override
    public String toString() {
        return "Offenders{" +
                "Id=" + id +
                ", Name='" + name + '\'' +
                ", Appearence='" + appearence + '\'' +
                '}';
    }
}