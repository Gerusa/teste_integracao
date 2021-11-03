package leilao;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.EntityManager;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.alura.leilao.dao.LeilaoDao;
import br.com.alura.leilao.model.Leilao;
import br.com.alura.leilao.model.Usuario;
import util.JPAUtil;

/**
 * O springBoot tem um módulo para testes automatizados. Porém, os casos de
 * testes dessa aplicação não utilizarão os recursos do springBoot já que
 * estamos simulando uma aplicação 'tradicional'.
 *
 */
class LeilaoDaoTest {

	private LeilaoDao dao;
	private EntityManager em;

	@BeforeEach
	public void beforeEach() {
		this.em = JPAUtil.getEntityManager();

		// usando injeção de dependência pelo construtor para viabilizar os testes
		this.dao = new LeilaoDao(em);

		// inicia transacao
		em.getTransaction().begin();
	}

	@AfterEach
	public void afterEach() {
		// desfaz tudo para no próximo teste a base estar 'limpa'
		em.getTransaction().rollback();
	}

	@Test
	void deveriaCadastrarLeilao() {
		final Usuario usuario = this.criarUsuario();

		Leilao leilao = new Leilao("Mochila", new BigDecimal("70"), LocalDate.now(), usuario);

		leilao = this.dao.salvar(leilao);

		Leilao leilaoSalvo = this.dao.buscarPorId(leilao.getId());

		Assert.assertNotNull(leilaoSalvo);
	}

	@Test
	void deveriaAtualizarLeilao() {
		final Usuario usuario = this.criarUsuario();

		Leilao leilao = new Leilao("Mochila", new BigDecimal("70"), LocalDate.now(), usuario);
		leilao = this.dao.salvar(leilao);

		leilao.setNome("Celular");
		leilao = this.dao.salvar(leilao);

		Leilao leilaoSalvo = this.dao.buscarPorId(leilao.getId());

		Assert.assertEquals("Celular", leilaoSalvo.getNome());
	}

	private Usuario criarUsuario() {
		Usuario usuario = new Usuario("fulano", "fulano@email.com", "12345678");
		em.persist(usuario);
		return usuario;
	}

}
