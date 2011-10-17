/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chalmers.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Johans
 */
@ManagedBean
@RequestScoped
public class RegisterBackingBean {
    
    @NotNull @Size(min=1, max=50, message="Must use 1-50 chars")
    private String email;
    @NotNull @Size(min=1, max=30, message="Must use 1-30 chars")
    private String name;
    @NotNull @Size(min=1, max=15, message="Must use 1-15 chars")
    private String passwd;
    @NotNull @Size(min=1, max=30, message="Must use 1-30 chars")
    private String street;
    @NotNull @Size(min=1, max=15, message="Must use 1-15 chars")
    private String city;
    @NotNull @Size(min=1, max=15, message="Must use 1-15 chars")
    private String country;
    private Boolean isAdmin;

    /** Creates a new instance of RegisterBackingBean */
    public RegisterBackingBean() {
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
