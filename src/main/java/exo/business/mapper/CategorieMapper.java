package exo.business.mapper;

import exo.data.entity.Categorie;
import exo.dto.CategorieDTO;
import exo.dto.ClientDTO;

public class CategorieMapper implements Mapper<Categorie, CategorieDTO> {


    @Override
    public CategorieDTO entityToDto(Categorie categorie) {
        if(categorie == null)
            return null;

        return CategorieDTO.builder()
                .id(categorie.getId())
                .nom(categorie.getNom())
                .description(categorie.getDescription())
                .build();
    }

    @Override
    public Categorie dtoToEntity(CategorieDTO categorieDTO) {
        if(categorieDTO == null)
            return null;

        return Categorie.builder()
                .id(categorieDTO.getId())
                .nom(categorieDTO.getNom())
                .description(categorieDTO.getDescription())
                .build();
    }
}
