package org.dbserver.sicredi.simulador.appObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SimuladorAppObject {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	public SimuladorAppObject(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 20);
	}
	
	public WebElement getValorParaAplicarTextField() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("valorAplicar")));
	}
	
	public WebElement getValorPouparTextField() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("valorInvestir")));
	}
	
	public WebElement getTempoTextField() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tempo")));
	}
	
	public WebElement getSimularButton() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#formInvestimento > div.simuladorOpcoes.clearfix > ul > li.simular > button")));
	}
	
	public WebElement getResultadoSimulador() {
		return driver.findElement(By.xpath("/html/body/div[3]/div/div/div[1]/div/div[2]/span[1]"));
	}
	
	public List<WebElement> getValorInvestirError() {
		return driver.findElements(By.id("valorAplicar-error"));
	}

}
