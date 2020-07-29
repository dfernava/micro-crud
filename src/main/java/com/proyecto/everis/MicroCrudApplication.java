package com.proyecto.everis;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableDiscoveryClient
@EnableSwagger2
@ComponentScan("com.proyecto.everis.*")
@EnableJpaRepositories("com.proyecto.everis.*")
@EnableReactiveMongoRepositories(basePackages = {"com.proyecto.everis.repository","com.proyecto.everis.resource"})
public class MicroCrudApplication extends AbstractReactiveMongoConfiguration {

	public static void main(String[] args) {
		SpringApplication.run(MicroCrudApplication.class, args);
	}
	
	@Value("${app.db}")
	private String db;
	
	
	@Bean
	public MongoClient mongoClient() {
		return MongoClients.create();
	}
	
	@Override
	protected String getDatabaseName() {
		return db;
	}
	
	@Bean
	public Docket swaggerPersonApi10() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
					.apis(RequestHandlerSelectors.basePackage("com.proyecto.everis.resources"))
					.paths(PathSelectors.any())
				.build()
				.apiInfo(new ApiInfoBuilder().version("1.0").title("Employee API").description("Documentation Employee API v1.0").build());
	}

}
