package com.proyecto.everis.model;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Document(collection = "client")
public class Client {
	
	private String id;
	private String typeDoc;
	private String typeClient;
	private String numDoc;	
	private String nameClient;

}
