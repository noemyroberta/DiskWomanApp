package br.ifal.app.diskwoman.beans;

import java.io.Serializable;

public class Offenders implements Serializable {

    private int id;
    private String name;
    private String appearence;
    private String age;
    private Sexes sex;

    public Offenders(int id, String name, String appearence, String age, Sexes sex) {
        this.id = id;
        this.name = name;
        this.appearence = appearence;
        this.age = age;
        this.sex = sex;
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

    public String getAppearence()
    {
        return appearence;
    }

    public void setAppearence(String appearence) {
        appearence = appearence;
    }

    public String getAge() { return age; }

    public void setAge(String age) { this.age = age; }

    public Sexes getSex() { return sex; }

    public void setSex(Sexes sex) { this.sex = sex; }

    @Override
    public String toString() {
        return "Offenders{" +
                ", id =" + id +
                ", name ='" + name + '\'' +
                ", appearence ='" + appearence + '\'' +
                ", age ='" + age + '\'' +
                ", sex = '" + sex +  '\'' +
                '}';
    }
}