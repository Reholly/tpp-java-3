package service;

import jakarta.servlet.http.HttpServletRequest;

import java.io.File;

public class Utility {
    public static String RedirectOn(String currentURL, String redirectPath){
        return currentURL.substring(0, currentURL.lastIndexOf("/")) + redirectPath;
    }

    public static void SetLoginAndPasswordInSession(HttpServletRequest request, String login, String password) {
        request.getSession().setAttribute("login", login);
        request.getSession().setAttribute("password", password);
    }

    public static void CreateNewUserFolder(String login) throws Exception {
        File folder = new File("/home/evgenii/JavaTPP/laba5/" + login) ;
        if(!folder.mkdir()) {
            throw new Exception("could not create folder");
        }
    }
}