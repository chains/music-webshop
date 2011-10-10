/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chalmers.core;

/**
 *
 * @author Daniel, Mikael
 */
public class OrderItem {

    private int qty;
    private CD product;

    OrderItem(int i, CD prod) {
        this.qty = i;
        this.product = prod;
    }

    public CD getProduct() {
        return product;
    }

    public void setProduct(CD product) {
        this.product = product;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
}
