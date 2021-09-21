package exo.data.dao;

import exo.data.entity.Client;
import exo.data.entity.Produit;
import exo.exception.ElementNotFoundException;
import util.EntityManagerProvider;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

public class ClientDAO implements CrudDAO<Client, Integer> {

    private final EntityManager manager = EntityManagerProvider.getEntityManager();

    @Override
    public Integer insert(Client client) {
        manager.getTransaction().begin();
        manager.persist(client);
        manager.getTransaction().commit();
        return client.getId();
    }

    @Override
    public List<Client> getAll() {
        TypedQuery<Client> q = manager.createQuery("SELECT c FROM Client c", Client.class);
        return q.getResultList();
    }

    @Override
    public Optional<Client> getOne(Integer id) {
        return Optional.ofNullable( manager.find(Client.class, id) );
    }

    @Override
    public void update(Client client) {
        Client toUpdate = getOne(client.getId())
                .orElseThrow(() -> new ElementNotFoundException(Client.class, client.getId()));

        manager.getTransaction().begin();

        toUpdate.setPrenom(client.getPrenom());
        toUpdate.setNom(client.getNom());
        toUpdate.setAdresse(client.getAdresse());
        toUpdate.setEmail(client.getEmail());

        manager.getTransaction().commit();
    }

    @Override
    public Optional<Client> delete(Integer id) {

        manager.getTransaction().begin();

        Optional<Client> opt = Optional.ofNullable( manager.find(Client.class, id) );
        opt.ifPresent( manager::remove );

        manager.getTransaction().commit();
        return opt;
    }
}
