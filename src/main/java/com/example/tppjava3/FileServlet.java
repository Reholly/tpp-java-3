package com.example.tppjava3;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.User;
import service.AuthService;
import service.FileManager;
import service.Utility;

@WebServlet(urlPatterns = {"/Manager"})
public class FileServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String login = (String) request.getSession().getAttribute("login");
        String password = (String) request.getSession().getAttribute("password");

        User user = AuthService.GetUser(login, password);

        if(user == null) {
            response.sendRedirect(Utility.RedirectOn(request.getRequestURL().toString(), "/Login"));
            return;
        }

        String currentPath = request.getParameter("path");

        if (currentPath == null) {
            currentPath =  "/home/evgenii/JavaTPP/laba5";
        }

        if(!Utility.IsCorrectFolderForUser(login, currentPath)) {
            currentPath = Utility.GetCorrectRouteForFolder(login);
        }


        FileManager fileManager = new FileManager();
        File[] folders = fileManager.allFolders(currentPath);
        if (folders == null) {
            folders = new File[0];
        }

        File[] files = fileManager.allFiles(currentPath);
        if (files == null) {
            files = new File[0];
        }

        Date generationDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yy HH:mm:ss");

        request.setAttribute("generationTime",dateFormat.format(generationDate));
        request.setAttribute("folders", folders);
        request.setAttribute("files", files);
        request.setAttribute("currentPath", currentPath);
        request.getRequestDispatcher("Manager.jsp").forward(request, response);

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.getSession().removeAttribute("login");
        request.getSession().removeAttribute("password");

        response.sendRedirect(Utility.RedirectOn(request.getRequestURL().toString(), "/Login"));
    }
}