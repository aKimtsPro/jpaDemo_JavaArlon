package exo.business;

import exo.business.mapper.ProduitMapper;
import exo.data.dao.ProduitDAO;
import exo.data.entity.Produit;
import exo.dto.ProduitDTO;
import exo.exception.ProduitNotFoundException;

import java.util.List;
import java.util.stream.Collectors;

public class ProduitServiceImpl implements ProduitService {

    private final ProduitDAO dao = new ProduitDAO();
    private final ProduitMapper mapper = new ProduitMapper();

    @Override
    public Integer insert(ProduitDTO toInsert) {
        return dao.insert( mapper.dtoToEntiy(toInsert) );
    }

    @Override
    public List<ProduitDTO> getAll() {
        return dao.getAll().stream()
                .map(mapper::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public ProduitDTO getOne(int id) {

        return dao.getOne(id)
                .map(mapper::entityToDto)
                .orElseThrow( () -> new ProduitNotFoundException(id));

    }

    @Override
    public void update(ProduitDTO toUpdate) {
        dao.update( mapper.dtoToEntiy(toUpdate) );
    }

    @Override
    public ProduitDTO delete(int id) {
        return dao.delete(id)
                .map(mapper::entityToDto)
                .orElseThrow( () -> new ProduitNotFoundException(id));
    }
}
