/*
 * Handles cart interaction from view cart to update the cart model.
 * Can remove and add items from cart. 
 * Also able to confirm order and sending mail to the shopper.
 */
package com.chalmers.beans;

import com.chalmers.core.CD;
import com.chalmers.core.ShopUser;
import com.chalmers.ctrl.Mail;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

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
        //Can not buy if not logged in or cart empty
        if(cart.getCart().isEmpty()){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Pay failure", "You don't have any items in your cart! "));
            return "";
        }
        else if(!loginbean.isLoggedIn()){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Pay failure", "You are not logged in. Log in before you press pay. "));
            return "";
        }
        // Get all needed text to send mail
        String message = cart.toString();
        ShopUser user = loginbean.getUser();
        String receiver = user.getEmail();
        String name = user.getName();

        //Call mailer
        Mail mailer = new Mail(message, receiver, name);

        mailer.sendMail();
        cart.emptyCart();

        return "goToConfirm";
    }
}
