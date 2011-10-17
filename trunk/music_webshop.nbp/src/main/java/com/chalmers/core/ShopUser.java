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
public class ShopUser implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "user_mail", nullable = false)
    private String email;
    @Column(name = "user_name", nullable = false)
    private String name;
    @Column(name = "user_passwd", nullable = false)
    private String passwd;
    @Column(name = "user_street", nullable = false)
    private String street;
    @Column(name = "user_city", nullable = false)
    private String city;
    @Column(name = "user_country", nullable = false)
    private String country;
    @Column(name = "user_admin", nullable = false)
    private Boolean isAdmin;
    //Does not need shoppingcart in database. Only in session.
    //private ShoppingCart cart;

    public ShopUser() {
    }
    

    public ShopUser(Long id, String email, String name, String passwd, String street, String city, String country, Boolean isAdmin) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.passwd = passwd;
        this.street = street;
        this.city = city;
        this.country = country;
        this.isAdmin = isAdmin;
    }

    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(Boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
    
    
    
}
