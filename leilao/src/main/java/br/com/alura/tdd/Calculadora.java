package br.com.alura.tdd;

public final class Calculadora {

  private Calculadora() {}

  /**
   * 2° Ciclo do TDD - Green:
   * Implementa-se a funcao retornando o valor desejado.
   */
//  public static double somar(double a, double b) {
//    return 4;
//  }

  /**
   * 3° Ciclo do TDD - Refactor:
   * Refatora-se o codigo para melhorar sua qualidade e ligibilidade, mantendo todos os testes passando.
   */
  public static double somar(double a, double b){
    return a + b;
  }
}
