package com.proyecto.everis.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.proyecto.everis.model.Product;
import com.proyecto.everis.resources.ClientController;
import com.proyecto.everis.service.impl.ProductServiceImpl;

import reactor.core.publisher.Mono;

@WebFluxTest(controllers = ClientController.class)
public class ProductControllerTest {
	
	@Autowired
	private WebTestClient webTestClient;
	
	@Autowired
	private ProductServiceImpl productRepository;
	
	@Test
	public void createClient() {
		Product pr=new Product();
		pr.setId("1");
		pr.setTypeProduct("CREDITO");
		pr.setNameProduct("TARJETA VISA");
		productRepository.deleteAll();
		
		webTestClient.post().uri("/products")
		.accept(MediaType.APPLICATION_JSON)
		.body(Mono.just(pr),Product.class)
		.exchange()
		.expectStatus().isOk()
		.expectHeader().valueEquals("Content-Type", MediaType.APPLICATION_JSON.toString())
		.expectBody()
		.jsonPath("$.nameProduct", "TARJETA VISA");
	}
	
	@Test
	public void listProduct() {
		webTestClient.get().uri("/products")
				.exchange()
				.expectStatus().isOk()
				.expectHeader().valueEquals("Content-Type", MediaType.APPLICATION_JSON.toString())
				.expectBodyList(Product.class).hasSize(1);
			     
               
	}
	
	@Test
	public void listOneClient() {
		webTestClient.get().uri("/products/{id}",1)
			.exchange()
	        .expectStatus().isOk()
	        .expectHeader().valueEquals("Content-Type", MediaType.APPLICATION_JSON.toString())
	        .expectBody()
	        .jsonPath("$.nameProduct").isEqualTo("TARJETA VISA");      
	}
	
	@Test
	public void updateProduct() {
		Product pr=new Product();
		pr.setId("1");
		pr.setTypeProduct("CREDITO");
		pr.setNameProduct("TARJETA MC");
		productRepository.deleteAll();
		
		webTestClient.put().uri("/products")
		.accept(MediaType.APPLICATION_JSON)
		.body(Mono.just(pr),Product.class)
		.exchange()
		.expectStatus().isOk()
		.expectHeader().valueEquals("Content-Type", MediaType.APPLICATION_JSON.toString())
		.expectBody()
		.jsonPath("$.nameProduct", "TARJETA MC");
	              
	}
	
	@Test
	public void deleteOne() {
		webTestClient.delete()
        .uri("/products/1")
        .exchange()
        .expectStatus().isOk()
        .expectBody(String.class);
	}
	
	@Test
	public void deleteAll() {
		webTestClient.delete()
        .uri("/products")
        .exchange()
        .expectStatus().isOk()
        .expectBody(String.class);
	}
	
	
}