package exo.business.mapper;

import exo.data.entity.Client;
import exo.dto.ClientDTO;
import exo.dto.CommandeDTO;

public class ClientMapper implements Mapper<Client, ClientDTO> {
    @Override
    public ClientDTO entityToDto(Client client) {
        if(client == null)
            return null;

        return ClientDTO.builder()
                .id(client.getId())
                .prenom(client.getPrenom())
                .nom(client.getNom())
                .email(client.getEmail())
                .adresse(client.getAdresse())
                .build();
    }

    @Override
    public Client dtoToEntity(ClientDTO clientDTO) {
        if(clientDTO == null)
            return null;

        return Client.builder()
                .id(clientDTO.getId())
                .prenom(clientDTO.getPrenom())
                .nom(clientDTO.getNom())
                .email(clientDTO.getEmail())
                .adresse(clientDTO.getAdresse())
                .build();

    }
}
