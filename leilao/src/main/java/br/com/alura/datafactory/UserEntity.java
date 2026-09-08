package br.com.alura.datafactory;

import lombok.Builder;
import lombok.Data;

/**
 * Classe 'Model' utilizada para guardar os dados.
 */
@Data
@Builder
public class UserEntity {

  private Long id;
  private String nome;
  private String email;
  private String senha;
  private String endereco;
}
