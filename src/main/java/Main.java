import data.entities.Section;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
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
        list.forEach((s) -> System.out.println(s.getId() +" - "+s.getName()+" - " + s.getDelegateId()));

        System.out.println("\n--- GET ONE ---");
        // - one
        // SELECT * FROM section WHERE section_id = 1010;
        Section s = em.find(Section.class, 1010);

        System.out.println("récupération faite");

        System.out.println(s.getId());
        System.out.println(s.getName());
        System.out.println(s.getDelegateId());

        System.out.println("\n--- UPDATE ---");
        // Update
        s.setName("BSc Management");
        em.flush();

        // Delete
        Section toDelete = em.find(Section.class, 2222);
        if(toDelete != null)
            em.remove( toDelete );

        // Create
        em.persist(
            Section.builder()
                .id(2222)
                .name("section persisté")
                .delegateId(10)
                .build()
        );
        em.getTransaction().commit();

        em.close();
        emf.close();


    }

}
