package com.metatelecom.crud.controllers;


import com.metatelecom.crud.dtos.ClientDTO;
import com.metatelecom.crud.services.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService service;

    @GetMapping
    public ResponseEntity<List<ClientDTO>> findAll() {
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(service.findById(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody ClientDTO clientDTO) {
        service.save(clientDTO);
    }

    @PutMapping("/updateClient/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updatePlayer(@PathVariable long id,@RequestBody ClientDTO dto) {
        service.updatePlayer(id, dto);
    }

    @DeleteMapping("/deleteClient/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePlayer(@PathVariable Long id) {
        service.deleteClient(id);
    }

}