/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chalmers.beans;

import com.chalmers.core.ShopUser;
import com.chalmers.ctrl.DBShopUserControl;
import com.chalmers.ctrl.Database;
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

    public void addShopUser() {
        DBShopUserControl shopUserControl = (DBShopUserControl) Database.getShopUserController();
        ShopUser user = new ShopUser(new Long(0), registerBackingBean.getEmail(), 
                registerBackingBean.getName(), registerBackingBean.getPasswd(), 
                registerBackingBean.getStreet(), registerBackingBean.getCity(), 
                registerBackingBean.getCountry(), false);
        shopUserControl.create(user);
    }

    public void setRegisterBackingBean(RegisterBackingBean registerBackingBean) {
        this.registerBackingBean = registerBackingBean;
    }
}
