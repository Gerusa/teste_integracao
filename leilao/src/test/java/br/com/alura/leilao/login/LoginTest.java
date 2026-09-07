package br.com.alura.leilao.login;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Teste Automatizado da funcionalidade de Login.
 */
public class LoginTest {

	// utilizando o padrão Page Object. Dessa forma, há uma separação entre o JUnit
	// e o Selenium.
	private LoginPage paginaDeLogin;

	@BeforeEach
	public void beforeEach() {
		this.paginaDeLogin = new LoginPage();
	}

	@AfterEach
	public void afterEach() {
		this.paginaDeLogin.fecharBrowser();
	}

	@Test
	public void deveriaEfetuarLoginComDadosValidos() {
		this.paginaDeLogin.preencherFormularioLogin("fulano", "pass");

		this.paginaDeLogin.efetuarLogin();

		// confere se não está mais na tela de login
		Assertions.assertFalse(this.paginaDeLogin.isPaginaDeLogin());

		// confere o nome do usuário logado que aparece na barra superior da tela após
		// login
		Assertions.assertEquals("fulano", this.paginaDeLogin.getNomeUsuarioLogado());

	}

	@Test
	public void naoDeveriaEfetuarLoginComDadosInvalidos() {
		this.paginaDeLogin.preencherFormularioLogin("invalido", "pass");

		this.paginaDeLogin.efetuarLogin();

		Assertions.assertTrue(this.paginaDeLogin.isPaginaDeLoginErro());

		// confere se a página está apresentando a validação
		Assertions.assertTrue(this.paginaDeLogin.isUsuarioInvalido());

	}

	@Test
	public void naoDeveriaAcessarPaginaRestritaSemEstarLogado() {
		// tenta acessar um leilão, sem realizar login
		this.paginaDeLogin.acessarLeilao();

		// deve estar na tela de login
		Assertions.assertTrue(this.paginaDeLogin.isPaginaSolicitacaoDeLogin());

		// a página não pode conter Dados do Leilão
		Assertions.assertFalse(this.paginaDeLogin.isPaginaDeLeilao());
	}

}
