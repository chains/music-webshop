/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chalmers.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Johans
 */
@ManagedBean
@RequestScoped
public class RegisterBackingBean {
    
    private String email;
    private String name;
    private String passwd;
    private String street;
    private String city;
    private String country;
    private Boolean isAdmin;

    /** Creates a new instance of RegisterBackingBean */
    public RegisterBackingBean() {
    }
}
