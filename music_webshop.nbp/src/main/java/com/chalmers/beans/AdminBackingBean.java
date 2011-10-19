package com.chalmers.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Johan Sandström
 */
@ManagedBean
@SessionScoped
public class AdminBackingBean {

    private String name;
    private double price;
    private String genre;
    private String description;
    private int noInStock;
    private double playtime;
    private String artist;

    /** Creates a new instance of AdminBackingBean */
    public AdminBackingBean() {
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNoInStock() {
        return noInStock;
    }

    public void setNoInStock(int noInStock) {
        this.noInStock = noInStock;
    }

    public double getPlaytime() {
        return playtime;
    }

    public void setPlaytime(double playtime) {
        this.playtime = playtime;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
