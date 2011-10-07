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
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "user_name", nullable = false)
    private String email;
    @Column(name = "user_passwd", nullable = false)
    private String passwd;
    @Column(name = "user_street", nullable = false)
    private String street;
    @Column(name = "user_city", nullable = false)
    private String city;
    @Column(name = "user_country", nullable = false)
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
