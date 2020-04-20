package org.dbserver.sicredi.simulador.testCases;

import org.dbserver.sicredi.simulador.tasks.SimuladorTask;
import org.dbserver.sicredi.simulador.utils.TestBase;
import org.testng.annotations.Test;

public class SimuladorInvestimentoFalhaTestCase extends TestBase{
	
    @Test
    private void simuladorInvestimentoComFalha() {
    	SimuladorTask simulador = new SimuladorTask(driver);
    	simulador.realizaSimulacao("00", "00", "12");
    	simulador.verificaErroDeValorMinimo();
    }

}
