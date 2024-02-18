package com.metatelecom.crud.services;

import com.metatelecom.crud.domains.Client;
import com.metatelecom.crud.dtos.ClientDTO;
import com.metatelecom.crud.exceptions.ClientException;
import com.metatelecom.crud.mappers.ClientMapper;
import com.metatelecom.crud.repositories.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;

    private final ClientMapper clientMapper;

    public List<ClientDTO> findAll() {
        List<Client> clients = clientRepository.findAll();
        if (clients.isEmpty()) {
            throw new ClientException("Nenhuma alternativa de pergunta encontrada.");
        }
        return clientMapper.toListDTO(clients);
    }

    public ClientDTO findById(Long id) {
        if (Objects.isNull(id)) {
            throw new IllegalArgumentException("O ID não pode ser nulo, tente novamente.");
        }
        if (!clientRepository.existsById(id)) {
            throw new ClientException(String.format("Cliente não encontrado com o id '%s'.", id));

        }
        return clientRepository.findById(id)
                .map(clientMapper::toDTO)
                .orElseThrow(() -> new ClientException("Erro ao tentar procurar um cliente"));
    }

    public ClientDTO save(ClientDTO clientDTO) {
        try {
            return clientMapper.toDTO(clientRepository.save(clientMapper.toEntity(clientDTO)));
        } catch (ClientException exQuestionAlternative) {
            throw new ClientException("Erro ao tentar salvar a alternativa");
        }
    }

    public ClientDTO updatePlayer(Long id, ClientDTO clientDTO) {
        try {
            Client existingClient = clientRepository.findById(id)
                    .orElseThrow(() -> new ClientException("Cliente não encontrado com ID: " + id));

            existingClient.setName(clientDTO.getName());
            existingClient.setContactNumber(clientDTO.getContactNumber());
            existingClient.setAddress(clientDTO.getAddress());
            existingClient.setGender(clientDTO.getGender());
            existingClient.setDepartment(clientDTO.getDepartment());
            existingClient.setSkills(clientDTO.getSkills());
            existingClient.setIsActive(clientDTO.getIsActive());

            return clientMapper.toDTO(clientRepository.save(existingClient));
        } catch (Exception ex) {
            throw new ClientException("Erro ao atualizar o cliente.");
        }
    }

    public void deleteClient(Long id) {
        if (Objects.isNull(id)) {
            throw new IllegalArgumentException("O ID não pode ser nulo, tente novamente.");
        }
        if (!clientRepository.existsById(id)) {
            throw new ClientException(String.format("Cliente não encontrado com o id '%s'.", id));

        }
        clientRepository.deleteById(id);
    }

}