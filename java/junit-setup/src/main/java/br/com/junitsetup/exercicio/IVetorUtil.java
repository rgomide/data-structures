package br.com.junitsetup.exercicio;

public interface IVetorUtil {

  /**
   * Copie o conteúdo do vetor a para o vetor b
   * 
   * @param a vetor de origem
   * @param b vetor de destino
   */
  public void copiarValores(int[] a, int[] b);

  /**
   * Copie o conteúdo do vetor a para o vetor b na ordem inversa
   * 
   * @param a vetor de origem
   * @param b vetor de destino
   */
  public void copiarValoresInverso(int[] a, int[] b);

  /**
   * Soma o conteúdo de dois vetores e retorna o resultado em um novo vetor
   * 
   * @param a vetor <strong>A</strong>
   * @param b vetor <strong>B</strong>
   * @return vetor contendo a soma dos elementos em cada posição
   */
  public int[] somarVetores(int[] a, int[] b);

  /**
   * Intercala os elementos de dois vetores em um novo. Os vetores de entrada
   * podem ser de tamanhos diferentes
   * 
   * @param a vetor <strong>A</strong>
   * @param b vetor <strong>B</strong>
   * @return novo vetor com os valores de <strong>A</strong> intercalados com o de
   *         <strong>B</strong>
   */
  public int[] intercalarElementos(int[] a, int[] b);

}