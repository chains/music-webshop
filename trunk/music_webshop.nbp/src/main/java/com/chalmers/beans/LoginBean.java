/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chalmers.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Daniel Nicklasson
 */

@ManagedBean(name = "loginBean")
@SessionScoped

public class LoginBean {

    private String username;
    private String password;
    private boolean loggedIn;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String login() {

        loggedIn = false;

        if (username != null && username.equals("admin") && password != null && password.equals("12345")) {
            loggedIn = true;
            return "goToAdminPage";
        } else {
            loggedIn = false;
            return "loginFailed";
        }
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }
    
    public String checkLogin(){
        if(loggedIn){
            
//            jQuery('#loginLink').fadeOut();  
            return "Logged in as Admin";
        }
        else{
            // Return nullstring, admin not logged in
            return "";
        }
    }
    
    
}
