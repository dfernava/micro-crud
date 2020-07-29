package com.proyecto.everis.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.proyecto.everis.model.Bank;

public interface IBankRepository extends ReactiveMongoRepository<Bank, String>{

}
