/*
 * Sends register request to Databasehandler, in this case DBShopUserControl.
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
 * @author Johan Sandström
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
        ShopUser user = new ShopUser(Long.valueOf(0), registerBackingBean.getEmail(), 
                registerBackingBean.getName(), registerBackingBean.getPasswd(), 
                registerBackingBean.getStreet(), registerBackingBean.getCity(), 
                registerBackingBean.getCountry(), false);
        shopUserControl.create(user);
    }

    public void setRegisterBackingBean(RegisterBackingBean registerBackingBean) {
        this.registerBackingBean = registerBackingBean;
    }
}
