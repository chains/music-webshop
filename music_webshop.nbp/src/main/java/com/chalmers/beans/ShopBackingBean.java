/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chalmers.beans;

import com.chalmers.core.CD;
import com.chalmers.ctrl.DBCDControl;
import com.chalmers.ctrl.Database;
import java.util.List;

/**
 *
 * @author Johan Sandström
 */
public class ShopBackingBean {

    private List<CD> products;
    private DBCDControl dbControl;
    //The genre that is selected in the left menu. All is default
    private String selectedGenre = "all";

    /** Creates a new instance of ShopBackingBean */
    public ShopBackingBean() {
        
       
        dbControl = (DBCDControl) Database.getCDController();
        products = dbControl.findEntities();
    }

    public List<CD> getProducts() {
        //TODO: Make it possible to return list with only specific genre.
        products = dbControl.findEntities();
        return products;
    }

    public String getSelectedGenre() {
        return selectedGenre;
    }

    public void setSelectedGenre(String selectedGenre) {
        this.selectedGenre = selectedGenre;
    }
}
