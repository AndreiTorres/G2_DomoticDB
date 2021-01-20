package domotic.persistence;

import domotic.persistence.model.Area;
import domotic.persistence.model.Device;
import domotic.persistence.model.Espacio;
import domotic.persistence.model.Room;
import domotic.persistence.orm.EFMBootstrapper;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class Application {

    public static void main(String[] args) {
        EntityManager entityManager = EFMBootstrapper.open();

        //Crear Entidades

        //Area
        Area area1 = new Area("Cocina");
        Area area2 = new Area("Sala");


        //Habitaciones
        Room room = new Room("Habitacion de Andrei", area1);
        Room room2 = new Room("Habitacion de Jose", area2);

        //Devices

        Device device = new Device("Television", room);
        Device device2 = new Device("Lampara" ,room2);


        //Espacio
        Espacio espacio1 = new Espacio("Jardin", area1);
        Espacio espacio2 = new Espacio("Recibidor", area2);


        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(device);
        entityManager.persist(device2);
        entityManager.persist(espacio1);
        entityManager.persist(espacio2);
        entityManager.persist(area1);
        entityManager.persist(area2);
        entityManager.persist(room);
        entityManager.persist(room2);
        transaction.commit();


        entityManager.close();
    }
}
