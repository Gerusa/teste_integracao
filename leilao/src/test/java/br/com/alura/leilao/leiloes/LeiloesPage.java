package br.com.alura.leilao.leiloes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Utilização do padrão Page Object. Ao utilizar este padrão favorecemos a
 * separação de responsabilidades entre os códigos de testes e de utilização da
 * API do Selenium WebDriver. Ou seja, aqui não tem nenhum acesso à api do
 * JUnit, e na classe de teste, não tem nada referente à api do Selenium.
 *
 */
public class LeiloesPage {

	private WebDriver browser;

	private static final String URL_CADASTRO_LEILAO = "http://localhost:8080/leiloes/new";

	public LeiloesPage(final WebDriver browser) {
		this.browser = browser;
	}

	public void fecharBrowser() {
		browser.quit();
	}

	public boolean isPaginaDeLeilao() {
		return browser.getPageSource().contains("Dados do Leilão");
	}

	public CadastroLeilaoPage carregarForumulario() {
		this.browser.navigate().to(URL_CADASTRO_LEILAO);
		return new CadastroLeilaoPage(browser);

	}

	public boolean isLeilaoCadastrado(String nome, String valor, String hoje) {
		WebElement linhaDaTabela = this.browser.findElement(By.cssSelector("#tabela-leiloes tbody tr:last-child"));
		WebElement colunaNome = linhaDaTabela.findElement(By.cssSelector("td:nth-child(1)"));
		WebElement colunaDataAbertura = linhaDaTabela.findElement(By.cssSelector("td:nth-child(2)"));
		WebElement colunaValorInicial = linhaDaTabela.findElement(By.cssSelector("td:nth-child(3)"));

		return colunaNome.getText().equals(nome) && colunaDataAbertura.getText().equals(hoje)
				&& colunaValorInicial.getText().equals(valor);
	}

}
