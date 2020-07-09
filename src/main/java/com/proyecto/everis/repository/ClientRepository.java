package com.proyecto.everis.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.proyecto.everis.model.Client;

public interface ClientRepository extends ReactiveMongoRepository<Client, String> {

}
