package exo.business.service.impl;

import exo.business.service.spec.CategorieService;
import exo.business.mapper.CategorieMapper;
import exo.data.dao.CategorieDAO;
import exo.data.entity.Categorie;
import exo.dto.CategorieDTO;
import exo.exception.ElementNotFoundException;

import java.util.function.Supplier;

public class CategorieServiceImpl extends AbstractCrudService<CategorieDTO, Categorie, String> implements CategorieService {

    public CategorieServiceImpl() {
        super(new CategorieDAO(),  new CategorieMapper());
    }

    @Override
    protected Supplier<ElementNotFoundException> getNotFoundExceptionSupplier(String id) {
        return () -> new ElementNotFoundException(Categorie.class,id );
    }
}
