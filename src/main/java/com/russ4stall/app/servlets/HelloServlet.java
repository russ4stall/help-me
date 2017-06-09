package com.russ4stall.app.servlets;

import com.russ4stall.app.models.*;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
        name = "HelloServlet",
        urlPatterns = {"/hello"}
)
public class HelloServlet extends HttpServlet {
    
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("hello servlet");
        
        User user = new User();
        user.setName("Russ");
        user.setAge(28);

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/hello.jsp");
        req.setAttribute("name", user.getName());
        dispatcher.forward(req, resp);
    }
}