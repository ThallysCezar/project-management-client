package com.metatelecom.crud.mappers;

import com.metatelecom.crud.domains.Client;
import com.metatelecom.crud.dtos.ClientDTO;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class ClientMapper {


    private final ModelMapper modelMapper;

    public ClientDTO toDTO(Client entity) {
        return modelMapper.map(entity, ClientDTO.class);
    }

    public Client toEntity(ClientDTO dto) {
        return modelMapper.map(dto, Client.class);
    }

    public List<ClientDTO> toListDTO(List<Client> modelList) {
        return modelList.stream()
                .map(this::toDTO).collect(Collectors.toList());
    }

    public List<Client> toList(List<ClientDTO> dtosList) {
        return dtosList.stream()
                .map(this::toEntity).collect(Collectors.toList());
    }

}