package com.example.sweenu.sw_info.model;

public class Film {
    String title;
    int episodeID;
    String director;
    String producer;
    String date;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getEpisodeID() {
        return episodeID;
    }

    public void setEpisodeID(int episodeID) {
        this.episodeID = episodeID;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Film(String title, int episodeID, String director, String producer, String date) {

        this.title = title;
        this.episodeID = episodeID;
        this.director = director;
        this.producer = producer;
        this.date = date;
    }
}