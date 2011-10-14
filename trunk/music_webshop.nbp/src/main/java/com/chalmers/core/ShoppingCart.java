/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chalmers.core;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Daniel, Mikael
 */
public class ShoppingCart {

    private List<OrderItem> products;

    public ShoppingCart() {
        products = new ArrayList<OrderItem>();
    }

    public void addProduct(CD prod) {

        // Create new OrderItem with quantity 1, if the item already exists
        // then add 1 to the integer the

        OrderItem item = new OrderItem(1, prod);

        // Check if the name matches a entry in the OrderItem list
        Boolean match = false;

        for (OrderItem dummy : products) {

            String tmp = dummy.getProduct().getName();
            if (tmp.equals(prod.getName())) {
                int i = item.getQty();
                i++;
                item.setQty(i);

                // We got a match!
                match = true;
            }
        }
        if (!match) {
            products.add(item);
        }
    }

    public void removeProduct(String name) {

        for (OrderItem dummy : products) {

            String tmp = dummy.getProduct().getName();
            if (tmp.equals(name)) {
                products.remove(dummy);
            }
        }

    }

    public double getTotalCost() {

        int total = 0;

        for (OrderItem dummy : products) {
            total += dummy.getProduct().getPrice();
        }
        return total;
    }

    public List<OrderItem> getOrderItems() {

        return products;
    }

    @Override
    public String toString() {
        
        // Help method for Mailer class
        StringBuilder b = new StringBuilder();
        
        
        for(OrderItem item : products){
            CD tempcd = item.getProduct();
            b.append("Quantity: " + item.getQty() +" ");
            b.append(tempcd.toString() );
            
            b.append(System.getProperty("line.separator"));
        }
        b.append("--------------------------------");
        b.append(System.getProperty("line.separator"));
        b.append("Total cost:"+this.getTotalCost() );
        return b.toString();
    }
}