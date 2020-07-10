package com.proyecto.everis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration;

import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;

@SpringBootApplication
@EnableDiscoveryClient
public class MicroCrudApplication extends AbstractReactiveMongoConfiguration {

	public static void main(String[] args) {
		SpringApplication.run(MicroCrudApplication.class, args);
	}
	
	@Bean
	public MongoClient mongoClient() {
		return MongoClients.create();
	}
	
	@Override
	protected String getDatabaseName() {
		return "reactive";
	}

}
