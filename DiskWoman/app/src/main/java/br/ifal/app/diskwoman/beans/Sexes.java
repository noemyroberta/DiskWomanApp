package br.ifal.app.diskwoman.beans;

public enum Sexes {

    FEMALE("Feminino"),
    MALE("Masculino");

    private String sex;

    Sexes(String sex) {
        this.sex = sex;
    }

    public String getSex() {
        return sex;
    }

    @Override
    public String toString() {
        return "Sexes{" +
                "sex='" + sex + '\'' +
                '}';
    }
}
