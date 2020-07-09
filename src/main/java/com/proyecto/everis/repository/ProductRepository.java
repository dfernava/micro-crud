package com.proyecto.everis.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.proyecto.everis.model.Product;

public interface ProductRepository extends ReactiveMongoRepository<Product, String> {

}
