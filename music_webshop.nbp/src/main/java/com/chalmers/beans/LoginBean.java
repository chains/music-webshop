/*
 * Handles all login/logout functions.
 * Can also be used to validate if a user is still logged in.
 */
package com.chalmers.beans;

import com.chalmers.core.ShopUser;
import com.chalmers.ctrl.DBShopUserControl;
import com.chalmers.ctrl.Database;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Daniel Nicklasson, Johan Sandström, Mikael Andersson Ynghammar
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
                if (shopUser.getIsAdmin()) {
                    isAdmin = true;
                }
                return "refreshpage";
            }
        }

        user = null;
        loggedIn = false;
        isAdmin = false;
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Login failure", "Your email or password is incorrect!"));
        return "";
    }

    public String logout() {
        user = null;
        loggedIn = false;
        isAdmin = false;


        return "refreshpage";
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    public String checkLogin() {
        if (isAdmin) {
            return "Logged in as Admin";
        } else {
            // Return nullstring, admin not logged in
            return "";
        }
    }
    //Div with buttons to login and register only visible when not logged in.

    public String loginDivVisibility() {
        if (loggedIn) {
            return "none";
        } else {
            return "block";
        }
    }
    //Div with information about who is logged in is only visible when logged in

    public String loggedinDivVisibility() {
        if (!loggedIn) {
            return "none";
        } else {
            return "block";
        }
    }
    //Button with link to adminpage is only visible when admin logged in.

    public String adminButtonVisibility() {
        if (isAdmin) {
            return "visible";
        } else {
            return "hidden";
        }
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }
}
