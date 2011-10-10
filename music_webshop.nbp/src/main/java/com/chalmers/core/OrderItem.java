/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chalmers.core;

/**
 *
 * @author Johan
 */
public class OrderItem {
    
    private int qty;
    private CD product;

    OrderItem(int i, CD prod) {
        this.qty = i;
        this.product = prod;
    }
    
}
