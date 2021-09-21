package exo.business.service.impl;

import exo.business.service.spec.CommandeService;
import exo.business.mapper.CommandeMapper;
import exo.data.dao.CommandeDAO;
import exo.data.entity.Commande;
import exo.dto.CommandeDTO;
import exo.exception.ElementNotFoundException;

import java.util.function.Supplier;

public class CommandeServiceImpl extends AbstractCrudService<CommandeDTO, Commande, String> implements CommandeService {
    public CommandeServiceImpl() {
        super(new CommandeDAO(), new CommandeMapper());
    }

    @Override
    protected Supplier<ElementNotFoundException> getNotFoundExceptionSupplier(String id) {
        return () -> new ElementNotFoundException(Commande.class,id );
    }
}
