/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chalmers.ctrl;

import java.util.List;

/**
 *
 * @author Johan
 */
public interface DBCtrl <T> {
      
    public void create(T t);
    public void destroy(Long id);
    public void edit(T t);
    public T findEntity(Long id);
    public List<T> findEntities();
    public List<T> findEntities(int maxResults, int firstResult);
    public int getEntityCount();

    
}
