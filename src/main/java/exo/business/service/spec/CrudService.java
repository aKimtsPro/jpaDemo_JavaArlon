package exo.business.service.spec;

import exo.exception.ElementNotFoundException;

import java.util.List;

public interface CrudService<DTO, ID> {
    // Create
    ID insert(DTO toInsert);

    // Read
    List<DTO> getAll();
    DTO getOne(ID id) throws ElementNotFoundException;

    // Update
    void update(DTO toUpdate);

    // Delete
    DTO delete(ID id) throws ElementNotFoundException;
}
