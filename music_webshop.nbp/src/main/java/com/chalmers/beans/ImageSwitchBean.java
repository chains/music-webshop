/*
 * Gives imageswitchers on xhtml pages images to switch between.
 */
package com.chalmers.beans;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Daniel Nicklasson, Jonas Ekström, Mikael Andersson Ynghammar
 */
@ManagedBean
@RequestScoped
public class ImageSwitchBean {

    private List<String> images;

    public ImageSwitchBean() {
        images = new ArrayList<String>();
        images.add("metallica_load.jpg");
        images.add("offspring_americana.jpg");
        images.add("st_anger.png");
        images.add("offspring_smash.jpg");
    }

    public List<String> getImages() {
        return images;
    }
}