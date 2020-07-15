package com.proyecto.everis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.everis.model.Client;
import com.proyecto.everis.repository.ClientRepository;
import com.proyecto.everis.service.IClientService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ClientServiceImpl implements IClientService{
	
	@Autowired
	private ClientRepository clientRepository;

	@Override
	public Mono<Client> create(Client t) {
		// TODO Auto-generated method stub
		return clientRepository.save(t);
	}

	@Override
	public Mono<Client> update(Client t) {
		// TODO Auto-generated method stub
		return clientRepository.save(t);
	}

	@Override
	public Mono<Void> delete(String id) {
		// TODO Auto-generated method stub
		return clientRepository.deleteById(id);
	}

	@Override
	public Mono<Client> finId(String id) {
		// TODO Auto-generated method stub
		return clientRepository.findById(id);
	}

	@Override
	public Flux<Client> listAll() {
		// TODO Auto-generated method stub
		return clientRepository.findAll();
	}

	@Override
	public Mono<Void> deleteAll() {
		// TODO Auto-generated method stub
		return clientRepository.deleteAll();
	}

}
