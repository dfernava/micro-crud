package com.proyecto.everis.model;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.data.mongodb.core.mapping.Document;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Document( collection ="client" )
@Data
@ApiModel(description = "Clase de la colección cliente, puede ser personal, personal vip o empresarial")
public class Client {
			
			@ApiModelProperty(notes = "ID del cliente único")
         private String id;
			
			@ApiModelProperty(notes = "Tipo de documento del cliente tal como: DNI, CE, RUC, etc")
			@NotNull
         private String typeDoc;
			
			@ApiModelProperty(notes = "Nombre completo del cliente personal, nulo en cliente empresarial")
         private String nameClient;
			
			@ApiModelProperty(notes = "Nombre según registro de cliente empresarial, nulo en cliente pesrsonal")
	     private String razonSocial;
			
			@ApiModelProperty(notes = "Número del tipo de documento")
			@NotNull
			@Size(min = 8, max = 12, message = "numero de documento minimo 8")
			@Pattern(regexp = ".*([0-9]$)", message = "Solo debe contener dígitos")
         private String numDoc;
			
			@ApiModelProperty(notes = "Tipo de cliente puede ser empresarial o personal")
			@NotNull
         private String typeClient;
			
			@ApiModelProperty(notes = "Condición de cliente: personal normal o vip y empresarial mype o corporativo")
			@NotNull
	     private String conditionClient;
		
}