package br.ifal.app.diskwoman.beans;

import java.io.Serializable;

public class Involved implements Serializable {

    private int id;
    private String name;
    private String age;
    private Sexes sex;

    public Involved(int id, String name, String age, Sexes sex) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public Involved() {

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

    public String getAge() { return age; }

    public void setAge(String age) { this.age = age; }

    public Sexes getSex() { return sex; }

    public void setSex() { this.sex = sex; }

    @Override
    public String toString() {
        return "Involved {" +
                ", id =" + id +
                ", name ='" + name + '\'' +
                ", age ='" + age + '\'' +
                ", sex =" + sex +
                '}';
    }
}