package domotic.persistence.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Permits {

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Users user;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Room room;

    private int limit_time;

    @Id
    @GeneratedValue
    private int id;

    public Permits() {}

    public Permits(Room room, int limit_time) {
        this.room = room;
        this.limit_time = limit_time;

    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room, int limit_time) {
        this.room = room;
        this.limit_time = limit_time;
    }

    public int getLimit_time() {
        return limit_time;
    }

    public void setLimit_time(int limit_time) {
        this.limit_time = limit_time;
    }

    @Override
    public String toString() {
        return "Permits{" +
                "user=" + user +
                ", room=" + room +
                ", limit_time=" + limit_time +
                '}';
    }
}
