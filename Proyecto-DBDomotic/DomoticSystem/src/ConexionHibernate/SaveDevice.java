package ConexionHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SaveDevice {
    
    public static void main(String[] args) {
        
        SessionFactory mFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Devices.class).configure().buildSessionFactory();
            
        Session mySession = mFactory.openSession();
        
        try {
            
            Devices device1 = new Devices(true, "Television Cuarto2", 1);
            mySession.beginTransaction();
            mySession.getTransaction().commit();
            mySession.close();
        } finally {
            mFactory.close();
            
        }
    }
}
