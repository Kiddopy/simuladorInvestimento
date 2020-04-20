package org.dbserver.sicredi.simulador.utils;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import org.dbserver.sicredi.simulador.utils.Browsers;

public class TestBase {
	
	public WebDriver driver;
	public Properties links;
	public Auxi auxi;
	
	@BeforeClass
	public void setUp() throws IOException {
		this.auxi = new Auxi();
		links = auxi.getProperties("config.properties");
		
		this.driver = Browsers.carregaDriver("chrome");
	    this.driver.get(links.getProperty("linkAplicacao"));
	    this.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    this.driver.manage().window().maximize();
	   
		
	}
	
	@AfterClass
	public void tearDown() {
		this.driver.close();
	}

}
