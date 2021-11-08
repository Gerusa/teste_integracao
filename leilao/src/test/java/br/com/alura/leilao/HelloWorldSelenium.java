package br.com.alura.leilao;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Teste Automatizado com Selenium. Foi adicionada dependência no maven
 * (org.seleniumhq.selenium), e o webDriver do chrome na pasta de drivers deste
 * projeto.
 * O driver serve como ponte entre a api do selenium e o navegador.
 *
 *Obs: a aplicação tem que estar rodando para executar o teste, através de Run As Junit
 */
public class HelloWorldSelenium {

	/**
	 * Teste com JUnit.
	 */
	@Test
	public void Hello() {
		// informa para o selenium onde está o driver do chrome
		System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");

		// abre o navegador
		WebDriver browser = new ChromeDriver();
		// acessa a aplicação
		browser.navigate().to("http://localhost:8080/leiloes");
		// fecha o navegador
		browser.quit();

	}

}
