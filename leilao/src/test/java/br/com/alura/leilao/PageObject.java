package br.com.alura.leilao;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PageObject {

	protected WebDriver browser;

	public PageObject(final WebDriver browser) {
		// informa para o selenium onde está o driver do chrome
		System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");

		this.browser = browser == null ? new ChromeDriver() : browser;
	}

	public void fecharBrowser() {
		// fecha o navegador
		browser.quit();
	}

}
