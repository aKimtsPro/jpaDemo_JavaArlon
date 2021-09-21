package exo.business.mapper;

import exo.data.entity.Produit;
import exo.dto.ProduitDTO;

public interface Mapper<ENTITY, DTO>{

    DTO entityToDto(ENTITY entity);
    ENTITY dtoToEntity(DTO dto);
}
