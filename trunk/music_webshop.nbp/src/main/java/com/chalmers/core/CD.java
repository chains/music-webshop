/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chalmers.core;

/**
 *
 * @author Johan
 */
public class CD extends Product {
    
    private String genre;
    private double playtime;

    public CD(String genre, double playtime, String name, double price, String category, String description, int noInStock) {
        super(name, price, category, description, noInStock);
        this.genre = genre;
        this.playtime = playtime;
    }
    
    
    
}
