package domotic.persistence.model;

import javax.persistence.*;

@Entity
public class Device {

    @Id
    @GeneratedValue
    private long deviceId;

    private String deviceName;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Room room;

    private boolean isIndispensable;

    @OneToOne(cascade = CascadeType.PERSIST)
    private DeviceSpecs deviceSpecs;

    public Device() {}

    public Device(String deviceName, Room room) {
        this.deviceName = deviceName;
        room.addDevice(this);
        this.room = room;
    }

    public boolean isIndispensable() {
        return isIndispensable;
    }

    public void setIndispensable(boolean indispensable) {
        isIndispensable = indispensable;
    }

    public DeviceSpecs getDeviceSpecs() {
        return deviceSpecs;
    }

    public void setDeviceSpecs(DeviceSpecs deviceSpecs) {
        this.deviceSpecs = deviceSpecs;
    }


    public long getDeviceId() {
        return deviceId;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    @Override
    public String toString() {
        return "Device{" +
                "deviceId=" + deviceId +
                ", deviceName='" + deviceName + '\'' +
                ", isIndispensable=" + isIndispensable +
                '}';
    }
}
