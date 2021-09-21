package exo.business.service.impl;

import exo.business.service.spec.CrudService;
import exo.business.mapper.Mapper;
import exo.data.dao.CrudDAO;
import exo.exception.ElementNotFoundException;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

abstract class AbstractCrudService<DTO, ENTITY, ID> implements CrudService<DTO, ID> {

    protected final CrudDAO<ENTITY, ID> dao;
    protected final Mapper<ENTITY, DTO> mapper;

    AbstractCrudService(CrudDAO<ENTITY, ID> dao, Mapper<ENTITY, DTO> mapper) {
        this.dao = dao;
        this.mapper = mapper;
    }

    @Override
    public ID insert(DTO toInsert) {
        return dao.insert( mapper.dtoToEntity(toInsert) );
    }

    @Override
    public List<DTO> getAll() {
        return dao.getAll().stream()
                .map(mapper::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public void update(DTO toUpdate) {
        dao.update( mapper.dtoToEntity(toUpdate) );
    }

    @Override
    public DTO getOne(ID id) throws ElementNotFoundException {
        return dao.getOne(id)
                .map(mapper::entityToDto)
                .orElseThrow( getNotFoundExceptionSupplier(id) );
    }

    @Override
    public DTO delete(ID id) throws ElementNotFoundException {
        return dao.delete(id)
                .map(mapper::entityToDto)
                .orElseThrow( getNotFoundExceptionSupplier(id) );
    }

    protected abstract Supplier<ElementNotFoundException> getNotFoundExceptionSupplier(ID id);

}
