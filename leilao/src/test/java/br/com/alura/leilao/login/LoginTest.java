package br.com.alura.leilao.login;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Teste Automatizado da funcionalidade de Login.
 */
public class LoginTest {

	private WebDriver browser;

	private static final String USUARIO_FULANO = "fulano";
	private static final String SENHA_USUARIO = "pass";
	private static final String TELA_LOGIN = "http://localhost:8080/leiloes/login";
	private static final String TELA_LOGIN_ERRO = "http://localhost:8080/login?error";

	// Roda antes de todos os testes, uma única vez
//	@BeforeAll
//	public void beforeAll() {
//		// informa para o selenium onde está o driver do chrome
//		System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
//	}

	@BeforeEach
	public void beforeEach() {
		// informa para o selenium onde está o driver do chrome
		System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
				
		// abre o navegador
		this.browser = new ChromeDriver();

		// acessa a funcionalidade de login
		browser.navigate().to(TELA_LOGIN);

	}

	@AfterEach
	public void afterEach() {
		// fecha o navegador
		browser.quit();

	}

	@Test
	public void deveriaEfetuarLoginComDadosValidos() {

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

	}

	@Test
	public void naoDeveriaEfetuarLoginComDadosInvalidos() {

		// preenche o usuário
		browser.findElement(By.id("username")).sendKeys("invalido");

		// preenche a senha
		browser.findElement(By.id("password")).sendKeys(SENHA_USUARIO);

		// envia os dados
		browser.findElement(By.id("login-form")).submit();

		// confere se está na tela de login com erro
		Assert.assertTrue(browser.getCurrentUrl().equals(TELA_LOGIN_ERRO));

		// confere se a página está apresentando a validação
		Assert.assertTrue(browser.getPageSource().contains("Usuário e senha inválidos."));

	}
	
	@Test
	public void naoDeveriaAcessarPaginaRestritaSemEstarLogado() {
		//tenta acessar um leilão, sem realizar login
		browser.navigate().to("http://localhost:8080/leiloes/2");
		
		//deve estar na tela de login
		Assert.assertTrue(browser.getCurrentUrl().equals("http://localhost:8080/login"));
		
		//a página não pode conter Dados do Leilão
		Assert.assertFalse(browser.getPageSource().contains("Dados do Leilão"));
	}

}
