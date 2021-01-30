package domotic.persistence;

import domotic.persistence.model.*;
import domotic.persistence.orm.EFMBootstrapper;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class Application {

    public static void main(String[] args) {
        EntityManager entityManager = EFMBootstrapper.open();

        //Crear Entidades

        //Usuario
        Users andrei = new Users("Andrei", "andrei", "andrei@hotmail.com", false);

        //UserType
        UserType invitado = new UserType("invitado");

        //Se le asigna un tipo de usuario
        andrei.setIdUserType(invitado);

        //Habitaciones
        Room room = new Room("Habitacion de Andrei");
        Room room2 = new Room("Habitacion de Jose");

        //Permisos
        Permits permits = new Permits(room, 1000);
        Permits permits1 = new Permits(room2, 1000);

        permits.setUser(andrei);
        permits1.setUser(andrei);


        //Devices
        Device device = new Device("Television", room);
        Device device2 = new Device("Lampara", room);
        Device device3 = new Device("AC", room2);

        //Brands
        Brand brand = new Brand("SAMSUNG");
        Brand brand1 = new Brand("SONY");
        Brand brand2 = new Brand("PANASONIC");


        //Models
        Model model = new Model("TV4KHD");
        Model model1 = new Model("LAMP9SH");
        Model model2 = new Model("AC5HGSS");

        //Types
        Type type = new Type("TELEVISION");
        Type type1 = new Type("LAMPARA");
        Type type2 = new Type("AC");

        //DeviceSpecs
        DeviceSpecs deviceSpecsTV = new DeviceSpecs(true, false, "4k" );
        deviceSpecsTV.setBrand(brand);
        deviceSpecsTV.setModel(model);
        deviceSpecsTV.setType(type);

        DeviceSpecs deviceSpecsLAMP = new DeviceSpecs(false, true, 1);
        deviceSpecsLAMP.setBrand(brand1);
        deviceSpecsLAMP.setModel(model1);
        deviceSpecsLAMP.setType(type1);

        DeviceSpecs deviceSpecsAC = new DeviceSpecs(false, true, 24);
        deviceSpecsAC.setBrand(brand2);
        deviceSpecsAC.setType(type2);
        deviceSpecsAC.setModel(model2);

        device.setDeviceSpecs(deviceSpecsTV);
        device2.setDeviceSpecs(deviceSpecsLAMP);
        device3.setDeviceSpecs(deviceSpecsAC);


        
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(device);
        entityManager.persist(device2);
        entityManager.persist(device3);
        entityManager.persist(andrei);
        entityManager.persist(permits);
        entityManager.persist(permits1);
        entityManager.persist(invitado);
        transaction.commit();


        entityManager.close();
    }
}
