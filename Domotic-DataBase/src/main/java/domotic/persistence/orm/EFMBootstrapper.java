package domotic.persistence.orm;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EFMBootstrapper {

    private static final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("defaultPersistenceUnit");

    public static EntityManager open() { return emf.createEntityManager(); }
}
