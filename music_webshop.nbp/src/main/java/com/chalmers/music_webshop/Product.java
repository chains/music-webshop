/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chalmers.music_webshop;

/**
 *
 * @author Johans
 */

public class Product {
    
    
    private String name;
    private double price;
    private String category;
    private String description;
    private int noInStock;

    public Product(String name, double price, String category, String description, int noInStock) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.description = description;
        this.noInStock = noInStock;
    }
    
    
    
    
    
}
