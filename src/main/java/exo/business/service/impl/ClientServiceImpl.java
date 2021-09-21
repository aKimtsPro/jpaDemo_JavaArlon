package exo.business.service.impl;

import exo.business.service.spec.ClientService;
import exo.business.mapper.ClientMapper;
import exo.data.dao.ClientDAO;
import exo.data.entity.Client;
import exo.dto.ClientDTO;
import exo.exception.ElementNotFoundException;

import java.util.function.Supplier;

public class ClientServiceImpl extends AbstractCrudService<ClientDTO, Client, Integer> implements ClientService {

    public ClientServiceImpl() {
        super(new ClientDAO(), new ClientMapper());
    }

    @Override
    protected Supplier<ElementNotFoundException> getNotFoundExceptionSupplier(Integer id) {
        return () -> new ElementNotFoundException(Client.class,id );
    }
}
