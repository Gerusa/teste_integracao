package br.com.alura.datafaker;

import net.datafaker.Faker;
import org.junit.jupiter.api.Test;

import java.util.Locale;

/**
 * Data Faker disponibiliza dados 'fake' para uso durante
 * testes, sem a necessidade de utilizar dados reais ou fixos.
 */
class DataFakerExampleTest {

  @Test
  void exemplosDataFaker() {
    Faker faker = new Faker(new Locale("pt-BR"));

    String nome = faker.name().fullName();
    String endereco = faker.address().fullAddress();
    String cpfValidoFormatado = faker.cpf().valid(true);
    String nomeUsuario = faker.credentials().username();
    String senhaUsuario = faker.credentials().password();

    System.out.println(nome);
    System.out.println(endereco);
    System.out.println(cpfValidoFormatado);
    System.out.println(nomeUsuario);
    System.out.println(senhaUsuario);
  }
}


