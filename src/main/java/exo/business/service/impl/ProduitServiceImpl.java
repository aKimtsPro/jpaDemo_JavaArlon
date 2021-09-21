package exo.business.service.impl;

import exo.business.service.spec.ProduitService;
import exo.business.mapper.ProduitMapper;
import exo.data.dao.ProduitDAO;
import exo.data.entity.Produit;
import exo.dto.ProduitDTO;
import exo.exception.ElementNotFoundException;

import java.util.function.Supplier;

public class ProduitServiceImpl extends AbstractCrudService<ProduitDTO, Produit, Integer> implements ProduitService {

    public ProduitServiceImpl() {
        super(new ProduitDAO(), new ProduitMapper());
    }

    @Override
    protected Supplier<ElementNotFoundException> getNotFoundExceptionSupplier(Integer id) {
        return () -> new ElementNotFoundException(Produit.class, id);
    }
}
