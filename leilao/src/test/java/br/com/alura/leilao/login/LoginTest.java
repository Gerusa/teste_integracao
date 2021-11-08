package br.com.alura.leilao.login;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Teste Automatizado da funcionalidade de Login.
 */
public class LoginTest {

	private static final String USUARIO_FULANO = "fulano";
	private static final String SENHA_USUARIO = "pass";
	private static final String TELA_LOGIN = "http://localhost:8080/leiloes/login";

	@Test
	public void deveriaEfetuarLoginComDadosValidos() {

		// informa para o selenium onde está o driver do chrome
		System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");

		// abre o navegador
		WebDriver browser = new ChromeDriver();

		// acessa a funcionalidade de login
		browser.navigate().to(TELA_LOGIN);

		// preenche o usuário
		browser.findElement(By.id("username")).sendKeys(USUARIO_FULANO);

		// preenche a senha
		browser.findElement(By.id("password")).sendKeys(SENHA_USUARIO);

		// envia os dados
		browser.findElement(By.id("login-form")).submit();

		// confere se não está mais na tela de login
		Assert.assertFalse(browser.getCurrentUrl().equals(TELA_LOGIN));

		// confere o nome do usuário logado que aparece na barra superior da tela após
		// login
		Assert.assertEquals(USUARIO_FULANO, browser.findElement(By.id("usuario-logado")).getText());

		// fecha o navegador
		browser.quit();
	}

}
