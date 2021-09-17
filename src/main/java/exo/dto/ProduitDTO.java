package exo.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProduitDTO {

    private int id;
    private String nom;
    private String marque;
    private double prix;

}
