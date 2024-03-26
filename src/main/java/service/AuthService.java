package service;

import model.User;

import java.util.HashMap;
import java.util.Objects;

public class AuthService {
    private static HashMap<String, User> Users = new HashMap<>() {
        {
            put("evgenii", new User("admin", "12345", "example@gmail.com"));
            put("someuser", new User("someuser", "12345", "someuser@gmail.com"));
        }
    };

    public static  void CreateUser(User user) {
        Users.put(user.getLogin(), user);
    }
    public static User GetUser(String login, String password) {
        User user = Users.get(login);

        if( user == null || !Objects.equals(user.getPassword(), password)) return null;

        return user;
    }
}
