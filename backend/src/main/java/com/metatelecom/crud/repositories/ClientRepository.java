package com.metatelecom.crud.repositories;

import com.metatelecom.crud.domains.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Long> {
}