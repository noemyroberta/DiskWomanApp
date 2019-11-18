package br.ifal.app.womancomplaintpolice.beans;

import java.io.Serializable;

public class Occurrences implements Serializable {

    private int id;
    private String Title;
    private String Description;
    private String Image;
    private String Media;
    private String Date;
    private boolean Status;

    public Occurrences(int id, String title, String description, String image, String media, String date, boolean status) {
        id = id;
        title = title;
        description = description;
        image = image;
        media = media;
        date = date;
        status = status;
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
        title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        image = image;
    }

    public String getMedia() {
        return media;
    }

    public void setMedia(String media) {
        media = media;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        date = date;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        status = status;
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