package com.proyecto.everis.model;

import javax.validation.constraints.NotNull;

import org.springframework.data.mongodb.core.mapping.Document;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Document( collection ="product" )
@Data
@ApiModel(description = "Clase de la colección de producto, puede ser cuentas o créditos")
public class Product {
	
	@ApiModelProperty(notes = "ID del producto único")
	private String id;	
	@ApiModelProperty(notes = "Nombre comercial del producto")
	@NotNull
	private String nameProduct;	
	@ApiModelProperty(notes = "Tipo de producto: Crédito o cuenta")
	@NotNull
	private String typeProduct;

}
