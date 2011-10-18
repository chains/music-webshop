/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chalmers.ctrl;

import com.chalmers.core.ShopUser;
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
public class DBShopUserControl implements DBCtrl<ShopUser> {

    private EntityManager em;
    private final EntityManagerFactory emf;

    public DBShopUserControl(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    @Override
    public void create(ShopUser t) {
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
        ShopUser customer;

        try {
            customer = em.getReference(ShopUser.class, id);
            customer.getId();
        } catch (EntityNotFoundException enfe) {
            throw new NoSuchElementException();
        }
        em.remove(customer);
        em.getTransaction().commit();
    }

    @Override
    public void edit(ShopUser t) {
        em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            t = em.merge(t);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {

//                Long id = new Long((long) t.getId());
                Long id = Long.valueOf(t.getId());

                if (findEntity(id) == null) {
                    throw new NoSuchElementException();
                }
            }
        }
    }

    @Override
    public ShopUser findEntity(Long id) {
        em = getEntityManager();

        return em.find(ShopUser.class, id);
    }

    @Override
    public List<ShopUser> findEntities() {
        em = getEntityManager();

        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(ShopUser.class));
        Query q = em.createQuery(cq);

        return (List<ShopUser>) q.getResultList();
    }

    @Override
    public List<ShopUser> findEntities(int maxResults, int firstResult) {
        em = getEntityManager();

        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(ShopUser.class));
        Query q = em.createQuery(cq);

        q.setMaxResults(maxResults);
        q.setFirstResult(firstResult);

        return (List<ShopUser>) q.getResultList();
    }

    @Override
    public int getEntityCount() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
