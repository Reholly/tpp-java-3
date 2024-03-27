package dal;

import model.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.sql.*;

public class UserRepository {
    private static final String dbUrl = "jdbc:postgresql://localhost:5432/java_tpp";
    private static final String user = "postgres";
    private static final String password = "1234";

    public  static void Connect() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {

    }

    public static void CreateUser(User user) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        Session session = Listener.sessionFactory.openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(user);
        tx1.commit();
        session.close();
    }

    public static User GetUserByLogin(String login) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        Session session = Listener.sessionFactory.openSession();
        Criteria criteria = session.createCriteria(User.class);
        User user = (User) criteria.add(Restrictions.eq("login", login)).uniqueResult();

       return user;
    }
}
