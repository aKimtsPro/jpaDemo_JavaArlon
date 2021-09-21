package exo.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ProduitDTO {

    private int id;
    private String nom;
    private String marque;
    private double prix;

    private List<CategorieDTO> categories;

}
