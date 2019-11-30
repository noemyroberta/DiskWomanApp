package br.ifal.app.diskwoman.beans;

import java.io.Serializable;

public class Involved implements Serializable {

    private int id;
    private String name;

    public Involved(int id, String name) {
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
        return "Involved{" +
                "Id=" + id +
                ", Name='" + name + '\'' +
                '}';
    }
}