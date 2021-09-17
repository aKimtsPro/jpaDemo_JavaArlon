package exo.business.mapper;

import exo.data.entity.Produit;
import exo.dto.ProduitDTO;

public class ProduitMapper {

    public ProduitDTO entityToDto(Produit entity){
        if(entity == null)
            return null;

        return ProduitDTO.builder()
                .id(entity.getId())
                .marque(entity.getMarque())
                .nom(entity.getNom())
                .prix(entity.getPrix())
                .build();
    }

    public Produit dtoToEntiy(ProduitDTO dto){
        if( dto == null )
            return null;

        return Produit.builder()
                .id(dto.getId())
                .marque(dto.getMarque())
                .nom(dto.getNom())
                .prix(dto.getPrix())
                .build();
    }


}
