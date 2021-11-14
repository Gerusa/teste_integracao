package br.com.alura.leilao.leiloes;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.alura.leilao.login.LoginPage;

/**
 * Teste Automatizado da funcionalidade de cadastro de leilões.
 */
public class LeiloesTest {

	// utilizando o padrão Page Object. Dessa forma, há uma separação entre o JUnit
	// e o Selenium.
	private LeiloesPage paginaDeLeiloes;

	private LoginPage paginaDeLogin;
	private CadastroLeilaoPage paginaDeCadastro;

	@BeforeEach
	public void beforeEach() {
		this.paginaDeLeiloes = this.efetuarLogin();
		this.paginaDeCadastro = this.paginaDeLeiloes.carregarForumulario();
	}

	private LeiloesPage efetuarLogin() {
		this.paginaDeLogin = new LoginPage();
		this.paginaDeLogin.preencherFormularioLogin("fulano", "pass");
		return this.paginaDeLogin.efetuarLogin();
	}

	@AfterEach
	public void afterEach() {
		this.paginaDeLeiloes.fecharBrowser();
	}

	@Test
	public void deveriaCadastrarLeilao() {
		final String hoje = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		final String nome = "Leilao do dia " + hoje;
		final String valor = "500.00";

		this.paginaDeLeiloes = this.paginaDeCadastro.cadastrarLeilao(nome, valor, hoje);
		
		Assert.assertTrue(this.paginaDeLeiloes.isLeilaoCadastrado(nome, valor, hoje));
	}
	
	@Test
	public void deveriaValidarCadastroDeLeilao() {
		this.paginaDeLeiloes = this.paginaDeCadastro.cadastrarLeilao("", "", "");
		
		Assert.assertTrue(this.paginaDeCadastro.isPaginaAtualIgualDeListagem());
		Assert.assertTrue(this.paginaDeCadastro.isMsgsDeValidacaoVisiveis());
		
	}

}
