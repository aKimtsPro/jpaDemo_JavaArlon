package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerProvider {

    private static EntityManagerProvider instance;
    private EntityManagerProvider(EntityManagerFactory emf) {
        this.emf = emf;
    }
    public static final String PERSISTENCE_UNIT = "exoJPA";
    private static boolean isOpen = false;
    private EntityManagerFactory emf;

    /**
     * Starts up a new provider cycle.
     * Permits the creation of entity managers.
     * @throws IllegalStateException if the entity manager provider is already opened
     */
    public static void open(){
        if(isOpen)
            throw new IllegalStateException("util.EntityManagerProvider is already opened");

        instance = new EntityManagerProvider(Persistence.createEntityManagerFactory(PERSISTENCE_UNIT));
        isOpen = true;
    }
    /**
     * Creates a new <code>EntityManager</code> instance and returns it
     * @return entity manager instance
     * @throws IllegalStateException if the entity manager provider is not opened
     */
    public static EntityManager getEntityManager() {
        if(!isOpen)
            throw new IllegalStateException("util.EntityManagerProvider is not opened");

        return instance.emf.createEntityManager();
    }
    /**
     * Creates a new <code>EntityManager</code> instance
     * @throws IllegalStateException if the entity manager provider is not opened
     */
    public static void close(){
        if(!isOpen)
            throw new IllegalStateException("util.EntityManagerProvider is not opened");

        if( instance != null ){
            instance.emf.close();
            instance = null;
        }

        isOpen = false;
    }
    /**
     * Indicates whether the <code>util.EntityManagerProvider</code> is opened or not.
     * return <code>true</code> if the <code>util.EntityManagerProvider</code> is opened.
     * @return boolean indicating whether the provider is opened.
     */
    public static boolean isOpen() {
        return isOpen;
    }
}
