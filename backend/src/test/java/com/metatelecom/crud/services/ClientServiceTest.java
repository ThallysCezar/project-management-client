package com.metatelecom.crud.services;

import com.metatelecom.crud.domains.Client;
import com.metatelecom.crud.dtos.ClientDTO;
import com.metatelecom.crud.exceptions.ClientException;
import com.metatelecom.crud.mappers.ClientMapper;
import com.metatelecom.crud.repositories.ClientRepository;
import com.metatelecom.crud.services.factories.ClientFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.*;

@DisplayName("Service de Client")
public class ClientServiceTest {

    private ClientRepository repository;
    private ClientService sut;
    private ClientMapper mapper;

    @BeforeEach
    void inicializarMocks() {
        this.repository = Mockito.mock(ClientRepository.class);
        this.mapper = Mockito.mock(ClientMapper.class);
        this.sut = new ClientService(repository, mapper);
    }

    //cenario feliz findAll
    @Test
    @DisplayName("Deve retornar todos os clientes")
    void deveRetornarTodosClientes() {
        List<Client> clientList = Arrays.asList(new Client(), new Client());
        List<ClientDTO> clientListDTO = Arrays.asList(new ClientDTO(), new ClientDTO());

        Mockito.when(repository.findAll()).thenReturn(clientList);
        Mockito.when(mapper.toListDTO(clientList)).thenReturn(clientListDTO);

        final var retorno = sut.findAll();

        Assertions.assertEquals(clientListDTO, retorno);
        Mockito.verify(repository, Mockito.times(1)).findAll();
        Mockito.verify(mapper, Mockito.times(1)).toListDTO(clientList);
    }

    //cenario triste findAll
    @Test
    @DisplayName("Deve lançar QuestionException quando houver erro ao procurar todas as questões por paginas")
    void deveLancarClientExceptionErroAoBuscarTodosClientes() {
        List<Client> clientList = new ArrayList<>(Collections.emptyList());
        Mockito.when(repository.findAll()).thenReturn(clientList);

        final var excecao = Assertions.assertThrows(ClientException.class, () ->
                sut.findAll());

        Mockito.verify(repository, Mockito.times(1)).findAll();
        Assertions.assertEquals("Nenhuma alternativa de pergunta encontrada.", excecao.getMessage());
    }


    //cenario feliz findById
    @Test
    @DisplayName("Deve retornar um client ao procurar por id")
    void deveRetornarQuestaoAoProcurarClientPorId() {
        final var id = 1L;
        final var clientEntity = new Client();
        clientEntity.setId(id);

        final var clientDTO = new ClientDTO();
        clientDTO.setId(id);

        Mockito.when(repository.findById(Mockito.anyLong())).thenReturn(Optional.of(clientEntity));
        Mockito.when(repository.existsById(id)).thenReturn(true);
        Mockito.when(mapper.toDTO(clientEntity)).thenReturn(clientDTO);

        final var retorno = sut.findById(id);

        Assertions.assertEquals(clientEntity.getId(), retorno.getId());
        Mockito.verify(repository, Mockito.times(1)).findById(id);
        Mockito.verify(mapper, Mockito.times(1)).toDTO(clientEntity);
    }

    //cenario triste findById
    @Test
    @DisplayName("Deve lançar IllegalArgumentException quando houver erro ao procurar por cliente por id")
    void deveLancarIllegalArgumentExceptionErroAoProcurarClientePorId() {
        final Long id = null;
        Mockito.when(repository.findById(null)).thenThrow(new IllegalArgumentException("O ID não pode ser nulo, tente novamente."));

        final var excecao = Assertions.assertThrows(IllegalArgumentException.class, () ->
                sut.findById(id));

        Assertions.assertEquals("O ID não pode ser nulo, tente novamente.", excecao.getMessage());
    }

    //cenario triste findById
    @Test
    @DisplayName("Deve lançar ClientException quando houver erro ao procurar por cliente por id")
    void deveLancarClientExceptionErroAoProcurarClientePorId() {
        final Long id = 9999L;
        Mockito.when(repository.findById(id)).thenThrow(new ClientException("Erro ao tentar procurar um cliente"));
        Mockito.when(repository.existsById(id)).thenReturn(true);

        final var excecao = Assertions.assertThrows(ClientException.class, () ->
                sut.findById(id));

        Assertions.assertEquals("Erro ao tentar procurar um cliente", excecao.getMessage());
    }

    //cenario feliz update
    @Test
    @DisplayName("Deve retornar um cliente atualizado por id")
    void deveRetornarUmClienteAtualizadoPorId() {
        final var clientDTO = ClientFactory.createValidClientDTO();
        clientDTO.setId(1L);
        clientDTO.setName("Test Name");
        clientDTO.setContactNumber("123456789");
        clientDTO.setAddress("Rua ABC 123");
        clientDTO.setGender("Masculino");
        clientDTO.setDepartment("Back-end");
        clientDTO.setSkills("Java, Angular, SpringBoot");
        clientDTO.setIsActive(true);

        final var clientEntity = ClientFactory.createValidClient();
        clientEntity.setId(1L);
        clientEntity.setName("Old Name");

        Mockito.when(repository.findById(Mockito.anyLong())).thenReturn(Optional.of(clientEntity));
        Mockito.when(repository.save(Mockito.any(Client.class))).thenReturn(clientEntity);
        Mockito.when(mapper.toDTO(clientEntity)).thenReturn(clientDTO);

        final var retorno = sut.updatePlayer(1L, clientDTO);

        Assertions.assertEquals("Test Name", retorno.getName());
        Mockito.verify(repository, Mockito.times(1)).findById(Mockito.anyLong());
        Mockito.verify(repository, Mockito.times(1)).save(Mockito.any(Client.class));
        Mockito.verify(mapper, Mockito.times(1)).toDTO(clientEntity);
    }

    //cenario feliz delete
    @Test
    @DisplayName("Deve deletar um cliente por id")
    void deveDeletarClientePorId() {
        final var clientDTO = ClientFactory.createValidClientDTO();
        clientDTO.setId(1L);

        final var clientEntity = ClientFactory.createValidClient();
        clientEntity.setId(1L);

        Mockito.when(repository.existsById(1L)).thenReturn(true);
        Mockito.when(mapper.toDTO(clientEntity)).thenReturn(clientDTO);

        sut.deleteClient(1L);

        Mockito.verify(repository, Mockito.times(1)).deleteById(1L);
    }

    //cenario triste delete
    @Test
    @DisplayName("Deve lançar IllegalArgumentException quando houver erro ao deletar cliente por id")
    void deveLancarIllegalArgumentExceptionErroAoDeleterClientePorId() {
        final Long id = null;
        Mockito.when(repository.findById(null)).thenThrow(new IllegalArgumentException("O ID não pode ser nulo, tente novamente."));

        final var excecao = Assertions.assertThrows(IllegalArgumentException.class, () ->
                sut.deleteClient(id));

        Assertions.assertEquals("O ID não pode ser nulo, tente novamente.", excecao.getMessage());
    }

    //cenario triste delete
    @Test
    @DisplayName("Deve lançar ClientException quando houver erro ao procurar por usuario por id")
    void deveLancarClientExceptionAoDeletarClientePorId() {
        final Long id = 1L;
        Mockito.when(repository.existsById(id)).thenReturn(false);

        final var excecao = Assertions.assertThrows(ClientException.class, () ->
                sut.deleteClient(id));

        Mockito.verify(repository, Mockito.times(1)).existsById(id);
        Assertions.assertEquals(String.format("Cliente não encontrado com o id '%s'.", id), excecao.getMessage());
    }

}
