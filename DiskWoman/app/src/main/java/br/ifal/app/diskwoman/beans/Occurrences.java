package br.ifal.app.diskwoman.beans;

import java.io.Serializable;

public class Occurrences implements Serializable {

    private int id;
    private String city;
    private String street;
    private String neighborhood;
    private String title;
    private String description;
    private String image;
    private String date;
    private String addressCep;
    private String addressNumber;

    public Occurrences( int id, String city, String street, String neighborhood, String title, String description, String image, String date,
                      String addressCep, String addressNumber){
        this.id = id;
        this.city = city;
        this.street = street;
        this.neighborhood = neighborhood;
        this.title = title;
        this.description = description;
        this.image = image;
        this.date = date;
        this.addressCep = addressCep;
        this.addressNumber = addressNumber;

    }

    public Occurrences(int id, String title, String description, String image, String date,
                       String addressCep, String addressNumber) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.image = image;
        this.date = date;
        this.addressCep = addressCep;
        this.addressNumber = addressNumber;
    }

    public Occurrences(String title, String description, String date) {
        this.title = title;
        this.description = description;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
       this.id = id;
    }

    public String getCity(){
        return city;
    }

    public void setCity(String city){
        this.city = city;
    }

    public String getStreet(){
        return  street;
    }

    public void setStreet(String street){
       this.street = street;
    }

    public String getNeighborhood(){
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood){
        this.neighborhood = neighborhood;
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
                '}';
    }
}