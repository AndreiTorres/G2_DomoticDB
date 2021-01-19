package domotic.persistence;

import domotic.persistence.model.Device;
import domotic.persistence.model.Room;
import domotic.persistence.orm.EFMBootstrapper;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class Application {

    public static void main(String[] args) {
        EntityManager entityManager = EFMBootstrapper.open();

        //Crear Entidades

        //Habitaciones
        Room room = new Room("Habitacion de Andrei");
        Room room2 = new Room("Habitacion de Jose");

        //Devices

        Device device = new Device("Television", room);
        Device device2 = new Device("Lampara" ,room2);

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(device);
        entityManager.persist(device2);
        transaction.commit();


        entityManager.close();
    }
}
