package exo.business.mapper;

import exo.data.entity.Produit;
import exo.dto.ProduitDTO;

import java.util.stream.Collectors;

public class ProduitMapper implements Mapper<Produit, ProduitDTO> {

    private final CategorieMapper cmapper = new CategorieMapper();

    public ProduitDTO entityToDto(Produit entity){
        if(entity == null)
            return null;

        return ProduitDTO.builder()
                .id(entity.getId())
                .marque(entity.getMarque())
                .nom(entity.getNom())
                .prix(entity.getPrix())
                .categories(
                    entity.getCategories().stream()
                        .map(cmapper::entityToDto)
                        .collect(Collectors.toList())
                )
                .build();
    }

    public Produit dtoToEntity(ProduitDTO dto){
        if( dto == null )
            return null;

        return Produit.builder()
                .id(dto.getId())
                .marque(dto.getMarque())
                .nom(dto.getNom())
                .prix(dto.getPrix())
                .categories(
                        dto.getCategories().stream()
                                .map(cmapper::dtoToEntity)
                                .collect(Collectors.toList())
                )
                .build();
    }


}
