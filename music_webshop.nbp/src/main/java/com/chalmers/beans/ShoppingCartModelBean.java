/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chalmers.beans;

import com.chalmers.core.CD;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Johan Sandström
 */
public class ShoppingCartModelBean {

    private List<CD> cart = new ArrayList<CD>();

    /** Creates a new instance of ShoppingCartModelBean */
    public ShoppingCartModelBean() {
    }

    public void addProduct(CD c) {
        cart.add(c);
    }

    public List<CD> getCart() {
        return cart;
    }

    public void setCart(List<CD> cart) {
        this.cart = cart;
    }
}
