/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chalmers.beans;

import com.chalmers.core.CD;
import com.chalmers.core.OrderItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Johan Sandström
 */
@ManagedBean
@SessionScoped
public class ShoppingCartModelBean {

    private List<OrderItem> cart = new ArrayList<OrderItem>();
    @ManagedProperty(value = "#{loginBean}")
    private LoginBean loginbean;

    /** Creates a new instance of ShoppingCartModelBean */
    public ShoppingCartModelBean() {
    }

    public void addProduct(CD c) {
        // Create new OrderItem with quantity 1, if the item already exists
        // then add 1 to the integer the

        OrderItem item = new OrderItem(1, c);

        // Check if the name matches a entry in the OrderItem list
        Boolean match = false;

        for (OrderItem dummy : cart) {

            Long tmp = dummy.getProduct().getId();
            if (tmp.equals(c.getId() )) {
                int i = dummy.getQty();
                i++;
                dummy.setQty(i);

                // We got a match!
                match = true;
                break;
            }
        }
        if (!match) {
            cart.add(item);
        }
    }
    
    public void emptyCart(){
        cart = new ArrayList<OrderItem>();
    }

    public void removeProduct(CD cd) {

        Iterator<OrderItem> it = cart.iterator();
        while(it.hasNext()){
            OrderItem dummy = it.next();
            Long id = dummy.getProduct().getId();
            if (id.equals( cd.getId())) {
                cart.remove(dummy);
            }
        }
    }

    public void removeOneProduct(CD cd) {
        Iterator<OrderItem> it = cart.iterator();
//        for (OrderItem dummy : cart) {
        while(it.hasNext()){ 
            OrderItem dummy = it.next();
            Long id = dummy.getProduct().getId();
            if (id.equals(cd.getId() )) {
                if ((dummy.getQty() - 1) == 0) {
                    it.remove();
                }
                dummy.setQty(dummy.getQty() - 1);
            }
        }
    }
    
    public int getCartCount(){
        
        int count = 0;
        for (OrderItem dummy : cart) {
            count += dummy.getQty();
        }
        return count;
    }
    
    /*
     * Gets the total price of all the items in the shoppingcart.
     */
    public double getTotal(){
        
        double price = 0;
        for(OrderItem order : cart){
            price += order.getQty()*order.getProduct().getPrice();
        }
        return price;
    }

    public List<OrderItem> getCart() {
        return cart;
    }

    public void setCart(List<OrderItem> cart) {
        this.cart = cart;
    }
    
        @Override
    public String toString() {
        
        // Help method for Mailer class
        StringBuilder b = new StringBuilder();
        
        b.append(System.getProperty("line.separator"));
        for(OrderItem item : cart){
            
            CD tempcd = item.getProduct();
            b.append("Quantity: " + item.getQty() +" ");
            b.append(tempcd.toString() );
            b.append(System.getProperty("line.separator"));
        }
        b.append("--------------------------------");
        b.append(System.getProperty("line.separator"));
        b.append("Total cost:"+ this.getTotal() );
        return b.toString();
    }

    public LoginBean getLoginbean() {
        return loginbean;
    }

    public void setLoginbean(LoginBean loginbean) {
        this.loginbean = loginbean;
    }
    
}
