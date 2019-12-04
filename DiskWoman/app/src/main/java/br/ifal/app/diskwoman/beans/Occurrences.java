package br.ifal.app.diskwoman.beans;

import java.io.Serializable;

public class Occurrences implements Serializable {

    private int id;
    private String title;
    private String description;
    private String image;
    private String date;
    private String addressCep;
    private String addressNumber;
    private String addressComplement;

    public Occurrences(int id, String title, String description, String image, String date,
                       String addressCep, String addressNumber, String addressComplement) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.image = image;
        this.date = date;
        this.addressCep = addressCep;
        this.addressNumber = addressNumber;
        this.addressComplement = addressComplement;
    }

    public Occurrences() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAddressCep() { return addressCep; }

    public void setAddressCep(String addressCep) { this.addressCep = addressCep; }

    public String getAddressNumber() { return addressNumber; }

    public void setAddressNumber(String addressNumber) { this.addressNumber = addressNumber; }

    public String getAddressComplement() { return addressComplement; }

    public void setAddressComplement(String addressComplement) {
        this.addressComplement = addressComplement;
    }

    @Override
    public String toString() {
        return "Occurrences {" +
                "id =" + id +
                ", title ='" + title + '\'' +
                ", description ='" + description + '\'' +
                ", image ='" + image + '\'' +
                ", date ='" + date + '\'' +
                ", cep ='" + addressCep + '\'' +
                ", number ='" + addressNumber + '\'' +
                ", reference ='" + addressComplement + '\'' +
                '}';
    }
}