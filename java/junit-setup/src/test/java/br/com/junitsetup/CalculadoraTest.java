package br.com.junitsetup;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class CalculadoraTest {

  @Test
  public void soma_DoisValoresInteiros_ComSucesso() {
    Integer a = 1;
    Integer b = 3;

    Object resultado = Calculadora.somar(a, b);

    assertEquals(4, resultado);
  }

  @Test
  public void soma_DoisValoresDecimais_ComSucesso() {
    Double a = 1.0;
    Double b = 3.0;

    Object resultado = Calculadora.somar(a, b);

    assertEquals(4.0, resultado);
  }

  @Test
  public void soma_UmValorNullComUmDouble_RetornaErro() {
    Double a = 1.0;

    RuntimeException exception = assertThrows(
        RuntimeException.class,
        () -> Calculadora.somar(a, null));

    assertEquals("Não é possível somar valores NULL.", exception.getMessage());

    exception = assertThrows(
        RuntimeException.class,
        () -> Calculadora.somar(null, a));

    assertEquals("Não é possível somar valores NULL.", exception.getMessage());
  }

  @Test
  public void soma_UmValorNullComUmInteiro_RetornaErro() {
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
