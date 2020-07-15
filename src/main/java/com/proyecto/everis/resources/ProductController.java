package com.proyecto.everis.resources;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.everis.model.Product;
import com.proyecto.everis.service.impl.ProductServiceImpl;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("products")
public class ProductController {
	
	@Autowired
	private ProductServiceImpl productRepository;
	
	@PostMapping
	Mono<Product> create(@Valid @RequestBody Product Product){
		return productRepository.create(Product);
	}
	
	@GetMapping(produces = "application/json")
	Flux<Product> listAll(){
		return productRepository.listAll();
	}
	
	@GetMapping(produces = "application/json",value="/{id}")
	Mono<Product> listById(@PathVariable String id){
		return productRepository.finId(id);
	}
	
	@PutMapping
	Mono<Product> update(@Valid @RequestBody Product Product){
		return productRepository.update(Product);
	}
	
	@DeleteMapping(value="/{id}")
	Mono<Void> deleteById(@PathVariable String id) {
		return productRepository.delete(id);
	}

}