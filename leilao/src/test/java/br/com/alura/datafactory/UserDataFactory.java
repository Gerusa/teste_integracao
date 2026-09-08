package br.com.alura.datafactory;

import net.datafaker.Faker;

import java.util.Locale;

/**
 * Classe aplicando o pattern Factory para gerar
 * diferentes dados.
 */
public final class UserDataFactory {

  //Ferramenta usada para criar os dados fake
  private static final Faker faker = new Faker(new Locale("pt-BR"));

  private UserDataFactory() {}

  public static UserEntity usuarioValido(){
    return UserEntity.builder()
        .nome(faker.name().fullName())
        .email(faker.internet().emailAddress())
        .senha(faker.credentials().password(8, 16))
        .endereco(faker.address().fullAddress())
        .build();
  }

}
