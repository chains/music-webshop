/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chalmers.core;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 * CD product
 * @author Johan
 */
@Entity
@NamedQueries({
@NamedQuery(name = "CD.findAll", query = "SELECT c FROM CD c")})
public class CD implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "cd_title", nullable = false, updatable = false)
    private String name;
    @Column(name = "cd_price", nullable = false)
    private double price;
    @Column(name = "cd_genre", nullable = false)
    private String genre;
    @Column(name = "cd_desc", nullable = false)
    private String description;
    @Column(name = "cd_stock", nullable = false)
    private int noInStock;
    @Column(name = "cd_playtime", nullable = false)
    private double playtime;
    @Column(name = "cd_artist", nullable = false)
    private String artist;

    public CD() {
    }

    public CD(Long id, String name, double price, String genre, String description, int noInStock, double playtime, String artist) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.genre = genre;
        this.description = description;
        this.noInStock = noInStock;
        this.playtime = playtime;
        this.artist = artist;
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

    public Long getId() {
        return id;
    }
    
    @Override
    public String toString(){
        return "Artist" +artist + " - " + "Album" + name + " Genre: " + genre + " price: " + price;
    }
}
