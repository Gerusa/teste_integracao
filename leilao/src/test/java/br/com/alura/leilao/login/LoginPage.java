package br.com.alura.leilao.login;

import org.openqa.selenium.By;

import br.com.alura.leilao.PageObject;
import br.com.alura.leilao.leiloes.LeiloesPage;

/**
 * Utilização do padrão Page Object. Ao utilizar este padrão favorecemos a
 * separação de responsabilidades entre os códigos de testes e de utilização da
 * API do Selenium WebDriver. Ou seja, aqui não tem nenhum acesso à api do
 * JUnit, e na classe de teste, não tem nada referente à api do Selenium.
 *
 */
public class LoginPage extends PageObject {

	private static final String TELA_LOGIN = "http://localhost:8080/leiloes/login";
	private static final String TELA_LOGIN_ERRO = "http://localhost:8080/login?error";

	public LoginPage() {
		super(null);
		// acessa a funcionalidade de login
		browser.navigate().to(TELA_LOGIN);
	}

	public void preencherFormularioLogin(String userName, String password) {
		// preenche o usuário
		browser.findElement(By.id("username")).sendKeys(userName);

		// preenche a senha
		browser.findElement(By.id("password")).sendKeys(password);

	}

	public LeiloesPage efetuarLogin() {
		// envia os dados
		browser.findElement(By.id("login-form")).submit();

		return new LeiloesPage(this.browser);
	}

	public boolean isPaginaDeLogin() {
		return browser.getCurrentUrl().equals(TELA_LOGIN);
	}

	public String getNomeUsuarioLogado() {
		return browser.findElement(By.id("usuario-logado")).getText();
	}

	public boolean isPaginaDeLoginErro() {
		return browser.getCurrentUrl().equals(TELA_LOGIN_ERRO);
	}

	public boolean isUsuarioInvalido() {
		return browser.getPageSource().contains("Usuário e senha inválidos.");
	}

	public void acessarLeilao() {
		browser.navigate().to("http://localhost:8080/leiloes/2");
	}

	public boolean isPaginaSolicitacaoDeLogin() {
		return browser.getCurrentUrl().equals("http://localhost:8080/login");
	}

	public boolean isPaginaDeLeilao() {
		return browser.getPageSource().contains("Dados do Leilão");
	}

}
