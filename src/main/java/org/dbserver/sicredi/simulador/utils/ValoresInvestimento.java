package org.dbserver.sicredi.simulador.utils;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ValoresInvestimento {
	   
	  @JsonProperty("id")
	  public String id;
	
	  @JsonProperty("valor")
	  public List<String> valoresAplicar;
	  
	  @JsonProperty("meses")
	  public List<String> tempo;
	  

}
