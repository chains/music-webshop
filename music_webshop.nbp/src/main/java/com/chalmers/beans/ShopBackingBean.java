/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chalmers.beans;

import com.chalmers.core.CD;
import com.chalmers.ctrl.DBCDControl;
import com.chalmers.ctrl.Database;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Johan Sandström
 */
@ManagedBean
@RequestScoped
public class ShopBackingBean {

    private List<String> genres = new ArrayList<String>();
    private List<CD> products;
    private DBCDControl dbControl;
    //The genre that is selected in the left menu. All is default
    private String selectedGenre;

    /** Creates a new instance of ShopBackingBean */
    public ShopBackingBean() {
        dbControl = (DBCDControl) Database.getCDController();
        products = dbControl.findEntities();
        
        //Add a "genre" for all genres
        genres.add("All Genres");
        //Get the genres from the products.
        for(CD cd : products){
           if(!genres.contains(cd.getGenre())){
               genres.add(cd.getGenre());
           }
            
        }
        
    }

    public List<CD> getProducts() {
//        products = dbControl.findEntities();
        return products;
    }

    public void setProducts(String genre) {
        //TODO: Make it possible to return list with only specific genre.
        List<CD> cds = dbControl.findEntities();
        //Remove CD's with wrong genre
        Iterator<CD> it = cds.iterator();
        if (!genre.equalsIgnoreCase("All Genres")) {
            while (it.hasNext()) {
                CD cd = it.next();
                if (!cd.getGenre().equalsIgnoreCase(genre)) {
                    it.remove();
                }
            }
        }

        products = cds;
    }

    
    public String getSelectedGenre() {
        return selectedGenre;
    }

    public void setSelectedGenre(String selectedGenre) {
        this.selectedGenre = selectedGenre;
        setProducts(selectedGenre);
    }

    public void setSelectedGenre() {
        FacesContext context = FacesContext.getCurrentInstance();
        Map requestMap = context.getExternalContext().getRequestParameterMap();
        String genre = (String) requestMap.get("genre");
        this.selectedGenre = genre;
        setProducts(genre);
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }
    
}
