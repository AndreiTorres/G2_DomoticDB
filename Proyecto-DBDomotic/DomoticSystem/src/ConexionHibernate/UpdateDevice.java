package ConexionHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateDevice {
    

    public static void main(String[] args) {
        
        SessionFactory mFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Devices.class) 
                .configure().buildSessionFactory(); //addAnnotatedClass(Devices.class).addAnnotatedClass(Rooms.class)
            
        Session mySession = mFactory.openSession();
        
        try {

            int idDevice = 1;

            mySession.beginTransaction();

            Devices updateDevice = mySession.get(Devices.class, idDevice);

            updateDevice.setName("Jose");
            
            //Eliminar un registro de la base de datos
            //mySession.createQuery("delete Devices where status=1").executeUpdate();
            mySession.getTransaction().commit();
            System.out.println("Registro actualizado");
            mySession.close();
        } finally {
            mFactory.close();
            
        }
    }
}
