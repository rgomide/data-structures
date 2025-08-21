public class ContagemSimples {
  public static void main(String[] args) throws Exception {
    long tempoInicio = System.currentTimeMillis();
    for (long i = 0; i < 999999; i++) {
      System.out.println(i);
    }
    long tempoTotal = System.currentTimeMillis() - tempoInicio;

    System.out.println(String.format("Tempo total: %dms", tempoTotal));
  }
}
