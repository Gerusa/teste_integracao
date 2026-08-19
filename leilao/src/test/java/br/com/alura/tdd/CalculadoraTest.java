package br.com.alura.tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class CalculadoraTest {

  /**
   * 1° Ciclo do TDD - Red:
   * escreve-se um teste que falha para uma funcionalidade ainda inexistente. Ou seja,
   * nesse momento, a 'Calculadora.somar' nao existe.
   */
  @Test
  void soma(){
    double resultado = Calculadora.somar(2,2);
    Assertions.assertEquals(4, resultado);
  }
}
