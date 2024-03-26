package dal;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import model.User;

import java.sql.SQLException;

@WebListener
public class Listener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        try {
            UserRepository.Connect();
        } catch (SQLException | IllegalAccessException | InstantiationException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        try {
            UserRepository.Close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}