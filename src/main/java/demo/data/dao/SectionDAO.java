package demo.data.dao;

import demo.data.entities.Section;
import util.EntityManagerProvider;

import javax.persistence.EntityManager;
import java.util.List;

public class SectionDAO {

    private static SectionDAO instance;
    public static SectionDAO getInstance() {
        return instance == null ? instance = new SectionDAO(): instance;
    }
    private SectionDAO() {}

//    private EntityManager manager = EntityManagerProvider.getEntityManager();

    public List<Section> getAll(){
        EntityManager manager = EntityManagerProvider.getEntityManager();
        List<Section> list = manager.createQuery("SELECT s FROM Section s", Section.class).getResultList();
        manager.close();
        return list;
    }

}
