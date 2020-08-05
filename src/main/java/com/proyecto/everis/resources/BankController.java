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

import com.proyecto.everis.model.Bank;
import com.proyecto.everis.service.IBankService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import io.swagger.annotations.ApiOperation;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("banks")
public class BankController {
	
	@Autowired
	private IBankService service;
	
	@ApiOperation(
            value = "Agrega banco",
            notes = "El parámetro de de tipo Bank.class"
    )
	@CircuitBreaker(name="ms1", fallbackMethod = "findError")
	@TimeLimiter(name="ms1")
	@PostMapping()
	Mono<ResponseEntity<Bank>> create(@Valid @RequestBody Bank BanksStream) {
		return this.service.create(BanksStream)
				.map(mapper->ResponseEntity.ok(mapper));
	}
	
	@ApiOperation(
            value = "Actualiza banco",
            notes = "El parámetro de de tipo Bank.class"
    )
	@CircuitBreaker(name="ms1", fallbackMethod = "findError")
	@TimeLimiter(name="ms1")
	@PutMapping()
	Mono<Bank> update(@Valid @RequestBody Bank BanksStream) {
		return this.service.create(BanksStream);
	}
	
	@ApiOperation(
            value = "Lista todo banco",
            notes = "No necesita parámetros"
    )
	@CircuitBreaker(name="ms1", fallbackMethod = "findError")
	@TimeLimiter(name="ms1")
	@GetMapping(produces="application/json")
	Flux<Bank> list() {
		return service.listAll();
	}
	
	@ApiOperation(
            value = "Lista un banco por id",
            notes = "El parámetro es de tipo string"
    )
	@CircuitBreaker(name="ms1", fallbackMethod = "findError")
	@TimeLimiter(name="ms1")
	@GetMapping("/{id}")
	Mono<ResponseEntity<Bank>> findById(@PathVariable String id) {
		return this.service.findId(id).
				map(mapper->ResponseEntity.ok(mapper))
				.defaultIfEmpty(ResponseEntity.notFound().build());
	}
	
	@ApiOperation(
            value = "Elimina un banco por id",
            notes = "El parámetro es de tipo string"
    )
	@CircuitBreaker(name="ms1", fallbackMethod = "findError")
	@TimeLimiter(name="ms1")
	@DeleteMapping("/{id}")
	Mono<Void> deleteById(@PathVariable String id) {
		return this.service.delete(id);
	}
	
	@ApiOperation(
            value = "Elimina todo lo bancos",
            notes = "Utilizado para pruebas"
    )
	@CircuitBreaker(name="ms1", fallbackMethod = "findError")
	@TimeLimiter(name="ms1")
	@DeleteMapping
	Mono<Void> deleteAll() {
		return this.service.deleteAll();
	}
	
	//Método de repsuesta del circuitbraker
	Mono<ResponseEntity<String>> findError(Exception ex){
		return Mono.just(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ha ocurrido un error intente en unos minutos"));
	}

}