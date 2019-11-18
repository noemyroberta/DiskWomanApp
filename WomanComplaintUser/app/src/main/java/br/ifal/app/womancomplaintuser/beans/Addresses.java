package br.ifal.app.womancomplaintuser.beans;

import java.io.Serializable;

public class Addresses implements Serializable {

    private String neighborhood;
    private String street;
    private String number;
    private String zipCod;
    private String city;
    private int id;

    public Addresses(String neighborhood, String street, String number, String zipCod, String city, int id) {
        neighborhood = neighborhood;
        street = street;
        number = number;
        zipCod = zipCod;
        city = city;
        id = id;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        neighborhood = neighborhood;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) { street = street; }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        number = number;
    }

    public String getZipCod() {
        return zipCod;
    }

    public void setZipCod(String zipCod) {
        zipCod = zipCod;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        city = city;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        id = id;
    }

    @Override
    public String toString() {
        return "Addresses{" +
                "Neighborhood='" + neighborhood + '\'' +
                ", Street='" + street + '\'' +
                ", Number='" + number + '\'' +
                ", ZipCod='" + zipCod + '\'' +
                ", City='" + city + '\'' +
                ", Id=" + id +
                '}';
    }
}
