package br.ifal.app.womancomplaintuser.beans;

import java.io.Serializable;

public class Occurrences implements Serializable {

    private int id;
    private String title;
    private String description;
    private String image;
    private String media;
    private String date;
    private boolean status;

    public Occurrences(int id, String title, String description, String image, String media, String date, boolean status) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.image = image;
        this.media = media;
        this.date = date;
        this.status = status;
    }

    public Occurrences(String title, String description, String date, boolean status) {
        this.title = title;
        this.description = description;
        this.image = image;
        this.media = media;
        this.date = date;
        this.status = status;

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

    public String getMedia() {
        return media;
    }

    public void setMedia(String media) {
        this.media = media;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Occurrence{" +
                "Id=" + id +
                ", Title='" + title + '\'' +
                ", Description='" + description + '\'' +
                ", Image='" + image + '\'' +
                ", Media='" + media + '\'' +
                ", Date='" + date + '\'' +
                ", Status=" + status +
                '}';
    }
}