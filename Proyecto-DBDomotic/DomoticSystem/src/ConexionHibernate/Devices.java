package ConexionHibernate;

import javax.persistence.*;
import javax.persistence.Column;
import javax.persistence.Id;

@Entity
@Table(name="devices")
public class Devices {

    @Id
    @Column(name="Id")
    private int id;

    @Column(name="Status")
    private boolean status;
    
    @Column(name="Name")
    private String name;
    
    /*
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="Id_Room", referencedColumnName = "Id")
    private Rooms room;*/

    @Column(name="Id_Room")
    private int id_room;

    public Devices(){
    }

    public Devices(boolean status, String name, int id_room) {
        this.status = status;
        this.name = name;
        this.id_room = id_room;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString(){
        String output;
        output = "ID: " + this.id + "\t" +
                "Status: " +this.status + "\t" +
                "Name: " + this.name + "\t" +
                "Id_Room: " + this.id_room;
        return output;
    }
/*
    public Rooms getRoom() {
        return room;
    }

    public void setRoom(Rooms room) {
        this.room = room;
    }*/

public int getId_room() {
    return id_room;
}

public void setId_room(int id_room) {
    this.id_room = id_room;
}
}
