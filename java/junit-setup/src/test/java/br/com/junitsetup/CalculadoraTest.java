package br.com.junitsetup;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculadoraTest {

  @Test
  @DisplayName("soma dois valores inteiros com suesso")
  public void somaDoisValoresInteirosComSucesso() {
    Integer a = 1;
    Integer b = 3;

    Object resultado = Calculadora.somar(a, b);

    assertEquals(4, resultado);
  }

  @Test
  @DisplayName("soma dois valores decimais com sucesso")
  public void somaDoisValoresDecimaisComSucesso() {
    Double a = 1.0;
    Double b = 3.0;

    Object resultado = Calculadora.somar(a, b);

    assertEquals(4.0, resultado);
  }

  @Test
  @DisplayName("soma um valor null com um double e retorna erro")
  public void somaUmValorNullComUmDoubleRetornaErro() {
    Double a = 1.0;

    RuntimeException exception = assertThrows(
        RuntimeException.class,
        () -> {
          Calculadora.somar(a, null);
        });

    assertEquals("Não é possível somar valores NULL.", exception.getMessage());

    exception = assertThrows(
        RuntimeException.class,
        () -> Calculadora.somar(null, a));

    assertEquals("Não é possível somar valores NULL.", exception.getMessage());
  }

  @Test
  @DisplayName("soma um valor null com um inteiro e retorna erro")
  public void somaUmValorNullComUmInteiroRetornaErro() {
    Integer a = 1;

    RuntimeException exception = assertThrows(
        RuntimeException.class,
        () -> Calculadora.somar(a, null));

    assertEquals("Não é possível somar valores NULL.", exception.getMessage());

    exception = assertThrows(
        RuntimeException.class,
        () -> Calculadora.somar(null, a));

    assertEquals("Não é possível somar valores NULL.", exception.getMessage());
  }
}
