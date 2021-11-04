package br.com.alura.leilao.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.alura.leilao.model.Usuario;
import br.com.alura.leilao.util.JPAUtil;
import br.com.alura.leilao.util.builder.UsuarioBuilder;

/**
 * O springBoot tem um módulo para testes automatizados. Porém, os casos de
 * testes dessa aplicação não utilizarão os recursos do springBoot já que
 * estamos simulando uma aplicação 'tradicional'.
 *
 */
class UsuarioDaoTest {

	private UsuarioDao dao;
	private EntityManager em;

	@BeforeEach
	public void beforeEach() {
		this.em = JPAUtil.getEntityManager();

		// usando injeção de dependência pelo construtor para viabilizar os testes
		this.dao = new UsuarioDao(em);

		// inicia transacao
		em.getTransaction().begin();
	}

	@AfterEach
	public void afterEach() {
		// desfaz tudo para no próximo teste a base estar 'limpa'
		em.getTransaction().rollback();
	}

	@Test
	void deveriaEncontrarUsuarioCadastrado() {
		final Usuario usuario = this.criarUsuario();

		Usuario usuarioEncontrado = this.dao.buscarPorUsername(usuario.getNome());
		Assert.assertNotNull(usuarioEncontrado);

	}

	private Usuario criarUsuario() {
		Usuario usuario = new UsuarioBuilder().comNome("Fulano").comEmail("fulano@email.com").comSenha("12345678")
				.criar();

		em.persist(usuario);

		return usuario;
	}

	@Test
	void naoDeveriaEncontrarUsuarioNaoCadastrado() {
		Assert.assertThrows(NoResultException.class, () -> this.dao.buscarPorUsername("beltrano"));

	}

	@Test
	void deveriaRemoverUsuario() {
		final Usuario usuario = this.criarUsuario();

		this.dao.deletar(usuario);

		Assert.assertThrows(NoResultException.class, () -> this.dao.buscarPorUsername(usuario.getNome()));

	}

}
