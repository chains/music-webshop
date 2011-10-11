/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chalmers.ctrl;

import com.chalmers.core.CD;
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
//        return new ProductJpaController(emf);
    }
}
