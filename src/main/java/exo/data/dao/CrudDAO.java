package exo.data.dao;

import java.util.List;
import java.util.Optional;

public interface CrudDAO<ENTITY,ID> {

    // Create
    ID insert(ENTITY entity);

    // Read
    List<ENTITY> getAll();
    Optional<ENTITY> getOne(ID id);

    // Update
    void update(ENTITY entity);

    // Delete
    Optional<ENTITY> delete(ID id);
}
