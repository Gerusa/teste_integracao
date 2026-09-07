package br.com.alura.datadriven;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PodeVotarUtilTest {

  /**
   * Sera executado 4 vezes: uma vez para cada valor do ValueSource.
   * @param idade
   */
  @ParameterizedTest
  @ValueSource(ints = {18, 19, 29, 30})
  void podeVotarTest(int idade){
    Assertions.assertThat(PodeVotarUtil.podeVotar(idade)).isTrue();
  }
}
