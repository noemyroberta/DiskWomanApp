package br.ifal.app.womancomplaintpolice.beans;

import java.io.Serializable;

public class Polices implements Serializable {

    private int id;
    private String name;

    public Polices(int id, String name) {
        id = id;
        name = name;
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

    @Override
    public String toString() {
        return "Polices{" +
                "Id=" + id +
                ", Name='" + name + '\'' +
                '}';
    }
}
