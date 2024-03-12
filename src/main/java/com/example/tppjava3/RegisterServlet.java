package com.example.tppjava3;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jdk.jshell.execution.Util;
import model.User;
import service.AuthService;
import service.Utility;

import java.io.IOException;

@WebServlet(urlPatterns = {"/Register"})
public class RegisterServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/Register.jsp").forward(request, response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String login = request.getParameter("login");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        if(email.isEmpty() || login.isEmpty() || password.isEmpty()) {
            response.getWriter().println("Incorrect login, password or email");
        }
        User user = AuthService.GetUser(login, password);
        if (user != null) {
            response.getWriter().println("User already exists");
            return;
        }

        AuthService.CreateUser(new User(login, password, email));
        request.getSession().setAttribute("login", login);
        request.getSession().setAttribute("password", password);
        try {
            Utility.CreateNewUserFolder(login);
        } catch (Exception ex) {
            response.getWriter().println(ex.getMessage());
            return;
        }

        response.sendRedirect(Utility.RedirectOn(request.getRequestURL().toString(), "/Manager?path=/"));
    }
}
