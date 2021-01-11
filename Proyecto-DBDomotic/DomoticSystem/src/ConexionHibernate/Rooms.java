package ConexionHibernate;

import javax.persistence.*;
import javax.persistence.Column;
import javax.persistence.Id;

@Entity
@Table(name="rooms")
public class Rooms {

    @Id
    @Column(name="Id")
    private int id;
    // @OneToMany(name="Id")
    // private Devices devices[];

    @Column(name="NameRoom")
    private String nameRoom;
    
    @Column(name="Floor")
    private int floor;

    @OneToOne(mappedBy = "rooms", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Devices devices;

    /*@OneToMany(name="Id")
    private Devices device;*/

    public Rooms(){
    }
    public Rooms(String nameRoom, int floor) {
        this.nameRoom = nameRoom;
        this.floor = floor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameRoom() {
        return nameRoom;
    }

    public void setNameRoom(String nameRoom) {
        this.nameRoom = nameRoom;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public Devices getDevices() {
        return devices;
    }

    public void setDevices(Devices devices) {
        this.devices = devices;
    }
}
