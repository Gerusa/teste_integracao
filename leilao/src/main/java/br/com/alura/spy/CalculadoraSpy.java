package br.com.alura.spy;

public class CalculadoraSpy {

  public int somar(int a, int b) {
    return a + b;
  }

  public int dobro(int valor) {
    return somar(valor, valor);
  }
}
