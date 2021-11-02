package leilao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import br.com.alura.leilao.dao.UsuarioDao;
import br.com.alura.leilao.model.Usuario;
import util.JPAUtil;

/**
 * O springBoot tem um módulo para testes automatizados. Porém, os casos de
 * testes dessa aplicação não utilizarão os recursos do springBoot já que
 * estamos simulando uma aplicação 'tradicional'.
 *
 */
class UsuariodDaoTest {

	private UsuarioDao dao;

	@Test
	void testeDeveriaEncontrarUsuarioCadastrado() {
		EntityManager em = JPAUtil.getEntityManager();
		// usando injeção de dependência pelo construtor para viabilizar os testes
		this.dao = new UsuarioDao(em);

		Usuario usuario = new Usuario("fulano", "fulano@email.com", "12345678");
		// inicia transacao
		em.getTransaction().begin();
		em.persist(usuario);
		em.getTransaction().commit();

		Usuario usuarioEncontrado = this.dao.buscarPorUsername(usuario.getNome());
		Assert.assertNotNull(usuarioEncontrado);

	}

	@Test
	void testeNaoDeveriaEncontrarUsuarioNaoCadastrado() {
		EntityManager em = JPAUtil.getEntityManager();
		// usando injeção de dependência pelo construtor para viabilizar os testes
		this.dao = new UsuarioDao(em);

		Assert.assertThrows(NoResultException.class, () -> this.dao.buscarPorUsername("beltrano"));

	}

}
