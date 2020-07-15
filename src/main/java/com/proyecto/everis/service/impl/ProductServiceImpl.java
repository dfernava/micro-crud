package com.proyecto.everis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.everis.model.Product;
import com.proyecto.everis.repository.ProductRepository;
import com.proyecto.everis.service.IProductService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductServiceImpl implements IProductService{
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public Mono<Product> create(Product t) {
		// TODO Auto-generated method stub
		return productRepository.save(t);
	}

	@Override
	public Mono<Product> update(Product t) {
		// TODO Auto-generated method stub
		return productRepository.save(t);
	}

	@Override
	public Mono<Void> delete(String id) {
		// TODO Auto-generated method stub
		return productRepository.deleteById(id);
	}

	@Override
	public Mono<Product> finId(String id) {
		// TODO Auto-generated method stub
		return productRepository.findById(id);
	}

	@Override
	public Flux<Product> listAll() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}

	@Override
	public Mono<Void> deleteAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
