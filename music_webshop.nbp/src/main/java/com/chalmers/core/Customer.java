/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chalmers.core;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Johan
 */
@Entity
public class Customer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "customer_name", nullable = false)
    private String email;
    @Column(name = "customer_passwd", nullable = false)
    private String passwd;
    @Column(name = "customer_street", nullable = false)
    private String street;
    @Column(name = "customer_city", nullable = false)
    private String city;
    @Column(name = "customer_country", nullable = false)
    private String country;
    //Does not need shoppingcart in database. Only in session.
    //private ShoppingCart cart;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
}
