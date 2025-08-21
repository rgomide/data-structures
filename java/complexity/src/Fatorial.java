public class Fatorial {
  public static void main(String[] args) throws Exception {
    final long QTDE_REPETICOES = 9999999;

    System.out.println(String.format("N,Iterativo,Recursivo"));

    for (long n = 1; n <= 30; n++) {
      long[] resultados = executarTeste(QTDE_REPETICOES, n);

      System.out.println(String.format("%d,%d,%d", n, resultados[0], resultados[1]));
    }

  }

  private static long[] executarTeste(long qtdeRepeticoes, long n) {
    long[] resultados = new long[2];
    long tempoInicio = System.currentTimeMillis();
    for (long i = 0; i < qtdeRepeticoes; i++) {
      fatorialIterativo(n);
    }
    resultados[0] = System.currentTimeMillis() - tempoInicio;
    tempoInicio = System.currentTimeMillis();
    for (long i = 0; i < qtdeRepeticoes; i++) {
      fatorialRecursivo(n);
    }
    resultados[1] = System.currentTimeMillis() - tempoInicio;
    return resultados;
  }

  private static long fatorialRecursivo(long n) {
    if (n == 0) {
      return 1;
    }
    return n * fatorialRecursivo(n - 1);
  }

  private static long fatorialIterativo(long n) {
    long resultado = 1;
    for (long i = 1; i <= n; i++) {
      resultado *= i;
    }
    return resultado;
  }
}
