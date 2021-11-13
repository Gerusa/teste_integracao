package br.com.alura.leilao.leiloes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Utilização do padrão Page Object. Ao utilizar este padrão favorecemos a
 * separação de responsabilidades entre os códigos de testes e de utilização da
 * API do Selenium WebDriver. Ou seja, aqui não tem nenhum acesso à api do
 * JUnit, e na classe de teste, não tem nada referente à api do Selenium.
 *
 */
public class CadastroLeilaoPage {
	
	private WebDriver browser;

	public CadastroLeilaoPage(WebDriver browser) {
		this.browser = browser;
	}
	
	public void fecharBrowser() {
		this.browser.quit();
	}

	public LeiloesPage cadastrarLeilao(String nome, String valorInicial, String dataAbertura) {
		browser.findElement(By.id("nome")).sendKeys(nome);
		browser.findElement(By.id("valorInicial")).sendKeys(valorInicial);
		browser.findElement(By.id("dataAbertura")).sendKeys(dataAbertura);
		
		browser.findElement(By.id("button-submit")).submit();
		
		return new LeiloesPage(browser);
	}

}
