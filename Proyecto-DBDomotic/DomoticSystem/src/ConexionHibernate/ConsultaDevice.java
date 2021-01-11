package ConexionHibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class ConsultaDevice {
    
    public static void main(String[] args) {
        
        SessionFactory mFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Devices.class).configure().buildSessionFactory();
        
        Session mySession = mFactory.openSession();
        try{
            //Comenzar sesion
            mySession.beginTransaction();

            //Consulta de todos los clientes
            List<Devices> allDevices = mySession.createQuery("from Devices").getResultList();
            
            allDevices.stream()
                .forEach(device -> System.out.println(device));


            System.out.println("\n\n");
            //Consulta devices con status = 0
            allDevices = mySession.createQuery("from Devices x where x.status=0").getResultList();

            allDevices.stream()
                .forEach(deviceWithStatus0 -> System.out.println(deviceWithStatus0));
            
            mySession.getTransaction().commit();
            mySession.close();
            

        } finally {
            mFactory.close();
        }
    }
}
