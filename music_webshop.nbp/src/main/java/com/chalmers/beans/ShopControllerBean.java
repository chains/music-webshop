/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chalmers.beans;

import com.chalmers.core.CD;
import javax.faces.bean.ManagedProperty;

/**
 *
 * @author Johan Sandström
 */
public class ShopControllerBean {

    @ManagedProperty(value = "#{cartBean}")
    private ShoppingCartModelBean cart;

    /** Creates a new instance of ShopControllerBean */
    public ShopControllerBean() {
    }
    /*
     * Adds CD to shopping cart
     */

    public void buyProduct(CD cd) {
        cart.addProduct(cd);
    }

    public ShoppingCartModelBean getCart() {
        return cart;
    }

    public void setCart(ShoppingCartModelBean bean) {
        this.cart = bean;
    }
}
