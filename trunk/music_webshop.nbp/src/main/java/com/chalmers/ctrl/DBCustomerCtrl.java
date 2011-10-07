/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chalmers.ctrl;

import com.chalmers.core.Customer;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author 
 */
public class DBCustomerCtrl implements DBCtrl<Customer>{

    private EntityManager em;
    private final EntityManagerFactory emf;

    public DBCustomerCtrl(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    @Override
    public void create(Customer t) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void destroy(Long id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void edit(Customer t) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Customer findEntity(Long id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Customer> findEntities() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Customer> findEntities(int maxResults, int firstResult) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int getEntityCount() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

 
    
}
