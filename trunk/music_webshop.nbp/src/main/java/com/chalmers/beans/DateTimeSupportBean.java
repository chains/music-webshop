/*
 * Returns current date in format yyyy/MM/dd HH:mm:ss
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
 * @author Daniel Nicklasson
 */
@ManagedBean
@SessionScoped
public class DateTimeSupportBean implements Serializable {

    public DateTimeSupportBean() {
    }

    public String getCurrentDateTimeSupportBean() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date d = new Date();
        return dateFormat.format(d);
    }
}
