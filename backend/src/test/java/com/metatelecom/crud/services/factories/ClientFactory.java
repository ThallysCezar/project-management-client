package com.metatelecom.crud.services.factories;

import com.metatelecom.crud.domains.Client;
import com.metatelecom.crud.dtos.ClientDTO;

public class ClientFactory {


    public static Client createValidClient() {
        Client client = new Client();
        client.setId(1L);
        client.setName("Cliente ativo 1");
        client.setContactNumber("123456789");
        client.setAddress("Rua ABC 123");
        client.setGender("Masculino");
        client.setDepartment("Back-end");
        client.setSkills("Java, Angular, SpringBoot");
        client.setIsActive(true);

        return client;
    }

    public static ClientDTO createValidClientDTO() {
        ClientDTO clientDTO = new ClientDTO();
        clientDTO.setId(1L);
        clientDTO.setName("Cliente ativo 1");
        clientDTO.setContactNumber("123456789");
        clientDTO.setAddress("Rua ABC 123");
        clientDTO.setGender("Masculino");
        clientDTO.setDepartment("Back-end");
        clientDTO.setSkills("Java, Angular, SpringBoot");
        clientDTO.setIsActive(true);

        return clientDTO;
    }

}