package model;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "login", unique = true, updatable = false, nullable = false)
    private String login;
    @Column(name = "password", updatable = false, nullable = false)
    private String password;
    @Column(name = "email", unique = true, updatable = false, nullable = false)
    private String email;

    public User() {

    }

    public User(String login, String password, String email) {
        this.login = login;
        this.password = password;
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
}