/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chalmers.beans;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Daniel Nicklasson
 */
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