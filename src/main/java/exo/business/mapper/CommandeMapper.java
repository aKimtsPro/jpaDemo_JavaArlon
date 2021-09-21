package exo.business.mapper;

import exo.data.entity.Commande;
import exo.dto.CommandeDTO;

public class CommandeMapper implements Mapper<Commande, CommandeDTO> {

    private final ClientMapper cmapper = new ClientMapper();

    @Override
    public CommandeDTO entityToDto(Commande commande) {
        if(commande == null)
            return null;

        return CommandeDTO.builder()
                .id(commande.getId())
                .dateConfirm(commande.getDateConfirm())
                .dateCreation(commande.getDateCreation())
                .proprietaire( cmapper.entityToDto(commande.getClient()) )
                .build();
    }

    @Override
    public Commande dtoToEntity(CommandeDTO commandeDTO) {
        if(commandeDTO == null)
            return null;

        return Commande.builder()
                .id(commandeDTO.getId())
                .dateConfirm(commandeDTO.getDateConfirm())
                .dateCreation(commandeDTO.getDateCreation())
                .client( cmapper.dtoToEntity(commandeDTO.getProprietaire()) )
                .build();
    }
}
