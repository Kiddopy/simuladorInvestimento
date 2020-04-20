package org.dbserver.sicredi.simulador.tasks;

import org.dbserver.sicredi.simulador.appObjects.SimuladorAppObject;
import org.dbserver.sicredi.simulador.utils.Auxi;
import org.dbserver.sicredi.simulador.utils.ExtentTestManager;
import org.openqa.selenium.WebDriver;
import org.dbserver.sicredi.simulador.utils.ScreenShot;
import org.dbserver.sicredi.simulador.utils.WaitDriver;

import com.aventstack.extentreports.Status;


public class SimuladorTask {
	
	private SimuladorAppObject simulador;
	private WaitDriver waitDriver;
	
	public SimuladorTask(WebDriver driver) {
		this.waitDriver = new WaitDriver(driver);
		this.simulador = new SimuladorAppObject(driver);
	}
	
	public void realizaSimulacao(String valorAplicar, String valorPoupar, String meses) {
		waitDriver.waitAllRequest();
		
		simulador.getValorParaAplicarTextField().sendKeys(valorAplicar);
		ExtentTestManager.log(Status.INFO, "Valor inserido para aplicar: " + valorAplicar);
		
		simulador.getValorPouparTextField().sendKeys(valorPoupar);
		ExtentTestManager.log(Status.INFO, "Valor inserido para poupar: " + valorPoupar);
		
		simulador.getTempoTextField().sendKeys(meses);
		ExtentTestManager.log(Status.INFO, "Valor inserido em meses: " + meses);
		
		simulador.getSimularButton().click();
		ExtentTestManager.log(Status.INFO, "Clique feito em 'Simular'");
	}

	public void verificaResultadoDaSimulacao(String meses) {
		waitDriver.waitAllRequest();
		
		String resultadoEsperadoDaSimulacao = "Em " + meses + " meses você terá guardado";
		String resultadoDaSimulacao = simulador.getResultadoSimulador().getText();
		
		if(resultadoEsperadoDaSimulacao.contentEquals(resultadoDaSimulacao)) {
			ExtentTestManager.log(Status.PASS, "O simulador exibiu um resultado!", ScreenShot.captureToBase64());
		}else {
			ExtentTestManager.log(Status.FAIL, "Ocorreu um erro ao exibir o resultado!", ScreenShot.captureToBase64());
		}
	}
	
	public void verificaErroDeValorMinimo() {
		boolean erroVisivel = !simulador.getValorInvestirError().isEmpty();
		if(erroVisivel) {
			ExtentTestManager.log(Status.PASS, "Erro de valor mínimo sendo exibido na tela corretamente", ScreenShot.captureToBase64());
		}else {
			ExtentTestManager.log(Status.FAIL, "O erro não aparece na tela.", ScreenShot.captureToBase64());
		}
	}
}
