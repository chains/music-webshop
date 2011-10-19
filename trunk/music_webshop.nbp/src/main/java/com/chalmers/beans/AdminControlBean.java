/*
 * Gives admins the functionality to add new CDs to the database.
 */
package com.chalmers.beans;

import com.chalmers.core.CD;
import com.chalmers.ctrl.DBCDControl;
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
public class AdminControlBean {
    
    @ManagedProperty(value = "#{adminBackingBean}")
    private AdminBackingBean adminBackingbean;

    /** Creates a new instance of AdminControlBean */
    public AdminControlBean() {
    }
    
    public void addCD(){
        DBCDControl cdControl = (DBCDControl)Database.getCDController();
        CD cd = new CD(Long.valueOf(0), adminBackingbean.getName(), 
                adminBackingbean.getPrice(), adminBackingbean.getGenre(), 
                adminBackingbean.getDescription(), adminBackingbean.getNoInStock(), 
                adminBackingbean.getPlaytime(), adminBackingbean.getArtist());
        cdControl.create(cd);
        
    }
    
    public AdminBackingBean getAdminBackingbean() {
        return adminBackingbean;
    }

    public void setAdminBackingbean(AdminBackingBean backingbean) {
        this.adminBackingbean = backingbean;
    }
}
