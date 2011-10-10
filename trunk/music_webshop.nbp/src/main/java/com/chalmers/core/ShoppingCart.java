/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chalmers.core;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Johan
 */
public class ShoppingCart {
    
    private List<OrderItem> products;
    
    public ShoppingCart(){
        products = new ArrayList<OrderItem>();
    }
    
    public void addProduct(CD prod){
        
        OrderItem item = new OrderItem(1, prod);
        
        if(products.contains(item)){
            
        }
            
            
        
        products.add(item);
        
        
    }

    public void removeProduct(String name){
    // TODO: Implement method    
    }
    
    public double getTotalCost(){
    // TODO: Implement method  
        return 0;
    }
    public List<OrderItem> getOrderItems(){
    // TODO: Implement method 
        return null;
    }
}