package br.com.alura.leilao.leiloes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import br.com.alura.leilao.PageObject;

/**
 * Utilização do padrão Page Object. Ao utilizar este padrão favorecemos a
 * separação de responsabilidades entre os códigos de testes e de utilização da
 * API do Selenium WebDriver. Ou seja, aqui não tem nenhum acesso à api do
 * JUnit, e na classe de teste, não tem nada referente à api do Selenium.
 *
 */
public class CadastroLeilaoPage extends PageObject {

	private static final String URL_LISTA_LEILAO = "http://localhost:8080/leiloes";

	public CadastroLeilaoPage(WebDriver browser) {
		super(browser);
	}

	public LeiloesPage cadastrarLeilao(String nome, String valorInicial, String dataAbertura) {
		browser.findElement(By.id("nome")).sendKeys(nome);
		browser.findElement(By.id("valorInicial")).sendKeys(valorInicial);
		browser.findElement(By.id("dataAbertura")).sendKeys(dataAbertura);

		browser.findElement(By.id("button-submit")).submit();

		return new LeiloesPage(browser);
	}

	/**
	 * Verifica se a página atual é a página de listagem de leilões.
	 * 
	 * @return
	 */
	public boolean isPaginaAtualIgualDeListagem() {
		return this.browser.getCurrentUrl().equals(URL_LISTA_LEILAO);
	}

	public boolean isMsgsDeValidacaoVisiveis() {
		return this.browser.getPageSource().contains("minimo 3 caracteres")
				&& this.browser.getPageSource().contains("não deve estar em branco")
				&& this.browser.getPageSource().contains("deve ser um valor maior de 0.1")
				&& this.browser.getPageSource().contains("deve ser uma data no formato dd/MM/yyyy");
	}

}
