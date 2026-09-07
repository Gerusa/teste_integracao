package br.com.alura.datadriven;

public class PodeVotarUtil {

  private PodeVotarUtil() {
  }

  public static boolean podeVotar(int idade){
    if (idade < 18){
      return false;
    }

    return true;
  }
}
