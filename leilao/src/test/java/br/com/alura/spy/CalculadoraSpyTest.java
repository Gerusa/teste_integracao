package br.com.alura.spy;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CalculadoraSpyTest {

  @Test
  void exemploDeSpyComCalculadora() {
    CalculadoraSpy calculadoraReal = new CalculadoraSpy();
    CalculadoraSpy spyCalculadora = Mockito.spy(calculadoraReal);

    int resultado = spyCalculadora.somar(2, 3);

    Mockito.verify(spyCalculadora).somar(2, 3);
    assertThat(resultado).isEqualTo(5);
  }

  @Test
  void exemploDeSpyComStubParcial() {
    CalculadoraSpy spyCalculadora = Mockito.spy(new CalculadoraSpy());

    // estuba apenas o método somar, com doReturn (mais seguro em spies)
    Mockito.doReturn(100).when(spyCalculadora).somar(2, 3);

    int resultadoSomar = spyCalculadora.somar(2, 3); // retorna o valor estubado: 100
    int resultadoDobro = spyCalculadora.dobro(4);    // chama o método real: 4 + 4 = 8

    assertThat(resultadoSomar).isEqualTo(100);
    assertThat(resultadoDobro).isEqualTo(8);

    Mockito.verify(spyCalculadora).somar(2, 3);
    Mockito.verify(spyCalculadora).dobro(4);
  }
}
