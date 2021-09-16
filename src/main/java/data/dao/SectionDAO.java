package data.dao;

import data.entities.Section;
import util.EntityManagerProvider;

import javax.persistence.EntityManager;
import java.util.List;

public class SectionDAO {

    private static SectionDAO instance;
    public static SectionDAO getInstance() {
        return instance == null ? instance = new SectionDAO(): instance;
    }
    private SectionDAO() {
        manager = EntityManagerProvider.getEntityManager();
    }

    private EntityManager manager;

    public List<Section> getAll(){
        return manager.createQuery("SELECT s FROM Section s").getResultList();
    }

}
