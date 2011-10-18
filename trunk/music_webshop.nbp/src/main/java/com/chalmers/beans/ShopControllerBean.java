/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chalmers.beans;

import com.chalmers.core.CD;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Johan Sandström
 */
@ManagedBean
@RequestScoped
public class ShopControllerBean {

    @ManagedProperty(value = "#{shoppingCartModelBean}")
    private ShoppingCartModelBean cart;

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
