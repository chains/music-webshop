/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chalmers.beans;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author dannic
 */



@ManagedBean
@SessionScoped
public class DateTimeSupportBean implements Serializable{
    
//    @ManagedProperty
//    private String

    /** Creates a new instance of DateTimeSupportBean */
    public DateTimeSupportBean() {
    }
    
    public String getCurrentDateTimeSupportBean(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date d = new Date();
        return dateFormat.format(d);
    }
}
