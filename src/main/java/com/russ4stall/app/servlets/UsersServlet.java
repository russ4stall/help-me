package com.russ4stall.app.servlets;

import com.russ4stall.app.models.User;
import com.russ4stall.app.services.UserService;

import java.io.IOException;

import javax.servlet.RequestDispatcher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
        name = "UsersServlet",
        urlPatterns = {"/users"}
)
public class UsersServlet extends HttpServlet {
    
    private UserService userService;

    public UsersServlet(UserService userService) {
        this.userService = userService;
    }    

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("get hello servlet");

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/users.jsp");
        req.setAttribute("users", userService.getList());
        dispatcher.forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("adding user");    

        String name = req.getParameter("name");
        String age = req.getParameter("age");

        User user = new User(name, Integer.valueOf(age));
        userService.addUser(user);
        System.out.println("added user: " + user.getId() + " | " + user.getName() + " | " + user.getAge());
        doGet(req, resp);
    }
}