/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chalmers.ctrl;

import com.chalmers.core.Customer;
import java.util.List;
import java.util.NoSuchElementException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author Johan Sandström
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
        em = null;

        em = getEntityManager();
        em.getTransaction().begin();
        em.persist(t);
        em.getTransaction().commit();
    }

    @Override
    public void destroy(Long id) {
        

        em = null;

        em = getEntityManager();
        em.getTransaction().begin();
        Customer customer;
       
        try {
            customer = em.getReference(Customer.class, id);
            customer.getId();
        } catch (EntityNotFoundException enfe) {
            throw new NoSuchElementException();
        }
        em.remove(customer);
        em.getTransaction().commit();
    }

    @Override
    public void edit(Customer t) {
                em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            t = em.merge(t);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {

                Long id = new Long((long) t.getId());

                if (findEntity(id) == null) {
                    throw new NoSuchElementException();
                }
            }
        }
    }

    @Override
    public Customer findEntity(Long id) {
        em = getEntityManager();

        return em.find(Customer.class, id);
    }

    @Override
    public List<Customer> findEntities() {
        em = getEntityManager();

        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(Customer.class));
        Query q = em.createQuery(cq);
 
        return (List<Customer>) q.getResultList();
    }

    @Override
    public List<Customer> findEntities(int maxResults, int firstResult) {
        em = getEntityManager();

        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(Customer.class));
        Query q = em.createQuery(cq);

        q.setMaxResults(maxResults);
        q.setFirstResult(firstResult);

        return (List<Customer>) q.getResultList();
    }

    @Override
    public int getEntityCount() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

 
    
}
