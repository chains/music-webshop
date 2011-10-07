/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chalmers.ctrl;

import com.chalmers.core.CD;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Johan
 */
public class DBCDControl implements DBCtrl<CD> {

    private EntityManager em;
    private final EntityManagerFactory emf;

    public DBCDControl(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    @Override
    public void create(CD t) {

        em = null;

        em = getEntityManager();
        em.getTransaction().begin();
        em.persist(t);
        em.getTransaction().commit();
    }

    @Override
    public void destroy(Long id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void edit(CD t) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public CD findEntity(Long id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<CD> findEntities() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<CD> findEntities(int maxResults, int firstResult) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int getEntityCount() {
        throw new UnsupportedOperationException("Not supported yet.");
    }


    
}
