package br.ifal.app.womancomplaintuser.beans;

import java.io.Serializable;

public class Addresses implements Serializable {

    private String neighborhood;
    private String street;
    private String number;
    private String zipCode;
    private String city;
    private int id;

    public Addresses(String neighborhood, String street, String number, String zipCode, String city, int id) {
        this.neighborhood = neighborhood;
        this.street = street;
        this.number = number;
        this.zipCode = zipCode;
        this.city = city;
        this.id = id;
    }

    public Addresses(String neighborhood, String street, String number, String zipCode, String city) {
        this.neighborhood = neighborhood;
        this.street = street;
        this.number = number;
        this.zipCode = zipCode;
        this.city = city;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) { this.street = street; }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Addresses{" +
                "Neighborhood='" + neighborhood + '\'' +
                ", Street='" + street + '\'' +
                ", Number='" + number + '\'' +
                ", ZipCod='" + zipCode + '\'' +
                ", City='" + city + '\'' +
                ", Id=" + id +
                '}';
    }
}
