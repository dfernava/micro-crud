package com.proyecto.everis.model;

import org.springframework.data.mongodb.core.mapping.Document;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Document(collection = "client")
@ApiModel(description = "Información sobre la coleccionde clientes empresariales o personales")
public class Client {
	@ApiModelProperty(notes = "Id colocado cono números enteros en formato string")
	private String id;
	@ApiModelProperty(notes = "Tipo de documento de identidad del cliente: DNI, CE, RUC, etc")
	private String typeDoc;
	@ApiModelProperty(notes = "Tipo de cliente personal o empresarial")
	private String typeClient;
	@ApiModelProperty(notes = "Número del documento seleccionado en typeDoc")
	private String numDoc;	
	@ApiModelProperty(notes = "Nombre de cliente o razon social")
	private String nameClient;

}
