package exo.data.dao;

import exo.data.entity.Produit;
import exo.exception.ElementNotFoundException;
import util.EntityManagerProvider;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

public class ProduitDAO implements CrudDAO<Produit, Integer> {

    private final EntityManager manager = EntityManagerProvider.getEntityManager();

    @Override
    public Integer insert(Produit produit) {
        manager.getTransaction().begin();
        manager.persist(produit);
        manager.getTransaction().commit();
        return produit.getId();
    }

    @Override
    public List<Produit> getAll() {
        TypedQuery<Produit> q = manager.createQuery("SELECT p FROM Produit p", Produit.class);
        return q.getResultList();
    }

    @Override
    public Optional<Produit> getOne(Integer id) {
        return Optional.ofNullable( manager.find(Produit.class, id) );
    }

    @Override
    public void update(Produit produit) {

        Produit toUpdate = getOne(produit.getId())
                .orElseThrow(() -> new ElementNotFoundException(Produit.class, produit.getId()));

        manager.getTransaction().begin();

        toUpdate.setMarque( produit.getMarque() );
        toUpdate.setNom( produit.getNom() );
        toUpdate.setPrix( produit.getPrix() );

        manager.getTransaction().commit();

    }

    @Override
    public Optional<Produit> delete(Integer id) {

        manager.getTransaction().begin();

        Optional<Produit> opt = Optional.ofNullable( manager.find(Produit.class, id) );
        opt.ifPresent( manager::remove );

        manager.getTransaction().commit();
        return opt;

    }
}
