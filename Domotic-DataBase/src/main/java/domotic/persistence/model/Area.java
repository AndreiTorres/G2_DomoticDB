package domotic.persistence.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Area {
    @Id
    @GeneratedValue
    private long areaId;

    private String areaName;

    @OneToMany(mappedBy = "area")
    private final Set<Espacio> espacios = new HashSet<>();

    @OneToMany(mappedBy = "area")
    private final Set<Room> rooms = new HashSet<>();

    public Area() {}

    public Area(String areaName) {
        this.areaName = areaName;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public Set<Espacio> getEspacios() {
        return espacios;
    }

    public Set<Room> getRooms() {
        return rooms;
    }

    public void addEspacio(Espacio espacio) {
        espacio.setArea(this);
        espacios.add(espacio);
    }

    public void addRoom(Room room) {
        room.setArea(this);
        rooms.add(room);
    }

    @Override
    public String toString() {
        return "Area{" +
                "areaId=" + areaId +
                ", areaName='" + areaName + '\'' +
                '}';
    }
}