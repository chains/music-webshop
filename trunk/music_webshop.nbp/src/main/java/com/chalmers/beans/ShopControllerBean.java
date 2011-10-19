/*
 *   Sending request to cart to add product.
 */
package com.chalmers.beans;

import com.chalmers.core.CD;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Johan Sandström, Jonas Ekström, Mikael Andersson Ynghammar
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
