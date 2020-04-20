package org.dbserver.sicredi.simulador.testCases;

import org.dbserver.sicredi.simulador.tasks.SimuladorTask;
import org.dbserver.sicredi.simulador.utils.HTTPRequests;
import org.dbserver.sicredi.simulador.utils.TestBase;
import org.dbserver.sicredi.simulador.utils.ValoresInvestimento;
import org.testng.annotations.Test;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SimuladorInvestimentoTestCase extends TestBase {
	 
	
	@Test
	public void simuladorDeInvestimento() throws Exception {
		
		SimuladorTask simulador = new SimuladorTask(driver);
		
		HTTPRequests request = new HTTPRequests();
		ObjectMapper mapper = new ObjectMapper();
		
		ValoresInvestimento valores = mapper.readValue(request.sendGet(links.getProperty("api")), ValoresInvestimento.class);
		
		for(String valor : valores.valoresAplicar){
			for(String mes : valores.tempo) {
				simulador.realizaSimulacao(valor, valor, mes);
				simulador.verificaResultadoDaSimulacao(mes);
				driver.navigate().refresh();
			}
		}
	
	}
	



}
