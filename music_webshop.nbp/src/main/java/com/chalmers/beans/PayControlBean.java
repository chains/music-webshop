/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chalmers.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Johan Sandström
 */
@ManagedBean
@RequestScoped
public class PayControlBean {

    @ManagedProperty(value = "#{shoppingCartModelBean}")
    private ShoppingCartModelBean cart;

    /** Creates a new instance of PayControlBean */
    public PayControlBean() {
    }

    public ShoppingCartModelBean getCart() {
        return cart;
    }

    public void setCart(ShoppingCartModelBean bean) {
        this.cart = bean;
    }
}
