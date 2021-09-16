import entities.Section;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.FlushModeType;
import javax.persistence.Persistence;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("demoJPA");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        // Read

        // - all
        List<Section> list = em.createQuery("SELECT s FROM Section s").getResultList();
        list.forEach((s) -> System.out.println(s.getSection_id() +" - "+s.getSection_name()+" - " + s.getDelegate_id()));

        // - one
        // SELECT * FROM section WHERE section_id = 1010;
        Section s = em.find(Section.class, 1010);

        System.out.println(s.getSection_id());
        System.out.println(s.getSection_name());
        System.out.println(s.getDelegate_id());
        
        // Update
        s.setSection_name("BSc Management");

        // Delete
        Section toDelete = em.find(Section.class, 2222);
        if(toDelete != null)
            em.remove( toDelete );

        // Create
        em.persist(
            Section.builder()
                .section_id(2222)
                .section_name("section persisté")
                .delegate_id(10)
                .build()
        );
        em.getTransaction().commit();

        em.close();
        emf.close();

    }

}
