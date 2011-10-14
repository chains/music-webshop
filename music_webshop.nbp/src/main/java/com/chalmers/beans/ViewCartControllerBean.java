/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chalmers.beans;

import com.chalmers.core.CD;
import com.chalmers.ctrl.Mail;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Johan Sandström
 */
@ManagedBean
@RequestScoped
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

    public void removeProduct(CD cd) {
        cart.removeProduct(cd);
    }

    public void removeOneProduct(CD cd) {
        cart.removeOneProduct(cd);
    }

    public String confirmOrder() throws Exception {
        String message = cart.toString();

        //Call mailer
        Mail mailtest = new Mail(message);

        mailtest.sendMail();

        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        session.invalidate();

        return "goToConfirm";
    }
}
