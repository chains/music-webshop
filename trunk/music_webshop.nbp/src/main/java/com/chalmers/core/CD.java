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

/**
 * CD product
 * @author Johan
 */

@Entity
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

    public CD() {
    }

    public CD(Long id, String name, double price, String genre, String description, int noInStock, double playtime) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.genre = genre;
        this.description = description;
        this.noInStock = noInStock;
        this.playtime = playtime;
    }



    public Long getId() {
        return id;
    }


    
}
