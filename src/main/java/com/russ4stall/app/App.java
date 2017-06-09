package com.russ4stall.app;

import java.io.File;

import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.webresources.*;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;
import java.util.concurrent.CopyOnWriteArrayList;

import com.russ4stall.app.services.UserService;
import com.russ4stall.app.servlets.*;
public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello muddah...");

        String contextPath = "/";
        String webappDirLocation = "src/main/webapp/";
        String baseDirectory = new File(webappDirLocation).getAbsolutePath();

        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);
        StandardContext context = (StandardContext) tomcat.addWebapp(contextPath, baseDirectory);

        UserService userService = new UserService();
        userService.populateUsers();
        
        Tomcat.addServlet(context, "UsersServlet", new UsersServlet(userService));
        context.addServletMappingDecoded("/users", "UsersServlet");

        // Additions to make @WebServlet work
        /*String buildPath = "target/classes";
        String webAppMount = "/WEB-INF/classes";

        File additionalWebInfClasses = new File(buildPath);
        WebResourceRoot resources = new StandardRoot(context);
        resources.addPreResources(new DirResourceSet(resources, webAppMount, additionalWebInfClasses.getAbsolutePath(), contextPath));
        context.setResources(resources); */
        // End of additions


        tomcat.start();
        tomcat.getServer().await();

    }
}