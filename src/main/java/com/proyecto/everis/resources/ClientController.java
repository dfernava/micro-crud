package com.proyecto.everis.resources;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.proyecto.everis.service.IClientService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import io.swagger.annotations.ApiOperation;

import com.proyecto.everis.model.Client;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("clients")
public class ClientController {
	
	@Autowired
	private IClientService repository;
	
	@ApiOperation(
            value = "Agrega cliente",
            notes = "El parámetro de de tipo Client.class"
    )
	@CircuitBreaker(name="ms1", fallbackMethod = "findError")
	@TimeLimiter(name="ms1")
	@PostMapping()
	Mono<ResponseEntity<Client>> create(@Valid @RequestBody Client ClientsStream) {
		return this.repository.create(ClientsStream)
				.map(mapper->ResponseEntity.ok(mapper));
	}
	
	@ApiOperation(
            value = "Actualiza cliente",
            notes = "El parámetro de de tipo Client.class"
    )
	@CircuitBreaker(name="ms1", fallbackMethod = "findError")
	@TimeLimiter(name="ms1")
	@PutMapping()
	Mono<Client> update(@Valid @RequestBody Client ClientsStream) {
		return this.repository.create(ClientsStream);
	}
	
	@ApiOperation(
            value = "Lista todo cliente",
            notes = "No necesita parámetros"
    )
	@CircuitBreaker(name="ms1", fallbackMethod = "findError")
	@TimeLimiter(name="ms1")
	@GetMapping(produces="application/json")
	Flux<Client> list() {
		return repository.listAll();
	}
	
	@ApiOperation(
            value = "Lista un cliente por id",
            notes = "El parámetro es de tipo string"
    )
	@CircuitBreaker(name="ms1", fallbackMethod = "findError")
	@TimeLimiter(name="ms1")
	@GetMapping("/{id}")
	Mono<ResponseEntity<Client>> findById(@PathVariable String id) {
		return this.repository.findId(id).
				map(mapper->ResponseEntity.ok(mapper))
				.defaultIfEmpty(ResponseEntity.notFound().build());
	}
	
	@ApiOperation(
            value = "Elimina un cliente por id",
            notes = "El parámetro es de tipo string"
    )
	@CircuitBreaker(name="ms1", fallbackMethod = "findError")
	@TimeLimiter(name="ms1")
	@DeleteMapping("/{id}")
	Mono<Void> deleteById(@PathVariable String id) {
		return this.repository.delete(id);
	}
	
	@ApiOperation(
            value = "Elimina todo lo clientes",
            notes = "Utilizado para pruebas"
    )
	@CircuitBreaker(name="ms1", fallbackMethod = "findError")
	@TimeLimiter(name="ms1")
	@DeleteMapping
	Mono<Void> deleteAll() {
		return this.repository.deleteAll();
	}
	
	//Método de repsuesta del circuitbraker
	Mono<ResponseEntity<String>> findError(Exception ex){
		return Mono.just(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ha ocurrido un error intente en unos minutos"));
	}

}
