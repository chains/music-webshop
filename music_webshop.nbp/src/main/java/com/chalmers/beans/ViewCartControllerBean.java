/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chalmers.beans;

import com.chalmers.core.CD;
import com.chalmers.core.ShopUser;
import com.chalmers.ctrl.Mail;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Johan Sandström, Daniel Nicklasson
 */
@ManagedBean
@RequestScoped
public class ViewCartControllerBean {

    @ManagedProperty(value = "#{shoppingCartModelBean}")
    private ShoppingCartModelBean cart;
    
    @ManagedProperty(value = "#{loginBean}")
    private LoginBean loginbean;

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

    public void emptyCart() {
        cart.emptyCart();
    }

    public LoginBean getLoginbean() {
        return loginbean;
    }

    public void setLoginbean(LoginBean loginbean) {
        this.loginbean = loginbean;
    }

    public String confirmOrder() throws Exception {
        
        // Get all needed text to send mail
        String message = cart.toString();
        ShopUser user = loginbean.getUser();
        String receiver = user.getEmail();
        String name = user.getName();

        //Call mailer
        Mail mailer = new Mail(message, receiver, name);

        mailer.sendMail();

        // Invalidate session, user has ordered the items in the shoppingcart
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        session.invalidate();

        return "goToConfirm";
    }
}
