/*
 * Returns a new controlobject to either the User or CD database.
 */
package com.chalmers.ctrl;

import com.chalmers.core.CD;
import com.chalmers.core.ShopUser;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Daniel Nicklasson (dixtre@gmail.com)
 */
public class Database {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("webshop_pu");

    public Database() {
    }

    public static DBCtrl<CD> getCDController() {
        return new DBCDControl(emf);
    }
    public static DBCtrl<ShopUser> getShopUserController(){
        return new DBShopUserControl(emf);
    }
}
