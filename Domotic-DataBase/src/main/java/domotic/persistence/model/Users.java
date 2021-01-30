package domotic.persistence.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Users {

    @Id
    @GeneratedValue
    private int id;
    private String user;
    private String password;
    private String email;
    private boolean isAdmin;

    @OneToOne(cascade = CascadeType.PERSIST)
    private UserType idUserType;

    @OneToMany(mappedBy = "user")
    private final Set<Permits> permits = new HashSet<>();

    public Users() {}

    public Users(String user, String password, String email, boolean isAdmin) {
        this.user = user;
        this.password = password;
        this.email = email;
        this.isAdmin = isAdmin;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public UserType getIdUserType() {
        return idUserType;
    }

    public void setIdUserType(UserType idUserType) {
        this.idUserType = idUserType;
    }

    public Set<Permits> getPermits() {
        return permits;
    }

    @Override
    public String toString() {
        return "Users{" +
                "user='" + user + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", isAdmin=" + isAdmin +
                ", idUserType=" + idUserType +
                ", permits=" + permits +
                '}';
    }
}
