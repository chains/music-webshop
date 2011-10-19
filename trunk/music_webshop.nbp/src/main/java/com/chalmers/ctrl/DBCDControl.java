/*
 * Interacts with database to create/change/delete/find users
 */
package com.chalmers.ctrl;

import com.chalmers.core.CD;
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

        em = null;

        em = getEntityManager();
        em.getTransaction().begin();
        CD cd;

        try {
            cd = em.getReference(CD.class, id);
            cd.getId();
        } catch (EntityNotFoundException enfe) {
            throw new NoSuchElementException();
        }
        em.remove(cd);
        em.getTransaction().commit();
    }

    @Override
    public void edit(CD t) {
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
    public CD findEntity(Long id) {
        em = getEntityManager();

        return em.find(CD.class, id);
    }

    @Override
    public List<CD> findEntities() {
        em = getEntityManager();

        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(CD.class));
        Query q = em.createQuery(cq);

        return (List<CD>) q.getResultList();
    }

    @Override
    public List<CD> findEntities(int maxResults, int firstResult) {
        em = getEntityManager();

        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(CD.class));
        Query q = em.createQuery(cq);

        q.setMaxResults(maxResults);
        q.setFirstResult(firstResult);

        return (List<CD>) q.getResultList();
    }

    @Override
    public int getEntityCount() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<CD> findByGenre(String genre) {
        em = getEntityManager();
        
        String request = "select c from CD c where c.genre='"+ genre +"' ";
        Query q = em.createQuery(request);
        List<CD> cds = q.getResultList();
        return cds;

    }
}
