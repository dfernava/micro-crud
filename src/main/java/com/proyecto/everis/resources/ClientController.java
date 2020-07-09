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

import com.proyecto.everis.model.Client;
import com.proyecto.everis.repository.ClientRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("clients")
public class ClientController {
	
	@Autowired
	private ClientRepository clientRepository;
	
	@PostMapping
	Mono<Client> create(@Valid @RequestBody Client client){
		return clientRepository.save(client);
	}
	
	@GetMapping(produces = "application/json")
	Flux<Client> listAll(){
		return clientRepository.findAll();
	}
	
	@GetMapping(produces = "application/json",value="/{id}")
	Mono<Client> listById(@PathVariable String id){
		return clientRepository.findById(id);
	}
	
	@PutMapping
	Mono<Client> update(@Valid @RequestBody Client client){
		return clientRepository.save(client);
	}
	
	@DeleteMapping(value="/{id}")
	Mono<Void> deleteById(@PathVariable String id) {
		return clientRepository.deleteById(id);
	}

}
