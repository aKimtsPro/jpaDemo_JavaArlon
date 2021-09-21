package exo.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CategorieDTO {

    private String id;
    private String nom;
    private String description;

}
