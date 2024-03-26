package service;

import dal.UserRepository;
import model.User;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Objects;

public class AuthService {

    public static  void CreateUser(User user) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        UserRepository.CreateUser(user);
    }
    public static User GetUser(String login, String password) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        User user = UserRepository.GetUserByLogin(login);

        if( user == null || !Objects.equals(user.getPassword(), password)) return null;

        return user;
    }
}
