package com.example.tppjava3;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.AuthService;
import service.Utility;

import java.io.IOException;

@WebServlet(urlPatterns = {"/Login"})
public class LoginServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        if(AuthService.GetUser(login, password) == null) {
            response.getWriter().println("incorrect password or login");
            return;
        }
        Utility.SetLoginAndPasswordInSession(request, login, password);

        response.sendRedirect(Utility.RedirectOn(request.getRequestURL().toString(), "/Manager"));
    }
}