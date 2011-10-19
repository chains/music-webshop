/*
 * Filters restrics users without the correct permissions to reach certain pages.
 */
package com.chalmers.ctrl;

import com.chalmers.beans.LoginBean;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Johan Sandström
 */
public class PageFilter implements Filter {

    private LoginBean loginBean;

    @Override
    public void init(FilterConfig fc) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest sr, ServletResponse sr1, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) sr;
        HttpServletResponse resp = (HttpServletResponse) sr1;
        HttpSession session = req.getSession(true);
        String pageRequested = req.getRequestURL().toString();

        // Get the bean from the session  
        loginBean = (LoginBean) session.getAttribute("loginBean");
        // if the bean is not in session instantiate a new bean  
        if (loginBean == null) {
            loginBean = new LoginBean();
        }

        if (loginBean.isAdmin() == false && pageRequested.contains("admin.xhtml")) {
            //Can't go to admin page if not logged in as admin.
            resp.sendRedirect("index.xhtml");

        } else if (loginBean.isLoggedIn() == false && pageRequested.contains("confirm.xhtml")) {
            //Can't go to confirm if not logged in.
            resp.sendRedirect("index.xhtml");

        } else {
            //Everything is OK!
            chain.doFilter(sr, sr1);
        }
        session.setAttribute("loginBean", loginBean);
    }

    @Override
    public void destroy() {
    }
}
