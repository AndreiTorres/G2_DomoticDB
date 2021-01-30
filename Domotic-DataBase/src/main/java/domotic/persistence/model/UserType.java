package domotic.persistence.model;

import javax.persistence.*;

@Entity
public class UserType {

    @Id
    @GeneratedValue
    private int userTypeId;

    private String userType;

    @OneToOne(mappedBy = "idUserType")
    private Users users;

    public UserType() {}

    public UserType(String userType) {
        this.userType = userType;
    }

    public int getUserTypeId() {
        return userTypeId;
    }

    public void setUserTypeId(int userTypeId) {
        this.userTypeId = userTypeId;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "UserType{" +
                "userType='" + userType + '\'' +
                ", users=" + users +
                '}';
    }
}
