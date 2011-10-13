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
public class ViewCartControllerBean {
   
    @ManagedProperty(value = "#{shoppingCartModelBean}")
    private ShoppingCartModelBean cart;
    
    /** Creates a new instance of ViewCartControllerBean */
    public ViewCartControllerBean() {
    }

    public ShoppingCartModelBean getCart() {
        return cart;
    }

    public void setCart(ShoppingCartModelBean bean) {
        this.cart = bean;
    }
    
    public void removeProduct(CD cd){
        cart.removeProduct(cd);
    }
    public void removeOneProduct(CD cd){
        cart.removeOneProduct(cd);
    }
    
}
