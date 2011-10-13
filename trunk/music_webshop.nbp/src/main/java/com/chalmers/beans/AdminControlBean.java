/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chalmers.beans;

import com.chalmers.core.CD;
import com.chalmers.ctrl.DBCDControl;
import com.chalmers.ctrl.Database;
import javax.faces.bean.ManagedProperty;

/**
 *
 * @author Johan Sandström
 */
public class AdminControlBean {
    
    @ManagedProperty(value = "#{addProductBackingBean}")
    private AdminBackingBean adminBackingbean;

    /** Creates a new instance of AdminControlBean */
    public AdminControlBean() {
    }
    
    public void addCD(){
        DBCDControl cdControl = (DBCDControl)Database.getCDController();
        cdControl.create(new CD(new Long(0), adminBackingbean.getName(), 
                adminBackingbean.getPrice(), adminBackingbean.getGenre(), 
                adminBackingbean.getDescription(), adminBackingbean.getNoInStock(), 
                adminBackingbean.getPlaytime(), adminBackingbean.getArtist()));
        
    }
    
    public AdminBackingBean getAdminBackingbean() {
        return adminBackingbean;
    }

    public void setAdmingBackingbean(AdminBackingBean backingbean) {
        this.adminBackingbean = backingbean;
    }
}
