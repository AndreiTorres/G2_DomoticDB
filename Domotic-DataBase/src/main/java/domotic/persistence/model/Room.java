package domotic.persistence.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Room {
    @Id
    @GeneratedValue
    private long roomId;

    private String roomName;

    @OneToMany(mappedBy = "room")
    private final Set<Device> devices = new HashSet<>();

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Area area;

    public Room() {}

    public Room(String roomName, Area area) {

        this.roomName = roomName;
        area.addRoom(this);
        this.area = area;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public Set<Device> getDevices() {
        return devices;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public void addDevice(Device device) {
        device.setRoom(this);
        devices.add(device);
    }


    @Override
    public String toString() {
        return "Room{" +
                "roomId=" + roomId +
                ", roomName='" + roomName + '\'' +
                '}';
    }
}
