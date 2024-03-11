package com.example.tppjava3;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import service.FileManager;

@WebServlet(urlPatterns = {"/Manager"})
public class HelloServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        FileManager fileManager = new FileManager();
        File[] folders = fileManager.allFolders(request.getParameter("path"));
        if (folders == null) {
            folders = new File[0];
        }

        File[] files = fileManager.allFiles(request.getParameter("path"));
        if (files == null) {
            files = new File[0];
        }

        Date generationDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yy HH:mm:ss");

        request.setAttribute("generationTime",dateFormat.format(generationDate));
        request.setAttribute("folders", folders);
        request.setAttribute("files", files);
        request.getRequestDispatcher("Manager.jsp").forward(request, response);

    }
}