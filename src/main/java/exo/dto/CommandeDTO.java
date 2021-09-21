package exo.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class CommandeDTO {

    private String id;
    private LocalDateTime dateConfirm;
    private LocalDateTime dateCreation;

    private ClientDTO proprietaire;

}
