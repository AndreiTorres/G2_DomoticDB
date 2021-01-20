package domotic.persistence;

import domotic.persistence.model.*;
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

        //Brands
        Brand brand = new Brand("SAMSUNG");
        Brand brand1 = new Brand("SONY");


        //Models
        Model model = new Model("TV4KHD");
        Model model1 = new Model("LAMP9SH");

        //Types
        Type type = new Type("TELEVISION");
        Type type1 = new Type("LAMPARA");

        //DeviceSpecs
        DeviceSpecs deviceSpecsTV = new DeviceSpecs(true, false, "4k" );
        deviceSpecsTV.setBrand(brand);
        deviceSpecsTV.setModel(model);
        deviceSpecsTV.setType(type);

        DeviceSpecs deviceSpecsLAMP = new DeviceSpecs(false, true, 1);
        deviceSpecsLAMP.setBrand(brand1);
        deviceSpecsLAMP.setModel(model1);
        deviceSpecsLAMP.setType(type1);


        device.setDeviceSpecs(deviceSpecsTV);
        device2.setDeviceSpecs(deviceSpecsLAMP);

        
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(device);
        entityManager.persist(device2);
        transaction.commit();


        entityManager.close();
    }
}
