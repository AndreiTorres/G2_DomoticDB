package domotic.persistence.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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

    public Room() {}

    public Room(String roomName) {
        this.roomName = roomName;
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
