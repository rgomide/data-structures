package br.com.gomide.binary_tree;

public class Node<T extends Comparable<?>> {

  private T value;
  private Node<T> left;
  private Node<T> right;

  public T getValue() {
    return value;
  }

  public void setValue(T value) {
    this.value = value;
  }

}
