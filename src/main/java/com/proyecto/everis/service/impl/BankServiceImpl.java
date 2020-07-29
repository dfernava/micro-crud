package com.proyecto.everis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.everis.model.Bank;
import com.proyecto.everis.repository.IBankRepository;
import com.proyecto.everis.service.IBankService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class BankServiceImpl implements IBankService  {
	
	@Autowired
	private IBankRepository repository;

	@Override
	public Mono<Bank> create(Bank t) {
		// TODO Auto-generated method stub
		return repository.save(t);
	}

	@Override
	public Mono<Bank> update(Bank t) {
		// TODO Auto-generated method stub
		return repository.save(t);
	}

	@Override
	public Mono<Void> delete(String id) {
		// TODO Auto-generated method stub
		return repository.deleteById(id);
	}

	@Override
	public Mono<Bank> findId(String id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}

	@Override
	public Flux<Bank> listAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Mono<Void> deleteAll() {
		// TODO Auto-generated method stub
		return repository.deleteAll();
	}

}