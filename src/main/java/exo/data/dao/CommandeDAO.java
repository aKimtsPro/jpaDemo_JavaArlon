package exo.data.dao;

import exo.data.entity.Client;
import exo.data.entity.Commande;
import exo.exception.ElementNotFoundException;
import util.EntityManagerProvider;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

public class CommandeDAO implements CrudDAO<Commande, String> {

    private final EntityManager manager = EntityManagerProvider.getEntityManager();

    @Override
    public String insert(Commande commande) {
        manager.getTransaction().begin();
        manager.persist(commande);
        manager.getTransaction().commit();
        return commande.getId();
    }

    @Override
    public List<Commande> getAll() {
        TypedQuery<Commande> q = manager.createQuery("SELECT c FROM Commande c", Commande.class);
        return q.getResultList();
    }

    @Override
    public Optional<Commande> getOne(String id) {
        return Optional.ofNullable( manager.find(Commande.class, id) );
    }

    @Override
    public void update(Commande commande) {
        Commande toUpdate = getOne(commande.getId())
                .orElseThrow(() -> new ElementNotFoundException(Commande.class, commande.getId()));

        manager.getTransaction().begin();

        toUpdate.setDateConfirm(commande.getDateConfirm());
        toUpdate.setDateCreation(commande.getDateCreation());

        if(commande.getClient() != null){
            Optional<Client> opt = Optional.ofNullable( manager.find(Client.class, commande.getClient().getId()));
            opt.ifPresent( toUpdate::setClient );
        }

        manager.getTransaction().commit();
    }

    @Override
    public Optional<Commande> delete(String id) {
        manager.getTransaction().begin();

        Optional<Commande> opt = Optional.ofNullable( manager.find(Commande.class, id) );
        opt.ifPresent( manager::remove );

        manager.getTransaction().commit();
        return opt;
    }
}
