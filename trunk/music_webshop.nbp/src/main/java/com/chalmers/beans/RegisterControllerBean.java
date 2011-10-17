/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chalmers.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Johans
 */
@ManagedBean
@RequestScoped
public class RegisterControllerBean {
    
    
    @ManagedProperty(value = "#{registerBackingBean}")
    private RegisterBackingBean registerBackingBean;

    /** Creates a new instance of RegisterControllerBean */
    public RegisterControllerBean() {
    }

    public RegisterBackingBean getRegisterBackingBean() {
        return registerBackingBean;
    }

    public void addShopUser(){
        //TODO implement method
    }
    
    public void setRegisterBackingBean(RegisterBackingBean registerBackingBean) {
        this.registerBackingBean = registerBackingBean;
    }
    
    
    
}
