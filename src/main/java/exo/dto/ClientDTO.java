package exo.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClientDTO {

    private int id;
    private String prenom;
    private String nom;
    private String email;
    private String adresse;

}
