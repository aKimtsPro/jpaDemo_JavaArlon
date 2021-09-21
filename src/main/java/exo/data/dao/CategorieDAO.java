package exo.data.dao;

import exo.data.entity.Categorie;
import exo.data.entity.Client;
import exo.data.entity.Commande;
import exo.data.entity.Produit;
import exo.exception.ElementNotFoundException;
import util.EntityManagerProvider;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

public class CategorieDAO implements CrudDAO<Categorie, String> {

    private final EntityManager manager = EntityManagerProvider.getEntityManager();

    @Override
    public String insert(Categorie categorie) {
        manager.getTransaction().begin();
        manager.persist(categorie);
        manager.getTransaction().commit();
        return categorie.getId();
    }

    @Override
    public List<Categorie> getAll() {
        TypedQuery<Categorie> q = manager.createQuery("SELECT c FROM Categorie c", Categorie.class);
        return q.getResultList();
    }

    @Override
    public Optional<Categorie> getOne(String id) {
        return Optional.ofNullable( manager.find(Categorie.class, id) );
    }

    @Override
    public void update(Categorie categorie) {
        Categorie toUpdate = getOne(categorie.getId())
                .orElseThrow(() -> new ElementNotFoundException(Commande.class, categorie.getId()));

        manager.getTransaction().begin();

        toUpdate.setNom(categorie.getNom());
        toUpdate.setDescription(categorie.getDescription());

        manager.getTransaction().commit();
    }

    @Override
    public Optional<Categorie> delete(String id) {
        manager.getTransaction().begin();

        Optional<Categorie> opt = Optional.ofNullable( manager.find(Categorie.class, id) );
        opt.ifPresent( manager::remove );

        manager.getTransaction().commit();
        return opt;
    }
}
