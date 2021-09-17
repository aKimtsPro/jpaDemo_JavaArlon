package exo.business;

import exo.data.entity.Produit;
import exo.dto.ProduitDTO;

import java.util.List;

public interface ProduitService {

    // Create
    Integer insert(ProduitDTO toInsert);

    // Read
    List<ProduitDTO> getAll();
    ProduitDTO getOne(int id);

    // Update
    void update(ProduitDTO toUpdate);

    // Delete
    ProduitDTO delete(int id);
}
