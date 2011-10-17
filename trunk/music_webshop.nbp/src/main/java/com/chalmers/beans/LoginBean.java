/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chalmers.beans;

import com.chalmers.core.ShopUser;
import com.chalmers.ctrl.DBShopUserControl;
import com.chalmers.ctrl.Database;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Daniel Nicklasson
 */
@ManagedBean
@SessionScoped
public class LoginBean {

    private ShopUser user;
    private String username;
    private String password;
    private boolean loggedIn;
    private boolean isAdmin;
    private List<ShopUser> users;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public ShopUser getUser() {
        return user;
    }

    public void setUser(ShopUser user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String login() {

        DBShopUserControl shopUserControl = (DBShopUserControl) Database.getShopUserController();

        users = shopUserControl.findEntities();
        for (ShopUser shopUser : users) {
            if (username != null && username.equals(shopUser.getEmail()) && password != null && password.equals(shopUser.getPasswd())) {
                loggedIn = true;
                user = shopUser;
                if(shopUser.getIsAdmin())
                    isAdmin = true;
                    return "";
            }
        }
        user = null;
        loggedIn = false;
        isAdmin = false;
        return "loginFailed";
//        loggedIn = false;
//        
//        if (username != null && username.equals("admin") && password != null && password.equals("12345")) {
//            loggedIn = true;
//            return "goToAdminPage";
//        } else {
//            loggedIn = false;
//            return "loginFailed";
//        }
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    public String checkLogin() {
        if (loggedIn) {

//            jQuery('#loginLink').fadeOut();  
            return "Logged in as Admin";
        } else {
            // Return nullstring, admin not logged in
            return "";
        }
    }

        public String loginDivVisibility() {
        if (loggedIn) {
            return "none";
        } else {
            return "block";
        }
    }
        
                public String loggedinDivVisibility() {
        if (!loggedIn) {
            return "none";
        } else {
            return "block";
        }
    }
    
    public String buttonVisibility() {
        if (loggedIn) {
            return "hidden";
        } else {
            return "visible";
        }
    }
}
