package com.fenqing168.school.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class WebPathListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        String baseUrl = sce.getServletContext().getInitParameter("baseUrl");
        sce.getServletContext().setAttribute("baseUrl", baseUrl);
    }
}
