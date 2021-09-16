package entities.manager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerProvider {

    private static EntityManagerProvider instance;
    private EntityManagerProvider(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public static final String PERSISTENCE_UNIT = "demoJPA";
    private static boolean isOpen = false;
    private EntityManagerFactory emf;

    public static void open(){
        instance = new EntityManagerProvider(Persistence.createEntityManagerFactory(PERSISTENCE_UNIT));
        isOpen = true;
    }
    public static EntityManager getEntityManager() {
        if(!isOpen)
            throw new IllegalStateException("EntityManagerProvider is not opened");

        return instance.emf.createEntityManager();
    }
    public static void close(){
        if(!isOpen)
            throw new IllegalStateException("EntityManagerProvider is not opened");

        if( instance != null ){
            instance.emf.close();
            instance = null;
        }

        isOpen = false;
    }
    public static boolean isOpen() {
        return isOpen;
    }
}
