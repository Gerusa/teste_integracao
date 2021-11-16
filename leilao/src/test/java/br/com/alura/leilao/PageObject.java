package br.com.alura.leilao;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PageObject {

	protected WebDriver browser;

	public PageObject(final WebDriver browser) {
		// informa para o selenium onde está o driver do chrome
		System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");

		this.browser = browser == null ? new ChromeDriver() : browser;

		// realiza configurações no webdriver
		this.browser.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS) // espera 5 segundos para encontrar um
																				// elemento na página
				.pageLoadTimeout(10, TimeUnit.SECONDS); // espera 10 segundos para carregar uma página
		
		// para saber q existe essas possibilidades
		// ajuda a lidar com requisições ajax ou códigos javaScript que podem
		// adiar o carregamento de elementos na página
	}

	public void fecharBrowser() {
		// fecha o navegador
		browser.quit();
	}

}
